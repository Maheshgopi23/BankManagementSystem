package bank.management.system;

import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.JOptionPane;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener
{
    String pin;
    TextField amount;
    JButton withdrawl, back;
    Withdrawl(String pin)
    {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/atmch.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image.setBounds(0, -30, screenSize.width, screenSize.height);
        add(image);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setFont(new Font("System",Font.BOLD,24));
        label1.setForeground(Color.WHITE);
        label1.setBounds(350, 250, 700, 35);
        image.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setFont(new Font("System",Font.BOLD,24));
        label2.setForeground(Color.WHITE);
        label2.setBounds(390, 290, 700, 35);
        image.add(label2);

        amount = new TextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(400, 350, 350, 35);
        image.add(amount);

        withdrawl = new JButton("WITHDRAWL");
        withdrawl.setBounds(675, 430, 200, 35);
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("System",Font.BOLD,15));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("BACK");
        back.setBounds(675, 495, 200, 35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        setTitle("Withdrawl");
        setLayout(null);
        setSize(screenSize.width,screenSize.height);
        setLocation(0,0);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try{
            String amount = this.amount.getText();
            Date date = new Date();
            if(e.getSource() == withdrawl)
            {
                if(amount.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                }
                else
                {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(resultSet.next())
                    {
                        if(resultSet.getString("type").equals("Deposit"))
                        {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }
                        else
                        {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawn Successfully");
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
        catch(Exception ex)
        {
            ex.printStackTrace();
        }    
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
