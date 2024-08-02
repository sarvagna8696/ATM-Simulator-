package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class signupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, panTextField;

    JButton next;
    JComboBox religion, education, occupation, income, category;

    JRadioButton Sno, Syes, Eyes, Eno, others;
    String formno;

    signupTwo(String formno) {

        this.formno = formno;

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 800);
        setLocation(420, 25);
        setVisible(true);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2 ");

        JLabel additionallDetails = new JLabel("Page 2: Additional Details");
        additionallDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionallDetails.setBounds(250, 80, 300, 30);
        add(additionallDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(70, 170, 100, 30);
        add(name);

        String[] vlReligion = { "Hindu", "Muslim", "Sikh", "Cristian", "others" };
        religion = new JComboBox<>(vlReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300, 170, 300, 20);
        add(religion);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(70, 220, 200, 30);
        add(fname);

        String vlCateggory[] = { "General", "OBC", "SC", "ST", "Others" };
        category = new JComboBox<>(vlCateggory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 220, 300, 20);
        add(category);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(70, 270, 200, 30);
        add(dob);

        String[] Income = { "NULL", "<1,50,000", "<5,00,000", "<10,00,000", ">10,00,000" };
        income = new JComboBox<>(Income);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 270, 300, 20);
        add(income);

        JLabel gender = new JLabel("Educational & ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(70, 320, 200, 30);
        add(gender);

        JLabel emailAddress = new JLabel("Qualification : ");
        emailAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        emailAddress.setBounds(70, 345, 200, 30);
        add(emailAddress);

        String[] Education = { "Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Others" };
        education = new JComboBox<>(Education);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 340, 300, 20);
        add(education);

        JLabel marital = new JLabel("OCcupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(70, 420, 200, 30);
        add(marital);
        String[] valOCcupation = { " Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
        occupation = new JComboBox<>(valOCcupation);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 420, 300, 20);
        add(occupation);

        JLabel address = new JLabel(" Pan Number : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(60, 470, 200, 30);
        add(address);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        panTextField.setBounds(300, 470, 300, 20);
        add(panTextField);

        JLabel city = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(65, 520, 200, 30);
        add(city);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        aadharTextField.setBounds(300, 520, 300, 20);
        add(aadharTextField);

        JLabel state = new JLabel("Senior Citizen  : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(70, 620, 200, 30);
        add(state);

        Syes = new JRadioButton("Yes");
        Syes.setBounds(300, 620, 90, 20);
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno = new JRadioButton("No");
        Sno.setBounds(400, 620, 90, 20);
        Sno.setBackground(Color.WHITE);
        add(Sno);
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(Syes);
        seniorgroup.add(Sno);

        JLabel pincode = new JLabel("Existing Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(70, 570, 200, 30);
        add(pincode);

        Eyes = new JRadioButton("Yes");
        Eyes.setBounds(300, 570, 90, 20);
        Eyes.setBackground(Color.WHITE);
        add(Eyes);

        Eno = new JRadioButton("No");
        Eno.setBounds(400, 570, 90, 20);
        Eno.setBackground(Color.WHITE);
        add(Eno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(Eyes);
        maritalgroup.add(Eno);
        maritalgroup.add(others);

        next = new JButton("Next");
        next.setBounds(340, 680, 200, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent e) {

        String Sreligion = (String) religion.getSelectedItem();
        String Scategory = (String) category.getSelectedItem();
        String Sincome = (String) income.getSelectedItem();
        String Seducation = (String) education.getSelectedItem();
        String Soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = "";
        if (Syes.isSelected()) {
            seniorCitizen = "Yes";

        } else if (Sno.isSelected()) {
            seniorCitizen = "No";

        }

        String existing = "";
        if (Eyes.isSelected()) {
            existing = "Yes";
        } else if (Eno.isSelected()) {
            existing = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {

            conn c = new conn();
            String q = "INSERT INTO signupTWO (formno, Sreligion, Scategory, Sincome, Seducation, Soccupation, Span, Saadhar, existing, seniorCitizen) VALUES ("
                    + "'" + formno + "', '" + Sreligion + "', '" + Scategory + "', '" + Sincome + "', '"
                    + Seducation + "', '" + Soccupation + "', '" + span + "', '" + saadhar + "', '"
                    + existing + "', '" + seniorCitizen + "')";
            c.s.executeUpdate(q);
            System.out.println(q);
            c.s.close();

            setVisible(false);
            new signupThree(formno).setVisible(true);

        } catch (Exception a) {
            System.out.println(a);
        }

    }

    public static void main(String[] args) {

        new signupTwo("");

    }
}
