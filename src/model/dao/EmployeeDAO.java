package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.entity.Employee;
import model.entity.Section;

/**
 * @author Yusuke Tanabe
 * 従業員データベースと繋ぐDAOクラス。
 */
public class EmployeeDAO {
	/**
	 * 唯一のインスタンスを生成する
	 */
	private static EmployeeDAO instance = new EmployeeDAO();
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
	private EmployeeDAO() {
	}

	/**
	 * @return EmployeeDAOの唯一のインスタンス。
	 * 唯一のインスタンスを取得する。
	 */
	public static EmployeeDAO getInstance() {
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
	 * @param lastName 従業員の苗字。
	 * @param firstName 従業員の氏名。
	 * @param lastKanaName 従業員の苗字のふりがな。
	 * @param firstKanaName 従業員の氏名のふりがな。
	 * @param gender 性別（0なら男性、1なら女性）。
	 * @param birthDay 生年月日（"yyyy-MM-dd"の文字列）。
	 * @param sectionCode 部署コード。
	 * @param hireDate 入社日。
	 * @param password パスワード。
	 * @return データベースに従業員情報を挿入出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * 従業員情報を新規追加する。
	 */
	public boolean insertEmployee(String lastName, String firstName, String lastKanaName, String firstKanaName,
			int gender, String birthDay, String sectionCode, String hireDate, String password) throws SQLException {

		// オートコミットを無効にする
		con.setAutoCommit(false);

		String sql = "SELECT MAX(employee_code) FROM m_employee;";
		ResultSet rs = st.executeQuery(sql);
		int code = 0;
		String employeeCode;

		if(rs.next()){
			code = Integer.parseInt(rs.getString(1).substring(1)) + 1;
		}

		employeeCode = "E" + String.format("%04d", code);

		boolean flag = false;
		String sql2 = "insert into m_employee values('"+ employeeCode +"','" + lastName + "', '" + firstName + "', '" + lastKanaName + "',"
				+ "'" + firstKanaName + "', '" + gender + "', '" + birthDay + "' , '" + sectionCode + "', '" + hireDate + "', null, '" + password + "');";

		int result = st.executeUpdate(sql2);

		// 正しく追加できた場合、コミットする
		if (result > 0) {
			flag = true;
			con.commit();
		}

		return flag;
	}

	/**
	 * @param employee - 従業員モデルクラス。
	 * @return データベースに従業員情報を更新出来たらtrue、出来なかったらfalse。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * 従業員の情報をアップデートする。（従業員情報編集機能）
	 */
	public Employee updateEmployee(Employee employee) throws SQLException {
		con.setAutoCommit(false);

		String sql = "UPDATE m_employee SET last_name = '" + employee.getLastName()
		+ "', first_name = '" + employee.getFirstName()
		+ "', last_kana_name = '"+ employee.getLastKanaName()
		+ "', first_kana_name = '" + employee.getFirstKanaName()
		+ "', gender = '" + employee.getGender()
		+ "', birth_day = '" + employee.getBirthDay()
		+ "', section_code = '" + employee.getSectionCode()
		+ "', hire_date = '" + employee.getHireDate()
		+ "' WHERE employee_code = '" + employee.getEmployeeCode() + "';";

		int count = st.executeUpdate(sql);

		if (count > 0) {
			con.commit();
		}

		return employee;
	}

	/**
	 * @param employeeCode - 従業員コード。
	 * @return 対応する従業員、存在しない場合null。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * 指定されたemployeeCodeから従業員の情報を取得して、Employee型で返す。
	 */
	public Employee selectEmployee(String employeeCode) throws SQLException {
		String sql = "SELECT * FROM m_employee WHERE employee_code = '"
				+ employeeCode + "';";

		ResultSet rs = st.executeQuery(sql);

		Employee employee = null;

		if(rs.next() && rs.getString(1).equals(employeeCode)){
			employee = new Employee();
			employee.setEmployeeCode(rs.getString(1));
			employee.setLastName(rs.getString(2));
			employee.setFirstName(rs.getString(3));
			employee.setLastKanaName(rs.getString(4));
			employee.setFirstKanaName(rs.getString(5));
			employee.setGender(rs.getInt(6));
			employee.setBirthDay(rs.getString(7));
			employee.setSectionCode(rs.getString(8));
			employee.setHireDate(rs.getString(9));

		}

		return employee;
	}


	/**
	 * @param employeeCode - 従業員コード。
	 * @return データベースに従業員情報を更新出来たら1、出来なかったら0。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * 指定されたemployeeCodeの従業員情報を削除する。
	 */
	public int deleteEmployee(String employeeCode) throws SQLException {
		con.setAutoCommit(false);
		String sql = "DELETE FROM m_employee WHERE employee_code = '"
				+ employeeCode + "';";
		int count = st.executeUpdate(sql);

		if (count > 0) {
			con.commit();
		}

		return count;

	}

	/**
	 * @return List<Section> - 部署一覧。
	 * @throws SQLException。データベース処理に問題があった場合。
	 * 表示のために部署一覧を取得して、List<Section>型で返す。
	 */
	public List<Section> getSection() throws SQLException {
		String sql = "SELECT * FROM m_section ORDER BY section_code;";
		List<Section> sections = new LinkedList<Section>();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()){
			//レコードの値を取得
			Section se = new Section();
			se.setSectionCode(rs.getString(1));
			se.setSectionName(rs.getString(2));
			sections.add(se);
		}

		return sections;

	}

}
