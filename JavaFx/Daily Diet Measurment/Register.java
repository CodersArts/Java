package sample;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    JTextArea tf7;
    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    Pattern pattern1 = Pattern.compile(regex);
    public Register()
    {
        setVisible(true);
        setBounds(500,100,600,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("User Registration");
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        l1 = new JLabel("User Registration");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Username : ");
        l3 = new JLabel("Name : ");
        l4 = new JLabel("Enter password : ");
        l5 = new JLabel("Confirm Password : ");
        l6 = new JLabel("Phone Number : ");
        l7 = new JLabel("Email: ");
        l8 = new JLabel("Address : ");
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextArea();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Cancel");

        tf1.setBorder(new LineBorder(Color.BLACK,1,true));
        tf1.setFont(new Font("Serif",Font.PLAIN,15));
        tf2.setBorder(new LineBorder(Color.BLACK,1,true));
        tf2.setFont(new Font("Serif",Font.PLAIN,15));
        p1.setBorder(new LineBorder(Color.BLACK,1,true));
        p1.setFont(new Font("Serif",Font.PLAIN,15));
        p2.setBorder(new LineBorder(Color.BLACK,1,true));
        p2.setFont(new Font("Serif",Font.PLAIN,15));
        tf5.setBorder(new LineBorder(Color.BLACK,1,true));
        tf5.setFont(new Font("Serif",Font.PLAIN,15));
        tf6.setBorder(new LineBorder(Color.BLACK,1,true));
        tf6.setFont(new Font("Serif",Font.PLAIN,15));
        tf7.setBorder(new LineBorder(Color.BLACK,1,true));
        tf7.setFont(new Font("Serif",Font.PLAIN,15));

        btn1.setBackground(new Color(118,162,255));
        btn1.setBorder(new EmptyBorder(10,10,10,10));
        btn2.setBackground(new Color(118,162,255));
        btn2.setBorder(new EmptyBorder(10,10,10,10));


        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        tf7.setBorder(border);
        tf7.setLineWrap(true);
        tf7.setWrapStyleWord(true);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 100);
        btn1.setBounds(150, 450, 100, 30);
        btn2.setBounds(300, 450, 100, 30);
        container.add(l1);
        container.add(l2);
        container.add(tf1);
        container.add(l3);
        container.add(tf2);
        container.add(l4);
        container.add(p1);
        container.add(l5);
        container.add(p2);
        container.add(l6);
        container.add(tf5);
        container.add(l7);
        container.add(tf6);
        container.add(l8);
        container.add(tf7);
        container.add(btn1);
        container.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = tf1.getText().trim();
                String name = tf2.getText().trim();
                String password = p1.getText().trim();
                String confirmPassword = p2.getText().trim();
                String phone = tf5.getText().trim();
                String email = tf6.getText().trim();
                String address = tf7.getText().trim();

                if(username.isEmpty() || name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty() || email.isEmpty() ||address.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Field is empty");
                    tf1.setText(null);
                    tf2.setText(null);
                    p1.setText(null);
                    p2.setText(null);
                    tf5.setText(null);
                    tf6.setText(null);
                    tf7.setText(null);
                }
                else if(!isNumeric(phone)) {
                    JOptionPane.showMessageDialog(null,"Phone number is not valid");
                    tf5.setText(null);
                }
                else if(phone.length() != 10) {
                    JOptionPane.showMessageDialog(null,"Phone number is not valid");
                    tf5.setText(null);
                }
                else if(!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null,"Password and confirm password is not equal");
                    p1.setText(null);
                    p2.setText(null);
                }
                else if(!validate(password)) {
                    JOptionPane.showMessageDialog(null,"Password must contain a number,uppercase and " +
                            "lowercase letter and a special character");
                    p1.setText(null);
                    p2.setText(null);
                }
                else if(containsUsername(username)) {
                    JOptionPane.showMessageDialog(null,"Username is already present!!");
                    tf1.setText(null);
                }
                else if(!validateEmail(email)) {
                    JOptionPane.showMessageDialog(null,"Email is not in valid format");
                    tf6.setText(null);
                }
                else {

                    UserDetails userDetails = new UserDetails(username,name,password,phone,email,address);
                    User.add(userDetails);
                    tf1.setText(null);
                    tf2.setText(null);
                    p1.setText(null);
                    p2.setText(null);
                    tf5.setText(null);
                    tf6.setText(null);
                    tf7.setText(null);
                    JOptionPane.showMessageDialog(null,"Successfully registered");
                    dispose();
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean validate(final String password){

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean containsUsername(String username)
    {

        for(int i=0;i<User.list.size();i++)
        {
            UserDetails userDetails = User.list.get(i);
            if(username.equals(userDetails.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean validateEmail(final String password){
        matcher = pattern1.matcher(password);
        return matcher.matches();
    }
}
