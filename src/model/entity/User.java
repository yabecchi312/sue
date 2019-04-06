package model.entity;

/**
 * @author Hideaki Yabe
 * 管理者ユーザーモデルクラス。
 */
public class User {

	/**
	 * ユーザーID。
	 */
	private String userId;

	/**
	 * パスワード。
	 */
	private String password;

	/**
	 * Userのコンストラクタ。
	 */
	public User() {
	}

	/**
	 * @return userId - ユーザーID。
	 * ユーザーIDを返す。
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId - ユーザーID。
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
