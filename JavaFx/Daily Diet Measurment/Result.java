package sample;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Result {

    private String search;
    private String food;
    private String beverages;

    public Result(String search,boolean foodCheckBox,boolean beveragesCheckBox)
    {
        this.search = search;
        this.food = foodCheckBox?"g":"";
        this.beverages = beveragesCheckBox?"ml":"";

        JFrame f = new JFrame("Food");
        CSVReader reader = null;
        List list = null;
            try {
                reader = new CSVReader(new FileReader("nutritionvalues-data.csv"));
                list = reader.readAll();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"File is not found!!");
            } catch (CsvException e) {
                JOptionPane.showMessageDialog(null,"File is not in valid format");
            }
        //Getting the Iterator object
        Iterator it = list.iterator();
        int j = 0;
        while(it.hasNext()) {
            String[] str = (String[]) it.next();
            if(str[0].isEmpty() || !it.hasNext()) {
                continue;
            }
            if(j>=2&&str[0].contains(search)&&(str[2].equals(food)||str[2].equals(beverages))) {
                j++;
            }
            if(j<2) {
                j++;
            }
        }
        Object[][] data = new Object[j-2][7];
        int i = 0;
        it = list.iterator();
        while(it.hasNext()) {
            String[] str = (String[]) it.next();
            if(str[0].isEmpty() || !it.hasNext()) {
                continue;
            }
            if(i>=2&&str[0].contains(search)&&(str[2].equals(food)||str[2].equals(beverages))) {
                data[i-2][0] = str[0];
                data[i-2][1] = Double.parseDouble(str[1]);
                data[i-2][2] = str[2];
                data[i-2][3] = Integer.parseInt(str[3]);
                data[i-2][4] = Integer.parseInt(str[4]);
                data[i-2][5] = Integer.parseInt(str[5]);
                data[i-2][6] = Integer.parseInt(str[6]);
                i++;
            }
            if(i<2) {
                i++;
            }
        }
        String column[]={"Food","Portion","Unit","Calorie","Fat","Carbohydrate","Protein"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data,column){
            public Class getColumnClass(int column) {
                Class returnValue;
                switch (column) {
                    case 0:
                        returnValue = String.class;
                    case 1:
                        returnValue = Integer.class;
                    case 2:
                        returnValue =  String.class;
                    case 3:
                        returnValue = Integer.class;
                    case 4:
                        returnValue = Integer.class;
                    case 5:
                        returnValue = Integer.class;
                    default:
                        returnValue = Integer.class;
                }
                return returnValue;
            }
        };
        final JTable jt=new JTable(defaultTableModel);jt.setRowHeight(30);
        JTableHeader jTableHeader = jt.getTableHeader();
        jTableHeader.setBackground(new Color(118,162,255));
        Border border1 = BorderFactory.createLineBorder(Color.BLACK,1);
        jt.setBorder(border1);

        JPanel jPanel = new JPanel();
        jPanel.setBounds(10,10,200,200);
        jPanel.setBackground(Color.WHITE);
        jPanel.setLayout(null);

        JLabel jLabel = new JLabel("FILTER");
        jLabel.setBounds(50,0,100,30);

        JLabel jLabel1 = new JLabel("Sort by");
        jLabel1.setBounds(0,50,100,30);

        String[] p = {"Name","Highest Calories","Highest Protein","Lowest Calories","Lowest Protein"};
        JComboBox jComboBox = new JComboBox(p);
        jComboBox.setBounds(0,80,150,30);
        jComboBox.setForeground(Color.BLACK);

        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jComboBox);

        Container container = f.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JButton jButton = new JButton("Close");
        jButton.setBounds(500,430,100,30);

        JButton jButton1 = new JButton("Add Meal");
        jButton1.setBounds(300,430,100,30);

        jButton.setBackground(new Color(118,162,255));
        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton1.setBackground(new Color(118,162,255));
        jButton1.setBorder(new EmptyBorder(10,10,10,10));

        jButton1.setEnabled(false);

     //   jButton1.setEnabled(false);

        jComboBox.setBackground(new Color(118,162,255));
        jComboBox.setBorder(new EmptyBorder(1,1,1,1));
        jComboBox.setForeground(Color.WHITE);


        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(200,0,600,400);
        sp.getViewport().setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.WHITE,1);
        sp.setBorder(border);
        sp.setForeground(Color.BLACK);
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        container.add(sp);
        container.add(jPanel);
        container.add(jButton);
        container.add(jButton1);
        f.setBounds(400,100,815,550);
        f.setVisible(true);
        jt.setAutoCreateRowSorter(true);
        f.setResizable(false);

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sort = (String)jComboBox.getSelectedItem();

                switch(sort)
                {
                    case "Highest Calories":
                        TableRowSorter<TableModel> sorter = new TableRowSorter<>(defaultTableModel);
                        jt.setRowSorter(sorter);
                        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                        int columnIndexToSort = 3;
                        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
                        sorter.setSortKeys(sortKeys);
                        break;

                    case "Highest Protein":
                        sorter = new TableRowSorter<>(defaultTableModel);
                        jt.setRowSorter(sorter);
                        sortKeys = new ArrayList<>();

                        columnIndexToSort = 6;
                        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
                        sorter.setSortKeys(sortKeys);
                        break;
                    case "Lowest Calories":
                        sorter = new TableRowSorter<>(defaultTableModel);
                        jt.setRowSorter(sorter);
                        sortKeys = new ArrayList<>();

                        columnIndexToSort = 3;
                        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                        sorter.setSortKeys(sortKeys);
                        break;

                    case "Lowest Protein":
                        sorter = new TableRowSorter<>(defaultTableModel);
                        jt.setRowSorter(sorter);
                        sortKeys = new ArrayList<>();

                        columnIndexToSort = 6;
                        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                        sorter.setSortKeys(sortKeys);
                        break;
                    default:
                        sorter = new TableRowSorter<>(defaultTableModel);
                        jt.setRowSorter(sorter);
                        sortKeys = new ArrayList<>();

                        columnIndexToSort = 0;
                        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
                        sorter.setSortKeys(sortKeys);
                        break;
                }
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jt.getSelectedRow();
                String calorie = Integer.toString((Integer)jt.getValueAt(row,3));
                String fat = Integer.toString((Integer) jt.getValueAt(row,4));
                String carbohydrate = Integer.toString((Integer) jt.getValueAt(row,5));
                String protein = Integer.toString((Integer) jt.getValueAt(row,6));
                String p = ""+calorie+","+fat+","+carbohydrate+","+protein;

                UserDetails userDetails = User.get(Home.username);
                userDetails.getTotal().add(p);
                jButton1.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Meal is successfully added");
            }
        });
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton1.setEnabled(true);
            }
        });
    }
}
