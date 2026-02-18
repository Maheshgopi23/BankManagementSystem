package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    MainClass(String pin)
    {

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/atmch.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image.setBounds(0, -30, screenSize.width, screenSize.height);
        add(image);

        JLabel label = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label.setBounds(350, 220, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,24));
        image.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(275, 300, 200, 35);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("System",Font.BOLD,15));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(675, 300, 200, 35);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("System",Font.BOLD,15));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(275, 365, 200, 35);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("System",Font.BOLD,15));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(675, 365, 200, 35);
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("System",Font.BOLD,15));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(275, 430, 200, 35);
        b5.setBackground(Color.WHITE);
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("System",Font.BOLD,15));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(675, 430, 200, 35);
        b6.setBackground(Color.WHITE);
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("System",Font.BOLD,15));
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(475, 495, 200, 35);
        b7.setBackground(Color.WHITE);
        b7.setForeground(Color.BLACK);
        b7.setFont(new Font("System",Font.BOLD,15));
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setSize(screenSize.width,screenSize.height);
        setLocation(0,0);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            new Deposit(pin).setVisible(false);
        }
        else if(e.getSource() == b2)
        {
            new Withdrawl(pin).setVisible(false);
        }
        else if(e.getSource() == b3)
        {
            new FastCash(pin).setVisible(false);
        }
        else if(e.getSource() == b4)
        {
            new Mini(pin);
        }
        else if(e.getSource() == b5)
        {
            new ChangePin(pin).setVisible(false);
        }
        else if(e.getSource() == b6)
        {
            new BalanceEnquiry(pin).setVisible(false);
        }
        else if(e.getSource() == b7)
        {
            System.exit(0);
        }   
        
    }
    public static void main(String[] args) {
        new MainClass("");
    }
}
