package furnitureapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddDesk extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField tf1, tf2,tf3,tf4, tf5, tf6, tf7;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    String woodType = "";
    JFrame jFrame;
    JButton btn4;
    AddDesk(JFrame jFrame)
    {
        setVisible(true);
        setBounds(500,100,500,500);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        this.jFrame = jFrame;

        setTitle("Set Attributes");
        l1 = new JLabel("Set Attributes");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));


        l2 = new JLabel("Item ID");
        l3 = new JLabel("Wood Type");
        l4 = new JLabel("Width");
        l5 = new JLabel("Depth");
        l6 = new JLabel("No of Drawers");


        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();



        btn1 = new JButton("Set");
        btn2 = new JButton("Oak");
        btn3 = new JButton("Walnut");
        btn4 = new JButton("Cancel");


        btn1.addActionListener(this);


        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);



        tf1.setBounds(250, 70, 200, 30);
        tf2.setBounds(250, 150, 200, 30);
        tf3.setBounds(250, 190, 200, 30);
        tf5.setBounds(250, 230, 200, 30);
        //  tf6.setBounds(250, 270, 200, 30);


        btn1.setBounds(100, 350, 100, 30);
        btn2.setBounds(250,110,100,30);
        btn3.setBounds(350,110,100,30);
        btn4.setBounds(250,350,100,30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(l4);
        add(tf2);
        add(l5);
        add(tf3);
        add(l6);
        add(tf5);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setEnabled(true);
                dispose();
            }
        });


        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                woodType = "Oak";
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                woodType = "Walnut";
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String ID = tf1.getText().trim();
        String width = tf2.getText().trim();
        String depth = tf3.getText().trim();
        String noOfDrawers = tf5.getText().trim();

        if(ID.isEmpty() || woodType.isEmpty() || width.isEmpty() || depth.isEmpty() || noOfDrawers.isEmpty()) {
            tf1.setText(null);
            woodType = "";
            tf2.setText(null);
            tf3.setText(null);
            tf5.setText(null);
            JOptionPane.showMessageDialog(this,"Field is empty");
        }
        else if(!isNumeric(ID) || !isNumeric(width) || !isNumeric(depth) || !isNumeric(noOfDrawers)) {
            tf1.setText(null);
            woodType = "";
            tf2.setText(null);
            tf3.setText(null);
            tf5.setText(null);
            JOptionPane.showMessageDialog(this,"Not a valid input");
        }
        else {
            int quantity = 0;
            String str = JOptionPane.showInputDialog(null,"Please enter number of quantity");
            try {
                quantity = Integer.parseInt(str);
            }
            catch(NumberFormatException e1) {
                GUI.list.remove(GUI.list.size()-1);
                JOptionPane.showMessageDialog(null,"Invalid Input");
                tf1.setText(null);
                woodType = "";
                tf2.setText(null);
                tf3.setText(null);
                tf4.setText(null);
                jFrame.setEnabled(true);
                dispose();
                return;
            }
            Furniture desk = new Desk(Integer.parseInt(ID),woodType.equals("Walnut")?0:1,quantity,Integer.parseInt(noOfDrawers),Integer.parseInt(width),
                    Integer.parseInt(depth));
            GUI.list.add(desk);

            int row = (GUI.list.size()-1)/3;
            int col = (GUI.list.size()-1)%3;

            if(col == 0) {
                GUI.defaultTableModel.setRowCount(GUI.list.size()>=9?GUI.defaultTableModel.getRowCount()+1:3);
            }
            Path path = Paths.get(""+Integer.parseInt(ID)+".jpg");
            ImageIcon imageIcon = new ImageIcon("Images//"+path.toString());
            Image image = imageIcon.getImage();
            Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
            ImageIcon imageIcon1 = new ImageIcon(image1);
            GUI.jTable.setValueAt(imageIcon1,row,col);
            tf1.setText(null);
            woodType = "";
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            jFrame.setEnabled(true);
            dispose();
        }
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
