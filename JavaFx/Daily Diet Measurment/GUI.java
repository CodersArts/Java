package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {

    public GUI()
    {

        setBounds(500,100,600,500);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JLabel jLabel = new JLabel("Welcome to Nutrition Center");
        jLabel.setBounds(150,100,400,30);
        Font font = new Font("Helvetica Neue",Font.BOLD,20);
        jLabel.setFont(font);

        JButton jButton = new JButton("Register");
        JButton jButton1 = new JButton("Login");
        JButton jButton2 = new JButton("Cancel");

        jButton.setBounds(80,300,100,30);
        jButton1.setBounds(230,300,100,30);
        jButton2.setBounds(380,300,100,30);

        jButton.setBackground(new Color(118,162,255));
        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton1.setBackground(new Color(118,162,255));
        jButton1.setBorder(new EmptyBorder(10,10,10,10));
        jButton2.setBackground(new Color(118,162,255));
        jButton2.setBorder(new EmptyBorder(10,10,10,10));

        container.add(jButton);
        container.add(jButton1);
        container.add(jLabel);
        container.add(jButton2);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String filename = "user.csv";
                File file = new File(filename);
                if(file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                User.store(filename);

                if(Home.username == null) {
                    System.exit(0);
                }
                UserDetails userDetails = User.get(Home.username);
                userDetails.store(Home.username+".txt");
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
