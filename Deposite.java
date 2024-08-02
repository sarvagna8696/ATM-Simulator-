package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposite, Back;
    String PinNumber;

    Deposite(String PinNumber) {
        this.PinNumber = PinNumber;

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

        JLabel text = new JLabel("Enter the Amount you want to Deposite");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 17));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 300, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(amount);

        deposite = new JButton("Deposite");
        deposite.setBounds(365, 485, 100, 20);
        deposite.setForeground(Color.BLACK);
        deposite.setBackground(Color.WHITE);
        deposite.addActionListener(this);
        image.add(deposite);

        Back = new JButton("Back");
        Back.setBounds(365, 515, 100, 20);
        Back.setForeground(Color.BLACK);
        Back.setBackground(Color.WHITE);
        Back.addActionListener(this);
        image.add(Back);

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == deposite) {
            String number = amount.getText();
            Date date = new Date();
            if (deposite.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    conn c = new conn();
                    String f = "insert into Bank values('" + PinNumber + "','" + date + "','Deposit','" + number + "')";

                    c.s.executeUpdate(f);
                    JOptionPane.showMessageDialog(null, "Rs" + number + "Deposited successfully");
                    setVisible(false);
                    new Transcations(PinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        } else if (a.getSource() == Back) {
            setVisible(false);
            new Transcations(PinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposite("");

    }

}
