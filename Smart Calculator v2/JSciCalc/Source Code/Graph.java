package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Graph extends Frame implements WindowListener,MouseMotionListener,
ActionListener{
	static int xy=1;
	 Stack str=new Stack(100);
	 String ori=new String();
	 Stack stry=new Stack(100);
	 String oriy=new String();
	 int size,x=0,y=0;
	 static int con=1;
	 static TextField t1=new TextField(150);
	 Label l1=new Label("Coordinates :");
	 Label l2=new Label("Scale :");
	 Label l3=new Label("New Curve y=f(x)");
	 Label l4=new Label("New Curve x=g(y)");
	 Label l5=new Label("New Parametric Curve");
	 Label l6=new Label("f(x)=");
	 Label l7=new Label("g(y)=");
	 Label l8=new Label("f(t)=");
	 Label l9=new Label("g(t)=");
	 Label l10=new Label("x=f(t) , y=g(t)");
	 TextField t3=new TextField(200);
	 TextField t4=new TextField(200);
	 TextField t5=new TextField(200);
	 TextField t6=new TextField(200);
	 TextField res=new TextField(200);
	 List scale=new List();
	 static float sc=50;
	 static double r=0.1;
	Button b1=new Button("Draw Graph");	
	Button b2=new Button("Draw Graph");	
	Button b3=new Button("Draw Graph");	
	Button help=new Button("Help");	
	 Graph(){
	 	super("Graph");
	 	setBackground(Color.cyan);
	 	System.out.println("Hellooooooo");
	 	size=700;
	 	setLayout(null);
	 	setSize(size+270,size+10);
		setVisible(true);
		
		addWindowListener(this);
		scale.addActionListener(this);
		t1.setEditable(false);
		res.setEditable(false);
		
		
		scale.add("0.01:1");
		scale.add("0.05:1");
		scale.add("0.1:1");
		scale.add("0.5:1");
		scale.add("1:1");
		scale.add("5:1");
		scale.add("10:1");
		scale.add("50:1");
		scale.add("100:1");
		scale.add("500:1");
		scale.add("1000:1");
		scale.select(4);
		add(t1);
		add(l1);
		add(l2);
		add(l3);
		add(l5);
		add(l4);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(help);
		
		add(scale);
				
		add(b1);
		add(b2);
		add(b3);
		add(res);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		help.addActionListener(this);
		
		l1.setBounds(705,30,150,30);
		t1.setBounds(705,65,250,30);
		l2.setBounds(705,100,80,40);
		scale.setBounds(790,110,110,80);
		
		l3.setBounds(705,220,250,30);
		l6.setBounds(705,250,50,30);
		t3.setBounds(755,250,200,30);
		b1.setBounds(755,290,150,30);
		
		l4.setBounds(705,330,250,30);
		l7.setBounds(705,360,50,30);
		t4.setBounds(755,360,200,30);
		b2.setBounds(755,400,150,30);
		
		l5.setBounds(705,440,250,30);
		l10.setBounds(705,460,250,30);
		l8.setBounds(705,490,50,30);
		t5.setBounds(755,490,200,30);
		l9.setBounds(705,520,50,30);
		t6.setBounds(755,520,200,30);
		b3.setBounds(755,560,150,30);
		
		res.setBounds(715,600,240,50);
		help.setBounds(755,660,150,40);
		
		t1.setFont(new Font("Courier",1,18));
		l1.setFont(new Font("Courier",1,18));
		l2.setFont(new Font("Courier",1,18));
		l3.setFont(new Font("Courier",1,16));
		l4.setFont(new Font("Courier",1,16));
		l5.setFont(new Font("Courier",1,16));
		l6.setFont(new Font("Courier",1,16));
		l7.setFont(new Font("Courier",1,16));
		l8.setFont(new Font("Courier",1,16));
		l9.setFont(new Font("Courier",1,16));
		l10.setFont(new Font("Courier",1,16));
		t3.setFont(new Font("Courier",1,16));
		t4.setFont(new Font("Courier",1,16));
		t5.setFont(new Font("Courier",1,16));
		t6.setFont(new Font("Courier",1,16));
		b1.setFont(new Font("Courier",1,16));
		b2.setFont(new Font("Courier",1,16));
		b3.setFont(new Font("Courier",1,16));
		scale.setFont(new Font("Courier",1,16));
		res.setFont(new Font("Courier",1,16));
		help.setFont(new Font("Courier",1,16));
		
		setBackground(Color.cyan);
		l1.setBackground(Color.cyan);
		l2.setBackground(Color.cyan);
		l3.setBackground(Color.cyan);
		l4.setBackground(Color.cyan);
		l5.setBackground(Color.cyan);
		l6.setBackground(Color.cyan);
		l7.setBackground(Color.cyan);
		l8.setBackground(Color.cyan);
		l9.setBackground(Color.cyan);
		l10.setBackground(Color.cyan);
		
		scale.setBackground(Color.cyan);
		
		addMouseMotionListener(this);
		validate();
		
}
	 
	public void paint(Graphics h){
			
				h.clearRect(0,0,900,700);
				h.setClip(0,0,700,700);
				Dimension d=new Dimension();
				d=getSize();
				h.setColor(Color.black);
				h.drawLine(0,size/2,size,size/2);
				h.drawLine(size/2,0,size/2,size);
				h.setColor(Color.orange);
				for(int q=50;q<size/2;q+=50){
				
					h.drawLine(size/2+q,0,size/2+q,size);
					h.drawLine(size/2-q,0,size/2-q,size);
					h.drawLine(0,size/2+q,size,size/2+q);
					h.drawLine(0,size/2-q,size,size/2-q);
				}
				h.setColor(Color.black);
				
		
				int a=size/2,b=size/2,aa,bb;
				float y=0,x=0;
				float s=(float)(350/sc);
				
		if(ori.length()>=1||oriy.length()>=1){
		if(xy==1)
				{
					if(con==1){
				for(x=0;x<=s;x+=r)
				{
				
				y=eval(ori,x);
				System.out.println(x+" "+y);
					aa=(int)(size/2+sc*x);
				bb=(int)(size/2-sc*y);
					h.drawLine(a,b,(int)(aa),(int)(bb));
				a=(int)(aa);
				b=(int)(bb);
				
				}
				
				a=size/2;
				b=size/2;
				
				
					for(x=0;x>=-s;x-=r){
					System.out.println("hello");
					y=eval(ori,x);
					System.out.println(x+"    "+y);
					h.drawLine(a,b,(int)(size/2+sc*x),(int)(size/2-(sc*y)));
					a=(int)(size/2+sc*x);
					b=(int)(size/2-(sc*y));				
				}
				}
				}
	
		else if (xy==2){
				if(con==1){
				for(y=0;y<=s;y+=r)
				{
				aa=(int)(size/2+sc*x);
				bb=(int)(size/2-sc*y);
				x=evaly(oriy,y);
				
					h.drawLine(a,b,aa,bb);
				a=aa;
				b=bb;
				
				}
				
				a=size/2;
				b=size/2;
				
					for(y=0;y>=-s;y-=r){
					System.out.println("hello");
					x=evaly(oriy,y);
					System.out.println(x+"    "+y);
					h.drawLine(a,b,(int)(size/2+sc*x),(int)(size/2-(sc*y)));
					a=(int)(size/2+sc*x);
					b=(int)(size/2-(sc*y));				
				}
				}
		}
				
		else if (xy==3){
				
				if(con==1){
					for(float t=0;t<s;t+=r){
					y=evalt(ori,t);
					x=evalt(oriy,t);
					h.drawLine((int)(size/2+sc*x),(int)(size/2-(sc*y)),(int)(size/2+sc*x),(int)(size/2-(sc*y)));
					a=size/2+(int)(sc*x);
				b=size/2-(int)(sc*y);	
					
				} 
					for(float t=0;t>-s;t-=r){
					System.out.println("hello");
					x=evalt(oriy,t);
					y=evalt(ori,t);
					
					h.drawLine((int)(size/2+sc*x),(int)(size/2-(sc*y)),(int)(size/2+sc*x),(int)(size/2-(sc*y)));
					a=size/2+(int)(sc*x);
				b=size/2-(int)(sc*y);	
				}
				}
				
				
				
				
	}}
	validate();
	}
	
	
	public void actionPerformed(ActionEvent a){
				
				if(scale.getSelectedItem()=="0.01:1")
				{	sc=(float)(50/0.01);
					r=0.00005;
				}
				if(scale.getSelectedItem()=="0.05:1")
				{	sc=(float)(50/0.05);
					r=0.00025;
				}
				if(scale.getSelectedItem()=="0.1:1")
				{	sc=(float)(50/0.1);
					r=0.0005;
				}
				if(scale.getSelectedItem()=="0.5:1")
				{	sc=(float)(50/0.5);
					r=0.0025;
				}
				if(scale.getSelectedItem()=="1:1")
				{	sc=(float)(50/1);
					r=0.005;
				}
				if(scale.getSelectedItem()=="5:1")
				{	sc=(float)(50/5);
					r=0.025;
				}
				if(scale.getSelectedItem()=="10:1")
				{	sc=(float)(50/10);
					r=0.05;
				}
				if(scale.getSelectedItem()=="50:1")
				{	sc=(float)(50/50);
					r=0.25;
				}
				if(scale.getSelectedItem()=="100:1")
				{	sc=(float)0.5;
					r=0.5;
				}
				if(scale.getSelectedItem()=="500:1")
				{	sc=(float)0.1;
					r=2.5;
				}
				if(scale.getSelectedItem()=="1000:1")
				{	sc=(float)0.05;
					r=5;
				}
				
				if(a.getSource()==help)
					new GraphHelp();
				if(a.getSource()==b1){
				xy=1;
				Stack infix=new Stack(200);
				Stack post=new Stack(200);
				String s=new String();

				s=t3.getText();
				if(s.length()<1)
				{
					res.setText("Insufficient data");
					con=2;
				}
				else {
				con=1;
				res.setText("");
				System.out.println(str+"  ");
				s=s.replaceAll("arcsin","%");
				s=s.replaceAll("arccos",";");
				s=s.replaceAll("arctan",":");
				s=s.replaceAll("sinh","q");
				s=s.replaceAll("cosh","w");
				s=s.replaceAll("tanh","z");
				s=s.replaceAll("sin","#");
				s=s.replaceAll("cos","~");
				s=s.replaceAll("tan","@");
				s=s.replaceAll("log","&");

				s=s.replaceAll("ln","`");
				s=s.replaceAll("sqrt","n");
				s=s.replaceAll("cbrt","o");
				s=s.replaceAll("sqre","s");
				s=s.replaceAll("cube","c");
				s=s.replaceAll("e","2.718281828459045");
				s=s.replaceAll("pi","3.141592653589793");


				for(int i=0;i<s.length();i++)
					infix.push(s.charAt(i));
				post=infix.infipost(post);
				str=infix;
				ori=s;
				}
				}
				if(a.getSource()==b2){
				xy=2;
				Stack infix=new Stack(200);
				Stack post=new Stack(200);
				String s=new String();

				s=t4.getText();
				if(s.length()<1)
				{
					res.setText("Insufficient data");
					con=2;
				}
				else {
						con=1;
						res.setText("");
				System.out.println(str+"  ");
				s=s.replaceAll("arcsin","%");
				s=s.replaceAll("arccos",";");
				s=s.replaceAll("arctan",":");
				s=s.replaceAll("sinh","q");
				s=s.replaceAll("cosh","w");
				s=s.replaceAll("tanh","z");
				s=s.replaceAll("sin","#");
				s=s.replaceAll("cos","~");
				s=s.replaceAll("tan","@");
				s=s.replaceAll("log","&");

				s=s.replaceAll("ln","`");
				s=s.replaceAll("sqrt","n");
				s=s.replaceAll("cbrt","o");
				s=s.replaceAll("sqre","s");
				s=s.replaceAll("cube","c");
				s=s.replaceAll("e","2.718281828459045");
				s=s.replaceAll("pi","3.141592653589793");


				for(int i=0;i<s.length();i++)
					infix.push(s.charAt(i));
				post=infix.infipost(post);
				stry=infix;
				oriy=s;
				}}
				if(a.getSource()==b3){
					xy=3;
					Stack infix1=new Stack(200);
					Stack post1=new Stack(200);
					Stack infix2=new Stack(200);
					Stack post2=new Stack(200);
					String s1=new String();
					String s2=new String();
					s1=t5.getText();
					s2=t6.getText();
					if(s1.length()<1||s2.length()<1)
					{
						res.setText("Insufficient data");
						con=2;
					}
					else {
						con=1;
					res.setText("");
				s1=s1.replaceAll("arcsin","%");
				s1=s1.replaceAll("arccos",";");
				s1=s1.replaceAll("arctan",":");
				s1=s1.replaceAll("sinh","q");
				s1=s1.replaceAll("cosh","w");
				s1=s1.replaceAll("tanh","z");
				s1=s1.replaceAll("sin","#");
				s1=s1.replaceAll("cos","~");
				s1=s1.replaceAll("tan","@");
				s1=s1.replaceAll("log","&");

				s1=s1.replaceAll("ln","`");
				s1=s1.replaceAll("sqrt","n");
				s1=s1.replaceAll("cbrt","o");
				s1=s1.replaceAll("sqre","s");
				s1=s1.replaceAll("cube","c");
				s1=s1.replaceAll("e","2.718281828459045");
				s1=s1.replaceAll("pi","3.141592653589793");
				
				
				s2=s2.replaceAll("arcsin","%");
				s2=s2.replaceAll("arccos",";");
				s2=s2.replaceAll("arctan",":");
				s1=s1.replaceAll("sinh","q");
				s1=s1.replaceAll("cosh","w");
				s1=s1.replaceAll("tanh","z");
				s2=s2.replaceAll("sin","#");
				s2=s2.replaceAll("cos","~");
				s2=s2.replaceAll("tan","@");
				s2=s2.replaceAll("log","&");

				s2=s2.replaceAll("ln","`");
				s2=s2.replaceAll("sqrt","n");
				s2=s2.replaceAll("cbrt","o");
				s2=s2.replaceAll("sqre","s");
				s2=s2.replaceAll("cube","c");
				s2=s2.replaceAll("e","2.718281828459045");
				s2=s2.replaceAll("pi","3.141592653589793");
				
				for(int i=0;i<s1.length();i++)
					infix1.push(s1.charAt(i));
				post1=infix1.infipost(post1);
				for(int i=0;i<s2.length();i++)
					infix2.push(s2.charAt(i));
				post2=infix2.infipost(post2);
				str=infix1;
				stry=infix2;
				ori=s1;
				oriy=s2;
				}
		}
		repaint();
		validate();
	}	public void windowActivated(WindowEvent ae){
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
		setVisible(false);
		//System.exit(0);
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
	public void mouseMoved(MouseEvent me){
		float x=me.getX();
		float y=me.getY();
		if(x>700||y>700)
		t1.setText(" ");
		else{
		x=(x-350)/sc;
		y=(350-y)/sc;
		t1.setText(x+" : "+y);
		}
	}
	public void mouseDragged(MouseEvent me){
		t1.setText("dragging");
	}
	float eval(String str, float d){
	
	
	String s=new String();
	int j=0;

	
	s=str.replaceAll("x","(0"+Float.toString(d)+")");
	Stack infix=new Stack(200);
	for(int l=0;l<s.length();l++)
	{
			
		infix.push(s.charAt(l));
	}
	Stack post=new Stack(200);
	post=infix.infipost(post);
	d=(float)post.posteval();
	System.out.println(d);
	j++;
	return d;
}
float evaly(String str, float d){
	
	
	String s=new String();
	int j=0;

	
	s=str.replaceAll("y","(0"+Float.toString(d)+")");
	Stack infix=new Stack(200);
	for(int l=0;l<s.length();l++)
	{
			
		infix.push(s.charAt(l));
	}
	Stack post=new Stack(200);
	post=infix.infipost(post);
	d=(float)post.posteval();
	System.out.println(d);
	j++;
	return d;
}
float evalt(String str, float d){
	
	
	String s=new String();
	int j=0;

	
	s=str.replaceAll("t","(0"+Float.toString(d)+")");
	Stack infix=new Stack(200);
	for(int l=0;l<s.length();l++)
	{
			
		infix.push(s.charAt(l));
	}
	Stack post=new Stack(200);
	post=infix.infipost(post);
	d=(float)post.posteval();
	System.out.println(d);
	j++;
	return d;
}
	public static void main(String a[]){
	
		new Graph();
	}
}