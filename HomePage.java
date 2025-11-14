import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HomePage {

    int ADMIN = 2;
    int MODERATOR = 1;

    int boardWidth = 800;
    int boardHeight = 600;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(0, 0, 0);
    Color customOrange = new Color(255, 149, 0);

    JFrame frame = new JFrame("Home Page");

    JTextField searchField = new JTextField();
    JButton searchButton = new JButton("Search");
    JPanel appGridPanel = new JPanel();
    JButton appSubmissionButton = new JButton("Submit App");
    JButton acceptAppButton = new JButton("Add App");
    JButton nextButton = new JButton(">");
    JButton prevButton = new JButton("<");

    java.util.List<App> apps = new ArrayList<>();
    private int index = 0;
    private final int APPS_PER_PAGE = 9;

    public HomePage(int status) throws Exception {

        AppDatabase db = new AppDatabase("apps.json");
        apps = db.getApps();

        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(customLightGray);
        frame.setLayout(null);

        searchField.setBounds(boardWidth - 260, 20, 150, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(searchField);

        searchButton.setBounds(boardWidth - 100, 20, 80, 30);
        searchButton.setBackground(customOrange);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(new LineBorder(customBlack));
        frame.add(searchButton);

        appSubmissionButton.setBounds(boardWidth - 360, 20, 90, 30);
        appSubmissionButton.setBackground(customOrange);
        appSubmissionButton.setForeground(Color.WHITE);
        appSubmissionButton.setBorder(new LineBorder(customBlack));
        frame.add(appSubmissionButton);

        acceptAppButton.setBounds(boardWidth - 455, 20, 85, 30);
        acceptAppButton.setBackground(customOrange);
        acceptAppButton.setForeground(Color.WHITE);
        acceptAppButton.setBorder(new LineBorder(customBlack));

        if (status == ADMIN || status == MODERATOR)
            frame.add(acceptAppButton);

        appGridPanel.setBounds(45, 80, 695, 460);
        appGridPanel.setBackground(customDarkGray);
        appGridPanel.setLayout(new GridLayout(3, 3, 10, 10));
        frame.add(appGridPanel);

        nextButton.setBounds(745, 80, 35, 460);
        nextButton.setBackground(customOrange);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBorder(new LineBorder(customBlack));
        frame.add(nextButton);

        prevButton.setBounds(5, 80, 35, 460);
        prevButton.setBackground(customOrange);
        prevButton.setForeground(Color.WHITE);
        prevButton.setBorder(new LineBorder(customBlack));
        frame.add(prevButton);

        displayApps(apps, status, index);

        nextButton.addActionListener(e -> {
            int maxPage = (apps.size() - 1) / APPS_PER_PAGE;
            if (index < maxPage) {
                index++;
                displayApps(apps, status, index);
            }
        });

        prevButton.addActionListener(e -> {
            if (index > 0) {
                index--;
                displayApps(apps, status, index);
            }
        });

        searchButton.addActionListener(e -> searchApps(status));

        // Submit App page
        appSubmissionButton.addActionListener(e -> {
            frame.dispose();
            new AppSubmissionPage(status, this);
        });
        
        // App approval
        acceptAppButton.addActionListener(e -> {
            frame.dispose();
            try {
				new AppPage(AppSubmissionPage.getApps(), status, true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        });

        frame.setVisible(true);
    }

    private void displayApps(java.util.List<App> list, int status, int index) {
        appGridPanel.removeAll();

        int start = index * APPS_PER_PAGE;
        int end = Math.min(start + APPS_PER_PAGE, list.size());

        for (int i = start; i < end; i++) {
            App app = list.get(i);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(customLightGray);
            panel.setBorder(new LineBorder(customBlack, 1));

            ImageIcon icon = new ImageIcon(getClass().getResource(app.getImagePath()));
            Image scaled = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(scaled), JLabel.CENTER);

            panel.add(imgLabel, BorderLayout.CENTER);

            JLabel nameLabel = new JLabel(app.getName(), SwingConstants.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            panel.add(nameLabel, BorderLayout.NORTH);

            JLabel priceLabel = new JLabel(app.getPrice().equals("0.0") ? "Free!" : "$" + app.getPrice(),
                    SwingConstants.CENTER);
            panel.add(priceLabel, BorderLayout.SOUTH);

            panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    frame.dispose();
                    try {
						new AppPage(app, status, false);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
                }
            });

            appGridPanel.add(panel);
        }

        // Fill empty slots
        for (int i = end - start; i < APPS_PER_PAGE; i++) {
            JPanel empty = new JPanel();
            empty.setBackground(customDarkGray);
            appGridPanel.add(empty);
        }

        appGridPanel.revalidate();
        appGridPanel.repaint();
    }

    private void searchApps(int status) {
        String query = searchField.getText().trim().toLowerCase();

        if (query.isEmpty()) {
            displayApps(apps, status, index);
            return;
        }

        ArrayList<App> filtered = new ArrayList<>();

        for (App a : apps) {
            if (a.getName().toLowerCase().contains(query) ||
                a.getType().toLowerCase().contains(query) ||
                a.getDeveloper().toLowerCase().contains(query)) {

                filtered.add(a);
            }
        }

        displayApps(filtered, status, 0);
    }

    public void addNewApp(App newApp) {
        apps.add(newApp);
        displayApps(apps, 0, index);
    }
}
