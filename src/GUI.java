import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class GUI 
{
//	declare class level objects and variables
	static JButton btnSubmit1, btnView2, btnAdd2, btnExit1, btnExit2, btnShow3, btnExit3, btnSearch3, btnNumber5, btnExit5, btnName5, btnExit6, btnEnter6,btnExit7, btnEnter7, btnAdd8, btnMod8, btnExit8 ,btnEdit10, btnDelete10, btnExit10, btnDelete12, btnExit12;
	static JButton movie1, movie2, movie3, movie4,  movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12;
	static JLabel lblTitle1, lblIntro1, lblInfo1, lblBlank1a, lblBlank1b, lblBlank2a, lblBlank2b, lblBlank2c, lblBlank2d;
	static JLabel lblTitle2, lblTitle3, lblInfo3;
	static JLabel n1, p1, a1, n2, p2, a2, n3, p3, a3, n4, p4 , a4, n5, p5,a5, n6, p6, a6, n7, p7,a7, n8, p8,  a8,n9, p9,a9, n10,  p10,a10;
	static JLabel names [] = new JLabel [10], addresses[] = new JLabel [10], phone [] = new JLabel [10];
	static JTextField txtInput1, txtInput9a, txtInput9b, txtInput9c, txtInput9d, txtInput9e, txtInput9f, txtInput12;
	static int realPass = 1234, counter = 1;
	static JFrame frame1 = new JFrame ("Phonebook+ Intro");
	static JFrame frame2 = new JFrame ("Navigation - Frame 2");
	static JFrame frame3 = new JFrame ("View Contacts");
	static JFrame frame4 = new JFrame ("View All Contacts");
	static JFrame frame5 = new JFrame ("Edit a Movie - Frame 5");
	static JFrame frame6 = new JFrame ("Add a Movie- Frame 6");
	static JFrame frame7 = new JFrame ("Edit Contacts");
	static JFrame frame8 = new JFrame ("Edit Contacts");
	static JFrame frame9 = new JFrame ("Add Contacts");
	static JFrame frame10 = new JFrame ("Modify Contacts");
	static JFrame frame11 = new JFrame ("Edit Contacts");
	static JFrame frame12 = new JFrame ("Delete Contacts");

	
	static Contact contact = new Contact();
	static makeContact con = new makeContact();
	static String info [][];
	static Contact.Modifications<String, String> phonebook = new Contact.Modifications<String, String>();
	
	private static void guiApp ()
	{
		// create and set up the various frame
		frame1.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame3.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame4.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame5.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		frame6.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		frame7.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		frame8.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		// **************************************************************
		// create components for login screen frame 1
		JPanel panel1a = new JPanel (new GridLayout (1, 1));
		JPanel panel1b = new JPanel ();
		JPanel panel1c = new JPanel ();
		JPanel panel1d = new JPanel (new GridLayout (1, 3));
		JPanel panel1e = new JPanel (new GridLayout (3, 3));
		JPanel panel1f = new JPanel ();
		JPanel main1 = new JPanel ();

		//lblTitle1 = new JLabel ("Movie Database Login:", JLabel.CENTER);
		//lblTitle1.setFont (new Font ("Serif", Font.BOLD, 24));	
		lblIntro1 = new JLabel ("Enter the Password:", JLabel.CENTER);
		txtInput1 = new JTextField ("");
		txtInput1.setHorizontalAlignment (JTextField.CENTER);
		btnSubmit1 = new JButton ("Enter");
		btnExit1 = new JButton ("Exit");
		
		ImageIcon icon = new ImageIcon("logo.jpg");
		lblTitle1 = new JLabel("", icon, JLabel.CENTER);

		//Button Handler1 for frame 1
		ButtonHandler1 onClick1 = new ButtonHandler1 ();
		btnSubmit1.addActionListener (onClick1);
		btnSubmit1.setLocation(300, 500);
		btnExit1.addActionListener (onClick1);
		
		

		// add components to content pane
		panel1a.add(lblTitle1);
		panel1b.add(lblIntro1);
		panel1c.add(txtInput1);		
		panel1d.add(btnSubmit1);		
		panel1f.add(btnExit1);

		main1.setLayout(new BorderLayout());
		main1.add (panel1a);
		main1.add(panel1d,BorderLayout.SOUTH);
		frame1.getContentPane().add(main1);
		frame1.setSize (600, 400);
		frame1.setVisible (true);


		//********************************************************************
		// frame 2 - Navigation Main Screen Menu
		JPanel panel2a = new JPanel (new GridLayout(1,1));
		JPanel panel2b = new JPanel (new GridLayout(3,3));
		JPanel panel2c = new JPanel (new GridLayout(1,1));
		JPanel panel2d = new JPanel (new GridLayout(1,1));
		JPanel panel2e = new JPanel (new GridLayout(1,3));
		
		JPanel main2 = new JPanel (new GridLayout (5, 1));
		lblTitle2 = new JLabel ("Phonebook+ Navigation Screen:", JLabel.CENTER);
		lblTitle2.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnView2 = new JButton ("View All Contacts");
		btnAdd2 = new JButton ("Edit Contacts");
		btnExit2 = new JButton ("Exit");

		//ButtonHandler2 for frame 2
		ButtonHandler2 onClick2 = new ButtonHandler2 ();
		btnAdd2.addActionListener (onClick2);
		btnView2.addActionListener (onClick2);
		btnExit2.addActionListener (onClick2);

		panel2a.add (lblTitle2);
		panel2b.add(btnView2);
		panel2b.add(btnAdd2);
		panel2b.add(btnExit2);
		main2.add(panel2a);
		main2.add(panel2b);

		frame2.getContentPane ().add(main2);
		frame2.setSize(400,450);
		frame2.setVisible (false);
		
		//************************************************************************
		//Frame 3 - View All Contacts
		JPanel panel3a = new JPanel (new GridLayout(1,1));
		JPanel panel3b = new JPanel (new GridLayout(3,3));
		JPanel panel3c = new JPanel (new GridLayout(1,1));
		JPanel panel3d = new JPanel (new GridLayout(1,1));
		JPanel panel3e = new JPanel (new GridLayout(1,3));
		
		JPanel main3 = new JPanel (new GridLayout (5, 1));
		lblTitle3 = new JLabel ("Browse Contacts:", JLabel.CENTER);
		lblTitle3.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnShow3 = new JButton ("View Contacts");
		btnSearch3 = new JButton ("Search Contacts");
		btnExit3 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler3 onClick3 = new ButtonHandler3 ();
		btnSearch3.addActionListener (onClick3);
		btnShow3.addActionListener (onClick3);
		btnExit3.addActionListener (onClick3);

		panel3a.add (lblTitle3);
		panel3b.add(btnShow3);
		panel3b.add(btnSearch3);
		panel3b.add(btnExit3);
		main3.add(panel3a);
		main3.add(panel3b);

		frame3.getContentPane ().add(main3);
		frame3.setSize(400,450);
		frame3.setVisible (false);

		

		//************************************************************************
		//Frame 4 - View Specific Movie

		JPanel panel4a = new JPanel (new GridLayout(1,26));
		JPanel panel4b = new JPanel (new GridLayout(0,4));
		JPanel panel4c = new JPanel (new GridLayout(0,2));
		JPanel panel4d = new JPanel (new GridLayout(0,2));
		JPanel panel4e = new JPanel (new GridLayout(0,2));
		JPanel panel4f = new JPanel (new GridLayout(0,2));
		JPanel panel4g = new JPanel (new GridLayout(0,2));
		JPanel panel4h = new JPanel (new GridLayout(0,2));
		JPanel panel4i = new JPanel (new GridLayout(0,2));
		JPanel panel4j = new JPanel (new GridLayout(0,2));
		JPanel panel4k = new JPanel (new GridLayout(0,2));
		JPanel panel4l = new JPanel (new GridLayout(0,2));
		
		JPanel main4 = new JPanel (new GridLayout(8,1));
		
		JButton A = new JButton ("A"),B = new JButton ("B"), C = new JButton ("C"), D = new JButton ("D"),E = new JButton ("E"),F = new JButton ("F"),G = new JButton ("G"),H = new JButton ("H"),I = new JButton ("I"),J = new JButton ("J"),K = new JButton ("K"),L = new JButton ("L"),M = new JButton ("M"),N = new JButton ("N");
		JButton O = new JButton ("O"),P = new JButton ("P"),Q = new JButton ("Q"),R = new JButton ("R"),S = new JButton ("S"),T = new JButton ("T"),U = new JButton ("U"),V = new JButton ("V"),W = new JButton ("W"),X = new JButton ("X"),Y = new JButton ("Y"),Z = new JButton ("Z");

		ButtonHandler13 onClick4 = new ButtonHandler13 ();
		A.addActionListener (onClick4); B.addActionListener (onClick4); C.addActionListener (onClick4);
		D.addActionListener (onClick4); E.addActionListener (onClick4); F.addActionListener (onClick4);
		G.addActionListener (onClick4); H.addActionListener (onClick4); I.addActionListener (onClick4);
		J.addActionListener (onClick4); K.addActionListener (onClick4); L.addActionListener (onClick4);
		M.addActionListener (onClick4); N.addActionListener (onClick4); O.addActionListener (onClick4);
		P.addActionListener (onClick4); Q.addActionListener (onClick4); R.addActionListener (onClick4);
		S.addActionListener (onClick4); T.addActionListener (onClick4); U.addActionListener (onClick4);
		V.addActionListener (onClick4); W.addActionListener (onClick4); X.addActionListener (onClick4);
		Y.addActionListener (onClick4); Z.addActionListener (onClick4); 
		
		JLabel name4a = new JLabel ("Name"); name4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel numb4a = new JLabel ("Number"); numb4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel addr4a = new JLabel ("Address"); addr4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel name4b = new JLabel ("Name"); name4b.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel numb4b = new JLabel ("Number"); numb4b.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel addr4b = new JLabel ("Address"); addr4b.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel b1 = new JLabel (""); JLabel b2 = new JLabel ("");
		
		for (int i = 0; i < 10; i ++){
			names [i] = new JLabel (""); names[i].setFont (new Font ("Serif", Font.BOLD, 12));
			phone [i] = new JLabel (""); phone[i].setFont (new Font ("Serif", Font.BOLD, 12));
			addresses [i] = new JLabel (""); addresses[i].setFont (new Font ("Serif", Font.BOLD, 12));
		}
		
		//panel4a.add(lblTitle4);
		panel4a.add(A);	panel4a.add(B); panel4a.add(C); panel4a.add(D); panel4a.add(E); panel4a.add(F);
		panel4a.add(G);	panel4a.add(H); panel4a.add(I); panel4a.add(J); panel4a.add(K); panel4a.add(L);
		panel4a.add(M); panel4a.add(N); panel4a.add(O); panel4a.add(P); panel4a.add(Q);	panel4a.add(R);
		panel4a.add(S); panel4a.add(T); panel4a.add(U); panel4a.add(V); panel4a.add(W); panel4a.add(X);
		panel4a.add(Y);	panel4a.add(Z);
		
		
		JPanel p0a = new JPanel (new GridLayout(0,2));
		JPanel p0b = new JPanel (new GridLayout(0,2));
		p0a.add(name4a);	p0a.add(numb4a);
		p0b.add(name4b);	p0b.add(numb4b);
		panel4b.add(p0a); panel4b.add(addr4a);
		panel4b.add(p0b); panel4b.add(addr4b);
		

		JPanel p1 = new JPanel (new GridLayout(0,2)); 	JPanel p2 = new JPanel (new GridLayout(0,2));
		JPanel p3 = new JPanel (new GridLayout(0,2)); 	JPanel p4 = new JPanel (new GridLayout(0,2));
		JPanel p5 = new JPanel (new GridLayout(0,2)); 	JPanel p6 = new JPanel (new GridLayout(0,2));
		JPanel p7 = new JPanel (new GridLayout(0,2)); 	JPanel p8 = new JPanel (new GridLayout(0,2));
		JPanel p9 = new JPanel (new GridLayout(0,2)); 	JPanel p10 = new JPanel (new GridLayout(0,2));
		
		p1.add(names[0]); p1.add(phone[0]);
		p2.add(names[1]); p2.add(phone[1]);
		p3.add(names[2]); p3.add(phone[2]);
		p4.add(names[3]); p4.add(phone[3]);
		p5.add(names[4]); p5.add(phone[4]);
		p6.add(names[5]); p6.add(phone[5]);
		p7.add(names[6]); p7.add(phone[6]);
		p8.add(names[7]); p8.add(phone[7]);
		p9.add(names[8]); p9.add(phone[8]);
		p10.add(names[9]); p10.add(phone[9]);
		
		//panel4c.add(names[0]);	
		panel4c.add(p1); panel4c.add(addresses[0]);
		panel4d.add(p2); panel4d.add(addresses[1]);
		panel4e.add(p3); panel4e.add(addresses[2]);
		panel4f.add(p4); panel4f.add(addresses[3]);
		panel4g.add(p5); panel4g.add(addresses[4]);
		panel4h.add(p6); panel4h.add(addresses[5]);
		panel4i.add(p7); panel4i.add(addresses[6]);
		panel4j.add(p8); panel4j.add(addresses[7]);
		panel4k.add(p9); panel4k.add(addresses[8]);
		panel4l.add(p10); panel4l.add(addresses[9]);
		
		JPanel panelM4a = new JPanel (new GridLayout(0,2));  JPanel panelM4b = new JPanel (new GridLayout(0,2));
		JPanel panelM4c = new JPanel (new GridLayout(0,2));  JPanel panelM4d = new JPanel (new GridLayout(0,2));
		JPanel panelM4e = new JPanel (new GridLayout(0,2));
		
		main4.add(panel4a);
		main4.add(panel4b); 	main4.add(panel4b); 
		
		
		panelM4a.add(panel4c); 	panelM4a.add(panel4d);
		panelM4b.add(panel4e);  panelM4b.add(panel4f);
		panelM4c.add(panel4g);  panelM4c.add(panel4h);
		panelM4d.add(panel4i); 	panelM4d.add(panel4j);
		panelM4e.add(panel4k); 	panelM4e.add(panel4l);
		
		main4.add(panelM4a); main4.add(panelM4b); main4.add(panelM4c); main4.add(panelM4d); main4.add(panelM4e);
		
		frame4.getContentPane ().add(main4);
		frame4.setSize(1500,1000);
		frame4.setVisible (true);
		
		//***************************************************
		// Frame 5 - Search Screen
		JPanel panel5a = new JPanel (new GridLayout(1,1));
		JPanel panel5b = new JPanel (new GridLayout(3,3));
		JPanel panel5c = new JPanel (new GridLayout(1,1));
		JPanel panel5d = new JPanel (new GridLayout(1,1));
		JPanel panel5e = new JPanel (new GridLayout(1,3));
		
		JPanel main5 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle5 = new JLabel ("Search Contacts By:", JLabel.CENTER);
		lblTitle5.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnName5 = new JButton ("Name");
		btnNumber5 = new JButton ("Number");
		btnExit5 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler5 onClick5 = new ButtonHandler5 ();
		btnName5.addActionListener (onClick5);
		btnNumber5.addActionListener (onClick5);
		btnExit5.addActionListener (onClick5);

		panel5a.add (lblTitle5);
		panel5b.add(btnName5);
		panel5b.add(btnNumber5);
		panel5b.add(btnExit5);
		main5.add(panel5a);
		main5.add(panel5b);

		frame5.getContentPane ().add(main5);
		frame5.setSize(400,450);
		frame5.setVisible (false);

		
		//***************************************************
		// Frame 6 - Search by Name
		JPanel panel6a = new JPanel (new GridLayout(1,1));
		JPanel panel6b = new JPanel (new GridLayout(3,2));
		JPanel panel6c = new JPanel (new GridLayout(1,1));
		JPanel panel6d = new JPanel (new GridLayout(1,1));
		JPanel panel6e = new JPanel (new GridLayout(1,3));
		
		JPanel main6 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle6 = new JLabel ("Search Contacts By Name:", JLabel.CENTER);
		lblTitle6.setFont (new Font ("Serif", Font.BOLD, 24));	
		JTextField txtInput6 = new JTextField ("");
		txtInput6.setHorizontalAlignment (JTextField.CENTER);
		btnEnter6 = new JButton ("Enter");
		btnExit6 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler6 onClick6 = new ButtonHandler6 ();
		btnEnter6.addActionListener (onClick6);
		btnExit6.addActionListener (onClick6);

		panel6a.add (lblTitle6);
		panel6b.add(txtInput6);
		panel6b.add(btnEnter6);
		panel6b.add(btnExit6);
		main6.add(panel6a);
		main6.add(panel6b);

		frame6.getContentPane ().add(main6);
		frame6.setSize(400,450);
		frame6.setVisible (false);
		
		//***************************************************
		// Frame 7 - Search by Number
		JPanel panel7a = new JPanel (new GridLayout(1,1));
		JPanel panel7b = new JPanel (new GridLayout(3,2));
		JPanel panel7c = new JPanel (new GridLayout(1,1));
		JPanel panel7d = new JPanel (new GridLayout(1,1));
		JPanel panel7e = new JPanel (new GridLayout(1,3));
		
		JPanel main7 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle7 = new JLabel ("Search Contacts By Number:", JLabel.CENTER);
		lblTitle7.setFont (new Font ("Serif", Font.BOLD, 24));	
		JTextField txtInput7 = new JTextField ("");
		txtInput7.setHorizontalAlignment (JTextField.CENTER);
		btnEnter7 = new JButton ("Enter");
		btnExit7 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler7 onClick7 = new ButtonHandler7 ();
		btnEnter7.addActionListener (onClick7);
		btnExit7.addActionListener (onClick7);

		panel7a.add (lblTitle7);
		panel7b.add(txtInput7);
		panel7b.add(btnEnter7);
		panel7b.add(btnExit7);
		main7.add(panel7a);
		main7.add(panel7b);

		frame7.getContentPane ().add(main7);
		frame7.setSize(400,450);
		frame7.setVisible (false);
		
		//***************************************************
		// Frame 8 - EditContacts
		JPanel panel8a = new JPanel (new GridLayout(1,1));
		JPanel panel8b = new JPanel (new GridLayout(3,3));
		JPanel panel8c = new JPanel (new GridLayout(1,1));
		JPanel panel8d = new JPanel (new GridLayout(1,1));
		JPanel panel8e = new JPanel (new GridLayout(1,3));
		
		JPanel main8 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle8 = new JLabel ("Edit Contacts:", JLabel.CENTER);
		lblTitle8.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnAdd8 = new JButton ("Add Contacts");
		btnMod8 = new JButton ("Modify Contacts");
		btnExit8 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler4 onClick8 = new ButtonHandler4 ();
		btnAdd8.addActionListener (onClick8);
		btnMod8.addActionListener (onClick8);
		btnExit8.addActionListener (onClick8);

		panel8a.add (lblTitle8);
		panel8b.add(btnAdd8);
		panel8b.add(btnMod8);
		panel8b.add(btnExit8);
		main8.add(panel8a);
		main8.add(panel8b);

		frame8.getContentPane ().add(main8);
		frame8.setSize(400,450);
		frame8.setVisible (false);
		
		//***************************************************
		// Frame 9 - Add Contacts

		JPanel panel9a = new JPanel (new GridLayout (2, 4, 2, 5)); // you must have at least 1 panel for your object
		JPanel panel9b = new JPanel (new GridLayout (2, 4, 2, 5)); // you must have at least 1 panel for your object
		JPanel panel9c = new JPanel (new GridLayout (2, 1, 2, 5)); // you must have at least 1 panel for your object
		JPanel main9 = new JPanel(new GridLayout (5, 1));
		JLabel lblTitle9 = new JLabel ("Add Contact:", JLabel.CENTER);
		lblTitle9.setFont (new Font ("Serif", Font.BOLD, 24));
		
		JButton btnEnter9 = new JButton ("Enter"); //text on button
		JButton btnExit9 = new JButton ("Back"); //text on button
		JLabel lbl9a = new JLabel ("First Name"); // text on label
		JLabel lbl9b = new JLabel ("Last Name"); // text on label
		JLabel lbl9c = new JLabel ("Phone Number"); // text on label
		JLabel lbl9d = new JLabel ("Address"); // text on label
		JLabel lbl9e = new JLabel ("City"); // text on label
		JLabel lbl9f = new JLabel ("State"); // text on label
		JLabel lbl9g = new JLabel (""); // text on label
		JLabel lbl9h = new JLabel (""); // text on label
		JLabel lbl9j = new JLabel (""); // text on label
		JLabel lbl9i = new JLabel (""); // text on label
		

		txtInput9a = new JTextField ("");
		txtInput9b = new JTextField ("");
		txtInput9c = new JTextField ("");
		txtInput9d = new JTextField ("");
		txtInput9e = new JTextField ("");
		txtInput9f = new JTextField ("");
		
		//ButtonHandler3 for frame 3
		ButtonHandler8 onClick9 = new ButtonHandler8 ();
		btnExit9.addActionListener (onClick9);
		btnEnter9.addActionListener (onClick9);


		main9.add (lblTitle9); // add the button to the panel frame first
		panel9a.add(lbl9a); // add label to panel
		panel9a.add (txtInput9a); // add the button to the panel frame first
		panel9a.add(lbl9b); // add label to panel
		panel9a.add (txtInput9b); // add the button to the panel frame first
		panel9a.add(lbl9c); // add label to panel
		panel9a.add (txtInput9c); // add the button to the panel frame first
		panel9a.add(lbl9d); // add label to panel
		panel9a.add (txtInput9d); // add the button to the panel frame first
		
		panel9b.add(lbl9e); // add label to panel
		panel9b.add (txtInput9e); // add the button to the panel frame first
		panel9b.add(lbl9f); // add label to panel
		panel9b.add (txtInput9f); // add the button to the panel frame first
		panel9b.add(lbl9g); // add label to panel
		panel9b.add(lbl9h); // add label to panel
		panel9b.add(lbl9j); // add label to panel
		panel9b.add(lbl9i); // add label to panel
		panel9c.add (btnEnter9); // add the button to the panel frame first
		panel9c.add (btnExit9); // add the button to the panel frame first
		
		main9.add(panel9a);
		main9.add(panel9b);
		main9.add(panel9c);

		frame9.add (main9);
		frame9.setSize (800,500);
		frame9.setVisible(false);
		
		//***************************************************
		// Frame 10 - Modify Contacts screen
		JPanel panel10a = new JPanel (new GridLayout(1,1));
		JPanel panel10b = new JPanel (new GridLayout(3,3));
		JPanel panel10c = new JPanel (new GridLayout(1,1));
		JPanel panel10d = new JPanel (new GridLayout(1,1));
		JPanel panel10e = new JPanel (new GridLayout(1,3));
		
		JPanel main10 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle10 = new JLabel ("Edit Contacts:", JLabel.CENTER);
		lblTitle10.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnEdit10 = new JButton ("Edit Contacts");
		btnDelete10 = new JButton ("Delete Contacts");
		btnExit10 = new JButton ("Back");

		//ButtonHandler3 for frame 3
		ButtonHandler9 onClick10 = new ButtonHandler9 ();
		
		btnEdit10.addActionListener (onClick10);
		btnDelete10.addActionListener (onClick10);
		btnExit10.addActionListener (onClick10);

		panel10a.add (lblTitle10);
		panel10b.add(btnEdit10);
		panel10b.add(btnDelete10);
		panel10b.add(btnExit10);
		main10.add(panel10a);
		main10.add(panel10b);

		frame10.getContentPane ().add(main10);
		frame10.setSize(400,450);
		frame10.setVisible (false);
	

	//***************************************************
	// Frame 10 - Modify Contacts screen
	
	//***************************************************
	// Frame 12 - Delete Contact screen
	JPanel panel12a = new JPanel (new GridLayout(1,1));
	JPanel panel12b = new JPanel (new GridLayout(3,2));
	JPanel panel12c = new JPanel (new GridLayout(1,1));
	JPanel panel12d = new JPanel (new GridLayout(1,1));
	JPanel panel12e = new JPanel (new GridLayout(1,3));
	
	JPanel main12 = new JPanel (new GridLayout (5, 1));
	JLabel lblTitle12 = new JLabel ("Delete Contacts By Name:", JLabel.CENTER);
	lblTitle12.setFont (new Font ("Serif", Font.BOLD, 24));	
	txtInput12 = new JTextField ("");
	txtInput12.setHorizontalAlignment (JTextField.CENTER);
	btnDelete12 = new JButton ("Delete");
	btnExit12 = new JButton ("Back");

	//ButtonHandler3 for frame 3
	ButtonHandler12 onClick12 = new ButtonHandler12 ();
	btnDelete12.addActionListener (onClick12);
	btnExit12.addActionListener (onClick12);

	panel12a.add (lblTitle12);
	panel12b.add(txtInput12);
	panel12b.add(btnDelete12);
	panel12b.add(btnExit12);
	main12.add(panel12a);
	main12.add(panel12b);

	frame12.getContentPane ().add(main12);
	frame12.setSize(400,450);
	frame12.setVisible (false);
	}
	//****************************************************************************
	// ButtonHandler1
	public static class ButtonHandler1 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text1 = e.getActionCommand();
			if (text1.equals("Enter"))
			{
				frame1.setVisible (false);
				frame2.setVisible (true);
			}
			else if (text1.equals ("Exit"))
			{
				frame1.setVisible (false);
			}
		}
	}

	//***********************************************************************************
	// ButtonHandler2
	public static class ButtonHandler2 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text2 = e.getActionCommand();
			if (text2.equals("View All Contacts"))
			{
				frame2.setVisible(false);
				frame3.setVisible(true);
			}
			else if (text2.equals("Edit Contacts"))
			{
				frame2.setVisible(false);
				frame8.setVisible(true);
			}
			else if (text2.equals ("Exit"))
			{
				frame2.setVisible (false);
			}
		}
	}
	//***********************************************************************************
	// ButtonHandler3
	public static class ButtonHandler3 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("View Contacts"))
			{
				frame3.setVisible(false);
				frame4.setVisible(true);
			}
			else if (text3.equals("Search Contacts"))
			{
				frame3.setVisible(false);
				frame5.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame3.setVisible (false);
				frame2.setVisible (true);
			}
		}
	}	
	// ButtonHandler4 - for edit screen section
	public static class ButtonHandler4 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Add Contacts"))
			{
				frame8.setVisible(false);
				frame9.setVisible(true);
			}
			else if (text3.equals("Modify Contacts"))
			{
				frame8.setVisible(false);
				frame10.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame3.setVisible (false);
				frame2.setVisible (true);
			}
		}
	}
	// ButtonHandler5 - for search screen section
	public static class ButtonHandler5 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Name"))
			{
				frame5.setVisible(false);
				frame6.setVisible(true);
			}
			else if (text3.equals("Number"))
			{
				frame5.setVisible(false);
				frame7.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame5.setVisible (false);
				frame3.setVisible (true);
			}
		}
	}	
	// ButtonHandler6 - for search name
	public static class ButtonHandler6 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Enter"))
			{
				System.out.println(txtInput9a.getText());
			}
			else if (text3.equals ("Back"))
			{
				frame6.setVisible (false);
				frame5.setVisible (true);
			}
		}
	}
	// ButtonHandler7 - for search number
	public static class ButtonHandler7 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Enter"))
			{
				//frame.setVisible(false);
				//frame6.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame7.setVisible (false);
				frame5.setVisible (true);
			}
		}
	}	
	// ButtonHandler8 - for add number
	public static class ButtonHandler8 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Enter")){					
				try {
					if (txtInput9a.getText().equals("") |txtInput9b.getText().equals("") | txtInput9c.getText().equals("") | txtInput9d.getText().equals("") |txtInput9e.getText().equals("") |txtInput9f.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Error: Missing Information!");
					}
					else if (txtInput9c.getText().length() < 7){
						JOptionPane.showMessageDialog(null,"Error: Invalid Phone Number!");						
					}
					else{
						String key = txtInput9a.getText();
						String insert = txtInput9b.getText().concat("," + txtInput9c.getText()).concat("," + txtInput9d.getText()).concat("," + txtInput9e.getText()).concat("," + txtInput9f.getText());
						phonebook.put(key, insert);
						System.out.println(key.concat("," + phonebook.get(key)));
						JOptionPane.showMessageDialog(null,"Contact Successfully added");
					}
				}
				catch (Exception error){
					JOptionPane.showMessageDialog(null,"Error: Something Went Wrong...");
					
				}
				//frame.setVisible(false);
				//frame6.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame10.setVisible (false);
				frame8.setVisible (true);
			}
		}
	}
	// ButtonHandler 9 - for edit screen section
	public static class ButtonHandler9 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Edit Contacts"))
			{
				frame10.setVisible(false);
				frame11.setVisible(true);
			}
			else if (text3.equals("Delete Contacts"))
			{
				frame10.setVisible(false);
				frame12.setVisible(true);
			}
			else if (text3.equals ("Back"))
			{
				frame10.setVisible (false);
				frame8.setVisible (true);
			}
		}
	}
	// ButtonHandler12 - for delete
	public static class ButtonHandler12 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			if (text3.equals("Delete"))
			{
				String key = txtInput12.getText();
				boolean find = phonebook.contains(key);
				System.out.println(find);
				try{
					if (key.equals("")){
						JOptionPane.showMessageDialog(null,"Error: Invalid name!");
					}
					
					else if (find == true){
						System.out.println(key);
						phonebook.delete(key);
						JOptionPane.showMessageDialog(null,"Contact Successfully Deleted");
					}
					else{
						JOptionPane.showMessageDialog(null,"Error: Contact Does Not Exist!");						
					}
				}
				catch (Exception error){
					JOptionPane.showMessageDialog(null,"Error: Something went wrong...");					
				}
			}
			else if (text3.equals ("Back"))
			{
				frame12.setVisible (false);
				frame5.setVisible (true);
			}
		}
	}
	
	// ButtonHandler13 - for display all
	public static class ButtonHandler13 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text = e.getActionCommand();
			if (text.equals ("Back"))
			{
				frame12.setVisible (false);
				frame5.setVisible (true);
			}
			else{
				int count = -1;
				if (text.equals("A")) {	count = 0;} else if (text.equals("B")) {count = 1;} 
				if (text.equals("C")) {count = 2;} else if (text.equals("D")) {count = 3;} 
				if (text.equals("E")) {count = 4;} else if (text.equals("F")) {count = 5;}
				if (text.equals("G")) { count = 6; } else if (text.equals("H")) {count = 7;} 
				if (text.equals("I")) { count = 8;} else if (text.equals("J")) {count = 9;}
				else if (text.equals("K")) { count = 10;} else if (text.equals("L")) {count = 11;} 
				else if (text.equals("M")) { count = 12; } else if (text.equals("N")) { count = 13;} 
				else if (text.equals("O")) { count = 14; } else if (text.equals("P")) {count = 15;} 
				else if (text.equals("Q")) { count = 16;} else if (text.equals("R")) {count = 17;} 
				else if (text.equals("S")) {count = 18;} else if (text.equals("T")) {count = 19;} 
				else if (text.equals("U")) {count = 20;} else if (text.equals("V")) {count = 21;} 
				else if (text.equals("W")) {count = 22;} else if (text.equals("X")) {count = 23;} 
				else if (text.equals("Y")) {count = 24;} else if (text.equals("Z")) {count = 25;}
				int x = 10 * count, label = 0;
				for (int i = x; i < x + 10; i++) {
					names[label].setText(info[i][0]);
					phone[label].setText(info[i][1]);
					addresses[label].setText(info[i][2]);
					label ++;
				}
			}
		}
	}
	
	public static void main (String [] args) throws FileNotFoundException
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run ()
			{
				try{
				///	makeContact.contactToFile();
					info = new String [261][3];
					File nameFile = new File("data/contact.txt");
					Scanner hf = new Scanner(nameFile);
					String toaddd = hf.nextLine();
					//for (int i = 0; i < nameFile.length(); i++) {
					int i = 0;
						while (hf.hasNext()) {
							String toadds = hf.nextLine();
							String[] n = toadds.split(",");
							String first = n[1].split(" ")[0];
							String last = n[1].split(" ")[1];
							info [i][0] = n[0];
							info [i][1] = n[1];
							info [i] [2] = n[2] + ", " + n[3]+ ", " + n[4];
							String insert = last.concat("," + n[2]).concat("," + n[3]).concat("," + n[4]);
							phonebook.put(first, insert);
							i ++;
						}
					//}
					guiApp();
				}
				catch (FileNotFoundException e){
					
				}
			}
		}
		);
	}
}
