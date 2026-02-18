package bank.management.system;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

    String pin;
    JLabel label2;
    JButton back;
    BalanceEnquiry(String pin)
    {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/atmch.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image.setBounds(0, -30, screenSize.width, screenSize.height);
        add(image);

        JLabel label1 = new JLabel("Your Current Account Balance is Rs. ");
        label1.setFont(new Font("System",Font.BOLD,24));
        label1.setForeground(Color.WHITE);
        label1.setBounds(300, 250, 700, 35);
        image.add(label1);

        label2 = new JLabel("");
        label2.setFont(new Font("System",Font.BOLD,24));
        label2.setForeground(Color.WHITE);
        label2.setBounds(390, 290, 700, 35);
        image.add(label2);

        back = new JButton("BACK");
        back.setBounds(675, 430, 200, 35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        int balance = 0;
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        label2.setText("Rs. "+balance);

        setTitle("Balance Enquiry");
        setLayout(null);
        setSize(screenSize.width,screenSize.height);
        setLocation(0,0);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back)
        {
            setVisible(false);
            new MainClass(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);   
    }
}
