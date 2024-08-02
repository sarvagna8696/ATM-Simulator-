package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

class signupOne extends JFrame implements ActionListener {

    JTextField nameTextField, fnameTextField, genderTextField, emailTextField, maritalTextField,
            cityTextField, addressTextField, stateTextField, pinTextField;

    JButton next;

    JRadioButton female, male, unmarried, married, others;
    JDateChooser dateChooser;

    long random;

    signupOne() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 900L) + 1000);

        JLabel formNo = new JLabel("NEW ACCOUNT APPLICATION FORM NO." + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 25));
        formNo.setBounds(130, 20, 600, 40);
        add(formNo);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 800);
        setLocation(420, 25);
        setVisible(true);

        setTitle("New Account Application");

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(250, 80, 250, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(70, 170, 100, 20);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        nameTextField.setBounds(300, 170, 300, 20);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(70, 220, 200, 20);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameTextField.setBounds(300, 220, 300, 20);
        add(fnameTextField);

        JLabel dob = new JLabel("DOB : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(70, 270, 200, 20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 270, 300, 20);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(70, 320, 200, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 320, 100, 20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 320, 100, 20);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(female);
        gendergroup.add(male);

        JLabel emailAddress = new JLabel("Email Address : ");
        emailAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        emailAddress.setBounds(70, 370, 200, 20);
        add(emailAddress);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailTextField.setBounds(300, 370, 300, 20);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(70, 420, 200, 20);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 420, 90, 20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 420, 90, 20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(500, 420, 90, 20);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel address = new JLabel("  Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(60, 470, 200, 20);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        addressTextField.setBounds(300, 470, 300, 20);
        add(addressTextField);

        JLabel city = new JLabel(" City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(65, 520, 200, 20);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        cityTextField.setBounds(300, 520, 300, 20);
        add(cityTextField);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(70, 570, 200, 20);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        stateTextField.setBounds(300, 570, 300, 20);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(70, 620, 200, 20);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        pinTextField.setBounds(300, 620, 300, 20);
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(340, 680, 200, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent e) {

        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";

        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "UnMarried";
        } else if (others.isSelected()) {
            marital = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();

        try {
            if (name.equals("")) {

                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                conn c = new conn();
                String q = "INSERT INTO signup ( formno , name ,fname , dob, gender , email, marital , address ,city , state , pincode)VALUES("
                        + "'" + formno + "'," + "'" + name + "'," + "'" + fname + "'," + "'" + dob + "'," + "'" + gender
                        + "'," + "'" + email + "'," + "'" + marital + "'," + "'" + address + "'," + "'" + city + "',"
                        + "'" + state + "'," + "'" + pincode + "')";
                c.s.executeUpdate(q);
                c.s.close();

                setVisible(false);
                new signupTwo(formno).setVisible(true);

            }

        } catch (Exception a) {
            System.out.println(a);
        }

        /*
         * if(e.getSource==next){
         * setVisible(false);
         * signupTwo.setVisible(true);
         * }
         */

    }

    public static void main(String[] args) {

        new signupOne();

    }
}
