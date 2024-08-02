package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    JTextField newPinField, confirmPinField;
    JButton changePinButton, backButton;
    String pinNumber;

    PinChange(String pinNumber) {
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

        JLabel newPinLabel = new JLabel("New PIN:");
        newPinLabel.setForeground(Color.WHITE);
        newPinLabel.setBounds(170, 350, 100, 30);
        image.add(newPinLabel);

        newPinField = new JTextField();
        newPinField.setBounds(300, 350, 150, 30);
        image.add(newPinField);

        JLabel confirmPinLabel = new JLabel("Confirm PIN:");
        confirmPinLabel.setForeground(Color.WHITE);
        confirmPinLabel.setBounds(170, 400, 100, 30);
        image.add(confirmPinLabel);

        confirmPinField = new JTextField();
        confirmPinField.setBounds(300, 400, 150, 30);
        image.add(confirmPinField);

        changePinButton = new JButton("Change ");
        changePinButton.setBounds(195, 500, 100, 30);
        changePinButton.addActionListener(this);
        image.add(changePinButton);

        backButton = new JButton("Back");
        backButton.setBounds(350, 500, 100, 30);
        backButton.addActionListener(this);
        image.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePinButton) {
            String newPin = newPinField.getText();
            String confirmPin = confirmPinField.getText();

            if (newPin.isEmpty() || confirmPin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter and confirm your new PIN.");
                return;
            }

            if (!newPin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(null, "PINs do not match!");
                return;
            }

            // Update the PIN in the database
            try {
                conn c = new conn();
                String query = "UPDATE login SET PinNumber='" + newPin + "' WHERE PinNumber='" + pinNumber + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "PIN changed successfully!");

                System.out.println(query);
                setVisible(false);
                new Transcations(newPin).setVisible(true); // Pass the new pin to the transactions page
            } catch (Exception ex) {
                System.out.println("Error changing PIN: " + ex.getMessage());
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Transcations(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");

    }
}
