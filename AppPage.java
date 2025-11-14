import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AppPage {

	int boardWidth = 640;
	int boardHeight = 540;

	Color customLightGray = new Color(212, 212, 210);
	Color customDarkGray = new Color(80, 80, 80);
	Color customBlack = new Color(0, 0, 0);
	Color customOrange = new Color(255, 149, 0);

	JFrame frame = new JFrame("App Viewer");

	JLabel nameLabel = new JLabel("Name:");
	JLabel typeLabel = new JLabel("Type:");
	JLabel priceLabel = new JLabel("Price:");
	JLabel developerLabel = new JLabel("Developer:");
	JLabel detailsLabel = new JLabel("Details:");
	JPanel appPicture = new JPanel();

	JLabel nameValue = new JLabel();
	JLabel typeValue = new JLabel();
	JLabel priceValue = new JLabel();
	JLabel developerValue = new JLabel();
	JLabel detailsValue = new JLabel();

	JButton backPageButton = new JButton("<");
	JButton approveButton = new JButton("Approve");
	JButton rejectButton = new JButton("Reject");

	private App app;

	public AppPage(App app, int pageIndex, boolean showApprovalButtons) throws Exception {

		this.app = app;

		frame.setSize(boardWidth, boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(customLightGray);

		JLabel title = new JLabel("App Viewer", JLabel.CENTER);
		title.setBounds(0, 10, boardWidth, 50);
		title.setFont(new Font("Arial", Font.BOLD, 32));
		frame.add(title);

		// Label Positions
		int xL = 80, xV = 200, width = 350, height = 30;

		nameLabel.setBounds(xL, 90, 120, height);
		typeLabel.setBounds(xL, 130, 120, height);
		priceLabel.setBounds(xL, 170, 120, height);
		developerLabel.setBounds(xL, 210, 120, height);
		detailsLabel.setBounds(xL, 250, 120, height);

		nameValue.setBounds(xV, 90, width, height);
		typeValue.setBounds(xV, 130, width, height);
		priceValue.setBounds(xV, 170, width, height);
		developerValue.setBounds(xV, 210, width, height);
		detailsValue.setBounds(xV, 250, width, height);

		frame.add(nameLabel);
		frame.add(typeLabel);
		frame.add(priceLabel);
		frame.add(developerLabel);
		frame.add(detailsLabel);
		frame.add(nameValue);
		frame.add(typeValue);
		frame.add(priceValue);
		frame.add(developerValue);
		frame.add(detailsValue);

		// Back Button
		backPageButton.setBounds(20, 20, 40, 30);
		backPageButton.setBackground(customOrange);
		backPageButton.setForeground(Color.WHITE);
		backPageButton.setBorder(new LineBorder(customBlack));
		backPageButton.setFocusable(false);
		frame.add(backPageButton);

		backPageButton.addActionListener(e -> {
			frame.dispose();
			try {
				new HomePage(pageIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Approve / Reject Buttons
		if (showApprovalButtons) {
			approveButton.setBounds(220, 400, 120, 40);
			approveButton.setBackground(new Color(0, 170, 0));
			approveButton.setForeground(Color.WHITE);
			approveButton.setBorder(new LineBorder(customBlack));
			approveButton.setFocusable(false);

			rejectButton.setBounds(360, 400, 120, 40);
			rejectButton.setBackground(new Color(200, 0, 0));
			rejectButton.setForeground(Color.WHITE);
			rejectButton.setBorder(new LineBorder(customBlack));
			rejectButton.setFocusable(false);

			frame.add(approveButton);
			frame.add(rejectButton);

			approveButton.addActionListener(e -> {
				try {
					approveApp(pageIndex);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			rejectButton.addActionListener(e -> rejectApp(pageIndex));
		}

		// App Image Panel
		appPicture.setBounds(420, 90, 150, 150);
		appPicture.setBackground(customLightGray);
		appPicture.setLayout(new BorderLayout());
		frame.add(appPicture);

		displayApp(app);
		frame.setVisible(true);
	}

	// displays app
	private void displayApp(App a) {

		nameValue.setText(a.getName());
		typeValue.setText(a.getType());

		String price = a.getPrice();
		if (price.equals("0.0"))
			priceValue.setText("Free!");
		else
			priceValue.setText("$" + price);

		developerValue.setText(a.getDeveloper());
		detailsValue.setText(a.getDetails());

		// Image
		appPicture.removeAll();
		ImageIcon originalIcon = new ImageIcon(getClass().getResource(a.getImagePath()));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
		appPicture.add(imageLabel, BorderLayout.CENTER);

		appPicture.revalidate();
		appPicture.repaint();
	}

	// approve app
	private void approveApp(int pageIndex) throws Exception {
		AppDatabase db = new AppDatabase("apps.json");
		db.addApp(app); 
		JOptionPane.showMessageDialog(frame, "App Approved & Added to Database!");
		frame.dispose();
		try {
			new HomePage(pageIndex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// reject app
	private void rejectApp(int pageIndex) {
		JOptionPane.showMessageDialog(frame, "App Rejected.");
		frame.dispose();
		try {
			new HomePage(pageIndex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
