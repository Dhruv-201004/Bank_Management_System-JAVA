package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_2 extends JFrame implements ActionListener {
    JComboBox comboBox1,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2, e1,e2;
    JButton next;
    String formno;
    SignUp_2(String formno){
        // TITLE
        super("APPLICATION FORM");

        // Bank Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno = formno;

        // Heading
        JLabel l1 = new JLabel("Form 2 ");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(450,30,600,40);
        add(l1);

        // Sub-Heading
        JLabel l2 = new JLabel("Additonal Details");
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        l2.setBounds(400,60,600,40);
        add(l2);

        // FORM NO.
        JLabel l3 = new JLabel("Form No : ");
        l3.setFont(new Font("Raleway", Font.BOLD,14));
        l3.setBounds(700,10,100,30);
        add(l3);

        JLabel l4 = new JLabel(formno);
        l4.setFont(new Font("Raleway", Font.BOLD,14));
        l4.setBounds(760,10,60,30);
        add(l4);
        // Religion Field
        JLabel l5 = new JLabel("Religion :");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(100,120,100,30);
        add(l5);

        String religion[] = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        comboBox1 = new JComboBox(religion);
        comboBox1.setBackground(new Color(243, 206, 97));
        comboBox1.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox1.setBounds(350,120,320,30);
        add(comboBox1);

        // Category Field
        JLabel l6 = new JLabel("Category : ");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(100,170,100,30);
        add(l6);

        String Category [] = {"General","OBC","SC", "ST", "Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(243, 206, 97));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        // Income Field
        JLabel l7 = new JLabel("Income : ");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(100,220,100,30);
        add(l7);

        String income [] = {"Null","<1,50,000","<2,50,000", "<5,00,000", "Upto 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(243, 206, 97));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        // Educational Field
        JLabel l8 = new JLabel("Educational : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,270,150,30);
        add(l8);

        String educational [] = {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(243, 206, 97));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        // Occupation Field
        JLabel l9 = new JLabel("Occupation : ");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(100,340,150,30);
        add(l9);

        String Occupation [] = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(243, 206, 97));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,340,320,30);
        add(comboBox5);

        // PAN No. Field
        JLabel l10 = new JLabel("PAN Number : ");
        l10.setFont(new Font("Raleway", Font.BOLD,18));
        l10.setBounds(100,390,150,30);
        add(l10);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD,18));
        textPan.setBounds(350,390,320,30);
        add(textPan);

        // Aadhar No. Field
        JLabel l11 = new JLabel("Aadhar Number : ");
        l11.setFont(new Font("Raleway", Font.BOLD,18));
        l11.setBounds(100,440,180,30);
        add(l11);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,18));
        textAadhar.setBounds(350,440,320,30);
        add(textAadhar);

        // Senior Citizen Field
        JLabel l12 = new JLabel("Senior Citizen : ");
        l12.setFont(new Font("Raleway", Font.BOLD,18));
        l12.setBounds(100,490,180,30);
        add(l12);

        //RadioButtons
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(243, 206, 97));
        r1.setBounds(350,490,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(243, 206, 97));
        r2.setBounds(460,490,100,30);
        add(r2);

        // Grouping Buttons
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        // Existing Account
        JLabel l13 = new JLabel("Existing Account : ");
        l13.setFont(new Font("Raleway", Font.BOLD,18));
        l13.setBounds(100,540,180,30);
        add(l13);

        // RadioButtons
        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,14));
        e1.setBackground(new Color(243, 206, 97));
        e1.setBounds(350,540,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,14));
        e2.setBackground(new Color(243, 206, 97));
        e2.setBounds(460,540,100,30);
        add(e2);

        // Grouping Buttons
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);


        // NEXT BUTTON
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);

        // Frame Layout
        getContentPane().setBackground(new Color(243, 206, 97));
        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        setUndecorated(true);
        setVisible(true);
    }
    // Binding Event To Button
    @Override
    public void actionPerformed(ActionEvent e) {

        // Storing Data In Identifiers
        String rel = (String) comboBox1.getSelectedItem();
        String cate= (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String scitizen = " ";
        if ((r1.isSelected())){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen ="No";
        }

        String eAccount = " ";
        if ((r1.isSelected())){
            eAccount = "Yes";
        } else if (r2.isSelected()) {
            eAccount ="No";
        }

        // Storing Data Into DataBase
        try{
            // Show Error If any Field Is Empty
            if (textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {
                Conn c = new Conn();

                // Query to Store Data
                String q = "INSERT INTO SignUP_2 VALUES('"+formno+"', '"+rel+"', '"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eAccount+"')";
                c.statement.executeUpdate(q);

                // Opening Form 3
                new SignUp_3(formno);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new SignUp_2("");
//    }
}
