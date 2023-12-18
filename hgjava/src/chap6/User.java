package chap6;

public class User {
	private String userId;
	private String passwd;
	private String userName;
	
	public User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}
	
	// getter
	public String getUserId() {
		return userId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public String getUserName() {
		return userName;
	}
	
	
	
}
