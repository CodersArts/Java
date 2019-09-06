import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Hotel extends JFrame implements ActionListener
{
	JPanel p,p1,p2,p3,lgn,cst,regn,bkng,room,bill,main,thnx,mnu,cart,enq;
	GridBagLayout gb;
	CardLayout cl;
	GridBagConstraints gbc;
	MyWinLis wl;
	MyFocusLis ff;
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	Font mfnt,mfnt1;

	
	//For Login Form
	JLabel l1,l2,l56;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3;

	//For Customer Form
	JLabel l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l17a;
	JTextField t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JTextArea ta1,ta2;
	JComboBox cb1;
	JButton b4,b5;
	JRadioButton r1,r2,r3,r4,r5,r6;
	MyItemLis il;

	//For Registration Form
	JLabel l18,l19,l20;
	JTextField t12;
	JPasswordField t13,t14;;
	JButton b6,b7;

	//For Booking Form
	JLabel l21,l22,l23,l24,l25,l26,l27,l28,l29,l29a;
	JTextField t15,t16,t17,t18,t19,t20,t21;
	JTextArea ta3,ta4;
	JButton b8,b9,b12;
	
	//For Rooms Form
	JList rlst;
	JButton b11;

	//For Billing Form
	JLabel l31,l32,l33,l34,l35,l37,l38,l39,l40,l41,l42,l43,l44,l45,l48,l49,l49a;
	JTextField t24,t25,t26,t27,t28,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39;
	JButton b13,b14;
	JComboBox cb2;

	//For Main Form
	JButton b15,b16,b17,b18,b22,b25,b28;

	//For Thanks Form
	JLabel l46,l47;
	JButton b19;

	//For Menu Form
	JLabel l50,l51,l52,l65a;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField t40,t41,t42,t43,t44,t45,t46,t47;
	JButton b20,b21,b26;

	//For Finishing Form
	JLabel l53,l54,l55,l57,l58,l59,l60,l61,l62,l63,l64;

	//For Enquiry Form
	JLabel l66,l67,l68,l69,l70,l71,l72,l73,l74,l75,l76,l77,l78,l79,l80;
	JTextField t50,t51,t52,t53,t54,t55,t56,t57,t58,t59,t60;
	JTextArea ta5;
	JList elst;
	JButton b27,b30;	

	public Hotel()
	{
		super("Hotel Management System");
		p=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		lgn=new JPanel();
		cst=new JPanel();
		regn=new JPanel();
		bkng=new JPanel();
		room=new JPanel();
		bill=new JPanel();
		main=new JPanel();
		thnx=new JPanel();
		mnu=new JPanel();
		enq=new JPanel();
		gb=new GridBagLayout();
		gbc=new GridBagConstraints();
		mfnt=new Font("Arial",Font.BOLD,25);
		mfnt1=new Font("Comic Sans MS",Font.BOLD,14);
		Insets ss=new Insets(5,5,5,5);
		gbc.insets=ss;
		cl=new CardLayout();

		p.setLayout(cl);
		gbc.fill=GridBagConstraints.BOTH;
		wl=new MyWinLis();
		addWindowListener(wl);
		ff=new MyFocusLis();

		//Initializing Finishing Form Objects
		l53=new JLabel("Hotel Management System");
		l54=new JLabel(" ");
		l55=new JLabel("Welcome to Main Form");
		l57=new JLabel(" ");
		l58=new JLabel("Customer Details Filling Form");
		l59=new JLabel(" ");
		l60=new JLabel("Booking Details Filling Form");
		l61=new JLabel(" ");
		l62=new JLabel("Billing   Form");
		l63=new JLabel(" ");
		l64=new JLabel(" ");
		l53.setFont(mfnt);
		l55.setFont(mfnt);
		l58.setFont(mfnt);
		l60.setFont(mfnt);
		l62.setFont(mfnt);
		

		//Initializing Login Form Objects
		
		l1=new JLabel("UserName");
		l2=new JLabel("Password");
		l56=new JLabel("New User ?");
		l1.setFont(mfnt1);
		l2.setFont(mfnt1);
		l56.setFont(mfnt1);
		t1=new JTextField(10);
		t2=new JPasswordField(10);
		b1=new JButton("Login");
		b2=new JButton("Exit");
		b3=new JButton("Create New Account");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		lgn.setLayout(gb);
		addLogin(l53,1,2,4,1);
		addLogin(l54,1,3,1,1);
		addLogin(l1,2,5,1,1);
		addLogin(l2,2,6,1,1);
		addLogin(l56,2,9,1,1);
		addLogin(t1,4,5,1,1);
		addLogin(t2,4,6,1,1);
		addLogin(b1,4,7,1,1);
		addLogin(b2,4,8,1,1);
		addLogin(b3,4,9,1,1);


		//Initializing Customer Form Objects

		l3=new JLabel("Customer Code");
		l4=new JLabel("Last Name");
		l5=new JLabel("First Name");
		l6=new JLabel("Sex");
		l7=new JLabel("Age");
		l8=new JLabel("Maritial status");
		l9=new JLabel("Nationality");
		l10=new JLabel("Country");
		l11=new JLabel("PassPort No.");
		l12=new JLabel("Visa No.");
		l13=new JLabel("Residential Address");
		l14=new JLabel("Official Address(if any)");
		l15=new JLabel("Phone No.");
		l16=new JLabel("Email ID");
		l17=new JLabel("Status");
		l17a=new JLabel("                    ");
		l3.setFont(mfnt1);
		l4.setFont(mfnt1);
		l5.setFont(mfnt1);
		l6.setFont(mfnt1);
		l7.setFont(mfnt1);
		l8.setFont(mfnt1);
		l9.setFont(mfnt1);
		l10.setFont(mfnt1);
		l11.setFont(mfnt1);
		l12.setFont(mfnt1);
		l13.setFont(mfnt1);
		l14.setFont(mfnt1);
		l15.setFont(mfnt1);
		l16.setFont(mfnt1);
		l17.setFont(mfnt1);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(5);
		t7=new JTextField(10);
		t8=new JTextField(10);
		t9=new JTextField(10);
		t10=new JTextField(15);
		t11=new JTextField(20);
		ta1=new JTextArea(5,10);
		ta2=new JTextArea(5,10);
		cb1=new JComboBox();
			cb1.addItem("New");
			cb1.addItem("Occasional");
			cb1.addItem("Regular");
			cb1.addItem("BlackListed");
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
		r3=new JRadioButton("Married");
		r4=new JRadioButton("Unmarried");
		r5=new JRadioButton("Indian");
		r6=new JRadioButton("Foreigner");
		b4=new JButton("Save Customer info");
		b5=new JButton("Back to Main");
		b4.addActionListener(this);
		b5.addActionListener(this);
		il=new MyItemLis();
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);
		r6.addActionListener(this);
		r5.addItemListener(il);
		r6.addItemListener(il);
		cst.setLayout(gb);
		t7.setEnabled(false);
		t8.setEnabled(false);
		t9.setEnabled(false);
		addCustomer(l58,1,1,4,1);
		addCustomer(l59,1,2,1,1);
		addCustomer(l3,2,4,1,1);
		addCustomer(l4,2,5,1,1);
		addCustomer(t4,4,5,1,1);
		addCustomer(l5,2,6,1,1);
		addCustomer(t5,4,6,1,1);
		addCustomer(l6,2,7,1,1);
		addCustomer(l7,2,8,1,1);
		addCustomer(l8,2,9,1,1);
		addCustomer(l9,2,10,1,1);
		addCustomer(l10,2,11,1,1);
		addCustomer(l11,2,12,1,1);
		addCustomer(l12,2,13,1,1);
		addCustomer(l13,2,14,1,1);
		addCustomer(l14,2,16,1,1);
		addCustomer(l15,2,18,1,1);
		addCustomer(l16,2,19,1,1);
		addCustomer(l17,2,20,1,1);
		addCustomer(l17a,3,4,1,1);
		addCustomer(t3,4,4,1,1);
		p1.add(r1);
		p1.add(r2);
		addCustomer(p1,4,7,1,1);
		addCustomer(t6,4,8,1,1);
		p2.add(r3);
		p2.add(r4);
		addCustomer(p2,4,9,1,1);
		p3.add(r5);
		p3.add(r6);
		addCustomer(p3,4,10,1,1); 
		addCustomer(t7,4,11,1,1);
		addCustomer(t8,4,12,1,1);
		addCustomer(t9,4,13,1,1);
		addCustomer(ta1,4,14,1,1);
		addCustomer(ta2,4,16,1,1);
		addCustomer(t10,4,18,1,1);
		addCustomer(t11,4,19,1,1);
		addCustomer(cb1,4,20,1,1);
		addCustomer(b4,2,21,1,1);
		addCustomer(b5,4,21,1,1);

		//Initialising Registration Form

		l18=new JLabel("UserName");
		l19=new JLabel("Password");
		l20=new JLabel("Retype Password");
		l18.setFont(mfnt1);
		l19.setFont(mfnt1);
		l20.setFont(mfnt1);
		t12=new JTextField(10);
		t13=new JPasswordField(10);
		t14=new JPasswordField(10);
		b6=new JButton("Save");
		b7=new JButton("Back");
		b6.addActionListener(this);
		b7.addActionListener(this);
		regn.setLayout(gb);
		addRegistration(l18,2,2,1,1);
		addRegistration(l19,2,3,1,1);
		addRegistration(l20,2,4,1,1);
		addRegistration(t12,4,2,1,1);
		addRegistration(t13,4,3,1,1);
		addRegistration(t14,4,4,1,1);
		addRegistration(b6,2,5,1,1);
		addRegistration(b7,4,5,1,1);

		//Initialising Booking Form Objects

		l21=new JLabel("Booking No.");
		l22=new JLabel("Customer Code");
		l23=new JLabel("Room No.");
		l24=new JLabel("Date Of Arrival");
		l25=new JLabel("No. Of Persons");
		l26=new JLabel("Relationship");
		l27=new JLabel("Name");
		l28=new JLabel("Address");
		l29=new JLabel("Date of Departure");
		l29a=new JLabel("                     ");
		l21.setFont(mfnt1);
		l22.setFont(mfnt1);
		l23.setFont(mfnt1);
		l24.setFont(mfnt1);
		l25.setFont(mfnt1);
		l26.setFont(mfnt1);
		l27.setFont(mfnt1);
		l28.setFont(mfnt1);
		l29.setFont(mfnt1);
		t15=new JTextField(10);
		t16=new JTextField(10);
		t16.addFocusListener(ff);
		t17=new JTextField(10);
		t18=new JTextField(10);
		t19=new JTextField(10);
		t20=new JTextField(10);
		t21=new JTextField(10);
		ta3=new JTextArea(5,10);
		ta4=new JTextArea(5,10);
		b8=new JButton("Save Booking Details");
		b9=new JButton("Back to Main");
		b12=new JButton("Available rooms");
		b12.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bkng.setLayout(gb);
		addBooking(l60,1,1,4,1);
		addBooking(l61,1,2,1,1);
		addBooking(l21,2,4,1,1);
		addBooking(l22,2,5,1,1);
		addBooking(l27,2,6,1,1);
		addBooking(l28,2,7,1,1);
		addBooking(l23,2,10,1,1);
		addBooking(l24,2,11,1,1);
		addBooking(l29,2,12,1,1);
		addBooking(l29a,3,4,1,1);
		addBooking(l25,2,13,1,1);
		addBooking(l26,2,14,1,1);
		addBooking(t15,4,4,1,1);
		addBooking(t16,4,5,1,1);
		addBooking(t20,4,6,1,1);
		addBooking(ta4,4,7,3,1);
		addBooking(t17,4,10,1,1);
		addBooking(b12,7,10,1,1);
		addBooking(t18,4,11,1,1);
		addBooking(t21,4,12,1,1);
		addBooking(t19,4,13,1,1);
		addBooking(ta3,4,14,3,1);
		addBooking(b8,2,16,1,1);
		addBooking(b9,4,16,1,1);

		//Initialising Rooms Form Objects

		b11=new JButton("Done");
		b11.addActionListener(this);
		rlst=new JList();
		rlst.setSelectionMode(0);
		room.setLayout(gb);
		addRooms(rlst,2,2,10,10);
		addRooms(b11,4,20,1,1);

		//Initialising Billing Form Objects

		l31=new JLabel("Bill No.");
		l32=new JLabel("Booking No.");
		l33=new JLabel("Departure Date");
		l34=new JLabel("Billing Days");
		l35=new JLabel("Total Room Rent");
		l37=new JLabel("Service Charges");
		l38=new JLabel("Gross Bill Amount");
		l39=new JLabel("Service Tax( In %)");
		l40=new JLabel("Discount Allowed");
		l41=new JLabel("Net Bill Amount");
		l42=new JLabel("Amount Recieved");
		l43=new JLabel("Outsatnding Amount(if any)");
		l44=new JLabel("Billing mode");
		l45=new JLabel("Credit Card No.");
		l48=new JLabel("Room No.");
		l49=new JLabel("Booking Date");
		l49a=new JLabel("                      ");
		l31.setFont(mfnt1);
		l32.setFont(mfnt1);
		l33.setFont(mfnt1);
		l34.setFont(mfnt1);
		l35.setFont(mfnt1);
		l37.setFont(mfnt1);
		l38.setFont(mfnt1);
		l39.setFont(mfnt1);
		l40.setFont(mfnt1);
		l41.setFont(mfnt1);
		l42.setFont(mfnt1);
		l43.setFont(mfnt1);
		l44.setFont(mfnt1);
		l45.setFont(mfnt1);
		l48.setFont(mfnt1);
		l49.setFont(mfnt1);
		t24=new JTextField(10);
		t25=new JTextField(10);
		t25.addFocusListener(ff);
		t26=new JTextField(10);
		t27=new JTextField(10);
		t28=new JTextField(10);
		t30=new JTextField(10);
		t31=new JTextField(10);
		t32=new JTextField(10);
		t33=new JTextField(10);
		t33.addFocusListener(ff);
		t34=new JTextField(10);
		t35=new JTextField(10);
		t35.addFocusListener(ff);
		t36=new JTextField(10);
		t37=new JTextField(10);
		t37.setEnabled(false);
		t37.addFocusListener(ff);
		t38=new JTextField(10);
		t39=new JTextField(10);
		b13=new JButton("Save and Print");
		b14=new JButton("Thanks");
		b13.addActionListener(this);
		b14.addActionListener(this);
		cb2=new JComboBox();
			cb2.addItem("By Cash");
			cb2.addItem("By Credit Card");
		cb2.addActionListener(this);
		bill.setLayout(gb);
		addBill(l62,1,1,4,1);
		addBill(l63,1,2,1,1);
		addBill(l31,2,4,1,1);
		addBill(l32,2,5,1,1);
		addBill(l48,2,6,1,1);
		addBill(l49,2,7,1,1);
		addBill(l49a,3,4,1,1);
		addBill(l33,2,8,1,1);
		addBill(l34,2,9,1,1);
		addBill(l35,2,10,1,1);
		addBill(l37,2,12,1,1);
		addBill(l38,2,13,1,1);
		addBill(l39,2,14,1,1);
		addBill(l40,2,15,1,1);
		addBill(l41,2,16,1,1);
		addBill(l44,2,17,1,1);
		addBill(l45,2,18,1,1);
		addBill(l42,2,19,1,1);
		addBill(l43,2,20,1,1);
		addBill(t24,4,4,1,1);
		addBill(t25,4,5,1,1);
		addBill(t38,4,6,1,1);
		addBill(t39,4,7,1,1);
		addBill(t26,4,8,1,1);
		addBill(t27,4,9,1,1);
		addBill(t28,4,10,1,1);
		addBill(t30,4,12,1,1);
		addBill(t31,4,13,1,1);
		addBill(t32,4,14,1,1);
		addBill(t33,4,15,1,1);
		addBill(t34,4,16,1,1);
		addBill(cb2,4,17,1,1);
		addBill(t37,4,18,1,1);
		addBill(t35,4,19,1,1);
		addBill(t36,4,20,1,1);
		addBill(b13,2,22,1,1);
		addBill(b14,4,22,1,1);

		//Initialising Main Form Objects

		b15=new JButton("Customer");
		b16=new JButton("Booking");
		b17=new JButton("Billing");
		b18=new JButton("Logout");
		b22=new JButton("Services");
		b28=new JButton("Enquiry");
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b22.addActionListener(this);
		b28.addActionListener(this);
		main.setLayout(gb);
		addMain(l55,1,2,4,1);
		addMain(l57,1,4,1,1);
		addMain(b15,3,5,1,2);
		addMain(b16,3,7,1,2);
		addMain(b22,3,9,1,2);
		addMain(b17,3,11,1,2);
		addMain(b28,3,13,1,2);
		addMain(b18,3,15,1,2);

		//Initialising Thanks Form Objects

		l46=new JLabel(" Thanx ");
		l47=new JLabel(" Software is developed by 'codersarts'  ");
		l46.setFont(mfnt);
		l47.setFont(mfnt);
		b19=new JButton("Back To Main");
		b19.addActionListener(this);
		thnx.setLayout(gb);
		addThanks(l46,5,4,3,3);
		addThanks(l47,5,8,3,3);
		addThanks(b19,5,12,3,3);

		//Initialising Menu Form Objects
		
		l50=new JLabel("Services provided by the Hotel");
		l51=new JLabel("");
		l52=new JLabel("");
		l65a=new JLabel("                      ");
		l50.setFont(mfnt);
		c1=new JCheckBox("BreakFast");
		c2=new JCheckBox("Lunch");
		c3=new JCheckBox("Dinner");
		c4=new JCheckBox("Laundary");
		c5=new JCheckBox("Telephone");
		c6=new JCheckBox("Gym");
		c7=new JCheckBox("Swimming Pool");
		c1.addItemListener(il);
		c2.addItemListener(il);
		c3.addItemListener(il);
		c4.addItemListener(il);
		c5.addItemListener(il);
		c6.addItemListener(il);
		c7.addItemListener(il);
		c1.setFont(mfnt1);
		c2.setFont(mfnt1);
		c3.setFont(mfnt1);
		c4.setFont(mfnt1);
		c5.setFont(mfnt1);
		c6.setFont(mfnt1);
		c7.setFont(mfnt1);
		t40=new JTextField(10);
		t41=new JTextField(10);
		t42=new JTextField(10);
		t43=new JTextField(10);
		t44=new JTextField(10);
		t45=new JTextField(10);
		t46=new JTextField(10);
		t47=new JTextField(10);
		t40.setText("0");
		t41.setText("0");
		t42.setText("0");
		t43.setText("0");
		t44.setText("0");
		t45.setText("0");
		t46.setText("0");
		t40.setEnabled(false);
		t41.setEnabled(false);
		t42.setEnabled(false);
		t43.setEnabled(false);
		t44.setEnabled(false);
		t45.setEnabled(false);
		t46.setEnabled(false);
		b20=new JButton("Total");
		b21=new JButton("Back to Main");
		b26=new JButton("Ok");
		b20.addActionListener(this);
		b21.addActionListener(this);
		b26.addActionListener(this);
		mnu.setLayout(gb);
		addMenu(l50,2,1,3,1);
		addMenu(l51,2,2,1,1);
		addMenu(l52,2,3,1,1);
		addMenu(l65a,3,4,1,1);
		addMenu(b20,2,11,1,1);
		addMenu(c1,2,4,1,1);
		addMenu(c2,2,5,1,1);
		addMenu(c3,2,6,1,1);
		addMenu(c4,2,7,1,1);
		addMenu(c5,2,8,1,1);
		addMenu(c6,2,9,1,1);
		addMenu(c7,2,10,1,1);
		addMenu(t40,4,4,1,1);
		addMenu(t41,4,5,1,1);
		addMenu(t42,4,6,1,1);
		addMenu(t43,4,7,1,1);
		addMenu(t44,4,8,1,1);
		addMenu(t45,4,9,1,1);
		addMenu(t46,4,10,1,1);
		addMenu(t47,4,11,1,1);
		addMenu(b26,2,12,1,1);
		addMenu(b21,4,12,1,1);

		//Initialising Enquiry Form Objects
		
		l66=new JLabel("Name");
		l67=new JLabel("Customer Code");
		l68=new JLabel("Age");
		l69=new JLabel("Nationality");
		l70=new JLabel("Address");
		l71=new JLabel("Phone No.");
		l72=new JLabel("Email-id");
		l73=new JLabel("Room No.");
		l74=new JLabel("Date of Arival");
		l75=new JLabel("Date of Departure");
		l76=new JLabel("No. of persons");
		l77=new JLabel("Net Bill Amount");
		l66.setFont(mfnt1);
		l67.setFont(mfnt1);
		l68.setFont(mfnt1);
		l69.setFont(mfnt1);
		l70.setFont(mfnt1);
		l71.setFont(mfnt1);
		l72.setFont(mfnt1);
		l73.setFont(mfnt1);
		l74.setFont(mfnt1);
		l75.setFont(mfnt1);
		l76.setFont(mfnt1);
		l77.setFont(mfnt1);
		l78=new JLabel("                    ");
		l79=new JLabel("");
		l80=new JLabel("Customer's Enquiry Form");
		l80.setFont(mfnt);
		t50=new JTextField(10);
		t50.addFocusListener(ff);
		t51=new JTextField(10);
		t52=new JTextField(10);
		t53=new JTextField(10);
		t54=new JTextField(10);
		t55=new JTextField(10);
		t56=new JTextField(10);
		t57=new JTextField(10);
		t58=new JTextField(10);
		t59=new JTextField(10);
		t60=new JTextField(10);
		ta5=new JTextArea(5,10);
		b27=new JButton("Ok");
		b27.addActionListener(this);
		b30=new JButton("Find");
		b30.addActionListener(this);
		elst=new JList();
		elst.setSelectionMode(0);
		enq.setLayout(gb);
		addEnquiry(l80,2,1,3,1);
		addEnquiry(l79,2,2,1,1);
		addEnquiry(l78,3,4,1,1);
		addEnquiry(l66,2,4,1,1);
		addEnquiry(l67,2,5,1,1);
		addEnquiry(l68,2,6,1,1);
		addEnquiry(l69,2,7,1,1);
		addEnquiry(l70,2,8,1,1);
		addEnquiry(l71,2,9,1,1);
		addEnquiry(l72,2,10,1,1);
		addEnquiry(l73,2,11,1,1);
		addEnquiry(l74,2,12,1,1);
		addEnquiry(l75,2,13,1,1);
		addEnquiry(l76,2,14,1,1);
		addEnquiry(l77,2,15,1,1);
		addEnquiry(t50,4,4,1,1);
		addEnquiry(t51,4,5,1,1);
		addEnquiry(t52,4,6,1,1);
		addEnquiry(t53,4,7,1,1);
		addEnquiry(ta5,4,8,1,1);
		addEnquiry(t54,4,9,1,1);
		addEnquiry(t55,4,10,1,1);
		addEnquiry(t56,4,11,1,1);
		addEnquiry(t57,4,12,1,1);
		addEnquiry(t58,4,13,1,1);
		addEnquiry(t59,4,14,1,1);
		addEnquiry(t60,4,15,1,1);
		addEnquiry(b27,3,17,1,1);
		addEnquiry(b30,5,14,1,1);
		addEnquiry(elst,6,4,20,10);


		//Adding Panels
		
		p.add("Login",lgn);
		p.add("Customer",cst);
		p.add("Registration",regn);
		p.add("Booking",bkng);
		p.add("Rooms",room);
		p.add("Bill",bill);
		p.add("Main",main);
		p.add("Menu",mnu);
		p.add("Thanks",thnx);
		p.add("Enquiry",enq);
		getContentPane().add(p);
		setSize(1024,768);
		show();
		 try
			{
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String url = "jdbc:ucanaccess://F:\\collection\\hotel.zip_expanded\\hotel\\database\\htl.mdb";
                     con=DriverManager.getConnection(url);

				System.out.println("done..");
			
			}
		catch(Exception e)
			{
				t1.setText("Error in Connection ");
				System.out.println("reeeee");
			}
	}
