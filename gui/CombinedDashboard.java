package gui;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class CombinedDashboard {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Teacher Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700); // Set exact window size
        frame.setLayout(new BorderLayout());

        // Left Sidebar Panel
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(15, 50, 120)); // Dark Blue
        sidebar.setPreferredSize(new Dimension(200, frame.getHeight()));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // "Teacher" Title Label
        JLabel welcomeLabel = new JLabel(" Teacher");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        sidebar.add(welcomeLabel);

        // Sidebar Buttons
        String[] menuItems = {"Home", "Attendance", "Teaching Course", "Drop Lesson", "Quiz", "Check Assignment", "Grade"};
        for (int i = 0; i < menuItems.length; i++) {
            JButton btn = new JButton(menuItems[i]);
            btn.setAlignmentX(Component.LEFT_ALIGNMENT);
            btn.setMaximumSize(new Dimension(180, 40));

            if (i == 0) { // Light blue highlight for "Home"
                btn.setBackground(new Color(30, 70, 160)); // Light blue
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(30, 70, 160)); // Darker blue
                btn.setForeground(Color.WHITE);
            }

            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            sidebar.add(btn);
            sidebar.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        // Top Navigation Bar
        JPanel topBar = new JPanel();
        topBar.setLayout(new BorderLayout());
        topBar.setPreferredSize(new Dimension(frame.getWidth(), 50));
        topBar.setBackground(new Color(240, 240, 240)); // Light Gray

        // Burger Menu Icon Panel
        JPanel burgerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set color for the lines
                g.setColor(Color.BLACK);
                // Draw three horizontal lines
                int lineHeight = 5; // Height of each line
                int spacing = 10; // Spacing between lines
                int width = 30; // Width of the lines
                int x = (getWidth() - width) / 2; // Center the lines
                int y = getHeight() / 2 - (lineHeight + spacing); // Center vertically

                // Draw lines
                g.fillRect(x, y, width, lineHeight);
                g.fillRect(x, y + lineHeight + spacing, width, lineHeight);
                g.fillRect(x, y + 2 * (lineHeight + spacing), width, lineHeight);
            }
        };
        burgerPanel.setPreferredSize(new Dimension(50, 50));
        burgerPanel.setBackground(new Color(240, 240, 240)); // Same as topBar
        burgerPanel.setBorder(BorderFactory.createEmptyBorder()); // Remove border

        // Add mouse listener for click events
        burgerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle sidebar visibility
                sidebar.setVisible(!sidebar.isVisible());
                frame.revalidate();
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Change cursor to hand when hovering
                burgerPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change cursor back to default
                burgerPanel.setCursor(Cursor.getDefaultCursor());
            }
        });

        // "Teacher" Label in Top Bar
        JLabel titleLabel = new JLabel("Teacher");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        // Profile Label (Clickable)
        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setFont(new Font("Arial", Font.BOLD, 14));
        profileLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        profileLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        profileLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Action to perform on click
                JOptionPane.showMessageDialog(frame, "Profile Clicked!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Change cursor to hand when hovering
                profileLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change cursor back to default
                profileLabel.setCursor(Cursor.getDefaultCursor());
            }
        });

        // Add components to the top bar
        topBar.add(burgerPanel, BorderLayout.WEST);
        topBar.add(titleLabel, BorderLayout.CENTER);
        topBar.add(profileLabel, BorderLayout.EAST);

        // Search Bar
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align components to the left
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding around the search bar

        // Create the search field with a larger size
        JTextField searchField = new JTextField(30); // Increase the number of columns to make it wider
        searchField.setPreferredSize(new Dimension(400, 35)); // Set a larger size (width: 400, height: 35)
        searchField.setFont(new Font("Arial", Font.PLAIN, 16)); // Increase the font size for better readability

        // Add the search field to the search panel
        searchPanel.add(searchField);

        // Add a search button (optional)
        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 35)); // Set button size
        searchButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set button font
        searchButton.setBackground(new Color(30, 70, 160)); // Set button color
        searchButton.setForeground(Color.WHITE); // Set text color
        searchButton.setFocusPainted(false); // Remove focus border
        searchPanel.add(searchButton);

        // Main Content Panel
        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(255, 230, 230)); // Light Pink
        mainContent.setLayout(new BorderLayout());
        mainContent.add(searchPanel, BorderLayout.NORTH);

        // Card Panel for Courses
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(2, 3, 15, 15)); // 2 rows, 3 columns
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
        cardPanel.setBackground(new Color(255, 230, 230)); // Same as background

        String[] features = {"Course 1", "Course 2", "Course 3", "Course 4", "Course 5", "Course 6"};
        for (String feature : features) {
            JPanel card = new JPanel();
            card.setPreferredSize(new Dimension(20, 30)); // Set card size
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add border
            card.setBackground(Color.WHITE); // Set background color
            JLabel cardLabel = new JLabel(feature, SwingConstants.CENTER); // Add label
            cardLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
            card.add(cardLabel);

            // Add MouseListener to make the card clickable
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Action to perform on click
                    JOptionPane.showMessageDialog(frame, feature + " Clicked!");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Change cursor to hand when hovering
                    card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Change cursor back to default
                    card.setCursor(Cursor.getDefaultCursor());
                }
            });

            cardPanel.add(card); // Add card to the card panel
        }

        mainContent.add(cardPanel, BorderLayout.CENTER); // Add card panel to main content

        // Adding Components to the Frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(topBar, BorderLayout.NORTH);
        frame.add(mainContent, BorderLayout.CENTER);

        // Show frame
        frame.setVisible(true);
    }
}