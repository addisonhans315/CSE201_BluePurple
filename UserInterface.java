import java.util.Scanner;
import java.io.*;

public class UserInterface {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Would you like to login in? (yes/no)");
		String input = sc.next();
		if (input.equals("yes")) {
			userLogin();
		}

	}

	public static void verifyUser(String username, String password) throws FileNotFoundException {
		Scanner input = new Scanner(new File("users.txt"));
		String usernameFile = input.next();
		String passwordFile = input.next();
		if (usernameFile.equals(username) && passwordFile.equals(password)) {
			System.out.println("You are logged in!");
		} else {
			System.out.println("Login unsuccessful :(");
		}
		input.close();

	}

	public static void userLogin() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your username: ");
		String username = sc.next();
		System.out.println("Please input your Password: ");
		String password = sc.next();
		verifyUser(username, password);
	}

}
