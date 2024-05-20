package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin =pin;

        // ATM Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // Heading
        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,400,35);
        l3.add(label1);

        //  New PIN Field
        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);

        // Re-Enter PIN Field
        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430,250,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600,255,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);


        // Change Button
        b1 = new JButton("CHANGE");
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


        // Frame Layout
        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    // Binding Events to Buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (e.getSource()==b1){// Change PIN Button Pressed
                if (!pin1.equals(pin2)){// Error if Both Fields does not match
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                if(p1.getText().length()!=4 ){
                    JOptionPane.showMessageDialog(null,"Enter a 4-digit PIN");
                    return;
                }

                // Updating PIN in DataBase
                Conn c = new Conn();
                String q1 = "UPDATE Bank SET PIN = '"+pin1+"' WHERE PIN = '"+pin+"'";
                String q2 = "UPDATE Login SET PIN = '"+pin1+"' WHERE PIN = '"+pin+"'";
                String q3 = "UPDATE SignUp_3 SET PIN = '"+pin1+"' WHERE PIN = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                // Message appears
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);

                // Back to Main Frame
                new Main(pin1);

            } else if (e.getSource()==b2) {// Back Button Pressed
                // Back to Main Frame
                setVisible(false);
                new Main(pin);
            }


        }catch (Exception E){
            E.printStackTrace();
        }
    }
   // public static void main(String[] args) {
      //  new Pin("");
    //}
}