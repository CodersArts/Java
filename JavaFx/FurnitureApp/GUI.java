package furnitureapp;
//Main GUI Home
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class GUI extends JFrame
{
    static public ArrayList<Furniture> list = new ArrayList<Furniture>(); //List to store chair,Table,Desk
    static public JTable jTable;
    static DefaultTableModel defaultTableModel; //Creating a table
    String woodType = "";
    String armrests = "";
    String baseType = "";
    public GUI() //Constructor for GUI class
    {
        //Creating a JFrame
        JFrame jFrame = new JFrame();
        jFrame.setBounds(500,100,415,520);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle("Furniture App");

        //Container layout set to null
        Container container = jFrame.getContentPane();
        container.setBackground(Color.WHITE);
        container.setLayout(null);

        //Creating a table
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setRowCount(3);
        defaultTableModel.setColumnCount(3);
        jTable = new JTable(defaultTableModel)
        {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) //Method for display image in table
            {
                return getDefaultRenderer(Icon.class);
            }

            public boolean isCellEditable(int row, int column) //Set table editable to false
            {
                return false;//This causes all cells to be not editable
            }
        };

        jTable.setTableHeader(null);
        jTable.setOpaque(false);

        //ActionListener for table
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jTable.setSelectionBackground(Color.WHITE);
            }
        });

        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        jTable.setRowHeight(100);
        jTable.setBorder(border);
        jTable.setVisible(true);


        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(0,20,400,300);
        jScrollPane.getViewport().setBackground(Color.WHITE);
        container.add(jScrollPane);

        //Buttons in GUI
        JButton jButton = new JButton("Add Chair");
        JButton jButton1 = new JButton("Add Table");
        JButton jButton2 = new JButton("Add Desk");
        JButton jButton3 = new JButton("View Order Summary");
        JButton jButton4 = new JButton("View Total Cost");
        JButton jButton5 = new JButton("Save");
        JButton jButton6 = new JButton("Load");
        JButton jButton7 = new JButton("Clear all");




        jButton.setBounds(0,320,150,40);
        jButton1.setBounds(0,360,150,40);
        jButton2.setBounds(0,400,150,40);
        jButton3.setBounds(0,440,200,40);
        jButton4.setBounds(200,440,200,40);
        jButton5.setBounds(250,400,150,40);
        jButton6.setBounds(250,360,150,40);
        jButton7.setBounds(250,320,150,40);

        container.add(jButton);
        container.add(jButton1);
        container.add(jButton2);
        container.add(jButton3);
        container.add(jButton4);
        container.add(jButton5);
        container.add(jButton6);
        container.add(jButton7);


        //ActionListener for all buttons
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setEnabled(false);
                 new AddChair(jFrame);
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setEnabled(false);
                new AddTable(jFrame);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setEnabled(false);
                new AddDesk(jFrame);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOrderSummary(jFrame);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewTotalCost(jFrame);
            }
        });

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Load(jFrame);
            }
        });

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Save(jFrame);
            }
        });

        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clear();
                for(int i=0;i<defaultTableModel.getRowCount();i++)
                {
                    defaultTableModel.removeRow(0);
                }
                defaultTableModel.setRowCount(3);
            }
        });

        //ActionListener for table
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable.rowAtPoint(e.getPoint());
                int col = jTable.columnAtPoint(e.getPoint());
                if(3*row+col>=list.size() || 3*row+col<0) {
                    JOptionPane.showMessageDialog(null,"No Item!");
                }
                else {
                    if(e.getButton() == MouseEvent.BUTTON1) { //Left click to display a pop up of details for Chair,Table,Desk
                        String p = list.get(3 * row + col).string();
                        JOptionPane.showMessageDialog(null, p);
                    }
                    else if(e.getButton() == MouseEvent.BUTTON3) { //Right click to update the values of Chair,Table,Desk
                        Furniture furniture = list.get(3*row+col);

                        if(furniture instanceof Chair) {
                            JDialog d;
                            d = new JDialog(jFrame , "Update Chair", false);
                            d.setLayout(null);

                            JLabel jLabel = new JLabel("Wood: ");
                            jLabel.setBounds(50,100,100,30);

                            JLabel jLabel1 = new JLabel("Armrests: ");
                            jLabel1.setBounds(50,150,100,30);

                            JLabel jLabel2 = new JLabel("Quantity: ");
                            jLabel2.setBounds(50,200,100,30);

                            JTextField jTextField = new JTextField();
                            jTextField.setBounds(150,100,200,30);

                            JTextField jTextField1 = new JTextField();
                            jTextField1.setBounds(150,150,200,30);

                            JTextField jTextField2 = new JTextField();
                            jTextField2.setBounds(150,200,200,30);

                            JTextField jTextField3 = new JTextField();
                            jTextField3.setBounds(150,250,200,30);

                            JButton btn1 = new JButton("Update");
                            btn1.setBounds(150,300,100,30);

                            JButton btn2 = new JButton("Oak");
                            btn2.setBounds(150,100,100,30);

                            JButton btn3 = new JButton("Walnut");
                            btn3.setBounds(250,100,100,30);

                            JButton btn4 = new JButton("Yes");
                            btn4.setBounds(150,150,100,30);

                            JButton btn5 = new JButton("No");
                            btn5.setBounds(250,150,100,30);

                            d.add(jLabel);
                            d.add(jLabel1);
                            d.add(jLabel2);
                            d.add(jTextField2);
                            d.add(btn1);
                            d.add(btn2);
                            d.add(btn3);
                            d.add(btn4);
                            d.add(btn5);

                            d.setBounds(500,100,500,500);
                            d.setVisible(true);
                            d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
                                    armrests = "Yes";
                                }
                            });

                            btn5.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    armrests = "No";
                                }
                            });


                            btn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String quantity = jTextField2.getText().trim();
                                    boolean flag = false;
                                    int count = 0;
                                    if(!woodType.isEmpty()) {
                                        flag = true;
                                        count++;
                                        furniture.setTypeOfWood(woodType);
                                        woodType = "";
                                    }
                                    if(!armrests.isEmpty()) {
                                        flag = true;
                                        count++;
                                        ((Chair) furniture).setArmrests(armrests.equals("Yes")?true:false);
                                        armrests = "";
                                    }
                                    if(!quantity.isEmpty()&&isNumeric(quantity)) {
                                        flag = true;
                                        count++;
                                        furniture.setQuantity(Integer.parseInt(quantity));
                                        quantity = "";
                                    }
                                    if(!flag) {
                                        JOptionPane.showMessageDialog(null,"No values is updated");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,""+count+" values is updated");
                                    }
                                    d.dispose();
                                }
                            });
                        }
                        else if(furniture instanceof Table) {
                            JDialog d;
                            d = new JDialog(jFrame , "Update Table", false);
                            d.setLayout(null);

                            JLabel jLabel = new JLabel("Wood: ");
                            jLabel.setBounds(50,100,100,30);

                            JLabel jLabel1 = new JLabel("Base Choice: ");
                            jLabel1.setBounds(50,150,100,30);

                            JLabel jLabel2 = new JLabel("Diameter: ");
                            jLabel2.setBounds(50,200,100,30);

                            JLabel jLabel3 = new JLabel("Quantity: ");
                            jLabel3.setBounds(50,250,100,30);

                            JTextField jTextField = new JTextField();
                            jTextField.setBounds(150,100,200,30);

                            JTextField jTextField1 = new JTextField();
                            jTextField1.setBounds(150,150,200,30);

                            JTextField jTextField2 = new JTextField();
                            jTextField2.setBounds(150,200,200,30);

                            JTextField jTextField3 = new JTextField();
                            jTextField3.setBounds(150,250,200,30);

                            JButton btn1 = new JButton("Update");
                            btn1.setBounds(150,350,100,30);

                            JButton btn2 = new JButton("Oak");
                            btn2.setBounds(150,100,100,30);

                            JButton btn3 = new JButton("Walnut");
                            btn3.setBounds(250,100,100,30);

                            JButton btn4 = new JButton("Wooden");
                            btn4.setBounds(150,150,100,30);

                            JButton btn5 = new JButton("Chrome");
                            btn5.setBounds(250,150,100,30);


                            d.add(jLabel);
                            d.add(jLabel1);
                            d.add(jLabel2);
                            d.add(jLabel3);
                            d.add(jTextField2);
                            d.add(jTextField3);
                            d.add(btn1);
                            d.add(btn2);
                            d.add(btn3);
                            d.add(btn4);
                            d.add(btn5);
                            d.setBounds(500,100,500,500);
                            d.setVisible(true);
                            d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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



                            btn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String diameter = jTextField2.getText().trim();
                                    String quantity = jTextField3.getText().trim();

                                    boolean flag = false;
                                    int count = 0;
                                    if(!woodType.isEmpty()) {
                                        flag = true;
                                        count++;
                                        furniture.setTypeOfWood(woodType);
                                        woodType = "";
                                    }
                                    if(!baseType.isEmpty()) {
                                        flag = true;
                                        count++;
                                        ((Table) furniture).setBaseChoice(baseType);
                                        baseType = "";
                                    }
                                    if(!diameter.isEmpty()&&isNumeric(diameter)) {
                                        flag = true;
                                        count++;
                                        ((Table) furniture).setDiameter(Integer.parseInt(diameter));
                                        diameter = "";
                                    }
                                    if(!quantity.isEmpty()&&isNumeric(quantity)) {
                                        flag = true;
                                        count++;
                                        furniture.setQuantity(Integer.parseInt(quantity));
                                        quantity = "";
                                    }
                                    if(!flag) {
                                        JOptionPane.showMessageDialog(null,"No values updated");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,""+count+" values updated");
                                    }
                                    d.dispose();
                                }

                            });
                        }
                        else if(furniture instanceof Desk) {
                            JDialog d;
                            d = new JDialog(jFrame , "Update Desk", false);
                            d.setLayout(null);

                            JLabel jLabel = new JLabel("Wood: ");
                            jLabel.setBounds(50,100,200,30);

                            JLabel jLabel1 = new JLabel("Number of Drawers: ");
                            jLabel1.setBounds(50,150,200,30);

                            JLabel jLabel2 = new JLabel("Width: ");
                            jLabel2.setBounds(50,200,200,30);

                            JLabel jLabel3 = new JLabel("Depth: ");
                            jLabel3.setBounds(50,250,200,30);

                            JLabel jLabel4 = new JLabel("Quantity: ");
                            jLabel4.setBounds(50,300,200,30);



                            JTextField jTextField = new JTextField();
                            jTextField.setBounds(200,100,200,30);

                            JTextField jTextField1 = new JTextField();
                            jTextField1.setBounds(200,150,200,30);

                            JTextField jTextField2 = new JTextField();
                            jTextField2.setBounds(200,200,200,30);

                            JTextField jTextField3 = new JTextField();
                            jTextField3.setBounds(200,250,200,30);

                            JTextField jTextField4 = new JTextField();
                            jTextField4.setBounds(200,300,200,30);

                            JButton btn1 = new JButton("Update");
                            btn1.setBounds(150,400,100,30);

                            JButton btn2 = new JButton("Oak");
                            btn2.setBounds(200,100,100,30);

                            JButton btn3 = new JButton("Walnut");
                            btn3.setBounds(300,100,100,30);

                            d.add(jLabel);
                            d.add(jLabel1);
                            d.add(jLabel2);
                            d.add(jLabel3);
                            d.add(jLabel4);
                            d.add(jTextField1);
                            d.add(jTextField2);
                            d.add(jTextField3);
                            d.add(jTextField4);
                            d.add(btn1);
                            d.add(btn2);
                            d.add(btn3);
                            d.setBounds(500,100,500,500);
                            d.setVisible(true);
                            d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

                            btn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String noOfDrawers = jTextField1.getText().trim();
                                    String width = jTextField2.getText().trim();
                                    String depth = jTextField3.getText().trim();
                                    String quantity = jTextField4.getText().trim();

                                    boolean flag = false;
                                    int count = 0;

                                    if(!woodType.isEmpty()) {
                                        flag = true;
                                        count++;
                                        furniture.setTypeOfWood(woodType);
                                        woodType = "";
                                    }
                                    if(!noOfDrawers.isEmpty()&&isNumeric(noOfDrawers)) {
                                        flag = true;
                                        count++;
                                        ((Desk) furniture).setNumberOfDrawers(Integer.parseInt(noOfDrawers));
                                        noOfDrawers = "";
                                    }
                                    if(!width.isEmpty()&&isNumeric(width)) {
                                        flag = true;
                                        count++;
                                        ((Desk) furniture).setWidth(Integer.parseInt(width));
                                        width = "";
                                    }
                                    if(!depth.isEmpty()&&isNumeric(depth)) {
                                        flag = true;
                                        count++;
                                        ((Desk) furniture).setDepth(Integer.parseInt(depth));
                                        depth = "";
                                    }
                                    if(!quantity.isEmpty()&&isNumeric(quantity)) {
                                        flag = true;
                                        count++;
                                        furniture.setQuantity(Integer.parseInt(quantity));
                                        quantity = "";
                                    }

                                    if(!flag) {
                                        JOptionPane.showMessageDialog(null,"No values updated");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,""+count+" updated");
                                    }
                                    d.dispose();
                                }
                            });
                        }
                    }
                }
            }
        });
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
