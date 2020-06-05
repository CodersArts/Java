package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {

    public Login()
    {
        setBounds(520,120,550,400);
        setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel jLabel4 = new JLabel("Login");
        jLabel4.setBounds(150,20,200,30);
        jLabel4.setForeground(Color.BLACK);
        jLabel4.setFont(new Font("Sans-Serif", Font.BOLD, 20));

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JLabel jLabel = new JLabel("Username");
        JLabel jLabel1 = new JLabel("Password");

        jLabel.setBounds(100,100,100,30);
        jLabel1.setBounds(100,150,100,30);

        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();

        jTextField.setBounds(250,100,200,30);
        jPasswordField.setBounds(250,150,200,30);
        jTextField.setBorder(new LineBorder(Color.BLACK,1,true));
        jTextField.setFont(new Font("Serif",Font.PLAIN,15));
        jPasswordField.setBorder(new LineBorder(Color.BLACK,1,true));
        jPasswordField.setFont(new Font("Serif",Font.PLAIN,15));

        JButton jButton = new JButton("Login");
        JButton jButton1 = new JButton("Cancel");

        jButton.setBounds(150,300,100,30);
        jButton.setBackground(new Color(118,162,255));
        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton1.setBounds(300,300,100,30);
        jButton1.setBackground(new Color(118,162,255));
        jButton1.setBorder(new EmptyBorder(10,10,10,10));


        container.add(jLabel);
        container.add(jLabel1);
        container.add(jTextField);
        container.add(jPasswordField);
        container.add(jButton);
        container.add(jButton1);
        container.add(jLabel4);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = jTextField.getText().trim();
                String password = jPasswordField.getText().trim();

                if(username.isEmpty() || password.isEmpty()) {
                    jTextField.setText(null);
                    jPasswordField.setText(null);
                    JOptionPane.showMessageDialog(null,"Field is empty");
                }
                else if(!User.check(username,password)) {
                    JOptionPane.showMessageDialog(null,"Username or password is incorrect");
                    jTextField.setText(null);
                    jPasswordField.setText(null);
                }
                else {
                    new Home(username);
                    UserDetails userDetails = User.get(username);
                    File file = new File(username+".txt");
                    if(!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    userDetails.load(username+".txt");
                    jTextField.setText(null);
                    jPasswordField.setText(null);
                    dispose();
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
