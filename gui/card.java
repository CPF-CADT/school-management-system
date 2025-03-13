package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class card {
    private String[] features ;
    private String[] defaultFeatures= {"Course 1", "Course 2", "Course 3", "Course 4", "Course 5", "Course 6"};
    JPanel mainContent = new JPanel();
    JPanel cardPanel = new JPanel();
    JFrame frame = new JFrame("Teacher Dashboard");
    public card(){
        this. features= defaultFeatures;
    }
    public card(String[] features  ){
        mainContent.setBackground(new Color(255, 230, 230)); // Light Pink
        mainContent.setLayout(new BorderLayout());
        cardPanel.setLayout(new GridLayout(3, 5, 15, 15)); // 2 rows, 3 columns
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));
        cardPanel.setBackground(new Color(255, 230, 230)); // Same as background

        
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
}}
