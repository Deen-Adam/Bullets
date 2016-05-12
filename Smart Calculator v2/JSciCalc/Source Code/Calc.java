/**Source Code for main Calculator Screen*/
 package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calc extends JFrame 
implements ActionListener,ItemListener{

	public String ans=new String();
	public static int deg=1;
	public static int hlp=1;
	public static int cond=1;
	int x=0,y=0;

	CheckboxGroup cg=new CheckboxGroup();
	Checkbox c1=new Checkbox("Radians", cg, true);
	Checkbox c2=new Checkbox("Degrees", cg, false);
	
	
	
	
	JButton b0=new JButton("0");		JButton b1=new JButton("1");
	JButton b2=new JButton("2");		JButton b3=new JButton("3");
	JButton b4=new JButton("4");		JButton b5=new JButton("5");
	JButton b6=new JButton("6");		JButton b7=new JButton("7");
	JButton b8=new JButton("8");		JButton b9=new JButton("9");
	JButton b10=new JButton("=");	   JButton b11=new JButton("+");
	JButton b12=new JButton("-");		JButton b13=new JButton("*");
	JButton b14=new JButton("/");		JButton b15=new JButton(".");
	JButton b16=new JButton("+/-");	  JButton b17=new JButton("^");
	JButton b18=new JButton("(");		JButton b19=new JButton(")");
	JButton b20=new JButton("sin");	   JButton b21=new JButton("cos");
	JButton b22=new JButton("tan");   JButton b23=new JButton("arcsin");
	JButton b24=new JButton("arccos");JButton b25=new JButton("arctan");
	JButton b26=new JButton("ln");		JButton b27=new JButton("log");
	JButton b28=new JButton("n!");		JButton b29=new JButton("sqrt");
	JButton b30=new JButton("cbrt");   JButton b31=new JButton("sqre");
	JButton b32=new JButton("cube");  JButton b33=new JButton("e^n");
	JButton b34=new JButton("10^n"); JButton b35=new JButton("sinh");   
	JButton b36=new JButton("cosh");  JButton b37=new JButton("tanh");	
	
	JButton AC=new JButton("AC");        JButton C=new JButton("DEL");
	JButton RES=new JButton("ANS");	   JButton M=new JButton("M");
	JButton CM=new JButton("CM");		JButton RM=new JButton("RM");
	JButton G=new JButton("Graph");	   JButton X=new JButton("X");
	JButton be=new JButton("e");		  JButton bpi=new JButton("pi");


	public static JTextArea t1=new JTextArea("",1,400);
	public static JTextArea t2=new JTextArea("",1,400);
	static JTextArea t3=new JTextArea("",0,30);
	
	MenuBar menuBar=new MenuBar();
	Menu File=new Menu("File");
	Menu Extras=new Menu("Extras");
	Menu Help=new Menu("Help");
	MenuItem Newtab=new MenuItem("New Tab");
	MenuItem Exit=new MenuItem("Exit");
	MenuItem Graph=new MenuItem("Graph");
	MenuItem Deter=new MenuItem("Determinant of a Matrix");
	MenuItem Inv=new MenuItem("Inverse of a Matrix");
	MenuItem Linear=new MenuItem("Solution of linear equations");
	MenuItem help=new MenuItem("Help");
	MenuItem About=new MenuItem("About JSciCalc");
	CheckboxMenuItem Real=new CheckboxMenuItem("Real Time Help",true);
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////


	Calc(){

		super("JSciCalc");
		int w=90,h=50,l=7*w-5,b=70,x=w*7,y=11*h;
		setSize(x+5,y+2*h+10);
		setLayout(null);
		
		
		setMenuBar(menuBar);
		menuBar.add(File);
		menuBar.add(Extras);
		menuBar.add(Help);
		File.add(Exit);
		Extras.add(Graph);
		Extras.add(Deter);
		Extras.add(Inv);
		Extras.add(Linear);
		Help.add(help);
		Help.add(About);
		Help.add(Real);


		b0.addActionListener(this);	b1.addActionListener(this);
		b2.addActionListener(this);	b3.addActionListener(this);
		b4.addActionListener(this);	b5.addActionListener(this);
		b6.addActionListener(this);	b7.addActionListener(this);
		b8.addActionListener(this);	b9.addActionListener(this);
		b10.addActionListener(this);b11.addActionListener(this);
		b12.addActionListener(this);b13.addActionListener(this);
		b14.addActionListener(this);b15.addActionListener(this);
		b16.addActionListener(this);b17.addActionListener(this);
		b18.addActionListener(this);b19.addActionListener(this);
		b20.addActionListener(this);b21.addActionListener(this);
		b22.addActionListener(this);b23.addActionListener(this);
		b24.addActionListener(this);b25.addActionListener(this);
		b26.addActionListener(this);b27.addActionListener(this);
		b28.addActionListener(this);b29.addActionListener(this);
		b30.addActionListener(this);b31.addActionListener(this);
		b32.addActionListener(this);be.addActionListener(this);
		bpi.addActionListener(this);
		AC.addActionListener(this);	C.addActionListener(this);
		RES.addActionListener(this);CM.addActionListener(this);
		G.addActionListener(this);	b34.addActionListener(this);
		X.addActionListener(this);	RM.addActionListener(this);
		M.addActionListener(this);	b33.addActionListener(this);
		b35.addActionListener(this);
		b36.addActionListener(this);	b37.addActionListener(this);
		
		Graph.addActionListener(this);
		Linear.addActionListener(this);
		Exit.addActionListener(this);
		Inv.addActionListener(this);
		Deter.addActionListener(this);
		About.addActionListener(this);
		Help.addActionListener(this);
		
		c1.addItemListener(this);	
		c2.addItemListener(this);
		Real.addItemListener(this);
		
		
		addWindowListener(new D());

		b0.addMouseListener(new C());b1.addMouseListener(new C());
		b2.addMouseListener(new C());b3.addMouseListener(new C());
		b4.addMouseListener(new C());b5.addMouseListener(new C());
		b6.addMouseListener(new C());b7.addMouseListener(new C());
		b8.addMouseListener(new C());b9.addMouseListener(new C());
		b10.addMouseListener(new C());b11.addMouseListener(new C());
		b12.addMouseListener(new C());b13.addMouseListener(new C());
		b14.addMouseListener(new C());b15.addMouseListener(new C());
		b16.addMouseListener(new C());b17.addMouseListener(new C());
		b18.addMouseListener(new C());b19.addMouseListener(new C());
		b20.addMouseListener(new C());b21.addMouseListener(new C());
		b22.addMouseListener(new C());b23.addMouseListener(new C());
		b24.addMouseListener(new C());b25.addMouseListener(new C());
		b26.addMouseListener(new C());b27.addMouseListener(new C());
		b28.addMouseListener(new C());b29.addMouseListener(new C());
		b30.addMouseListener(new C());b31.addMouseListener(new C());
		b32.addMouseListener(new C());b33.addMouseListener(new C());
		b34.addMouseListener(new C());C.addMouseListener(new C());
		M.addMouseListener(new C());AC.addMouseListener(new C());
		RM.addMouseListener(new C());CM.addMouseListener(new C());
		X.addMouseListener(new C());CM.addMouseListener(new C());
		G.addMouseListener(new C());CM.addMouseListener(new C());
		RES.addMouseListener(new C());
		t1.addMouseListener(new C());
		t2.addMouseListener(new C());
		c1.addMouseListener(new C());
		c2.addMouseListener(new C());
		be.addMouseListener(new C());
		bpi.addMouseListener(new C());
		b35.addMouseListener(new C());
		b36.addMouseListener(new C());
		b37.addMouseListener(new C());
		
		add(b0);	add(t1);		add(t2);	add(b1);
		add(b2);	add(b3);		add(b4);	add(b5);
		add(b6);	add(b7);		add(b8);	add(b9);
		add(b10);	add(b11);		add(b12);	add(b13);
		add(b14);	add(b15);		add(b16);	add(b17);
		add(b18);	add(b19);		add(b20);	add(b21);
		add(b22);	add(b23);		add(b24);	add(b25);
		add(b26);	add(b27);		add(AC);	add(b28);
		add(b29);	add(b30);		add(b31);	add(b32);
		add(RES);	add(C);		add(CM);	add(RM);
		add(G);		add(X);		add(M);		add(b33);
		add(b34);	add(be);	add(bpi); 	add(b37);
		add(b35); add(b36);
		
		//////////////////
		
		
		/////////////////

		add(c1);
		add(c2);
			
		
		add(t3);

		JScrollPane j1=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane j2=new JScrollPane(t2,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane j3=new JScrollPane(t3,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Container c=getContentPane();
		c.add(j1);
		c.add(j2);
		c.add(j3);
		t1.setFont(new Font("Times New Roman",0,30));		t2.setFont(new Font("Times New Roman",0,30));
		b0.setFont(new Font("Times New Roman",0,20));		b1.setFont(new Font("Times New Roman",0,20));
		b2.setFont(new Font("Times New Roman",0,20));		b3.setFont(new Font("Times New Roman",0,20));
		b4.setFont(new Font("Times New Roman",0,20));		b5.setFont(new Font("Times New Roman",0,20));
		b6.setFont(new Font("Times New Roman",0,20));		b7.setFont(new Font("Times New Roman",0,20));
		b8.setFont(new Font("Times New Roman",0,20));		b9.setFont(new Font("Times New Roman",0,20));
		b10.setFont(new Font("Times New Roman",0,20));		b11.setFont(new Font("Times New Roman",0,20));
		b12.setFont(new Font("Times New Roman",0,20));		b13.setFont(new Font("Times New Roman",0,20));
		b14.setFont(new Font("Times New Roman",0,20));		b15.setFont(new Font("Times New Roman",1,20));
		b16.setFont(new Font("Times New Roman",0,20));		b17.setFont(new Font("Times New Roman",0,20));
		b18.setFont(new Font("Times New Roman",0,20));		b19.setFont(new Font("Times New Roman",0,20));
		b20.setFont(new Font("Times New Roman",0,20));		b21.setFont(new Font("Times New Roman",0,20));
		b22.setFont(new Font("Times New Roman",0,20));		b23.setFont(new Font("Times New Roman",0,20));
		b24.setFont(new Font("Times New Roman",0,20));		b25.setFont(new Font("Times New Roman",0,20));
		b26.setFont(new Font("Times New Roman",0,20));		b27.setFont(new Font("Times New Roman",0,20));
		b28.setFont(new Font("Times New Roman",0,20));		RES.setFont(new Font("Times New Roman",1,20));
		M.setFont(new Font("Times New Roman",1,20));		CM.setFont(new Font("Times New Roman",1,20));
		RM.setFont(new Font("Times New Roman",1,20));		C.setFont(new Font("Times New Roman",1,20));
		AC.setFont(new Font("Times New Roman",1,20));		G.setFont(new Font("Times New Roman",0,20));
		X.setFont(new Font("Times New Roman",0,20));		c1.setFont(new Font("Times New Roman",1,18));
		c2.setFont(new Font("Times New Roman",1,18));		
		b34.setFont(new Font("Times New Roman",0,20));
		b33.setFont(new Font("Times New Roman",0,20));		b29.setFont(new Font("Times New Roman",0,20));
		b30.setFont(new Font("Times New Roman",0,20));		b31.setFont(new Font("Times New Roman",0,20));
		b32.setFont(new Font("Times New Roman",0,20));		t3.setFont(new Font("Times New Roman",0,20));
		b30.setFont(new Font("Times New Roman",0,20));		b37.setFont(new Font("Times New Roman",0,20));
		b35.setFont(new Font("Times New Roman",0,20));		b36.setFont(new Font("Times New Roman",0,20));
		be.setFont(new Font("Times New Roman",0,20));		bpi.setFont(new Font("Times New Roman",0,20));
		
		File.setFont(new Font("Times New Roman",0,15));		menuBar.setFont(new Font("Times New Roman",0,15));
		Help.setFont(new Font("Times New Roman",0,15));		Extras.setFont(new Font("Times New Roman",0,15));
		
		
		
		t3.setLineWrap(true);
		t3.setWrapStyleWord(true);
		t3.setEditable(false);
		t2.setEditable(false);
		
		// Adding and setting the locations of the components on the screen //
		b0.setBounds(0,y,w,h);		b15.setBounds(w,y,w,h);		b10.setBounds(2*w,y,w,h);		b11.setBounds(3*w,y,w,h);
		bpi.setBounds(4*w,y,w,h);		b29.setBounds(5*w,y,w,h);		M.setBounds(6*w,y,w,h);
		y=y-h;

		b1.setBounds(0,y,w,h);		b2.setBounds(w,y,w,h);		b3.setBounds(2*w,y,w,h);		b12.setBounds(3*w,y,w,h);
		be.setBounds(4*w,y,w,h);		b30.setBounds(5*w,y,w,h);		RM.setBounds(6*w,y,w,h);
		y=y-h;

		b4.setBounds(0,y,w,h);		b5.setBounds(w,y,w,h);		b6.setBounds(2*w,y,w,h);		b13.setBounds(3*w,y,w,h);
		b17.setBounds(4*w,y,w,h);		b31.setBounds(5*w,y,w,h);		CM.setBounds(6*w,y,w,h);
		y=y-h;

		b7.setBounds(0,y,w,h);		b8.setBounds(w,y,w,h);		b9.setBounds(2*w,y,w,h);		b14.setBounds(3*w,y,w,h);
		b28.setBounds(4*w,y,w,h);		b32.setBounds(5*w,y,w,h);		RES.setBounds(6*w,y,w,h);
		y=y-h;

		b33.setBounds(0,y,w,h);		b34.setBounds(w,y,w,h);		b26.setBounds(2*w,y,w,h);		b27.setBounds(3*w,y,w,h);
		b18.setBounds(4*w,y,w,h);		b19.setBounds(5*w,y,w,h);		C.setBounds(6*w,y,w,h);
		y=y-h;

		b20.setBounds(0,y,w,h);		b21.setBounds(w,y,w,h);		b22.setBounds(2*w,y,w,h);		b23.setBounds(3*w,y,w,h);
		b24.setBounds(4*w,y,w,h);		b25.setBounds(5*w,y,w,h);		AC.setBounds(6*w,y,w,h);
		y=y-h;


		b35.setBounds(0,y,w,h);		b36.setBounds(w,y,w,h);		b37.setBounds(2*w,y,w,h);
		y=y-h;
		
		c1.setBounds(0,y,w,h-10);		c2.setBounds(w,y,w,h-10);		j3.setBounds(3*w,y,4*w,2*h);
		y=y-h;
		
		j1.setBounds(2,10,l,b);		j2.setBounds(2,110,l,b);
		
		t1.setBackground(Color.cyan);		t2.setBackground(Color.cyan);		t3.setBackground(Color.white);
		c1.setForeground(Color.white);		c2.setForeground(Color.white);		
//////////////////////////////////////////////////////		
		
//////////////////////////////////////////////////////////		
		c.setBackground(Color.black);
		setVisible(true);
		validate();
	}
	// Event handling for buttons and menu items //
	public void actionPerformed (ActionEvent a)
	{


			if(a.getSource()==b0)
				t1.append("0");
			if(a.getSource()==b1)
				t1.append("1");
			if(a.getSource()==b2)
				t1.append("2");
			if(a.getSource()==b3)
				t1.append("3");
			if(a.getSource()==b4)
				t1.append("4");
			if(a.getSource()==b5)
				t1.append("5");
			if(a.getSource()==b6)
				t1.append("6");
			if(a.getSource()==b7)
				t1.append("7");
			if(a.getSource()==b8)
				t1.append("8");
			if(a.getSource()==b9)
				t1.append("9");
			if(a.getSource()==b11)
				t1.append("+");
			if(a.getSource()==b12)
				t1.append("-");
			if(a.getSource()==b13)
				t1.append("*");
			if(a.getSource()==b14)
				t1.append("/");
			if(a.getSource()==b15)
				t1.append(".");
			if(a.getSource()==b16)
				t1.append("");
			if(a.getSource()==b17)
				t1.append("^");
			if(a.getSource()==b18)
				t1.append("(");
			if(a.getSource()==b19)
				t1.append(")");
			if(a.getSource()==b20)
				t1.append("sin");
			if(a.getSource()==b21)
				t1.append("cos");
			if(a.getSource()==b22)
				t1.append("tan");
			if(a.getSource()==b23)
				t1.append("arcsin");
			if(a.getSource()==b24)
				t1.append("arccos");
			if(a.getSource()==b25)
				t1.append("arctan");
			if(a.getSource()==b26)
				t1.append("ln");
			if(a.getSource()==b27)
				t1.append("log");
			if(a.getSource()==b28)
				t1.append("!");
			if(a.getSource()==b29)
				t1.append("sqrt");
			if(a.getSource()==b30)
				t1.append("cbrt");
			if(a.getSource()==b31)
				t1.append("sqre");
			if(a.getSource()==b32)
				t1.append("cube");
			if(a.getSource()==b34)
			{
				t1.append("10^");
			}
			if(a.getSource()==b33)
			{
				t1.append("e^");
			}
			if(a.getSource()==b35)
				t1.append("sinh");	
			if(a.getSource()==b36)
				t1.append("cosh");	
			if(a.getSource()==b37)
				t1.append("tanh");	
			
			if(a.getSource()==X)
				t1.append("x");
			if(a.getSource()==be)
				t1.append("e");
			if(a.getSource()==bpi)
				t1.append("pi");
			if(a.getSource()==M)
			{
				ans=t2.getText();

			}
			if(a.getSource()==CM)
			{
				ans="";

			}
			if(a.getSource()==RM)
			{
				t1.append(ans);
			}

			if(a.getSource()==RES)
			{
				try{
				Stack infix=new Stack(200);
				Stack post=new Stack(200);
				String str=new String();

				str=t1.getText();
				System.out.println(str+"  ");
				str=str.replaceAll("arcsin","%");
				str=str.replaceAll("arccos",";");
				str=str.replaceAll("arctan",":");
				str=str.replaceAll("sinh","q");
				str=str.replaceAll("cosh","w");
				str=str.replaceAll("tanh","z");
				str=str.replaceAll("sin","#");
				str=str.replaceAll("cos","~");
				str=str.replaceAll("tan","@");
				str=str.replaceAll("log","&");

				str=str.replaceAll("ln","`");
				str=str.replaceAll("sqrt","n");
				str=str.replaceAll("cbrt","o");
				str=str.replaceAll("sqre","s");
				str=str.replaceAll("cube","c");
				str=str.replaceAll("e","2.718281828459045");
				str=str.replaceAll("pi","3.141592653589793");


				for(int i=0;i<str.length();i++)
					infix.push(str.charAt(i));
				//infix.show();
				post=infix.infipost(post);
				//post.show();
				double d=post.posteval();
				t1.setText(d+"");
				}catch(Exception e){
					t2.setText("Error");
				}
			}
			if(a.getSource()==b10)
			{
				Stack infix=new Stack(200);
				Stack post=new Stack(200);
				String str=new String();

				try{
				str=t1.getText();
				System.out.println(str+"  ");
				str=str.replaceAll("arcsin","%");
				str=str.replaceAll("arccos",";");
				str=str.replaceAll("arctan",":");
				str=str.replaceAll("sinh","q");
				str=str.replaceAll("cosh","w");
				str=str.replaceAll("tanh","z");
				str=str.replaceAll("sin","#");
				str=str.replaceAll("cos","~");
				str=str.replaceAll("tan","@");
				str=str.replaceAll("log","&");

				str=str.replaceAll("ln","`");
				str=str.replaceAll("sqrt","n");
				str=str.replaceAll("cbrt","o");
				str=str.replaceAll("sqre","s");
				str=str.replaceAll("cube","c");
				str=str.replaceAll("e","2.718281828459045");
				str=str.replaceAll("pi","3.141592653589793");

				for(int i=0;i<str.length();i++)
					infix.push(str.charAt(i));
				//infix.show();
				post=infix.infipost(post);
				//post.show();
				if(cond==2){
				t2.setText("Error");
				System.out.println(cond);
				}
				else{
				double d=post.posteval();
				t2.setText(d+"");
				System.out.println(cond);
				}
				}catch(Exception e){
					t2.setText("Error");
				}
			}
			
			if(a.getSource()==C)
			{
				String s=new String(t1.getText());
				char o[]=new char[(s.length())-1];
				for(int i=0;i<s.length()-1;i++)
				o[i]=s.charAt(i);
				String s1=new String(o);
				t1.setText(s1);
			}
			if(a.getSource()==AC)
				{
					t1.setText("");
					t2.setText("");
				}
				if(a.getSource()==Graph){
					new Graph();
				}
				if(a.getSource()==Help){
					new Help();
				}
				if(a.getSource()==Exit){
					System.exit(0);
				}
				if(a.getSource()==About){
					new About();
				}
				if(a.getSource()==Deter){
					new Det();
				}
				if(a.getSource()==Linear){
					new Linear();
				}
				if(a.getSource()==Inv){
					new Inverse();
				}

	}


	// Event handling for Checkbox items //
	public void itemStateChanged(ItemEvent ie){

		if(ie.getSource()==c1){
			deg=1;

		}
		if(ie.getSource()==c2){

			deg=2;
		}
		if(ie.getSource()==Real){
			t3.setText("");
			if(hlp==0)
				hlp=1;
			else if(hlp==1)
				hlp=0;
		}
	validate();
			
	}
	

	// Class for mouse handling, used for real-time help//
	class C extends MouseAdapter{
		public void mouseEntered(MouseEvent a){
		if(hlp==1){		
		if(a.getSource()==b0)
			t3.setText("Displays the number 0");
		if(a.getSource()==b1)
			t3.setText("Displays the number 1");
		if(a.getSource()==b2)
			t3.setText("Displays the number 2");
		if(a.getSource()==b3)
			t3.setText("Displays the number 3");
		if(a.getSource()==b4)
			t3.setText("Displays the number 4");
		if(a.getSource()==b5)
			t3.setText("Displays the number 5");
		if(a.getSource()==b6)
			t3.setText("Displays the number 6");
		if(a.getSource()==b7)
			t3.setText("Displays the number 7");
		if(a.getSource()==b8)
			t3.setText("Displays the number 8");
		if(a.getSource()==b9)
			t3.setText("Displays the number 9");
		if(a.getSource()==b10)
			t3.setText("Computes the result of the expression");
		if(a.getSource()==b11)
			t3.setText("Displays the operator + for addition");
		if(a.getSource()==b12)
			t3.setText("Displays the operator - for subtraction");
		if(a.getSource()==b13)
			t3.setText("Displays the operator * for multiplication");
		if(a.getSource()==b14)
			t3.setText("Displays the operator / for division");
		if(a.getSource()==b15)
			t3.setText("Displays the operator . for decimal point");
		if(a.getSource()==b17)
			t3.setText("Displays the operator ^ for computing a number raised to the power");
		if(a.getSource()==b18)
			t3.setText("Displays the opening bracket (");
		if(a.getSource()==b19)
			t3.setText("Displays the closing bracket )");
		if(a.getSource()==b20)
			t3.setText("Displays sin to compute trigonometric sine ");
		if(a.getSource()==b21)
			t3.setText("Displays cos to compute trigonometric cosine ");
		if(a.getSource()==b22)
			t3.setText("Displays tan to compute trigonometric tangent ");
		if(a.getSource()==b23)
			t3.setText("Displays arcsin to compute trigonometric arc sine ");
		if(a.getSource()==b24)
			t3.setText("Displays arccos to compute trigonometric arc cosine ");
		if(a.getSource()==b25)
			t3.setText("Displays arctan to display trigonometric arc tangent ");
		if(a.getSource()==b27)
			t3.setText("Displays log to compute logarithm to the base 10 ");
		if(a.getSource()==b26)
			t3.setText("Displays ln to compute natural logarithm to the base e ");
		if(a.getSource()==b28)
			t3.setText("Displays operator ! to compute the factorial of a number ");
		if(a.getSource()==b29)
			t3.setText("Displays sqrt to compute the square root of a number ");
		if(a.getSource()==b30)
			t3.setText("Displays cbrt to compute the cube root of a number ");
		if(a.getSource()==b31)
			t3.setText("Displays sqre to compute the square of a number ");
		if(a.getSource()==b32)
			t3.setText("Displays cube to compute the cube of a number  ");
		if(a.getSource()==b33)
			t3.setText("Displays e^ to compute e raised to the power ");
		if(a.getSource()==b34)
			t3.setText("Displays 10^ to compute 10 raised to the power ");
		if(a.getSource()==b35)
			t3.setText("Displays sinh to compute hyperbolic sine ");
		if(a.getSource()==b36)
			t3.setText("Displays cosh to compute hyperbolic cosine ");
		if(a.getSource()==b37)
			t3.setText("Displays tanh to compute hyperbolic tangent ");
		if(a.getSource()==AC)
			t3.setText("Clears both the input and output display ");
		if(a.getSource()==C)
			t3.setText("Deletes a digit in the input display ");
		if(a.getSource()==RES)
			t3.setText("Computes the result and diplays it in the input display ");
		if(a.getSource()==G)
			t3.setText("Draws the graph of the expression in another window ");
		if(a.getSource()==X)
			t3.setText("Displays the letter x for use as a variable in an expression ");
		if(a.getSource()==M)
			t3.setText("Computes the expression and adds it to memory ");
		if(a.getSource()==RM)
			t3.setText("Retrieves the number stored in memory and displays it in input display ");
		if(a.getSource()==CM)
			t3.setText("Clears the memory ");
		if(a.getSource()==c1)
			t3.setText("Computes trigonometric functions in radians");
		if(a.getSource()==c2)
			t3.setText("Computes trigonometric functions in degrees");
		if(a.getSource()==be)
			t3.setText("Displays the constant number e");
		if(a.getSource()==bpi)
			t3.setText("Displays the constant number pi");
		if(a.getSource()==t1)
			t3.setText("Input display ");
		if(a.getSource()==t2)
			t3.setText("Output display ");
		}
	}
		
	}

	// Class for window handling events //
	class D extends WindowAdapter{
	public void windowActivated(WindowEvent ae){
		System.out.println("activated");
	}
	public void windowClosed(WindowEvent ae){
		System.out.println("closed");
	}
	public void windowDeactivated(WindowEvent ae){
		System.out.println("deactivated");
	}
	public void windowClosing(WindowEvent ae){
		System.out.println("closing");
		System.exit(0);
	}
	public void windowDeiconified(WindowEvent ae){
		System.out.println("deicionified");
	}
	public void windowIconified(WindowEvent ae){
		System.out.println("iconified");
	}
	public void windowOpened(WindowEvent ae){
		System.out.println("opened");
	}

	}
	public static void main(String args[])
	{
		new Calc();

	}
}
 