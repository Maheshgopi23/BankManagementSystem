package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class Login extends JFrame implements ActionListener{
    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField2;
    JButton button1, button2, button3;
    Login()
    {
        super("Bank Management System");



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("assets/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        label2 = new JLabel("Enter Card Number : ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        label3 = new JLabel("Enter PIN : ");
        label3.setForeground(Color.WHITE);  
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setBounds(150, 250, 375, 30);
        add(label3);


        textField1 = new JTextField();
        textField1.setBounds(350, 190, 200, 30);
        textField1.setFont(new Font("Arial", Font.BOLD, 15));
        add(textField1);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(350, 250, 200, 30);
        passwordField2.setFont(new Font("Arial", Font.BOLD, 15));
        add(passwordField2);


        button1 = new JButton("SIGN IN");
        button1.setBounds(150, 320, 120, 30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setBounds(320, 320, 120, 30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setBounds(490, 320, 120, 30);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.addActionListener(this);
        add(button3);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("assets/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1)
            {
                Conn con = new Conn();
                String cardnumber = textField1.getText().trim();
                String pin = new String(passwordField2.getPassword()).trim();
                String query = "select * from login where card_number = '"+cardnumber+"' and pin = '"+pin+"'";
                ResultSet resultSet = con.statement.executeQuery(query);
                if(resultSet.next())
                {
                    setVisible(false);
                    new MainClass(pin).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            else if(e.getSource() == button2)
            {
                textField1.setText("");
                passwordField2.setText("");
            }
            else if(e.getSource() == button3)
            {
                new SignUp();
                setVisible(false);
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
