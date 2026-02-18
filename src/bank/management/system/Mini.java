package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    Mini(String pin) {
        this.pin = pin;

        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);
        setTitle("Mini Statement");

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 300);
        add(label1);

        JLabel label2 = new JLabel("Indian Bank");
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        JLabel label3 = new JLabel("Card Number:");
        label3.setFont(new Font("System", Font.BOLD, 14));
        label3.setBounds(20, 80, 400, 20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setFont(new Font("System", Font.BOLD, 14));
        label4.setBounds(20, 450, 400, 20); 
        add(label4);

        try
        {
            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery("select * from login where pin = '" + pin + "'");
            if (rs.next())
            {
                label3.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }

            int balance = 0;
            String transactionHistory = ""; 
            rs = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next())
            {
                transactionHistory += rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>";

                if (rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            label1.setText("<html>" + transactionHistory + "</html>");
            label4.setText("Your current account balance is Rs " + balance);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        button = new JButton("EXIT");
        button.setBounds(150, 500, 100, 25);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}

