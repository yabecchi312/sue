package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Yusuke Tanabe
 * 出退勤時刻管理データベースと繋ぐDAOクラス。
 */
public class AttendanceEmployeeDAO {
	/**
	 * 唯一のインスタンスを生成する。
	 */
	private static AttendanceEmployeeDAO instance = new AttendanceEmployeeDAO();

	/**
	 * 特定のデータベースとの接続(セッション)。
	 */
	private Connection con;
	/**
	 * 静的SQL文を実行し、作成された結果を返すために使用されるオブジェクト。
	 */
	private Statement st;

	/**
	 * 日付/時間オブジェクトの出力および解析のためのフォーマッタ。<br>
	 * "HH:mm:ss"のフォーマットで表記。
	 */
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	/**
	 * 日付/時間オブジェクトの出力および解析のためのフォーマッタ。<br>
	 * "HH:mm:ss"のフォーマットで表記。
	 */

	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * privateのため新規のインスタンスをつくらせない。
	 */
	private AttendanceEmployeeDAO() {
	}

	//唯一のインスタンスを取得（＝シングルトン）

	/**
	 * @return AttendanceEmployeeDAOの唯一のインスタンス。
	 * 唯一のインスタンスを取得する。
	 */
	public static AttendanceEmployeeDAO getInstance() {
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
	 * @param employeeCode 従業員コード。
	 * @param password 対応するパスワード。
	 * @return データベースと一致していたら従業員コード、一致していなかったらnull。
	 * @throws SQLException データベース処理に問題があった場合。
	 * 指定されたemployeeCodeとpasswordから従業員がログインできるかどうかチェックする。
	 */
	public String loginEmployee(String employeeCode, String password) throws SQLException {
		String sql = "select * from m_employee where employee_code='"
				+ employeeCode + "' and password='" + password + "';";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			if (employeeCode.equals(rs.getString(1))) {
				if (password.equals(rs.getString(11))) {
					return employeeCode;
				}
			}
		}
		return null;
	}

	/**
	 * @param employeeCode 従業員コード。
	 * @return データベースに出勤情報を挿入出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * タイムカード出勤時間をテーブルに記録する。
	 */
	public boolean setStartTime(String employeeCode) throws SQLException {
		con.setAutoCommit(false);
		LocalDateTime now = LocalDateTime.now();
		//既にその日のデータが追加されていたらfalseを返す
		String sql = "SELECT * from t_work_time WHERE employee_code = '" + employeeCode
				+ "' and work_date = '" + now.format(dateFormat) + "';";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			return false;
		} else {
			sql = "INSERT INTO t_work_time (employee_code, work_date, start_time) VALUES ('"
			+ employeeCode + "', '" + now.format(dateFormat) + "', '"
			+ now.format(timeFormat) + "' );";
			st.executeUpdate(sql);
			con.commit();
			return true;
		}
	}

	/**
	 * @param employeeCode 従業員コード。
	 * @return データベースに退勤情報を更新出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * タイムカード退勤時間をテーブルに記録する。
	 */
	public boolean setFinishTime(String employeeCode) throws SQLException {
		con.setAutoCommit(false);
		LocalDateTime now = LocalDateTime.now();
		//出勤が押されていなかったらfalseを返す
		String sql = "SELECT * from t_work_time WHERE employee_code = '" + employeeCode
				+ "' and work_date = '" + now.format(dateFormat) + "';";
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()) {
			return false;
		} else {
			sql = "UPDATE t_work_time SET finish_time = '" + now.format(timeFormat)
					+ "' WHERE employee_code = '" + employeeCode + "' and work_date = '" + now.format(dateFormat) + "';";
			st.executeUpdate(sql);
			con.commit();
			return true;
		}
	}

	/**
	 * @param employeeCode 従業員コード。
	 * @return データベースに休憩開始情報を更新出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * タイムカード休憩開始時間をテーブルに記録する。
	 */
	public boolean setStartBreakTime(String employeeCode) throws SQLException {
		con.setAutoCommit(false);
		LocalDateTime now = LocalDateTime.now();
		//出勤が押されていなかったらfalseを返す
		String sql = "SELECT * from t_work_time WHERE employee_code = '" + employeeCode
				+ "' and work_date = '" + now.format(dateFormat) + "';";
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()) {
			return false;
		} else {
			sql = "UPDATE t_work_time SET break_start_time = '" + now.format(timeFormat)
					+ "' WHERE employee_code = '" + employeeCode + "' and work_date = '" + now.format(dateFormat) + "';";
			st.executeUpdate(sql);
			con.commit();
			return true;
		}
	}

	/**
	 * @param employeeCode 従業員コード。
	 * @return データベースに休憩終了情報を更新出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * タイムカード休憩終了時間をテーブルに記録する。
	 */
	public boolean setFinishBreakTime(String employeeCode) throws SQLException {
		con.setAutoCommit(false);
		LocalDateTime now = LocalDateTime.now();
		//出勤または休憩開始が押されていなかったらfalseを返す
		String sql = "SELECT * from t_work_time WHERE employee_code = '" + employeeCode
				+ "' and work_date = '" + now.format(dateFormat) + "';";
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next() && rs.getString(5) == null) {
			return false;
		} else {
			sql = "UPDATE t_work_time SET break_finish_time = '" + now.format(timeFormat)
					+ "' WHERE employee_code = '" + employeeCode + "' and work_date = '" + now.format(dateFormat) + "';";
			st.executeUpdate(sql);
			con.commit();
			return true;
		}
	}

}
