import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class AddModPage {
	int boardWidth = 640;
	int boardHeight = 540;

	// Custom colors
	Color customLightGray = new Color(212, 212, 210);
	Color customDarkGray = new Color(80, 80, 80);
	Color customBlack = new Color(0, 0, 0);
	Color customOrange = new Color(255, 149, 0);

	JFrame frame = new JFrame("Add Moderator");

	// Components
	JLabel titleLabel = new JLabel("Add Moderator username and password", JLabel.CENTER);

	JLabel usernameLabel = new JLabel("Username:");
	JTextField usernameField = new JTextField();

	JLabel passwordLabel = new JLabel("Password:");
	JTextField passwordField = new JTextField();

	JButton submitButton = new JButton("Submit");
	JLabel messageLabel = new JLabel("", JLabel.CENTER);

	JButton backPageButton = new JButton("<");

	public AddModPage(int val) {

		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(customLightGray);

		// Title
		titleLabel.setBounds(0, 50, boardWidth, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
		titleLabel.setForeground(customBlack);
		frame.add(titleLabel);

		// Labels & Fields
		usernameLabel.setBounds(80, 120, 120, 30);
		frame.add(usernameLabel);
		usernameField.setBounds(210, 120, 300, 30);
		frame.add(usernameField);

		passwordLabel.setBounds(80, 160, 120, 30);
		frame.add(passwordLabel);
		passwordField.setBounds(210, 160, 300, 30);
		frame.add(passwordField);

		// Submit Button
		submitButton.setBounds(250, 400, 140, 50);
		submitButton.setBackground(customOrange);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Arial", Font.BOLD, 18));
		submitButton.setFocusable(false);
		submitButton.setBorder(new LineBorder(customBlack));
		frame.add(submitButton);

		// Back Page Button
		backPageButton.setBounds(20, 20, 30, 30);
		backPageButton.setBackground(customOrange);
		backPageButton.setForeground(Color.WHITE);
		backPageButton.setBorder(new LineBorder(customBlack));
		backPageButton.setFocusable(false);
		frame.add(backPageButton);

		// Message Label
		messageLabel.setBounds(0, 460, boardWidth, 40);
		messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		messageLabel.setForeground(customBlack);
		frame.add(messageLabel);

		// Button Functionality
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = usernameField.getText().trim();
				String password = passwordField.getText().trim();

				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill out all fields before submitting.");
					return;
				}

				JOptionPane.showMessageDialog(frame, "Moderator Created");

				String temp = username + " " + password + " 1\n" ;
				String oldtemp = "";
				
				try {
					oldtemp = Files.readString(Path.of("users.txt"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				temp += oldtemp;
				
				try {
					Files.writeString(Path.of("users.txt"), temp.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		backPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new HomePage(val);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		frame.setVisible(true);
	}
}
