package bank;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    int balance = 0;

    balanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null); // D:\Java projects\bank.management.system\src\icons\atm.jpg
        setUndecorated(true);
        setVisible(true);
        setSize(900, 900);
        setLocation(370, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image l2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(l2);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();

        try {

            ResultSet rs = c.s.executeQuery("select * from Bank where pinNumber='" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);

        }

        JLabel text = new JLabel("Your Current Account balance is Rs :" + balance);
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.WHITE);
        image.add(text);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transcations(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
