package furnitureapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
//AddTable button implementation
public class AddTable extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5;
    JTextField tf1, tf2,tf3;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;

    String woodType = "";
    String baseType = "";
    JButton btn6;
    JFrame jFrame;
    AddTable(JFrame jFrame)
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
        l4 = new JLabel("Base Type");
        l5 = new JLabel("Diameter");

        tf1 = new JTextField();
        tf3 = new JTextField();

        btn1 = new JButton("Set");
        btn2 = new JButton("Oak");
        btn3 = new JButton("Walnut");
        btn4 = new JButton("Wooden");
        btn5 = new JButton("Chrome");
        btn6 = new JButton("Cancel");

        btn1.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);

        tf1.setBounds(250, 70, 200, 30);
        tf3.setBounds(250, 190, 200, 30);

        btn1.setBounds(100, 250, 100, 30);
        btn2.setBounds(250,110,100,30);
        btn3.setBounds(350,110,100,30);
        btn4.setBounds(250,150,100,30);
        btn5.setBounds(350,150,100,30);
        btn6.setBounds(250,250,100,30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(l4);
        add(l5);
        add(tf3);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);

        //ActionListener for all buttons
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

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseType = "Wooden";
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseType = "Chrome";
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setEnabled(true);
                dispose();
            }
        });
    }

    //ActionListener for Set button
    @Override
    public void actionPerformed(ActionEvent e) {

        String ID = tf1.getText().trim();
        String diameter = tf3.getText().trim();

        if(ID.isEmpty() || woodType.isEmpty()||baseType.isEmpty()||diameter.isEmpty()) {
            tf1.setText(null);
            woodType = "";
            baseType = "";
            tf3.setText(null);
            JOptionPane.showMessageDialog(this,"Field is empty");
        }
        else if(!isNumeric(ID) || !isNumeric(diameter)) {
            tf1.setText(null);
            woodType = "";
            baseType = "";
            tf3.setText(null);
            JOptionPane.showMessageDialog(this,"Not a valid input");
        }
        else {
            int quantity = 0;
            String str = JOptionPane.showInputDialog(null,"Please enter number of quantity");
            try {
                quantity = Integer.parseInt(str);
            }
            catch(NumberFormatException e1) {
                JOptionPane.showMessageDialog(null,"Invalid Input");
                tf1.setText(null);
                woodType = "";
                baseType = "";
                tf3.setText(null);
                jFrame.setEnabled(true);
                dispose();
            }
            Furniture table = new Table(1,Integer.parseInt(diameter),Integer.parseInt(ID),woodType.equals("Walnut")
            ?0:1,quantity,baseType.equals("Wooden")?0:1);
            GUI.list.add(table);

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
            baseType = "";
            tf3.setText(null);
            jFrame.setEnabled(true);
            dispose();
            return;
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
