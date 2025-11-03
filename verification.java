import java.util.Scanner;
import java.io.*;

public class verification {
	
	String user;
	String pass;
	String textFile;
	int status;
	Boolean found = false;
	
	public verification(String user, String pass, String textFile) {
		Scanner input = null;
		try {
			input = new Scanner(new File(textFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		while (input.hasNext()) {
			String usernameFile = input.next();
			String passwordFile = input.next();
			int val = input.nextInt();

			if (user.equals(usernameFile) && pass.equals(passwordFile)) {
				found = true;
				status = val;
				break;
			}

		}
	}
	
	public int getStatus() {
		return status;
	}
	
	public Boolean verify() {
		return found;
	}
}