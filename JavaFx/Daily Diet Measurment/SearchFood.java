package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFood extends JFrame implements ActionListener {

    public SearchFood()
    {
        setBounds(580,180,500,400);
        setVisible(true);
        setTitle("Search Food");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JLabel jLabel = new JLabel("Search Food : ");
        jLabel.setBounds(50,100,200,30);

        JCheckBox jCheckBox = new JCheckBox("Food ");
        JCheckBox jCheckBox1 = new JCheckBox("Beverages ");

        jCheckBox.setBounds(100,150,100,30);
        jCheckBox1.setBounds(250,150,150,30);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(200,100,200,30);

        JButton jButton = new JButton("Search");
        jButton.setBounds(100,250,100,30);

        JButton jButton1 = new JButton("Cancel");
        jButton1.setBounds(250,250,100,30);


        jTextField.setBorder(new LineBorder(Color.BLACK,1,true));
        jTextField.setFont(new Font("Serif",Font.PLAIN,15));
        jButton.setBackground(new Color(118,162,255));
        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton1.setBackground(new Color(118,162,255));
        jButton1.setBorder(new EmptyBorder(10,10,10,10));

        jCheckBox.setBackground(new Color(255,255,255));
        jCheckBox.setBorder(new EmptyBorder(10,10,10,10));
        jCheckBox1.setBackground(new Color(255,255,255));
        jCheckBox1.setBorder(new EmptyBorder(10,10,10,10));




        container.add(jLabel);
        container.add(jTextField);
        container.add(jButton);
        container.add(jButton1);
        container.add(jCheckBox);
        container.add(jCheckBox1);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String search = jTextField.getText().trim();
                boolean checkBox = jCheckBox.isSelected();
                boolean checkBox1 = jCheckBox1.isSelected();
                dispose();
                new Result(search,checkBox,checkBox1);
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
