import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HomePage {

    int boardWidth = 800;
    int boardHeight = 600;

    // Custom colors (same theme as LoginPage)
    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(0, 0, 0);
    Color customOrange = new Color(255, 149, 0);

    JFrame frame = new JFrame("Home Page");

    JTextField searchField = new JTextField("Search...");
    JButton searchButton = new JButton("Search");
    JPanel appGridPanel = new JPanel();

    public HomePage(int x) {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(customLightGray);
        frame.setLayout(null);

        // Search bar (top-right)
        searchField.setBounds(boardWidth - 260, 20, 150, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(searchField);

        searchButton.setBounds(boardWidth - 100, 20, 80, 30);
        searchButton.setBackground(customOrange);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(new LineBorder(customBlack));
        searchButton.setFocusable(false);
        frame.add(searchButton);

        // App grid panel
        appGridPanel.setBounds(50, 80, 700, 460);
        appGridPanel.setBackground(customDarkGray);
        appGridPanel.setLayout(new GridLayout(3, 3, 10, 10)); // 3 rows, 3 columns
        frame.add(appGridPanel);

        // Example app buttons
        String[] apps = {"Mail", "Calendar", "Notes", "Tasks", "Music", "Settings", "SnapChat", "Instagram", "Spotify"};
        for (String appName : apps) {
            JButton appButton = new JButton(appName);
            appButton.setFont(new Font("Arial", Font.BOLD, 18));
            appButton.setBackground(customOrange);
            appButton.setForeground(Color.WHITE);
            appButton.setFocusable(false);
            appButton.setBorder(new LineBorder(customBlack, 2));
            appGridPanel.add(appButton);
        }

        // Search button functionality
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText().trim().toLowerCase();
                boolean found = false;

                for (Component c : appGridPanel.getComponents()) {
                    if (c instanceof JButton) {
                        JButton btn = (JButton) c;
                        boolean match = btn.getText().toLowerCase().contains(query);
                        btn.setVisible(match || query.isEmpty());
                        if (match) found = true;
                    }
                }

                if (!found && !query.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                        "No apps found for: " + query,
                        "Search Result",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
