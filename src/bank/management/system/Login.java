package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
    Login(){
        // TITLE
        super("Bank Management System");

        // Bank Image
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        // Card Image
        ImageIcon I1 =  new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image I2 = I1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel Image = new JLabel(I3);
        Image.setBounds(630,350,100,100);
        add(Image);

        // Sub Heading
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        // Card No Field
        label2 = new JLabel("Card No:");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        // PIN Field
        label3 = new JLabel("PIN:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        // SIGN IN Button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        button1.setBounds(320,300,100,30);
        button1.addActionListener(this);
        add(button1);

        // Clear Button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button2.setBounds(460,300,100,30);
        button2.addActionListener(this);
        add(button2);

        // SIGN UP Button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.BLACK);
        button3.setBounds(320,350,240,30);
        button3.addActionListener(this);
        add(button3);


        // BackGround Image
        ImageIcon I_1 =  new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image I_2 = I_1.getImage().getScaledInstance(850,480,java.awt.Image.SCALE_DEFAULT);
        ImageIcon I_3 = new ImageIcon(I_2);
        JLabel Image_1 = new JLabel(I_3);
        Image_1.setBounds(0,0,850,480);
        add(Image_1);

        // Frame Layout
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);
    }

    // Binding Events to Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){// SIGN IN
                Conn c = new Conn();

                String cardno = textField2.getText();
                String pin = passwordField3.getText();

                // Query To Fetch Data From DataBase
                String q = "SELECT* FROM Login WHERE Card_Number = '"+ cardno+"' AND PIN = '"+pin+"'";

                // Store Data From DataBase
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){// If Data Match Open Main Frame
                    setVisible(false);
                    new Main(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }

            } else if (e.getSource()==button2) {//CLEAR
                textField2.setText("");
                passwordField3.setText("");

            } else if (e.getSource()==button3) {//SIGN UP
                new SignUp_1();
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
