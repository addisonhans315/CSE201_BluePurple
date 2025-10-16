package appStore;

import java.util.*;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermissions() {
		return permissions;
	}

	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	
	public Review leaveReview() {
		Scanner sc = new Scanner(System.in);
		int num = -1;
		System.out.println("Please rate this app 1-5: ");
		try {
			String rating = sc.next();
			num = Integer.parseInt(rating);
		} catch (NumberFormatException e) {
			System.out.println("Invalid rating");
		}
		if (num > 5 || num < 1) {
			System.out.println("Invalid rating");
			sc.close();
			return null;
		}
		System.out.println("Please enter your review for this app: ");
		String rev = sc.next();
		sc.close();
		return new Review(num, rev);
	}
	
}