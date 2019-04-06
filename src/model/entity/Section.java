package model.entity;

/**
 * @author Hideaki Yabe
 * 部署モデルクラス。
 */
public class Section {

	/**
	 * 部署コード。
	 */
	private String sectionCode;

	/**
	 * 部署名。
	 */
	private String sectionName;


	/**
	 * Sectionのコンストラクタ。
	 */
	public Section() {
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

}
