package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_Enquiry extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton b1;
    Balance_Enquiry(String pin){
        this.pin =pin;

        // ATM Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // Current Balance Field
        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,700,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,400,35);
        l3.add(label2);

        // Back Button
        b1 = new JButton("Back");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Fetching Current Balance Amount From Bank
        int balance =0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Bank WHERE PIN = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("Type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // Displaying Balance
        label2.setText(""+balance);

        // Frame Layout
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    // Binding Event To Button
    @Override
    public void actionPerformed(ActionEvent e) {
        // Back Button Pressed - Back to Main Frame
        setVisible(false);
        new Main(pin);
    }

//    public static void main(String[] args) {
//        new Balance_Enquiry("");
//    }
}
