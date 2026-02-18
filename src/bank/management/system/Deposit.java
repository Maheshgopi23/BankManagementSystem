package bank.management.system;

import java.awt.Image;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame implements ActionListener{
    String pin;
    TextField amount;
    JButton deposit, back;
    Deposit(String pin)
    {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/atmch.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image.setBounds(0, -30, screenSize.width, screenSize.height);
        add(image);

        JLabel label1 = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        label1.setFont(new Font("System",Font.BOLD,24));
        label1.setForeground(Color.WHITE);
        label1.setBounds(300, 220, 700, 35);
        image.add(label1);

        amount = new TextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(400, 280, 350, 35);
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(675, 365, 200, 35);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("System",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(675, 430, 200, 35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        setTitle("Deposit");
        setLayout(null);
        setSize(screenSize.width,screenSize.height);
        setLocation(0,0);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            String amount = this.amount.getText();
            Date date = new Date();
            if(e.getSource() == deposit)
            {
                if(amount.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
                }
                else{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new MainClass(pin);
                }
            }
            else if(e.getSource() == back)
            {
                setVisible(false);
                new MainClass(pin);
            }
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
        
        
    }
    public static void main(String[] args) {
        new Deposit(" ");
    }

}
