package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;
    TextField textField;

    JButton b1, b2;
    Withdrawal(String pin){
        this.pin=pin;

        // ATM Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // Heading
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        // Amount Field
        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);


        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        // Withdraw Button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    // Binding Events To Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {// Withdraw Pressed
            try {
                String amount = textField.getText();
                Date date = new Date();

                // Error if Amount is Empty
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                } else {
                    Conn c = new Conn();

                    // Store Data From DataBase
                    ResultSet resultSet = c.statement.executeQuery("SELECT* FROM Bank WHERE pin = '" + pin + "'");

                    // Calculating Balance Amount
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("Type").equals("Deposit")) {
                            // Transaction Type Deposit then add Balance
                            balance += Integer.parseInt(resultSet.getString("Amount"));
                        }
                        else {
                            // Subtract Withdrawal from Balance
                            balance -= Integer.parseInt(resultSet.getString("Amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        // Balance less than Withdrawal Amount
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    // Store Withdrawal Transaction into DataBase
                    c.statement.executeUpdate("INSERT INTO BANK VALUES('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                    // Open Main Frame
                    setVisible(false);
                    new Main(pin);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==b2) {// Back Button Pressed

            // Back to Main Frame
            setVisible(false);
            new Main(pin);
        }
    }

//    public static void main(String[] args) {
//        new Withdrawal("");
//    }
}
