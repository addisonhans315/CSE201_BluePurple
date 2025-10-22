import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoginPage {

    int boardWidth = 640;
    int boardHeight = 540;

    // Custom colors
    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(0, 0, 0);
    Color customOrange = new Color(255, 149, 0);

    JFrame frame = new JFrame("Login Page");

    // Components
    JLabel titleLabel = new JLabel("User Login", JLabel.CENTER);
    JLabel userLabel = new JLabel("Username:");
    JLabel passLabel = new JLabel("Password:");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton guestButton = new JButton("Guest");
    JLabel messageLabel = new JLabel("Username: user, Password: password", JLabel.CENTER);

    LoginPage() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(customLightGray);

        // Title label
        titleLabel.setBounds(0, 40, boardWidth, 60);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(customBlack);
        frame.add(titleLabel);

        // Username label and text field
        userLabel.setBounds(150, 150, 100, 30);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(userLabel);

        userField.setBounds(260, 150, 230, 30);
        userField.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(userField);

        // Password label and field
        passLabel.setBounds(150, 200, 100, 30);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(passLabel);

        passField.setBounds(260, 200, 230, 30);
        passField.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(passField);

        // Buttons
        loginButton.setBounds(200, 270, 100, 40);
        loginButton.setBackground(customOrange);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setFocusable(false);
        loginButton.setBorder(new LineBorder(customBlack));
        frame.add(loginButton);

        guestButton.setBounds(340, 270, 100, 40);
        guestButton.setBackground(customDarkGray);
        guestButton.setForeground(Color.WHITE);
        guestButton.setFont(new Font("Arial", Font.BOLD, 18));
        guestButton.setFocusable(false);
        guestButton.setBorder(new LineBorder(customBlack));
        frame.add(guestButton);

        // Message Label
        messageLabel.setBounds(0, 340, boardWidth, 40);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messageLabel.setForeground(Color.WHITE);
        frame.add(messageLabel);

        // Add Button Functionality
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("user") && password.equals("password")) {
                    messageLabel.setForeground(Color.BLACK);
                    messageLabel.setText("Login Successful! Welcome, " + username + "!");
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });

        guestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });

        frame.setVisible(true);
    }
}
