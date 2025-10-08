
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

	// constructor to create users
	// instance variables include username, password, and userLevel which determines
	// user permission. 0 = user, 1 = moderator, 2 = admin
	// have methods to do things based on user permissions (admins can add and
	// change app details)
	// moderators can do certain things
}
