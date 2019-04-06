package model.entity;

import java.util.Date;

/**
 * @author Hideaki Yabe
 * 従業員一覧画面表示モデルクラス。
 */
public class ViewListDisplay {

	/**
	 * 従業員コード。
	 */
	private String employeeCode;

	/**
	 * 氏名。
	 */
	private String employeeName;

	/**
	 * 氏名かな。
	 */
	private String employeeKanaName;

	/**
	 * 性別。
	 */
	private String gender;

	/**
	 * 生年月日。
	 */
	private Date birthDay;

	/**
	 * 部署名。
	 */
	private String sectionName;

	/**
	 * 入社日。
	 */
	private Date hireDate;


	/**
	 * ViewListDisplayのコンストラクタ。
	 */
	public ViewListDisplay() {
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
	 * @return employeeName - 氏名。
	 * 氏名を返す。
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName - 氏名。
	 * 指定したemployeeNameをセットする。
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return employeeKanaName - 氏名かな。
	 * 氏名かなを返す。
	 */
	public String getEmployeeKanaName() {
		return employeeKanaName;
	}

	/**
	 * @param employeeKanaName - 氏名かな。
	 * 指定したemployeeKanaNameをセットする。
	 */
	public void setEmployeeKanaName(String employeeKanaName) {
		this.employeeKanaName = employeeKanaName;
	}

	/**
	 * @return gender - 性別。
	 * 性別を返す。
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender 0または1という数値。
	 * 数値を受け取って対応する文字列をgenderフィールドにセットする。
	 */
	public void setGender(int gender) {
		if(gender == 0) {
			this.gender = "男性";
		} else {
			this.gender = "女性";

		}
	}

	/**
	 * @return birthDay - 生年月日。
	 * 生年月日を返す。
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay - 生年月日。
	 * 指定したbirthDayをセットする。
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return sectionName - 部署名。
	 * 部署名を返す。
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName - 部署名。
	 * 指定したsectionNameをセットする。
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return hireDate - 入社日。
	 * 入社日を返す。
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate - 入社日。
	 * 指定したhireDateをセットする。
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
