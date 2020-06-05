package furnitureapp;
//ViewOrderSummary button implementation
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewOrderSummary extends JFrame implements ActionListener{

    JButton jButton;
    ViewOrderSummary(JFrame jFrame)
    {
        setBounds(500,100,500,600);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        double price = 0;
        String[] column = {"Summary","Item"};
        ArrayList<Furniture> list = (ArrayList<Furniture>) GUI.list.clone();
        Collections.sort(list,new Sort());
        Object[][] data = new Object[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            String value = list.get(i).toString();
            data[i][0] = value;
            Path path = Paths.get(""+list.get(i).getIDNumber()+".jpg");
            ImageIcon imageIcon = new ImageIcon("Images//"+path.toString());
            Image image = imageIcon.getImage();
            Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
            ImageIcon imageIcon1 = new ImageIcon(image1);
            data[i][1] = (ImageIcon)imageIcon1;
            price += list.get(i).getCharge();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data,column);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        JTable jTable = new JTable(defaultTableModel){
            @Override
            public TableCellRenderer getCellRenderer(int row, int column)
            {
                int modelColumn = convertColumnIndexToModel(column);
                if(modelColumn == 1) {
                    return getDefaultRenderer(Icon.class);
                }
                else {
                    return super.getCellRenderer(row,column);
                }
            }

            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };
        jTable.setRowHeight(180);
        Border border = BorderFactory.createLineBorder(Color.BLACK,2);
        jTable.setBorder(border);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(50,50,350,400);
        jScrollPane.setMaximumSize(new Dimension(350,100));
        jScrollPane.getViewport().setBackground(Color.WHITE);
        Border border1 = BorderFactory.createLineBorder(Color.WHITE,0);
        jScrollPane.setBorder(border1);

        jButton = new JButton("Close");
        jButton.setBounds(250,480,100,30);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(100,480,200,30);

        jLabel.setText("Item Price :"+decimalFormat.format(price));
        container.add(jScrollPane);
        container.add(jButton);
        container.add(jLabel);

        jButton.addActionListener(this);
    }

    //ActionListener for all buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}

//Comparator for sorting according to price in descending order
class Sort implements Comparator<Furniture>
{
    @Override
    public int compare(Furniture o1, Furniture o2) {
        return (int) (o2.getCharge()-o1.getCharge());
    }
}
