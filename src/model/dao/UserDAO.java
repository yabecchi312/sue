package model.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Hideaki Yabe
 * 管理者データベースと繋ぐDAOクラス。
 */
public class UserDAO {
	/**
	 * 唯一のインスタンスを生成する
	 */
	private static UserDAO instance = new UserDAO(); //唯一のインスタンスとする

	/**
	 * 特定のデータベースとの接続(セッション)。
	 */
	private Connection con;
	/**
	 * 静的SQL文を実行し、作成された結果を返すために使用されるオブジェクト。
	 */
	private Statement st;
	/**
	 * privateのため新規のインスタンスをつくらせない。
	 */
	private UserDAO() {
	}

	/**
	 * @return UserDAOの唯一のインスタンス。
	 * 唯一のインスタンスを取得する。
	 */
	public static UserDAO getInstance() {
		return instance;
	}

	/**
	 * @throws SQLException データベース処理に問題があった場合。
	 * 特定のデータベースとの接続(セッション)を生成する。
	 */
	public void dbConnect() throws SQLException {
		ConnectionManager cm = ConnectionManager.getInstance();
		con = cm.connect();
	}

	/**
	 * @throws SQLException データベース処理に問題があった場合。
	 * 静的SQL文を実行し、作成された結果を返すために使用されるオブジェクトを生成する。
	 */
	public void createSt() throws SQLException {
		st = con.createStatement();
	}

	/**
	 * 特定のデータベースとの接続(セッション)を切断する。
	 */
	public void dbDiscon() {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param userId - ユーザーID。
	 * @param password - パスワード。
	 * @return データベースと一致していたらtrue、一致していなかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * @throws NoSuchAlgorithmException。ある暗号アルゴリズムが要求されたにもかかわらず、現在の環境では使用可能でない場合。
	 * 指定されたemployeeCodeとpasswordから管理者ユーザーがログインできるかどうかチェックする。
	 */
	public boolean loginUser(String userId, String password) throws SQLException, NoSuchAlgorithmException {

		boolean loginUserChkFlag = false;

		//パスワードをハッシュ化
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] passwordDigest = digest.digest(password.getBytes());
		String sha1 = String.format("%040x", new BigInteger(1, passwordDigest));

		// user_idとpasswordがマッチしたユーザレコードを取得する
		String sql = "select * from m_user where user_id='"
				+ userId + "' and password='" + sha1.substring(8) + "';";
		ResultSet rs = st.executeQuery(sql);

		// マッチしたデータがあればtrueを代入する
		if (rs.next()) {
			if (userId.equals(rs.getString(1))) {
				if (sha1.substring(8).equals(rs.getString(2))) {
					loginUserChkFlag = true;
				}
			}
		}
		return loginUserChkFlag;
	}

	/**
	 * @param userId - ユーザーID。
	 * @param password - パスワード。
	 * @return データベースに管理者を挿入出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * @throws NoSuchAlgorithmException。ある暗号アルゴリズムが要求されたにもかかわらず、現在の環境では使用可能でない場合。
	 * 管理者ユーザーの情報を新規追加する。
	 */
	public boolean insertUser(String userId, String password) throws SQLException, NoSuchAlgorithmException {

		// オートコミットを無効にする
		con.setAutoCommit(false);

		boolean insertUserChkFlag = false;

		// user_idがマッチしたユーザレコードを取得する
		String sql = "select * from m_user where user_id='"
				+ userId + "';";
		ResultSet rs = st.executeQuery(sql);

		//パスワードをハッシュ化
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] passwordDigest = digest.digest(password.getBytes());
		String sha1 = String.format("%040x", new BigInteger(1, passwordDigest));

		//テーブルのuser_idをチェックして同じ値がなかったら、userテーブルにinsertする
		//大文字小文字チェック
		if (!rs.next() || !userId.equals(rs.getString(1))) {
			sql = "insert into m_user values('" + userId + "','" + sha1.substring(8) + "', null);";
			int result = st.executeUpdate(sql);

			// 正しく追加できた場合、コミットする
			if (result > 0) {
				insertUserChkFlag = true;
				con.commit();
			}

		}

		return insertUserChkFlag;
	}
}
