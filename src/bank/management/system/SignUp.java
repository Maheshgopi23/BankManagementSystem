package bank.management.system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignUp extends JFrame implements ActionListener {

    JTextField textName,textFname,textEmail,textMs,textAdd,textCity,textPin,textState;
    JButton next;
    JRadioButton r1,r2,m1,m2,m3;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    SignUp()
    {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO.");
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Arial",Font.BOLD,30));
        add(label1);

        JLabel labelFormNo = new JLabel(first);
        labelFormNo.setFont(new Font("Arial", Font.BOLD, 30));
        labelFormNo.setBounds(530, 20, 200, 40);
        add(labelFormNo);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Arial",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Arial",Font.BOLD,22));
        label3.setBounds(290,90,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Arial",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Arial",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name : ");
        labelfName.setFont(new Font("Arial",Font.BOLD,20));
        labelfName.setBounds(100,240,200,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Arial",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date Of Birth : ");
        DOB.setFont(new Font("Arial",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender : ");
        labelG.setFont(new Font("Arial",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.BOLD,14));
        r1.setBackground(new Color(0,255,255));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Arial",Font.BOLD,14));
        r2.setBackground(new Color(0,255,255));
        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelEmail = new JLabel("Email Address : ");
        labelEmail.setFont(new Font("Arial",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Arial",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status : ");
        labelMs.setFont(new Font("Arial",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,440,100,30);
        m1.setBackground(new Color(0,255,255));
        m1.setFont(new Font("Arial",Font.BOLD,14));
        add(m1);

        m2 = new JRadioButton("UnMarried");
        m2.setBounds(450,440,100,30);
        m2.setBackground(new Color(0,255,255));
        m2.setFont(new Font("Arial",Font.BOLD,14));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(600,440,100,30);
        m3.setBackground(new Color(0,255,255));
        m3.setFont(new Font("Arial",Font.BOLD,14));
        add(m3);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(m1);
        bg1.add(m2);
        bg1.add(m3);


        JLabel labelAdd = new JLabel("Address : ");
        labelAdd.setFont(new Font("Arial",Font.BOLD,20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Arial",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City : ");
        labelCity.setFont(new Font("Arial",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Arial",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code : ");
        labelPin.setFont(new Font("Arial",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Arial",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State : ");
        labelState.setFont(new Font("Arial",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Arial",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(new Color(0,255,255));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fName = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected())
        {
            gender = "Male";
        }
        else if(r2.isSelected())
        {
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected())
        {
            marital = "Married";
        }
        else if(m2.isSelected())
        {
            marital = "Unmarried";
        }
        else if(m3.isSelected())
        {
            marital = "Others";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try
        {
            if(textName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the Fields");
            }
            else
            {
                Conn con1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new SignUp2(formno);
                setVisible(false);
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new SignUp();
    }

}
