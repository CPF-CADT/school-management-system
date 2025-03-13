package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class framBackground {
    public JFrame frame = new JFrame("Teacher Dashboard");
    public JPanel sidebar = new JPanel();
    public JPanel topBar = new JPanel();
    public JLabel profileLabel = new JLabel("Profile");
    public JLabel titleLabel = new JLabel("Teacher");
    public JPanel burgerPanel = new JPanel() {
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
    public framBackground(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700); // Set exact window size
        frame.setLayout(new BorderLayout());
        // Left Sidebar Panel
        sidebar.setBackground(new Color(15, 50, 120)); // Dark Blue
        sidebar.setPreferredSize(new Dimension(200, frame.getHeight()));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        // Top Navigation Bar
             topBar.setLayout(new BorderLayout());
             topBar.setPreferredSize(new Dimension(frame.getWidth(), 50));
             topBar.setBackground(new Color(240, 240, 240)); // Light Gray
               
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
        frame.setVisible(true);
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(topBar, BorderLayout.NORTH);
        


        }
    public  class sideBar{
    public sideBar(){
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
        }}
    }
    public class TopBar{
        public TopBar(){
        // "Teacher" Label in Top Bar
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        // Profile Label (Clickable)
        
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
        topBar.add(burgerPanel, BorderLayout.WEST);
        topBar.add(titleLabel, BorderLayout.CENTER);
        topBar.add(profileLabel, BorderLayout.EAST);
    }}
    }

