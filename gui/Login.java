package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {
    public Login() {
        // Frame setup
        setTitle("Login");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel with light pink background
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 230, 230)); // Light pink
        panel.setLayout(null); // Manual positioning

        // Title Label
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setBounds(270, 20, 200, 60); // Adjusted position for new frame size
        panel.add(titleLabel);

        // Email Field with Placeholder
        JTextField emailField = new JTextField("Email");
        emailField.setBounds(250, 100, 250, 45); // Increased size
        emailField.setBackground(Color.WHITE);
        emailField.setForeground(Color.DARK_GRAY);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18)); // Font size increased
        panel.add(emailField);

        // Add focus listener to handle placeholder behavior
        emailField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("Email")) {
                    emailField.setText("");
                    emailField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("Email");
                    emailField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        // Password Field with Placeholder
        JTextField passwordField = new JTextField("Password"); // Use JTextField instead of JPasswordField for plain text
        passwordField.setBounds(250, 160, 250, 45); // Increased size
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); // Font size increased
        panel.add(passwordField);

        // Add focus listener to handle placeholder behavior
        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 220, 250, 45); // Adjusted size to match new input box size
        loginButton.setBackground(new Color(102, 102, 255)); // Blue color
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18)); // Font size increased
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
