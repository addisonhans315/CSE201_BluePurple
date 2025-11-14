import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class AppSubmissionPage {
	int boardWidth = 640;
	int boardHeight = 540;

	// Custom colors
	Color customLightGray = new Color(212, 212, 210);
	Color customDarkGray = new Color(80, 80, 80);
	Color customBlack = new Color(0, 0, 0);
	Color customOrange = new Color(255, 149, 0);

	JFrame frame = new JFrame("App Submission Form");

	// Components
	JLabel titleLabel = new JLabel("Submit Your App", JLabel.CENTER);

	JLabel appNameLabel = new JLabel("App Title:");
	JTextField appNameField = new JTextField();

	JLabel priceLabel = new JLabel("Price ($):");
	JTextField priceField = new JTextField();

	JLabel typeLabel = new JLabel("Type:");
	JTextField typeField = new JTextField();

	JLabel creatorLabel = new JLabel("Creator Name:");
	JTextField creatorField = new JTextField();

	JLabel logoPathLabel = new JLabel("Logo Path:");
	JTextField logoPathField = new JTextField();

	JLabel descLabel = new JLabel("App Description:");
	JTextArea descArea = new JTextArea();
	JScrollPane descScroll = new JScrollPane(descArea);

	JButton submitButton = new JButton("Submit");
	JLabel messageLabel = new JLabel("", JLabel.CENTER);

	JButton backPageButton = new JButton("<");

	private HomePage homePage;

	static App temp;

	public AppSubmissionPage(int val, HomePage homePage) {
		this.homePage = homePage;
		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(customLightGray);

		// Title
		titleLabel.setBounds(0, 20, boardWidth, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
		titleLabel.setForeground(customBlack);
		frame.add(titleLabel);

		// Labels & Fields
		appNameLabel.setBounds(80, 90, 120, 30);
		frame.add(appNameLabel);
		appNameField.setBounds(210, 90, 300, 30);
		frame.add(appNameField);

		priceLabel.setBounds(80, 130, 120, 30);
		frame.add(priceLabel);
		priceField.setBounds(210, 130, 300, 30);
		frame.add(priceField);

		typeLabel.setBounds(80, 170, 120, 30);
		frame.add(typeLabel);
		typeField.setBounds(210, 170, 300, 30);
		frame.add(typeField);

		creatorLabel.setBounds(80, 210, 120, 30);
		frame.add(creatorLabel);
		creatorField.setBounds(210, 210, 300, 30);
		frame.add(creatorField);

		logoPathLabel.setBounds(80, 250, 120, 30);
		frame.add(logoPathLabel);
		logoPathField.setBounds(210, 250, 300, 30);
		frame.add(logoPathField);

		descLabel.setBounds(80, 290, 200, 30);
		frame.add(descLabel);
		descArea.setLineWrap(true);
		descArea.setWrapStyleWord(true);
		descScroll.setBounds(210, 290, 300, 100);
		frame.add(descScroll);

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

				String appName = appNameField.getText().trim();
				String price = priceField.getText().trim();
				String type = typeField.getText().trim();
				String creator = creatorField.getText().trim();
				String logoPath = logoPathField.getText().trim();
				String description = descArea.getText().trim();

				if (appName.isEmpty() || price.isEmpty() || creator.isEmpty() || logoPath.isEmpty()
						|| description.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill out all fields before submitting.");
					return;
				}
				
				JOptionPane.showMessageDialog(frame, "App Submitted");

				temp = new App(appName, logoPath, type, price, description, creator);

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

	// Return complete list of apps
	public static App getApps() {
		return temp;
	}
}
