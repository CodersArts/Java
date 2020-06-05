package furnitureapp;
//Save button implementation
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField tf1, tf2,tf3,tf4, tf5, tf6, tf7;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    Save(JFrame jFrame)
    {
        setVisible(true);
        setBounds(500,100,400,400);
        setLayout(null);
        setResizable(false);

        setTitle("Save To File");
        l1 = new JLabel("Save To File");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Please enter file name");

        tf1 = new JTextField();

        btn1 = new JButton("Save");
        btn2 = new JButton("Cancel");

        btn1.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80,70,200,30);

        tf1.setBounds(80, 110, 200, 30);

        btn1.setBounds(80, 180, 100, 30);
        btn2.setBounds(200,180,100,30);

        add(l1);
        add(l2);
        add(tf1);
        add(btn1);
        add(btn2);

        //ActionListener for all buttons
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String filename = tf1.getText().trim();
        if(filename.isEmpty()) {
            tf1.setText(null);
            JOptionPane.showMessageDialog(this,"Field is empty");
        }
        else if(isNumeric(filename)) {
            tf1.setText(null);
            JOptionPane.showMessageDialog(this,"Not a valid filename");
        }
        else {
            Path path = Paths.get(filename+".txt");
            try {
                BufferedWriter br = Files.newBufferedWriter(path);
                for(int i=0;i<GUI.list.size();i++)
                {
                    if(GUI.list.get(i) instanceof Chair) {
                        String hasArmrests;
                        String chair = "CHAIR";
                        br.write(chair);
                        br.newLine();
                        chair = "ID : "+GUI.list.get(i).getIDNumber();
                        br.write(chair);
                        br.newLine();
                        chair =  "Wood: " + GUI.list.get(i).woodChoice;
                        br.write(chair);
                        br.newLine();
                        chair =  "Armrests: " + (((Chair) GUI.list.get(i)).getArmrests()?"Yes":"No");
                        br.write(chair);
                        br.newLine();
                        chair = "Number of Units per chair: " + ((Chair) GUI.list.get(i)).getNumberOfUnits();
                        br.write(chair);
                        br.newLine();
                        chair = "Quantiy :" + GUI.list.get(i).getQuantity();
                        br.write(chair);
                        br.newLine();
                        chair = "The price is: " + GUI.list.get(i).getCharge();
                        br.write(chair);
                        br.newLine();
                    }
                    else if(GUI.list.get(i) instanceof Table) {
                        String table = "TABLE";
                        br.write(table);
                        br.newLine();
                        table = "ID : "+GUI.list.get(i).getIDNumber();
                        br.write(table);
                        br.newLine();
                        table = "Wood: " + GUI.list.get(i).woodChoice;
                        br.write(table);
                        br.newLine();
                        table =  "Base Choice :"  + ((Table) GUI.list.get(i)).getBaseChoice();
                        br.write(table);
                        br.newLine();
                        table =  "basePrice : " + ((Table) GUI.list.get(i)).getBasePrice();
                        br.write(table);
                        br.newLine();
                        table = "Diameter: " +((Table) GUI.list.get(i)).getDiameter();
                        br.write(table);
                        br.newLine();
                        table = "Quantity : " + GUI.list.get(i).getQuantity();
                        br.write(table);
                        br.newLine();
                        table = "The Price is: "+GUI.list.get(i).getCharge();
                        br.write(table);
                        br.newLine();
                    }
                    else if(GUI.list.get(i) instanceof Desk) {
                        String desk = "DESK ";
                        br.write(desk);
                        br.newLine();
                        desk = "ID : "+GUI.list.get(i).getIDNumber();
                        br.write(desk);
                        br.newLine();
                        desk = "Wood : " + GUI.list.get(i).woodChoice;
                        br.write(desk);
                        br.newLine();
                        desk = "Number of Drawers : "  + ((Desk) GUI.list.get(i)).getNumberOfDrawers();
                        br.write(desk);
                        br.newLine();
                        desk = "Width : " + ((Desk) GUI.list.get(i)).getWidth();
                        br.write(desk);
                        br.newLine();
                        desk = "Depth : " + ((Desk) GUI.list.get(i)).getDepth();
                        br.write(desk);
                        br.newLine();
                        desk = "Height : 80";
                        br.write(desk);
                        br.newLine();
                        desk = "Quantity : " + GUI.list.get(i).getQuantity();
                        br.write(desk);
                        br.newLine();
                        desk = "The Price is : " + GUI.list.get(i).getCharge();
                        br.write(desk);
                        br.newLine();
                    }
                }
                br.close();
                tf1.setText(null);
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,"File is not found");
            }
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
