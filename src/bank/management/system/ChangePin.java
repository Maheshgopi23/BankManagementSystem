package bank.management.system;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;

public class ChangePin extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pinTextField, repinTextField;
    String pin;
    ChangePin(String pin)
    {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/atmch.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image.setBounds(0, -30, screenSize.width, screenSize.height);
        add(image);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System",Font.BOLD,24));
        label1.setForeground(Color.WHITE);
        label1.setBounds(500, 220, 700, 35);
        image.add(label1);

        JLabel label2 = new JLabel("NEW PIN:");
        label2.setFont(new Font("System",Font.BOLD,24));
        label2.setForeground(Color.WHITE);
        label2.setBounds(275, 300, 700, 35);
        image.add(label2);

        
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        pinTextField.setBounds(525, 300, 350, 35);
        pinTextField.setBackground(Color.WHITE);
        pinTextField.setForeground(Color.BLACK);
        image.add(pinTextField);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN:");
        label3.setFont(new Font("System",Font.BOLD,24));
        label3.setForeground(Color.WHITE);
        label3.setBounds(275, 360, 700, 35);
        image.add(label3);

        repinTextField = new JPasswordField();
        repinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        repinTextField.setBounds(525, 360, 350, 35);
        repinTextField.setBackground(Color.WHITE);
        repinTextField.setForeground(Color.BLACK);
        image.add(repinTextField);

        change = new JButton("CHANGE");
        change.setBounds(275, 450, 200, 35);
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("System",Font.BOLD,15));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(675, 450, 200, 35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);

        
        setLayout(null);
        setSize(screenSize.width,screenSize.height);
        setLocation(0,0);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setTitle("Change Pin");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == back)
        {
            setVisible(false);
            new MainClass(pin).setVisible(true);
        }

        try{
            String newPin = pinTextField.getText();
            String rePin = repinTextField.getText();
            if(!newPin.equals(rePin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(e.getSource() == change)
            {
                if(pinTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                if(repinTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
            
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rePin+"' where pin = '"+pin+"'";
                String query2 = "update login set pin = '"+rePin+"' where pin = '"+pin+"'";
                String query3 = "update signupthree set pin = '"+rePin+"' where pin = '"+pin+"'";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new MainClass(rePin);
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ChangePin("");
    }
}
