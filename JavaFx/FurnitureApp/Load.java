package furnitureapp;
//Load button implementation
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Load extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JTextField tf1;
    JButton btn1;
    JButton btn2;
    Load(JFrame jFrame)
    {
        setVisible(true);
        setBounds(500,100,400,400);
        setLayout(null);
        setResizable(false);

        setTitle("Load from file");
        l1 = new JLabel("Load from file");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Please enter file name");

        tf1 = new JTextField();

        btn1 = new JButton("Load");
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
                BufferedReader br = Files.newBufferedReader(path);
                String line = "";
                while((line = br.readLine()) != null)
                {
                    String option = line.trim();
                    if(option.equals("CHAIR")) {
                        String[] str = br.readLine().trim().split(":");
                        String ID = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String wood = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String armrests = str[1].trim();
                        br.readLine();
                        str = br.readLine().trim().split(":");
                        String quantity = str[1].trim();
                        br.readLine();
                        Furniture chair = new Chair(armrests.equals("Yes")?true:false,Integer.parseInt(ID),wood.equals("Walnut")?0:1,Integer.parseInt(quantity));
                        GUI.list.add(chair);

                        int row = (GUI.list.size()-1)/3;
                        int col = (GUI.list.size()-1)%3;

                        if(col == 0) {
                            GUI.defaultTableModel.setRowCount(GUI.list.size()>=9?GUI.defaultTableModel.getRowCount()+1:3);
                        }
                        Path path1 = Paths.get(""+Integer.parseInt(ID)+".jpg");
                        ImageIcon imageIcon = new ImageIcon("Images//"+path1.toString());
                        Image image = imageIcon.getImage();
                        Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                        ImageIcon imageIcon1 = new ImageIcon(image1);
                        GUI.jTable.setValueAt(imageIcon1,row,col);



                    }
                    else if(option.equals("TABLE")) {
                        String[] str = br.readLine().trim().split(":");
                        String ID = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String wood = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String baseChoice = str[1].trim();
                        br.readLine();
                        str = br.readLine().trim().split(":");
                        String diameter = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String quantity = str[1].trim();
                        br.readLine();
                        Furniture table = new Table(1,Integer.parseInt(diameter),Integer.parseInt(ID),wood.equals("Walnut")
                                ?0:1,1,baseChoice.equals("Wooden")?0:1);
                        GUI.list.add(table);

                        int row = (GUI.list.size()-1)/3;
                        int col = (GUI.list.size()-1)%3;

                        if(col == 0) {
                            GUI.defaultTableModel.setRowCount(GUI.list.size()>=9?GUI.defaultTableModel.getRowCount()+1:3);
                        }
                        Path path1 = Paths.get(""+Integer.parseInt(ID)+".jpg");
                        ImageIcon imageIcon = new ImageIcon("Images//"+path1.toString());
                        Image image = imageIcon.getImage();
                        Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                        ImageIcon imageIcon1 = new ImageIcon(image1);
                        GUI.jTable.setValueAt(imageIcon1,row,col);
                    }
                    else if(option.equals("DESK")) {
                        String[] str = br.readLine().trim().split(":");
                        String ID = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String wood = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String noOfDrawers = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String width = str[1].trim();
                        str = br.readLine().trim().split(":");
                        String depth = str[1].trim();
                        br.readLine();
                        str = br.readLine().trim().split(":");
                        String quantity = str[1].trim();
                        br.readLine();

                        Furniture desk = new Desk(Integer.parseInt(ID),wood.equals("Walnut")?0:1,1,Integer.parseInt(noOfDrawers),Integer.parseInt(width),
                                Integer.parseInt(depth));
                        GUI.list.add(desk);

                        int row = (GUI.list.size()-1)/3;
                        int col = (GUI.list.size()-1)%3;

                        if(col == 0) {
                            GUI.defaultTableModel.setRowCount(GUI.list.size()>=9?GUI.defaultTableModel.getRowCount()+1:3);
                        }
                        Path path1 = Paths.get(""+Integer.parseInt(ID)+".jpg");
                        ImageIcon imageIcon = new ImageIcon("Images//"+path1.toString());
                        Image image = imageIcon.getImage();
                        Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                        ImageIcon imageIcon1 = new ImageIcon(image1);
                        GUI.jTable.setValueAt(imageIcon1,row,col);
                    }

                }
                tf1.setText(null);
                dispose();
            } catch (IOException ex) {
                tf1.setText(null);
                JOptionPane.showMessageDialog(this, "File is not found");
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
