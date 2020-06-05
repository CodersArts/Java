package sample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame implements ActionListener {

    static String username;
    public Home(String username)
    {
        Home.username = username;
        setBounds(500,100,600,600);
        setVisible(true);
        setTitle("Home");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);


        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        JButton jButton = new JButton("<html><br> ");
        JButton jButton1 = new JButton("<html><br> ");
        JButton jButton2 = new JButton("<html> <br> ");
        JButton jButton4 = new JButton("<html><br>");



        JButton jButton6 = new JButton("Logout");
        JButton jButton7 = new JButton("Cancel");


        jButton.setBounds(120,100,100,100);
        jButton1.setBounds(340,100,100,100);
        jButton2.setBounds(120,250,100,100);
        jButton4.setBounds(340,250,100,100);
        jButton6.setBounds(150,450,100,30);
        jButton7.setBounds(300,450,100,30);


        ImageIcon imageIcon = new ImageIcon("Images//queryCase.jpg");
        Image image = imageIcon.getImage();
        Image image1 = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image1);
        JLabel jLabel = new JLabel("Search Food");
        jLabel.setBounds(120,200,100,30);
        jLabel.setHorizontalAlignment(JLabel.CENTER);



        ImageIcon imageIcon2 = new ImageIcon("Images//progress.png");
        Image image2 = imageIcon2.getImage();
        Image image3 = image2.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(image3);
        JLabel jLabel1 = new JLabel("Today's Progress");
        jLabel1.setBounds(340,200,100,30);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);


        ImageIcon imageIcon4 = new ImageIcon("Images//chart.png");
        Image image4 = imageIcon4.getImage();
        Image image5 = image4.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon imageIcon5 = new ImageIcon(image5);
        JLabel jLabel2 = new JLabel("Monthly Progress");
        jLabel2.setBounds(120,350,100,30);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);


        ImageIcon imageIcon8 = new ImageIcon("Images//save.png");
        Image image8 = imageIcon8.getImage();
        Image image9 = image8.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon imageIcon9 = new ImageIcon(image9);
        JLabel jLabel4 = new JLabel("Save");
        jLabel4.setBounds(340,350,100,30);
        jLabel4.setHorizontalAlignment(JLabel.CENTER);


        jButton1.setBackground(Color.WHITE);

        jButton.setIcon(imageIcon1);
        jButton1.setIcon(imageIcon3);
        jButton2.setIcon(imageIcon5);
        jButton4.setIcon(imageIcon9);

        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton1.setBorder(new EmptyBorder(10,10,10,10));
        jButton2.setBorder(new EmptyBorder(10,10,10,10));
        jButton4.setBorder(new EmptyBorder(10,10,10,10));
        jButton6.setBackground(new Color(118,162,255));
        jButton6.setBorder(new EmptyBorder(10,10,10,10));
        jButton7.setBackground(new Color(118,162,255));
        jButton7.setBorder(new EmptyBorder(10,10,10,10));

        container.add(jButton);
        container.add(jButton1);
        container.add(jButton2);
        container.add(jButton4);
        container.add(jButton6);
        container.add(jButton7);
        container.add(jLabel);
        container.add(jLabel1);
        container.add(jLabel2);
    //    container.add(jLabel3);
        container.add(jLabel4);
    //    container.add(jLabel5);


        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SearchFood();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog d;
                JFrame jFrame = new JFrame();
                d = new JDialog(jFrame,"Today's Summary", false);
                Container container = d.getContentPane();
                container.setLayout(null);
                container.setBackground(Color.WHITE);

                JLabel jLabel = new JLabel("Calories : ");
                jLabel.setBounds(50,100,200,30);

                JLabel jLabel1 = new JLabel("Protein : ");
                jLabel1.setBounds(50,150,200,30);

                JLabel jLabel2 = new JLabel("Carbohydrates : ");
                jLabel2.setBounds(50,200,200,30);

                JLabel jLabel3 = new JLabel("Fats : ");
                jLabel3.setBounds(50,250,200,30);


                JProgressBar jProgressBar = new JProgressBar();
                jProgressBar.setBounds(200,100,200,30);
                jProgressBar.setForeground(new Color(25,189,255));


                JProgressBar jProgressBar1 = new JProgressBar();
                jProgressBar1.setBounds(200,150,200,30);
                jProgressBar1.setForeground(new Color(25,189,255));

                JProgressBar jProgressBar2 = new JProgressBar();
                jProgressBar2.setBounds(200,200,200,30);
                jProgressBar2.setForeground(new Color(25,189,255));

                JProgressBar jProgressBar3 = new JProgressBar();
                jProgressBar3.setBounds(200,250,200,30);
                jProgressBar3.setForeground(new Color(25,189,255));

                JButton jButton1 = new JButton("Cancel");
                jButton1.setBounds(200,400,100,30);

                jButton1.setBackground(new Color(118,162,255));
                jButton1.setBorder(new EmptyBorder(10,10,10,10));


                container.add(jLabel);
                container.add(jLabel1);
                container.add(jLabel2);
                container.add(jLabel3);
               // container.add(jLabel4);
                container.add(jProgressBar);
                container.add(jProgressBar1);
                container.add(jProgressBar2);
                container.add(jProgressBar3);
                //container.add(jProgressBar4);
                container.add(jButton1);
                d.setBounds(550,150,500,500);
                d.setVisible(true);
                d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                UserDetails userDetails = User.get(Home.username);

                if(userDetails.getTotal().size() != 0) {
                    String str = userDetails.getTotal().get(userDetails.getTotal().size()-1);
                    String[] p = str.trim().split(",");
                    int calorie = Integer.parseInt(p[0]);
                    int protein = Integer.parseInt(p[3]);
                    int carbohydrate = Integer.parseInt(p[2]);
                    int fat = Integer.parseInt(p[1]);
                    if(calorie>=2000) {
                        jProgressBar.setValue(100);
                    }
                    else {
                        jProgressBar.setValue(((calorie * 100)) / 200);
                    }

                    if(protein>=100) {
                        jProgressBar1.setValue(100);
                    }
                    else {
                        jProgressBar1.setValue((protein*100)/100);
                    }

                    if(carbohydrate>=300) {
                        jProgressBar2.setValue(100);
                    }
                    else {
                        jProgressBar2.setValue((carbohydrate*100)/300);
                    }

                    if(fat>=50) {
                        jProgressBar3.setValue(100);
                    }
                    else {
                        jProgressBar3.setValue((fat*100)/50);
                    }

                }


                jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        d.dispose();
                        d.setVisible(false);
                    }
                });
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Double> scores = new ArrayList<Double>();
                UserDetails userDetails = User.get(username);

                if(userDetails.getTotal().size()<=31) {
                    for (int i = 0; i < userDetails.getTotal().size(); i++) {
                        String str = userDetails.getTotal().get(i);
                        String[] p = str.trim().split(",");
                        scores.add(Double.parseDouble(p[0]));
                    }
                }
                else {
                    for (int i = userDetails.getTotal().size()-31; i < userDetails.getTotal().size(); i++) {
                        String str = userDetails.getTotal().get(i);
                        String[] p = str.trim().split(",");
                        scores.add(Double.parseDouble(p[0]));
                    }
                }
                MonthlySummary mainPanel = new MonthlySummary(scores);
                mainPanel.setPreferredSize(new Dimension(650, 400));
                JFrame frame = new JFrame("Monthly Summary");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setBackground(Color.WHITE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Save();
            }
        });

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jButton7.addActionListener(new ActionListener() {
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