public void addLogin(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		lgn.add(cc);
	}
public void addCustomer(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		cst.add(cc);
	}
public void addRegistration(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		regn.add(cc);
	}
public void addBooking(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		bkng.add(cc);
	}
public void addRooms(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		room.add(cc);
	}
public void addBill(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		bill.add(cc);
	}
public void addMain(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		main.add(cc);
	}
public void addThanks(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		thnx.add(cc);
	}
public void addMenu(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		mnu.add(cc);
	}
public void addEnquiry(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		enq.add(cc);
	}
public void actionPerformed(ActionEvent ee)
	{
		
		if(ee.getSource()==b1)
		{
			try
			{		
				ps=con.prepareStatement("Select * from Users where UserName=? and Password=?");	
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				rs=ps.executeQuery();
				t1.setText("");
				t2.setText("");
				rs.next();
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
				cl.show(p,"Main");
			}
			catch(Exception e)
			{
				t1.setText("Illegal User Name or Password");
				t2.setText("");
			}
		}
		if(ee.getSource()==b2)
			{
				System.exit(0);
			}
		if(ee.getSource()==b3)
			{
				cl.show(p,"Registration");
			}
		if(ee.getSource()==b4)
			{
			try
			{
				ps=con.prepareStatement("Insert into Customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,t3.getText());
				ps.setString(2,t4.getText());
				ps.setString(3,t5.getText());
				if(r1.isSelected())
				{
					ps.setString(4,"Male");
				}
				else
				{
					ps.setString(4,"Female");
				}
				ps.setInt(5,Integer.parseInt(t6.getText()));
				if(r3.isSelected())
				{
					ps.setString(6,"Unmarried");
				}
				else
				{
					ps.setString(6,"Married");
				}
				if(r5.isSelected())
				{
					ps.setString(7,"Indian");
				}
				else
				{
					ps.setString(7,"Foreigner");
				}
				ps.setString(8,t7.getText());
				ps.setString(9,t8.getText());
				ps.setString(10,t9.getText());
				ps.setString(11,ta1.getText());
				ps.setString(12,ta2.getText());
				ps.setString(13,t10.getText());
				ps.setString(14,t11.getText());
				ps.setString(15,(String)cb1.getSelectedItem());	
				int i;
				i=ps.executeUpdate();	
				t3.setText("Customer details successfully added");
				t4.setText("");	
				t5.setText("");
				r1.setSelected(true);
				r2.setSelected(false);
				t6.setText("");
				r3.setSelected(false);
				r4.setSelected(true);
				r5.setSelected(true);
				r6.setSelected(false);
				t7.setText("");
				t8.setText("");
				t9.setText("");
				ta1.setText("");
				ta2.setText("");
				t10.setText("");
				t11.setText("");
			}
			catch(Exception e)
			{
				t3.setText("Error in adding Customer details");
			}
			}
		
		if(ee.getSource()==b5)
			{
				cl.show(p,"Main");
			}
		if(ee.getSource()==b6)
		{
			try
			{
				ps=con.prepareStatement("Insert into Users values(?,?)");	
				String str1,str2;
				str1=t13.getText();
				str2=t14.getText();
				if(str1.equals(str2))
				{
					ps.setString(1,t12.getText());
					ps.setString(2,t13.getText());
					int i=ps.executeUpdate();
					t12.setText("UserName successfully added");
					t13.setText("");
					t14.setText("");				}
				else
				{
					t12.setText("Please retype your UserName And Password correctly");
				}
			}
			catch(Exception e)
				{
					t12.setText("Error in  making new account");
				} 
		}
		if(ee.getSource()==b7)
			{
				cl.show(p,"Login");
				t12.setText("");

			}
		if(ee.getSource()==b8)
		{
			try
			{
				ps=con.prepareStatement("Insert into Booking values (?,?,?,?,?,?)");
				ps.setString(1,t15.getText());		
				ps.setString(2,t16.getText());
				ps.setInt(3,Integer.parseInt(t17.getText()));
				ps.setString(4,t18.getText());
				ps.setInt(5,Integer.parseInt(t19.getText()));
				ps.setString(6,ta3.getText());	
				int i;
				i=ps.executeUpdate();
				ps=con.prepareStatement("Update Rooms set Status= 'NotAvailable' Where  RNo=?");
				ps.setInt(1,Integer.parseInt(t17.getText()));
				i=ps.executeUpdate();
				t15.setText("Booking successfully added");
				t16.setText("");
				t17.setText("");
				t20.setText("");
				t21.setText("");
				ta4.setText("");
				t17.setText("");
				t18.setText("");
				t19.setText("");
				ta3.setText("");
			}
			catch(Exception e)
			{
				t15.setText("Error in Booking");
			}
		}
		if(ee.getSource()==b9)
			{
				cl.show(p,"Main");
			}
		if(ee.getSource()==b11)
			{
				String rr;
				rr=(String)rlst.getSelectedValue();
				rr=rr.substring(0,3);
				t17.setText(rr);
				cl.show(p,"Booking");
			}
		if(ee.getSource()==b12)
			{
				String ss[];
				ss=new String[50];
				int i=0;
				try
				{		
				ps=con.prepareStatement("Select * from Rooms where status='available'");	
				rs=ps.executeQuery();
				while(rs.next())
				{
					ss[i]=rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3);
					i++;
				}
				rlst.setListData(ss);
				rlst.setVisibleRowCount(5);
			

				}
				catch(Exception e)
				{
					t17.setText("Sorry !! No Rooms are Available");
				}
				cl.show(p,"Rooms");		
			}	
		if(ee.getSource()==b13)
			{
			try
			{
				ps=con.prepareStatement("Insert into Billing values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,t24.getText());		
				ps.setString(2,t25.getText());
				ps.setString(3,t26.getText());
				ps.setInt(4,Integer.parseInt(t27.getText()));
				ps.setInt(5,Integer.parseInt(t28.getText()));	
				ps.setInt(6,Integer.parseInt(t30.getText()));
				ps.setInt(7,Integer.parseInt(t31.getText()));
				ps.setInt(8,Integer.parseInt(t32.getText()));
				ps.setInt(9,Integer.parseInt(t33.getText()));
				ps.setInt(10,Integer.parseInt(t34.getText()));
				ps.setString(11,(String)cb2.getSelectedItem());
				ps.setInt(12,Integer.parseInt(t35.getText()));
				ps.setString(13,t37.getText());
				ps.setInt(14,Integer.parseInt(t36.getText()));
				int i;
				i=ps.executeUpdate();
				t24.setText("Billing successfully done");
				
				//For printing the bill

				  //PrintUtilities.printComponent(this);
		
			/*	ps=con.prepareStatement("Update Rooms set Status= 'Available' Where  RNo=?");
				ps.setInt(1,Integer.parseInt(t17.getText()));
				i=ps.executeUpdate();	*/
			}
			catch(Exception e)
			{
				t24.setText("Error in Billing");
				t25.setText("");
				t26.setText("");
				t27.setText("");
				t28.setText("");
				t30.setText("");
				t31.setText("");
				t32.setText("");
				t33.setText("");
				t34.setText("");
				t35.setText("");
				t36.setText("");
				t37.setText("");
				t38.setText("");
				t39.setText("");
			}
			}
		if(ee.getSource()==b14)
			{
				t25.setText("");
				t26.setText("");
				t27.setText("");
				t28.setText("");
				t30.setText("");
				t31.setText("");
				t32.setText("");
				t33.setText("");
				t34.setText("");
				t35.setText("");
				t36.setText("");
				t37.setText("");
				t38.setText("");
				t39.setText("");
				cl.show(p,"Thanks");
			}
		if(ee.getSource()==b15)
			{
			int num;
			String str;
			try
			{
				ps=con.prepareStatement("Select top 1 * from Customer order by CCode desc");	
				rs=ps.executeQuery();
				rs.next();
				str=rs.getString(1);
				num=Integer.parseInt(str.substring(1));
				num++;
				if(num<10)
				{
					str="C00" + num;
				}
				else if(num<100)
				{
					str="C0" + num;
				}
				else if(num<1000)
				{
					str="C" + num;
				}
				t3.setText(str);
				r1.setSelected(true);
				r2.setSelected(false);
				r3.setSelected(false);
				r4.setSelected(true);
				r5.setSelected(true);
				r6.setSelected(false);
						
			}
			catch(Exception e3)
				{
					t3.setText("Error in Code generation");
				}
				cl.show(p,"Customer");
			}
		if(ee.getSource()==b16)
		{
			int num;
			String str;
			try
			{
				ps=con.prepareStatement("Select top 1 * from Booking order by BNo desc");	
				rs=ps.executeQuery();
				rs.next();
				str=rs.getString(1);
				num=Integer.parseInt(str.substring(1));
				num++;
				if(num<10)
				{
					str="B00" + num;
				}
				else if(num<100)
				{
					str="B0" + num;
				}
				else if(num<1000)
				{
					str="B" + num;
				}
				t15.setText(str);
			}
			catch(Exception e3)
			{
				t15.setText("Error in Code generation");
			}
			cl.show(p,"Booking");
			t17.setText("");
		}
		if(ee.getSource()==b17)
			{
			int num;
			String str;
			try
			{
				ps=con.prepareStatement("Select top 1 * from Billing order by BillNo desc");	
				rs=ps.executeQuery();
				rs.next();
				str=rs.getString(1);
				num=Integer.parseInt(str.substring(3));
				num++;
				if(num<10)
				{
					str="BNo00" + num;
				}
				else if(num<100)
				{
					str="BNo0" + num;
				}
				else if(num<1000)
				{
					str="BNo" + num;
				}
				t24.setText(str);
				t25.setText("");
				t26.setText("");
				t27.setText("");
				t28.setText("");
				t31.setText("");
				t32.setText("");
				t33.setText("");
				t34.setText("");
				t35.setText("");
				t36.setText("");
				t37.setText("");
				t38.setText("");
				t39.setText("");
			}
			catch(Exception e3)
			{
				t24.setText("Error in Code generation");
			}
			cl.show(p,"Bill");
			}
		if(ee.getSource()==b18)
			{
				t1.setText("");
				t2.setText("");
				cl.show(p,"Login");
			}
		if(ee.getSource()==b19)
			{
				cl.show(p,"Main");
			}
		if(ee.getSource()==b20)
			{
				int num;
				num=0;
				num=Integer.parseInt(t40.getText())+Integer.parseInt(t41.getText())+Integer.parseInt(t42.getText())+Integer.parseInt(t43.getText())+Integer.parseInt(t44.getText())+Integer.parseInt(t45.getText())+Integer.parseInt(t46.getText());							
				t47.setText(String.valueOf(num));
			}	
		if(ee.getSource()==b21)
			{
				cl.show(p,"Main");
				t40.setText("0");
				t41.setText("0");
				t42.setText("0");
				t43.setText("0");
				t44.setText("0");
				t45.setText("0");
				t46.setText("0");
				t47.setText("0");
			}
		if(ee.getSource()==b22)
			{
				c1.setSelected(false);
				c2.setSelected(false);
				c3.setSelected(false);
				c4.setSelected(false);
				c5.setSelected(false);
				c6.setSelected(false);
				c7.setSelected(false);
				cl.show(p,"Menu");

			}
		if(ee.getSource()==b26)
			{
				try
				{
					t30.setText(t47.getText());
					t40.setEnabled(true);
					t40.setText("Details added successfully");
					t41.setText("0");
					t42.setText("0");
					t43.setText("0");
					t44.setText("0");
					t45.setText("0");
					t46.setText("0");
				}
				catch(Exception e)
				{
					t40.setEnabled(true);
					t40.setText("Error in adding details");
					t41.setText("0");
					t42.setText("0");
					t43.setText("0");
					t44.setText("0");
					t45.setText("0");
					t46.setText("0");
				}
			}
		if(ee.getSource()==b27)
			{
				cl.show(p,"Main");
			}	
		if(ee.getSource()==b28)
			{
				cl.show(p,"Enquiry");
			}
		if(ee.getSource()==b30)
			{
			String rr="";
				try
				{
					
					rr=(String)elst.getSelectedValue();
					ps=con.prepareStatement("Select * from Customer where CCode=?");	
					ps.setString(1,rr);
					rs=ps.executeQuery();
						rs.next();
					t51.setText(rs.getString(1));
					t52.setText(String.valueOf(rs.getInt(5)));
					t53.setText(rs.getString(7));
					ta5.setText(rs.getString(11));
					t54.setText(rs.getString(13));
					t55.setText(rs.getString(14));	
					ps=con.prepareStatement("Select * from Booking where Ccode=?");	
					ps.setString(1,t51.getText());
					rs=ps.executeQuery();
					rs.next();
					t56.setText(String.valueOf(rs.getInt(3)));
					t57.setText(rs.getString(4));
					//t58.setText(rs.getString(4));
					t59.setText(String.valueOf(rs.getInt(5)));		
				}
				catch(Exception ee1)
				{
					t51.setText("Error in finding record " + rr);
				}
			}	
		if(ee.getSource()==r1)
			{
					r2.setSelected(false);
					r1.setSelected(true);
			}
		if(ee.getSource()==r2)
			{
					r1.setSelected(false);
					r2.setSelected(true);
			}
			if(ee.getSource()==r3)
			{
					r4.setSelected(false);
					r3.setSelected(true);
			}
		if(ee.getSource()==r4)
			{
					r3.setSelected(false);
					r4.setSelected(true);
			}
		if(ee.getSource()==r5)
			{
					r6.setSelected(false);
					r5.setSelected(true);
			}
		if(ee.getSource()==r6)
			{
					r5.setSelected(false);
					r6.setSelected(true);
			}
		if(ee.getSource()==cb2)
		{
			String str;
			str=(String)cb2.getSelectedItem();
			if(str.equals("By Credit Card"))
			{
				t37.setEnabled(true);
				t35.setEnabled(true);
			}
			else if(str.equals("By Cash"))
			{
				t37.setEnabled(false);
				t35.setEnabled(true);		
			}
		}
					
	}
public static void main(String a[])
	{
		Hotel ht =new Hotel();
	}
class MyWinLis extends WindowAdapter
	{
		public void windowClosing(WindowEvent w)
		{
			Hotel ht;
			ht=(Hotel)w.getSource();
			ht.dispose();
			System.exit(0);
		}
	}
class MyFocusLis implements FocusListener
	{
int damt=0;		
public void focusGained(FocusEvent e)
		{
		}
		public void focusLost(FocusEvent e)
		{
			if(e.getSource()==t16)
			{
			try
			{		
				ps=con.prepareStatement("Select * from Customer where CCode=?");	
				ps.setString(1,t16.getText());
				rs=ps.executeQuery();
				rs.next();
				t20.setText(rs.getString(3) + " " + rs.getString(2));
				ta4.setText(rs.getString(11));
			}
			catch(Exception ex)
			{
				t13.setText("Invalid Customer  No. ! Try Again");
				t20.setText("");
				ta4.setText("");

			}
			}
			if(e.getSource()==t25)
			{
			try
			{		
				ps=con.prepareStatement("Select * from Booking where BNo=?");	
				ps.setString(1,t25.getText());
				rs=ps.executeQuery();
				rs.next();
				t38.setText(rs.getString(3));
				t39.setText(rs.getString(4));
				ps=con.prepareStatement("Select Date()");	
				rs=ps.executeQuery();
				rs.next();
				t26.setText(rs.getString(1));	
				ps=con.prepareStatement("Select DateDiff('d',?,?)");	
				ps.setString(1,t39.getText());
				ps.setString(2,t26.getText());
				rs=ps.executeQuery();
				rs.next();
				t27.setText(rs.getString(1));
				ps=con.prepareStatement("Select * from Rooms where RNo=?");	
				ps.setString(1,t38.getText());
				rs=ps.executeQuery();
				rs.next();
				int rent;
				rent=rs.getInt(3)*Integer.parseInt(t27.getText());
				t28.setText(String.valueOf(rent));
				int amt,st,ar;
			    amt=Integer.parseInt(t28.getText())+Integer.parseInt(t30.getText());
				t31.setText(String.valueOf(amt)) ;
				st=amt*10/100;	
				t32.setText(String.valueOf(st));
				t33.setText("0");
				
				amt=amt+st;
				damt=amt;
				t34.setText(String.valueOf(amt));
				
				
			}
			catch(Exception ex)
			{
				t25.setText("Invalid Booking  No. ! Try Again " + ex.getMessage());
			}
			}
			if(e.getSource()==t33)
			{
				int ar;
				ar=Integer.parseInt(t33.getText());
				damt=damt-ar;
				t34.setText(String.valueOf(damt)) ;
			}
			if(e.getSource()==t35)
			{
				int ar;
				ar=Integer.parseInt(t34.getText())-Integer.parseInt(t35.getText());
				t36.setText(String.valueOf(ar)) ;
			}
			if(e.getSource()==t37)
			{
				t35.setText(String.valueOf(t34.getText()));
			}
			if(e.getSource()==t50)
			{
				
				String ss[];
				ss=new String[10];
				int i=0;
				try
				{		
					ps=con.prepareStatement("Select * from Customer where FName=?");	
					ps.setString(1,t50.getText());
					rs=ps.executeQuery();
					while(rs.next())
					{
						ss[i]=rs.getString(1);
						i++;
					}
					elst.setListData(ss);
					elst.setVisibleRowCount(5);
				}
				catch(Exception e1)
				{
					t50.setText("Sorry !! No such record Available");
				}	
				
			}	
			
		}
		
	}
class MyItemLis implements ItemListener
{
	public void itemStateChanged(ItemEvent ee)
	{
		if(ee.getSource()==r6)
		{
			if(r6.isSelected())
			{
				t7.setEnabled(true);
				t8.setEnabled(true);
				t9.setEnabled(true);
			}			
			else
			{			
				t7.setEnabled(false);
				t8.setEnabled(false);
				t9.setEnabled(false);
			}
		}
		if(ee.getSource()==c1)
		{
			if(c1.isSelected())
			{
				t40.setEnabled(true);
				t40.setText("");
			}
			else
			{
				t40.setEnabled(false);
				t40.setText("0");
			}
		}
		if(ee.getSource()==c2)
		{
			if(c2.isSelected())
			{
				t41.setEnabled(true);
				t41.setText("");
			}
			else
			{
				t41.setEnabled(false);
				t41.setText("0");
			}
		}
		if(ee.getSource()==c3)
		{
			if(c3.isSelected())
			{
				t42.setEnabled(true);
				t42.setText("");
			}
			else
			{
				t42.setEnabled(false);
				t42.setText("0");
			}
		}
		if(ee.getSource()==c4)
		{
			if(c4.isSelected())
			{
				t43.setEnabled(true);
				t43.setText("");
			}
			else
			{
				t43.setEnabled(false);
				t43.setText("0");
			}
		}
		if(ee.getSource()==c5)
		{
			if(c5.isSelected())
			{
				t44.setEnabled(true);
				t44.setText("");
			}
			else
			{
				t44.setEnabled(false);
				t44.setText("0");
			}
		}
		if(ee.getSource()==c6)
		{
			if(c6.isSelected())
			{
				t45.setEnabled(true);
				t45.setText("");
			}
			else
			{
				t45.setEnabled(false);
				t45.setText("0");
			}
		}
		if(ee.getSource()==c7)
		{
			if(c7.isSelected())
			{
				t46.setEnabled(true);
				t46.setText("");
			}
			else
			{
				t46.setEnabled(false);
				t46.setText("0");
			}
		}
	}
}
}
