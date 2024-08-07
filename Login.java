package bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton signin, clear, signup;
    JTextField cardTextField;
    JPasswordField PinTextField;
    
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 500);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Set up constraints
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Logo
        ImageIcon lo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image lo2 = lo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon lo3 = new ImageIcon(lo2);
        JLabel label = new JLabel(lo3);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(label, gbc);
        
        // Welcome text
        JLabel Text = new JLabel("Welcome to ATM");
        Text.setFont(new Font("Osward", Font.BOLD, 38));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(Text, gbc);
        
        // Card number
        JLabel Cardno = new JLabel("Card No:");
        Cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(Cardno, gbc);
        
        cardTextField = new JTextField();
        gbc.gridx = 1;
        add(cardTextField, gbc);
        
        // PIN
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(Pin, gbc);
        
        PinTextField = new JPasswordField();
        gbc.gridx = 1;
        add(PinTextField, gbc);
        
        // Sign in button
        signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(signin, gbc);
        
        // Clear button
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        gbc.gridx = 1;
        add(clear, gbc);
        
        // Sign up button
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(signup, gbc);
        
        getContentPane().setBackground(Color.WHITE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardTextField.setText("");
            PinTextField.setText("");
        } else if (e.getSource() == signin) {
            conn c = new conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = new String(PinTextField.getPassword()); // Use getPassword() for security
            String Q = "select * from login where CardNumber='" + cardNumber + "' and  PinNumber='" + pinNumber + "' ";
            try {
                ResultSet rs = c.s.executeQuery(Q);
                if (rs.next()) {
                    setVisible(false);
                    new Transcations(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception t) {
                JOptionPane.showMessageDialog(null, "Error: " + t.getMessage());
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
