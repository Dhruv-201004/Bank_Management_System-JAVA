package bank.management.system;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;
import java.util.Random;

public class SignUp_3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JTextField textpin;
    JButton s,c;
    String formno;
    SignUp_3(String formno){
        // TITLE
        super("APPLICATION FORM");

        this.formno = formno;

        // Bank Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        // Heading
        JLabel l1 = new JLabel("Form 3 ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(380,40,400,40);
        add(l1);

        // Sub-Heading
        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(350,70,400,40);
        add(l2);

        // FORM No.
        JLabel l3 = new JLabel("Form No : ");
        l3.setFont(new Font("Raleway", Font.BOLD,14));
        l3.setBounds(700,10,100,30);
        add(l3);

        JLabel l4 = new JLabel(formno);
        l4.setFont(new Font("Raleway", Font.BOLD,14));
        l4.setBounds(760,10,60,30);
        add(l4);

        // Account Field
        JLabel l5 = new JLabel("Account Type:");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100,140,200,30);
        add(l5);

        // RadioButtons
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(110, 246, 104));
        r1.setBounds(100,180,150,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(110, 246, 104));
        r2.setBounds(350,180,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(new Color(110, 246, 104));
        r3.setBounds(100,220,250,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(new Color(110, 246, 104));
        r4.setBounds(350,220,250,30);
        add(r4);

        // Grouping Buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        // Card No. Fields
        JLabel l6 = new JLabel("Card Number:");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,300,200,30);
        add(l6);


        JLabel l7 = new JLabel("(Your 16-digit Card Number)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(100,330,200,20);
        add(l7);

        JLabel l8 = new JLabel("XXXX-XXXX-XXXX-4841");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(330,300,250,30);
        add(l8);

        JLabel l9 = new JLabel("(It would appear on ATM Card/Cheque Book and Statements)");
        l9.setFont(new Font("Raleway",Font.BOLD,12));
        l9.setBounds(330,330,500,20);
        add(l9);

        // PIN Fields
        JLabel l10 = new JLabel("PIN:");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,370,200,30);
        add(l10);

        textpin = new JTextField();
        textpin.setFont(new Font("Raleway",Font.BOLD,18));
        textpin.setBounds(330,370,200,30);
        add(textpin);

        JLabel l11 = new JLabel("(Enter 4-digit Password)");
        l11.setFont(new Font("Raleway",Font.BOLD,12));
        l11.setBounds(100,400,200,20);
        add(l11);

        // Services Fields
        JLabel l12 = new JLabel("Services Required:");
        l12.setFont(new Font("Raleway",Font.BOLD,18));
        l12.setBounds(100,450,200,30);
        add(l12);

        // RadioButtons
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(110, 246, 104));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(110, 246, 104));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(110, 246, 104));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(110, 246, 104));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(110, 246, 104));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(110, 246, 104));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        // CheckBox (Default Selected)
        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        c7.setBackground(new Color(110, 246, 104));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,20);
        add(c7);

        //  Submit Button
        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(260,720,100,40);
        s.addActionListener(this);
        add(s);

        // Cancel Button
        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(450,720,100,40);
        c.addActionListener(this);
        add(c);

        // Frame Layout
        getContentPane().setBackground(new Color(110, 246, 104));
        setSize(850,800);
        setLayout(null);
        setLocation(400,20);
        setUndecorated(true);
        setVisible(true);
    }

    // Binding Events to Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        // Storing Data In Identifiers
        String atype ="";
        if (r1.isSelected()){
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype ="Fixed Deposit Account";
        }else if (r3.isSelected()){
            atype ="Current Account";
        }else if (r4.isSelected()){
            atype = "Recurring Deposit Account";
        }

        // Generating Card No.
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        String pin = textpin.getText();

        String serv = "";
        if(c1.isSelected()){
            serv = serv+"ATM CARD ";
        } else if (c2.isSelected()) {
            serv = serv+"Internet Banking";
        } else if (c3.isSelected()) {
            serv = serv+"Mobile Banking";
        } else if (c4.isSelected()) {
            serv = serv+"EMAIL Alerts";
        } else if (c5.isSelected()) {
            serv=serv+"Cheque Book";
        } else if (c6.isSelected()) {
            serv=serv+"E-Statement";
        }

        // Storing Data In DataBase
        try {
            if (e.getSource()==s){ // Submit Button Pressed
                // Show Error If any Field Is Empty
                if (atype.equals("")|| textpin.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    if ( textpin.getText().length()!=4) {//
                        JOptionPane.showMessageDialog(null, "Invalid PIN");
                    }else {
                        Conn c = new Conn();

                        // Query to Store Data
                        String q1 = "INSERT INTO SignUp_3 VALUES('" + formno + "', '" + atype + "','" + cardno + "','" + pin + "','" + serv + "')";
                        String q2 = "INSERT INTO Login VALUES('" + formno + "','" + cardno + "','" + pin + "')";
                        c.statement.executeUpdate(q1);
                        c.statement.executeUpdate(q2);

                        // Display Card No. and PIN
                        JOptionPane.showMessageDialog(null, "Card Number : " + cardno + "\n Pin : " + pin);

                        // Opening Deposit Page for First Deposit
                        new Deposit(pin);
                        setVisible(false);
                    }
                }
            } else if (e.getSource()==c) {// Cancel Button Pressed
                System.exit(0);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        new SignUp_3("");
//    }
}
