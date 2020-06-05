package furnitureapp;
//ViewTotalCost button implementation
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ViewTotalCost extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JButton btn1;
    ViewTotalCost(JFrame jFrame)
    {
        setVisible(true);
        setBounds(500,150,400,200);
        setLayout(null);
        setResizable(false);

        setTitle("Total Cost");
        l1 = new JLabel("Total Cost");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        double totalCost = 0;
        for(int i=0;i<GUI.list.size();i++)
        {
            totalCost += GUI.list.get(i).getCharge();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        l2 = new JLabel();

        btn1 = new JButton("Close");

        btn1.addActionListener(this);

        l1.setBounds(120, 30, 400, 30);

        l2.setBounds(150, 70, 200, 30);
        l2.setText(""+decimalFormat.format(totalCost));

        btn1.setBounds(120, 120, 100, 30);
        add(l1);
        add(l2);
        add(btn1);
    }

    //ActionListener for all buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
