package model.entity;

/**
 * @author Kaori Masutani
 * 従業員モデルクラス。
 */

public class Employee {

	/**
	 * 従業員コード。
	 */
	private String employeeCode;

	/**
	 * 氏。
	 */
	private String lastName;

	/**
	 * 名。
	 */
	private String firstName;

	/**
	 * 氏かな。
	 */
	private String lastKanaName;

	/**
	 * 名かな。
	 */
	private String firstKanaName;

	/**
	 * 性別。
	 */
	private int gender;

	/**
	 * 生年月日。
	 */
	private String birthDay;


	/**
	 * 部署コード。
	 */
	private String sectionCode;

	/**
	 * 入社日。
	 */
	private String hireDate;

	/**
	 * パスワード。
	 */
	private String password;

	/**
	 * Employeeのコンストラクタ。
	 */
	public Employee(){
	}


	/**
	 * @return employeeCode - 従業員コード。
	 * 従業員コードを返す。
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @param employeeCode - 従業員コード。
	 * 指定したemployeeCodeをセットする。
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


	/**
	 * @return lastName - 氏。
	 * 氏を返す。
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName - 氏。
	 * 指定したlastNameをセットする。
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName - 名。
	 * 名を返す。
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName - 名。
	 * 指定したfirstNameをセットする。
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastKanaName - 氏かな。
	 * 氏かなを返す。
	 */
	public String getLastKanaName() {
		return lastKanaName;
	}

	/**
	 * @param lastKanaName - 氏かな。
	 * 指定したlastKanaNameをセットする。
	 */
	public void setLastKanaName(String lastKanaName) {
		this.lastKanaName = lastKanaName;
	}

	/**
	 * @return firstKanaName - 名かな。
	 * 氏かなを返す。
	 */
	public String getFirstKanaName() {
		return firstKanaName;
	}

	/**
	 * @param firstKanaName - 名かな。
	 * 指定したfirstKanaNameをセットする。
	 */
	public void setFirstKanaName(String firstKanaName) {
		this.firstKanaName = firstKanaName;
	}

	/**
	 * @return gender - 性別。
	 * 性別を返す。
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender - 性別。
	 * 指定したgenderをセットする。
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @param gender "男性"または"女性"という文字列。
	 * 文字列を受け取って対応する数値をgenderフィールドにセットする。
	 */
	public void setGender(String gender) {
		if(gender.equals("男性")) {
			this.gender = 0;
		} else if(gender.equals("女性")){
			this.gender = 1;
		}
	}

	/**
	 * @return birthDay - 生年月日。
	 * 生年月日を返す。
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay - 生年月日。
	 * 指定したbirthDayをセットする。
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return sectionCode - 部署コード。
	 * 部署コードを返す。
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode - 部署コード。
	 * 指定したsectionCodeをセットする。
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return hireDate - 入社日。
	 * 入社日を返す。
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate - 入社日。
	 * 指定したhireDateをセットする。
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return password - パスワード。
	 * パスワードを返す。
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password - パスワード。
	 * 指定したpasswordをセットする。
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
