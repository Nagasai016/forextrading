package saiii;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import saiii.Interface;

public class LoginFrame extends JFrame {
    private JTextField clientIdField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel clientIdLabel = new JLabel("User ID:");
        JLabel passwordLabel = new JLabel("Password:");

        clientIdField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientId = clientIdField.getText();
                String password = new String(passwordField.getPassword());

                if (clientId.equals("admin") && password.equals("123456")) {
                    try {
						openInterface();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else if (clientId.equals("1001") && password.equals("123456")) {
                    try {
						openInterface();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(clientIdLabel);
        panel.add(clientIdField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
    }

    private void openInterface() throws IOException {
        new saiii.Interface();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}
