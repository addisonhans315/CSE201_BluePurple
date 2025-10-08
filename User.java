
public class User {
	private String username;
	private String password;
	private int permissions;

	public User(String username, String password, int permissions) {
		this.username = username;
		this.password = password;
		this.permissions = permissions;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getPermissions() {
		return permissions;
	}
}
