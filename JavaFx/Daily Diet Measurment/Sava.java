package sample;
//Save button implementation

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Save extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JTextField tf1;
    JButton btn1;
    JButton btn2;
    Save()
    {
        setVisible(true);
        setBounds(580,180,400,400);
        setLayout(null);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        setTitle("Save To File");
        l1 = new JLabel("Save To File");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Please enter file name");

        tf1 = new JTextField();

        btn1 = new JButton("Save");
        btn2 = new JButton("Cancel");

        btn1.addActionListener(this);

        l1.setBounds(80, 30, 400, 30);
        l2.setBounds(80,100,200,30);

        tf1.setBounds(80, 150, 200, 30);

        btn1.setBounds(80, 250, 100, 30);
        btn2.setBounds(200,250,100,30);


        tf1.setBorder(new LineBorder(Color.BLACK,1,true));
        tf1.setFont(new Font("Serif",Font.PLAIN,15));
        btn1.setBackground(new Color(118,162,255));
        btn1.setBorder(new EmptyBorder(10,10,10,10));
        btn2.setBackground(new Color(118,162,255));
        btn2.setBorder(new EmptyBorder(10,10,10,10));

        container.add(l1);
        container.add(l2);
        container.add(tf1);
        container.add(btn1);
        container.add(btn2);

        //ActionListener for all buttons
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btn1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String filename = tf1.getText().trim()+".txt";
        UserDetails userDetails = User.get(Home.username);
        userDetails.store(filename);
        //JOptionPane.showMessageDialog(null,"File is successfully saved!!");
        dispose();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
