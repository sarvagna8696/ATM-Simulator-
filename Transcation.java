package bank;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transcations extends JFrame implements ActionListener {
    JButton desposite, withDrawl, fast, miniStatemnet, pinchange, balanceEnquiry, exit;

    String pinNumber;

    Transcations(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null); // D:\Java projects\bank.management.system\src\icons\atm.jpg
        setUndecorated(true);
        setVisible(true);
        setSize(900, 900);
        setLocation(370, 0);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image l2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(l2);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transcation");
        text.setBounds(210, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 17));
        image.add(text);

        desposite = new JButton("Deposite");
        desposite.setBounds(170, 350, 100, 30);
        desposite.setForeground(Color.BLACK);
        desposite.setBackground(Color.WHITE);
        desposite.addActionListener(this);
        image.add(desposite);

        withDrawl = new JButton("Cash Withdrawl");
        withDrawl.setBounds(340, 350, 130, 30);
        withDrawl.setForeground(Color.BLACK);
        withDrawl.setBackground(Color.WHITE);
        withDrawl.addActionListener(this);
        image.add(withDrawl);

        fast = new JButton("Fast Cash");
        fast.setBounds(170, 400, 100, 30);
        fast.setForeground(Color.BLACK);
        fast.setBackground(Color.WHITE);
        fast.addActionListener(this);
        image.add(fast);

        miniStatemnet = new JButton("Mini Statement");
        miniStatemnet.setBounds(340, 400, 130, 30);
        miniStatemnet.setForeground(Color.BLACK);
        miniStatemnet.setBackground(Color.WHITE);
        miniStatemnet.addActionListener(this);
        image.add(miniStatemnet);

        pinchange = new JButton("Pin Change ");
        pinchange.setBounds(170, 450, 110, 30);
        pinchange.setForeground(Color.BLACK);
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(340, 450, 130, 30);
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(340, 500, 100, 30);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == exit) {
            System.exit(0);
        } else if (a.getSource() == desposite) {
            setVisible(true);
            new Deposite(pinNumber).setVisible(true);
            System.out.println(pinNumber);

        } else if (a.getSource() == withDrawl) {
            new Withdrawl(pinNumber).setVisible(true);
            System.out.println(pinNumber);
        } else if (a.getSource() == fast) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
            System.out.println(pinNumber);
        } else if (a.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
            System.out.println(pinNumber);
        } else if (a.getSource() == balanceEnquiry) {
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true);
            System.out.println(pinNumber);
        } else if (a.getSource() == miniStatemnet) {

            new MiniStatement(pinNumber).setVisible(true);
            System.out.println(pinNumber);
        }
    }

    public static void main(String[] args) {
        new Transcations("");
    }

}
