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

        setLayout(null);
        setSize(800, 500);
        setVisible(true);
        setLocation(400, 200);
        setTitle("AUTOMATED TELLER MACHINE ");

        // Image
        ImageIcon lo = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.jpg"));
        Image lo2 = lo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon lo3 = new ImageIcon(lo2);

        JLabel label = new JLabel(lo3);
        label.setBounds(70, 20, 100, 100);
        add(label);

        JLabel Text = new JLabel("Welcome to ATM");
        Text.setFont(new Font("Osward", Font.BOLD, 38));
        Text.setBounds(200, 40, 400, 40);
        add(Text);

        JLabel Cardno = new JLabel(" Card No :");
        Cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        Cardno.setBounds(110, 150, 150, 30);
        add(Cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(280, 150, 250, 30);
        add(cardTextField);

        JLabel Pin = new JLabel("PIN :");
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));
        Pin.setBounds(120, 220, 150, 30);
        add(Pin);

        PinTextField = new JPasswordField();
        PinTextField.setBounds(280, 220, 250, 30);
        add(PinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(280, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(280, 380, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

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
            String pinNumber = PinTextField.getText();
            String Q = "select * from login where CardNumber='" + cardNumber + "' and  PinNumber='" + pinNumber + "' ";

            try {
                ResultSet rs = c.s.executeQuery(Q);
                if (rs.next()) {
                   
                    setVisible(false);
                    new Transcations(pinNumber).setVisible(true);
                    System.out.println(pinNumber);

                   

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            } catch (Exception t) {
                System.out.println(t);
            }

        } else if (e.getSource() == signup) {

            setVisible(false);
            new signupOne().setVisible(true);

        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new Login();

    }
}
