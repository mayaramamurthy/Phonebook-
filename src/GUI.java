import java.awt.BorderLayout;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GUI 
{
//	declare class level objects and variables
	static JButton btnSubmit1, btnView2, btnAdd2, btnExit1, btnExit2, btnShow3, btnExit3, btnSearch3, btnNumber5, btnExit5, btnName5, btnExit6, btnEnter6,btnExit7, btnEnter7, btnAdd8, btnMod8, btnExit8 ,btnEdit10, btnDelete10, btnExit10, btnDelete12, btnExit12;
	static JLabel lblTitle1, lblIntro1, lblInfo1, lblBlank1a, lblBlank1b, lblBlank2a, lblBlank2b, lblBlank2c, lblBlank2d, lblTitle2, lblTitle3, lblInfo3,lblDisplay6a, lblDisplay6b, lblDisplay6c, lblDisplay6d, lblDisplay7a, lblDisplay7b, lblDisplay7c, lblDisplay7d;
	static JLabel n1, p1, a1, n2, p2, a2, n3, p3, a3, n4, p4 , a4, n5, p5,a5, n6, p6, a6, n7, p7,a7, n8, p8,  a8,n9, p9,a9, n10,  p10,a10;
	static JLabel names [] = new JLabel [10], addresses[] = new JLabel [10], phone [] = new JLabel [10];
	static JTextField txtInput1, txtInput6, txtInput7, txtInput9a, txtInput9b, txtInput9c, txtInput9d, txtInput9e, txtInput9f,txtInput11a, txtInput11b, txtInput11c, txtInput11d, txtInput11e, txtInput11f, txtInput12, getContact11;
	static JFrame frame1 = new JFrame ("Phonebook+ Intro"),frame2 = new JFrame ("Navigation"),frame3 = new JFrame ("View Contacts"),frame4 = new JFrame ("View All Contacts"), frame5 = new JFrame ("Search Screen"),frame6 = new JFrame ("Search by Name"), frame7 = new JFrame ("Search by Number"),frame8 = new JFrame ("Edit Contacts"),frame9 = new JFrame ("Add Contacts"), frame10 = new JFrame ("Modify Contacts"),frame11 = new JFrame ("Edit Contacts"),frame12 = new JFrame ("Delete Contacts");
	
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
		JPanel panel1f = new JPanel ();
		JPanel main1 = new JPanel ();
	
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
		
		JPanel main3 = new JPanel (new GridLayout (5, 1));
		lblTitle3 = new JLabel ("Browse Contacts:", JLabel.CENTER);
		lblTitle3.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnShow3 = new JButton ("Display Contacts");
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
		JPanel panel4m = new JPanel (new GridLayout(0,6));
		JPanel panel4n = new JPanel (new GridLayout(3,1));
		
		JPanel main4 = new JPanel (new GridLayout(8,1));
		
		JButton A = new JButton ("A"),B = new JButton ("B"), C = new JButton ("C"), D = new JButton ("D"),E = new JButton ("E"),F = new JButton ("F"),G = new JButton ("G"),H = new JButton ("H"),I = new JButton ("I"),J = new JButton ("J"),K = new JButton ("K"),L = new JButton ("L"),M = new JButton ("M"),N = new JButton ("N");
		JButton O = new JButton ("O"),P = new JButton ("P"),Q = new JButton ("Q"),R = new JButton ("R"),S = new JButton ("S"),T = new JButton ("T"),U = new JButton ("U"),V = new JButton ("V"),W = new JButton ("W"),X = new JButton ("X"),Y = new JButton ("Y"),Z = new JButton ("Z");
		JButton exit4 = new JButton ("Back");
		
		ButtonHandler13 onClick4 = new ButtonHandler13 ();
		A.addActionListener (onClick4); B.addActionListener (onClick4); C.addActionListener (onClick4);
		D.addActionListener (onClick4); E.addActionListener (onClick4); F.addActionListener (onClick4);
		G.addActionListener (onClick4); H.addActionListener (onClick4); I.addActionListener (onClick4);
		J.addActionListener (onClick4); K.addActionListener (onClick4); L.addActionListener (onClick4);
		M.addActionListener (onClick4); N.addActionListener (onClick4); O.addActionListener (onClick4);
		P.addActionListener (onClick4); Q.addActionListener (onClick4); R.addActionListener (onClick4);
		S.addActionListener (onClick4); T.addActionListener (onClick4); U.addActionListener (onClick4);
		V.addActionListener (onClick4); W.addActionListener (onClick4); X.addActionListener (onClick4);
		Y.addActionListener (onClick4); Z.addActionListener (onClick4); exit4.addActionListener (onClick4); 
		
		JLabel name4a = new JLabel ("Name"); name4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel numb4a = new JLabel ("Number"); numb4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel addr4a = new JLabel ("Address"); addr4a.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel name4b = new JLabel ("Name"); name4b.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel numb4b = new JLabel ("Number"); numb4b.setFont (new Font ("Serif", Font.BOLD, 15));
		JLabel addr4b = new JLabel ("Address"); addr4b.setFont (new Font ("Serif", Font.BOLD, 15));

		JLabel b3 = new JLabel (""); JLabel b4 = new JLabel ("");
		JLabel b5 = new JLabel (""); JLabel b6 = new JLabel ("");
		
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
		panel4m.add(b3);panel4m.add(b4);panel4m.add(exit4);
		
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
		panel4n.add(b5);		panel4n.add(b6);
		panel4n.add(panel4m);
		main4.add(panelM4a); main4.add(panelM4b); main4.add(panelM4c); main4.add(panelM4d); main4.add(panelM4e); main4.add(panel4n);
		
		frame4.getContentPane ().add(main4);
		frame4.setSize(1500,700);
		frame4.setVisible (false);
		
		//***************************************************
		// Frame 5 - Search Screen
		JPanel panel5a = new JPanel (new GridLayout(1,1));
		JPanel panel5b = new JPanel (new GridLayout(3,3));
		
		JPanel main5 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle5 = new JLabel ("Search Contacts By:", JLabel.CENTER);
		lblTitle5.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnName5 = new JButton ("Name");
		btnNumber5 = new JButton ("Number");
		btnExit5 = new JButton ("Back");

		//ButtonHandler3 for frame 5
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
		JPanel panel6c = new JPanel (new GridLayout(4,1));
		
		JPanel main6 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle6 = new JLabel ("Search Contacts By Name:", JLabel.CENTER);
		lblTitle6.setFont (new Font ("Serif", Font.BOLD, 24));	
		txtInput6 = new JTextField ("");
		
		lblDisplay6a = new JLabel ("");	lblDisplay6a.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay6a.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay6b = new JLabel (""); lblDisplay6b.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay6b.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay6c = new JLabel (""); lblDisplay6c.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay6c.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay6d = new JLabel ("");	lblDisplay6d.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay6d.setHorizontalAlignment(JLabel.CENTER);

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
		panel6c.add(lblDisplay6a);
		panel6c.add(lblDisplay6b);
		panel6c.add(lblDisplay6c);
		panel6c.add(lblDisplay6d);
		main6.add(panel6a);
		main6.add(panel6b);
		main6.add(panel6c);

		frame6.getContentPane ().add(main6);
		frame6.setSize(400,500);
		frame6.setVisible (false);
		
		//***************************************************
		// Frame 7 - Search by Number
		JPanel panel7a = new JPanel (new GridLayout(1,1));
		JPanel panel7b = new JPanel (new GridLayout(3,2));
		JPanel panel7c = new JPanel (new GridLayout(4,1));
		
		JPanel main7 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle7 = new JLabel ("Search Contacts By Number:", JLabel.CENTER);
		lblTitle7.setFont (new Font ("Serif", Font.BOLD, 24));	
		txtInput7 = new JTextField ("");
		txtInput7.setHorizontalAlignment (JTextField.CENTER);
		btnEnter7 = new JButton ("Enter");
		btnExit7 = new JButton ("Back");

		lblDisplay7a = new JLabel ("");	lblDisplay7a.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay7a.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay7b = new JLabel (""); lblDisplay7b.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay7b.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay7c = new JLabel (""); lblDisplay7c.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay7c.setHorizontalAlignment(JLabel.CENTER);
		lblDisplay7d = new JLabel ("");	lblDisplay7d.setFont (new Font ("Serif", Font.BOLD, 17)); lblDisplay7d.setHorizontalAlignment(JLabel.CENTER);
		
		//ButtonHandler3 for frame 3
		ButtonHandler7 onClick7 = new ButtonHandler7 ();
		btnEnter7.addActionListener (onClick7);
		btnExit7.addActionListener (onClick7);

		panel7a.add (lblTitle7);
		panel7b.add(txtInput7);
		panel7b.add(btnEnter7);
		panel7b.add(btnExit7);
		panel7c.add(lblDisplay7a);
		panel7c.add(lblDisplay7b);
		panel7c.add(lblDisplay7c);
		panel7c.add(lblDisplay7d);
		main7.add(panel7a);
		main7.add(panel7b);
		main7.add(panel7c);

		frame7.getContentPane ().add(main7);
		frame7.setSize(400,450);
		frame7.setVisible (false);
		
		//***************************************************
		// Frame 8 - Edit Contacts
		JPanel panel8a = new JPanel (new GridLayout(1,1));
		JPanel panel8b = new JPanel (new GridLayout(3,3));
		
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
		
		JPanel main10 = new JPanel (new GridLayout (5, 1));
		JLabel lblTitle10 = new JLabel ("Edit Contacts:", JLabel.CENTER);
		lblTitle10.setFont (new Font ("Serif", Font.BOLD, 24));	
		btnEdit10 = new JButton ("Edit Contacts");
		btnDelete10 = new JButton ("Delete Contacts");
		btnExit10 = new JButton ("Back");

		//ButtonHandler9 for frame `10
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
	// Frame 11 - Modify Contacts screen
		
		JPanel panel11a = new JPanel (new GridLayout (2, 4, 2, 5)); 
		JPanel panel11b = new JPanel (new GridLayout (2, 4, 2, 5));  
		JPanel panel11c = new JPanel (new GridLayout (2, 1, 2, 5));    
		JPanel main11 = new JPanel(new GridLayout (4, 1));
		JLabel lblTitle11 = new JLabel ("Enter Contact To Modify", JLabel.CENTER);
		lblTitle11.setFont (new Font ("Serif", Font.BOLD, 24));

		JButton btnExit11 = new JButton ("Back");
		JButton btnMod11 = new JButton ("Make Changes");
		JButton btnEnter11 = new JButton ("Find Contact");
		
		getContact11 = new JTextField ("");
		
		//ButtonHandler11 for frame 11
		ButtonHandler11 onClick11 = new ButtonHandler11 ();		
		btnMod11.addActionListener (onClick11);
		btnExit11.addActionListener (onClick11);
		btnEnter11.addActionListener (onClick11);
		
		JLabel lbl11a = new JLabel ("First Name"); // text on label
		JLabel lbl11b = new JLabel ("Last Name"); // text on label
		JLabel lbl11c = new JLabel ("Phone Number"); // text on label
		JLabel lbl11d = new JLabel ("Address"); // text on label
		JLabel lbl11e = new JLabel ("City"); // text on label
		JLabel lbl11f = new JLabel ("State"); // text on label
		JLabel lbl11g = new JLabel (""); // text on label
		JLabel lbl11h = new JLabel (""); // text on label
		JLabel lbl11j = new JLabel (""); // text on label
		JLabel lbl11i = new JLabel (""); // text on label
		

		txtInput11a = new JTextField ("");
		txtInput11b = new JTextField ("");
		txtInput11c = new JTextField ("");
		txtInput11d = new JTextField ("");
		txtInput11e = new JTextField ("");
		txtInput11f = new JTextField ("");
		
		main11.add (lblTitle11); // add the button to the panel frame first
		panel11a.add(lbl11a); // add label to panel
		panel11a.add (txtInput11a); // add the button to the panel frame first
		panel11a.add(lbl11b); // add label to panel
		panel11a.add (txtInput11b); // add the button to the panel frame first
		panel11a.add(lbl11c); // add label to panel
		panel11a.add (txtInput11c); // add the button to the panel frame first
		panel11a.add(lbl11d); // add label to panel
		panel11a.add (txtInput11d); // add the button to the panel frame first
		
		panel11b.add(lbl11e); // add label to panel
		panel11b.add (txtInput11e); // add the button to the panel frame first
		panel11b.add(lbl11f); // add label to panel
		panel11b.add (txtInput11f); // add the button to the panel frame first
		panel11b.add(lbl11g); // add label to panel
		panel11b.add(lbl11h); // add label to panel
		panel11b.add(lbl11j); // add label to panel
		panel11b.add(lbl11i); // add label to panel
		panel11c.add (btnMod11); // add the button to the panel frame first
		panel11c.add (btnExit11); // add the button to the panel frame first
		
		main11.add(panel11a);
		main11.add(panel11b);
		main11.add(panel11c);
		
		// sets frame size
		frame11.getContentPane ().add(main11);
		frame11.setSize(800,500);
		frame11.setVisible (false);
	
	
	//***************************************************
	// Frame 12 - Delete Contact screen
	JPanel panel12a = new JPanel (new GridLayout(1,1));
	JPanel panel12b = new JPanel (new GridLayout(3,2));
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
			if (text3.equals("Display Contacts"))
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
				String key = txtInput6.getText();
				try{
					String[] info = phonebook.get(key).split(",");
					lblDisplay6a.setText(key + " " + info[0]);
					lblDisplay6b.setText(info[1] );
					lblDisplay6c.setText(info[2]);
					lblDisplay6d.setText(info[3] + ", " + info[4]);
				}
				catch (NullPointerException err){
					JOptionPane.showMessageDialog(null,"Error: Contact " + key + " does not exist");
				}
			}
			else if (text3.equals ("Back"))
			{
				frame6.setVisible (false);
				frame5.setVisible (true);
				lblDisplay6a.setText("");	lblDisplay6b.setText("");	lblDisplay6c.setText("");	lblDisplay6d.setText("");
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
				String key = txtInput7.getText();
				try {
					if (key.length() > 7){
						String[] info = phonebook.findNum(key).split(",");
						lblDisplay7a.setText(info[0]);
						lblDisplay7b.setText(info[1] );
						lblDisplay7c.setText(info[2]);
						lblDisplay7d.setText(info[3] + ", " + info[4]);
					}
					else {
						JOptionPane.showMessageDialog(null,"Error: Invalid Number");
					}
				}
				catch (NullPointerException err){
					JOptionPane.showMessageDialog(null,"Error: Contact " + key + " does not exist");					
				}
				catch (ArrayIndexOutOfBoundsException err){
					JOptionPane.showMessageDialog(null,"Error: Contact " + key + " does not exist");					
				}
			}
			else if (text3.equals ("Back"))
			{
				lblDisplay7a.setText("");	lblDisplay7b.setText("");	lblDisplay7c.setText("");	lblDisplay7d.setText("");
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
				frame8.setVisible (false);
				frame2.setVisible (true);
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
				frame2.setVisible (true);
			}
		}
	}
	// ButtonHandler 11 - for modify screen section
	public static class ButtonHandler11 implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String text3 = e.getActionCommand();
			String key = txtInput11a.getText();
			if (text3.equals("Make Changes")) // makes the given changes
			{
				try {
					if (txtInput11a.getText().equals("") |txtInput11b.getText().equals("") | txtInput11c.getText().equals("") | txtInput11d.getText().equals("") |txtInput11e.getText().equals("") |txtInput11f.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Error: Missing Information!");
					}
					else if (txtInput11c.getText().length() < 7){
						JOptionPane.showMessageDialog(null,"Error: Invalid Phone Number!");						
					}
					else if (phonebook.contains(key)){
						String insert = txtInput11b.getText().concat("," + txtInput11c.getText()).concat("," + txtInput11d.getText()).concat("," + txtInput11e.getText()).concat("," + txtInput11f.getText());
						phonebook.Modify(key, insert);
						JOptionPane.showMessageDialog(null,"Contact Successfully Modified");
					}
					else if (phonebook.contains(key) == false){JOptionPane.showMessageDialog(null,"Contact Does Not Exist");}
				}
				catch (Exception error){
					JOptionPane.showMessageDialog(null,"Error: Something Went Wrong...");
					
				}
			}
			// allows you to go back to the prior screen
			else if (text3.equals ("Back"))
			{
				frame11.setVisible (false);
				frame10.setVisible (true);
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
				try{
					if (key.equals("")){
						JOptionPane.showMessageDialog(null,"Error: Invalid name!");
					}
					
					else if (find == true){
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
				frame10.setVisible (true);
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
				frame4.setVisible (false);
				frame3.setVisible (true);
			}
			else{
				ArrayList find = phonebook.findAll(text);
				String [] info = new String [5];
				for (int i = 0; i < 10; i ++){
					names[i].setText("");
					phone[i].setText("");
					addresses[i].setText("");
				}
				for (int i = 0; i < find.size(); i++) {
					info = ((String) find.get(i)).split(",");
					names[i].setText(info[0]);
					phone[i].setText(info[1]);
					addresses[i].setText(info[2] + ", " + info[3] + ", " +info[4]);
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
							String first = n[0].split(" ")[0];
							String last = n[0].split(" ")[1];
							info [i][0] = n[0];
							info [i][1] = n[1];
							info [i] [2] = n[2] + ", " + n[3]+ ", " + n[4];
							String insert = last.concat("," + n[1]).concat("," + n[2]).concat("," + n[3]).concat("," + n[4]);
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
