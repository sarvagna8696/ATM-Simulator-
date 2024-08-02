package bank;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber) {

        setLayout(null);
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 300, 40);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 30);
        add(balance);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber= '" + pinNumber + "' ");

            while (rs.next()) {
                card.setText("Card Number :" + rs.getString("CardNumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("CardNumber").substring(12));
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        try {
            conn w = new conn();
            ResultSet rs = w.s.executeQuery("select * from Bank where pinNumber='" + pinNumber + "'");
            int bal = 0;

            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your current account balance is Rs :" + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new MiniStatement("");

    }

}
