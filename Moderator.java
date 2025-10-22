package appStore;

public class Moderator extends User {

	public Moderator(String username, String password) {
		super(username, password);
	}
	public Moderator(User u) {
		super(u.getUsername(), u.getPassword());
	}

}
