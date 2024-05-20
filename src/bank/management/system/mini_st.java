package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini_st extends JFrame implements ActionListener {
    String pin;
    JButton button;
    mini_st(String pin){
        this.pin = pin;

        // Heading
        JLabel label1 = new JLabel("INDIAN BANK");
        label1.setFont(new Font("System", Font.BOLD,15));
        label1.setBounds(150,20,200,20);
        add(label1);

        // Card Number Field
        JLabel label2 = new JLabel();
        label2.setBounds(20,80,300,20);
        add(label2);


        // Transaction Field
        JLabel label3 = new JLabel();
        label3.setBounds(20,140,400,200);
        add(label3);
        // Current Balance Field
        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);


        // Fetching Data From DataBase
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Login WHERE PIN = '"+pin+"'");
            while (resultSet.next()){
                label2.setText("Card Number:  "+ resultSet.getString("Card_Number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("Card_Number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        // Calculating Current Balance
        try{
            int balance =0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Bank WHERE PIN = '"+pin+"'");
            while (resultSet.next()){

                if (resultSet.getString("Type").equals("Deposit")){
                    label3.setText(label3.getText() + "<html>"+resultSet.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Amount")+ "<br><br><html>");
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    label3.setText(label3.getText() + "<html>"+resultSet.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Type")+"&nbsp;&nbsp;&nbsp;"+resultSet.getString("Amount")+ "<br><br><html>");
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Exit Button
        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        // Frame Layout
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    // EXIT Button Pressed Closes MINI STATEMENT FRAME
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

//    public static void main(String[] args) {
//        new mini_st("");
//    }
}
