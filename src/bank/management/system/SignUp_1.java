package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp_1 extends JFrame implements ActionListener {
    JTextField textName,textFName,textEmail,
            textAddr,textCt,textPc,textSt;
    JDateChooser dateChooser;
    JRadioButton r1,r2,r3,m1,m2,m3;
    JButton Next;
    Random r = new Random();
    long fno = (r.nextLong() % 9000L) + 1000L;
    String f = " "+ Math.abs(fno);
    SignUp_1(){
        // TITLE
        super("APPLICATION FORM");

        // Bank Image
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        // Heading
        JLabel label1 = new JLabel("APPLICATION FORM NO."+ f);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        // Sub-Heading 1
        JLabel label2 = new JLabel("Form 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(390,70,600,30);
        add(label2);

        // Sub-Heading 2
        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(340,90,600,30);
        add(label3);

        // Name Field
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,20));
        textName.setBounds(300,190,400,30);
        add(textName);

        //Father's Name Field
        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setFont(new Font("Raleway",Font.BOLD,20));
        labelFName.setBounds(100,240,200,30);
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway",Font.BOLD,20));
        textFName.setBounds(300,240,400,30);
        add(textFName);

        //DOB Field
        JLabel DOB = new JLabel("Date Of Birth :");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        // Calender for DOB
        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.white);
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        // Gender Field
        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        // RadioButtons For Male/Female/Other
        r1 = new JRadioButton("Male");
        r1.setBackground(Color.CYAN);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.CYAN);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(420,290,80,30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setBackground(Color.CYAN);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBounds(550,290,90,30);
        add(r3);

        // Grouping Buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        // Email Field
        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,20));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        // Marital Status Field
        JLabel labelMS = new JLabel("Email :");
        labelMS.setFont(new Font("Raleway",Font.BOLD,20));
        labelMS.setBounds(100,440,200,30);
        add(labelMS);

        // RadioButtons For Married/Unmarried/Other
        m1 = new JRadioButton("Married");
        m1.setBackground(Color.CYAN);
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBounds(300,440,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(Color.CYAN);
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBounds(420,440,100,30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(Color.CYAN);
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBounds(550,440,100,30);
        add(m3);

        // Grouping Buttons
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        // Address Field
        JLabel labelAddr = new JLabel("Address :");
        labelAddr.setFont(new Font("Raleway",Font.BOLD,20));
        labelAddr.setBounds(100,490,200,30);
        add(labelAddr);

        textAddr = new JTextField();
        textAddr.setFont(new Font("Raleway",Font.BOLD,20));
        textAddr.setBounds(300,490,400,30);
        add(textAddr);

        // City Field
        JLabel labelCt = new JLabel("City :");
        labelCt.setFont(new Font("Raleway",Font.BOLD,20));
        labelCt.setBounds(100,540,200,30);
        add(labelCt);

        textCt = new JTextField();
        textCt.setFont(new Font("Raleway",Font.BOLD,20));
        textCt.setBounds(300,540,400,30);
        add(textCt);

        // Pin Code Field
        JLabel labelPc = new JLabel("Pin Code :");
        labelPc.setFont(new Font("Raleway",Font.BOLD,20));
        labelPc.setBounds(100,590,200,30);
        add(labelPc);

        textPc = new JTextField();
        textPc.setFont(new Font("Raleway",Font.BOLD,20));
        textPc.setBounds(300,590,400,30);
        add(textPc);

        // State Field
        JLabel labelSt = new JLabel("State :");
        labelSt.setFont(new Font("Raleway",Font.BOLD,20));
        labelSt.setBounds(100,640,200,30);
        add(labelSt);

        textSt = new JTextField();
        textSt.setFont(new Font("Raleway",Font.BOLD,20));
        textSt.setBounds(300,640,400,30);
        add(textSt);


        // Next Button
        Next = new JButton("Next");
        Next.setFont(new Font("Raleway",Font.BOLD,14));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(620,700,80,30);
        Next.addActionListener(this);
        add(Next);


        // Main Frame Layout
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Storing Data In Identifiers
        String FNo = f;
        String Name = textName.getText();
        String FName = textFName.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if(r1.isSelected()){
            Gender= "Male";
        } else if (r2.isSelected()) {
            Gender = "Female";
        } else if (r3.isSelected()) {
            Gender = "Other";
        }

        String Email = textEmail.getText();
        String Marital = null;
        if(m1.isSelected()){
            Marital = "Married";
        } else if (m2.isSelected()) {
            Marital = "Unmarried";
        } else if (m3.isSelected()) {
            Marital = "Other";
        }

        String Address = textAddr.getText();
        String City = textCt.getText();
        String PC = textPc.getText();
        String State = textSt.getText();

        // Storing Data In DataBase
        try{
            // Show Error If any Field Is Empty
            if(textName.getText().equals("")|| textFName.getText().equals("")|| textAddr.getText().equals("")|| textCt.getText().equals("")|| textPc.getText().equals("")|| textSt.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the Fields"
                );
            }
            else{
                Conn con = new Conn();

                // Query to Store Data
                String q = "INSERT INTO SignUp_1 VALUES('"+FNo+"','"+Name+"','"+FName+"','"+DOB+"','"+Gender+"','"+Email+"','"+Marital+"','"+Address+"','"+City+"','"+PC+"','"+State+"')";
                con.statement.executeUpdate(q);

                // Open Form 2
                new SignUp_2(f);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new SignUp_1();
//    }
}
