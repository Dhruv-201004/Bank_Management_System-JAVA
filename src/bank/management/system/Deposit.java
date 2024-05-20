package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textAmt;

    JButton b1, b2;
    Deposit(String pin){

        this.pin = pin;

        // ATM Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1550,830);
        add(img);

        // Amount Field
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        img.add(label1);

        textAmt = new TextField();
        textAmt.setBackground(new Color(255, 255, 255));
        textAmt.setBounds(460,230,320,25);
        textAmt.setFont(new Font("Raleway", Font.BOLD,22));
        img.add(textAmt);

        // Deposit Button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        img.add(b1);

        // Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        img.add(b2);

        // Frame Layout
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }
// Binding Events to Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Storing Data in Identifiers
            String amount = textAmt.getText();
            Date date = new Date();
            if (e.getSource()==b1){// Deposit Button Pressed
                // Error if Empty Field
                if (textAmt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                }else {
                    // Storing Data in DataBase
                    Conn c = new Conn();
                    c.statement.executeUpdate("INSERT INTO Bank VALUES('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);

                    // Open Main Window
                    new Main(pin);
                }
            }else if (e.getSource()==b2){// Back Button Pressed
                setVisible(false);
                // Open Main Window
                new Main(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        new Deposit("");
//    }
}
