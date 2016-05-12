package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Det extends JFrame 
implements WindowListener,ActionListener,ItemListener
{
	////////////////////////////////////////////////
	JButton b1=new JButton("Determinant");
	JButton b2=new JButton("Solution of linear equations");
	JButton b3=new JButton("Calculate");
	JButton b4=new JButton("Calculate");
	JButton b5=new JButton("Calculate");
	JButton home=new JButton("Home");
	////////////////////////////////////////////////
	JTextField t1=new JTextField("",100);
	JTextField t2=new JTextField("",100);
	JTextField t3=new JTextField("",100);
	JTextField t4=new JTextField("",100);
	JTextField t5=new JTextField("",100);
	JTextField t6=new JTextField("",100);
	JTextField t7=new JTextField("",100);
	JTextField t8=new JTextField("",100);
	JTextField t9=new JTextField("",100);
	JTextField t10=new JTextField("",100);
	JTextField t11=new JTextField("",100);
	JTextField t12=new JTextField("",100);
	JTextField t13=new JTextField("",100);
	JTextField t14=new JTextField("",100);
	JTextField t15=new JTextField("",100);
	JTextField t16=new JTextField("",100);
	JTextField res=new JTextField("",100);
	////////////////////////////////////////////////
	JLabel l1=new JLabel("Choose the degree of the matrix:");
	JLabel l2=new JLabel("Enter the elements:");
	JLabel l3=new JLabel("Determinant:");
	JLabel l00=new JLabel("A [0][0]:");
	JLabel l01=new JLabel("A [0][1]:");
	JLabel l02=new JLabel("A [0][2]:");
	JLabel l03=new JLabel("A [0][3]:");
	JLabel l10=new JLabel("A [1][0]:");
	JLabel l11=new JLabel("A [1][1]:");
	JLabel l12=new JLabel("A [1][2]:");
	JLabel l13=new JLabel("A [1][3]:");
	JLabel l20=new JLabel("A [2][0]:");
	JLabel l21=new JLabel("A [2][1]:");
	JLabel l22=new JLabel("A [2][2]:");
	JLabel l23=new JLabel("A [2][3]:");
	JLabel l30=new JLabel("A [3][0]:");
	JLabel l31=new JLabel("A [3][1]:");
	JLabel l32=new JLabel("A [3][2]:");
	JLabel l33=new JLabel("A [3][3]:");
	JLabel l40=new JLabel("A [4][0]:");
	JLabel l41=new JLabel("A [4][1]:");
	JLabel l42=new JLabel("A [4][2]:");
	JLabel l43=new JLabel("A [4][3]:");
	
	JLabel ll=new JLabel("To calculate the Determinant of a Square Matrix");
	//////////////////////////////////////////////////
	CheckboxGroup c=new CheckboxGroup();
	Checkbox c1=new Checkbox("2x2",c,false);
	Checkbox c2=new Checkbox("3x3",c,false);
	Checkbox c3=new Checkbox("4x4",c,false);
	/////////////////////////////////////////////////
	static int d=0;	
	int w=60,h=40,l=120,b=40;
		
	///////////////////////////////////////////////////////////////// constructor
	Det(){
		super("Determinant of a Matrix");
		setSize(800,500);
		setLayout(null);
		getContentPane().setBackground(Color.cyan);
			add(c1);
			add(c2);
			add(c3);
			add(l1);
			add(ll);
			ll.setBounds(100,50,400,40);
			l1.setBounds(100,100,300,40);
			c1.setBounds(100,150,50,40);
			c2.setBounds(100,200,50,40);
			c3.setBounds(100,250,50,40);
			c1.setFont(new Font("Arial",1,16));
			c2.setFont(new Font("Arial",1,16));
			c3.setFont(new Font("Arial",1,16));
			l1.setFont(new Font("Arial",1,16));
			ll.setFont(new Font("Arial",1,16));

		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b2.addActionListener(this);
		home.addActionListener(this);
		res.setEditable(false);
		addWindowListener(this);
		setVisible(true);
		
	}
	////////////////////////////////////////////////////////////////// button events
	public void actionPerformed(ActionEvent i){
		if(i.getSource()==b3){
			try{
			float a[][]=new float[2][2];
			String tt1=t1.getText();
			String tt2=t2.getText();
			String tt3=t3.getText();
			String tt4=t4.getText();
			Float f1=new Float(tt1);
			Float f2=new Float(tt2);
			Float f3=new Float(tt3);
			Float f4=new Float(tt4);
			a[0][0]=f1.floatValue();
			a[0][1]=f2.floatValue();
			a[1][0]=f3.floatValue();
			a[1][1]=f4.floatValue();
			
			float r=a[0][0]*a[1][1]-a[1][0]*a[0][1];
			res.setText(""+r);
			}catch(Exception e){
				res.setText("Error");
			}
		}
		if(i.getSource()==b4){
			try{
			float a[][]=new float[3][3];
			String tt1=t1.getText();
			String tt2=t2.getText();
			String tt3=t3.getText();
			String tt4=t4.getText();
			String tt5=t5.getText();
			String tt6=t6.getText();
			String tt7=t7.getText();
			String tt8=t8.getText();
			String tt9=t9.getText();
			Float f1=new Float(tt1);
			Float f2=new Float(tt2);
			Float f3=new Float(tt3);
			Float f4=new Float(tt4);
			Float f5=new Float(tt5);
			Float f6=new Float(tt6);
			Float f7=new Float(tt7);
			Float f8=new Float(tt8);
			Float f9=new Float(tt9);
			a[0][0]=f1.floatValue();
			a[0][1]=f2.floatValue();
			a[0][2]=f3.floatValue();
			a[1][0]=f4.floatValue();
			a[1][1]=f5.floatValue();
			a[1][2]=f6.floatValue();
			a[2][0]=f7.floatValue();
			a[2][1]=f8.floatValue();
			a[2][2]=f9.floatValue();
			
			float r=calcu(a[0][0],a[0][1],a[0][2],a[1][0],a[1][1],a[1][2],a[2][0],a[2][1],a[2][2]);
			res.setText(""+r);
			}catch(Exception e){
				res.setText("Error");
			}
		}
		if(i.getSource()==b5){
			try{
			float a[][]=new float[4][4];
			String tt1=t1.getText();
			String tt2=t2.getText();
			String tt3=t3.getText();
			String tt4=t4.getText();
			String tt5=t5.getText();
			String tt6=t6.getText();
			String tt7=t7.getText();
			String tt8=t8.getText();
			String tt9=t9.getText();
			String tt10=t10.getText();
			String tt11=t11.getText();
			String tt12=t12.getText();
			String tt13=t13.getText();
			String tt14=t14.getText();
			String tt15=t15.getText();
			String tt16=t16.getText();
			Float f1=new Float(tt1);
			Float f2=new Float(tt2);
			Float f3=new Float(tt3);
			Float f4=new Float(tt4);
			Float f5=new Float(tt5);
			Float f6=new Float(tt6);
			Float f7=new Float(tt7);
			Float f8=new Float(tt8);
			Float f9=new Float(tt9);
			Float f10=new Float(tt10);
			Float f11=new Float(tt11);
			Float f12=new Float(tt12);
			Float f13=new Float(tt13);
			Float f14=new Float(tt14);
			Float f15=new Float(tt15);
			Float f16=new Float(tt16);
			a[0][0]=f1.floatValue();
			a[0][1]=f2.floatValue();
			a[0][2]=f3.floatValue();
			a[0][3]=f4.floatValue();
			a[1][0]=f5.floatValue();
			a[1][1]=f6.floatValue();
			a[1][2]=f7.floatValue();
			a[1][3]=f8.floatValue();
			a[2][0]=f9.floatValue();
			a[2][1]=f10.floatValue();
			a[2][2]=f11.floatValue();
			a[2][3]=f12.floatValue();
			a[3][0]=f13.floatValue();
			a[3][1]=f14.floatValue();
			a[3][2]=f15.floatValue();
			a[3][3]=f16.floatValue();
			float r1=calcu(a[1][1],a[1][2],a[1][3],a[2][1],a[2][2],a[2][3],a[3][1],a[3][2],a[3][3]);
			float r2=calcu(a[1][2],a[1][3],a[1][0],a[2][2],a[2][3],a[2][0],a[3][2],a[3][3],a[3][0]);
			float r3=calcu(a[1][3],a[1][0],a[1][1],a[2][3],a[2][0],a[2][1],a[3][3],a[3][0],a[3][1]);
			float r4=calcu(a[1][0],a[1][1],a[1][2],a[2][0],a[2][1],a[2][2],a[3][0],a[3][1],a[3][2]);
			float r=a[0][0]*r1+a[0][1]*r2+a[0][2]*r3+a[0][3]*r4;
			res.setText(""+r);
			}catch(Exception e){
				res.setText("Error");
			}
			
		}
		if(i.getSource()==home){
			setVisible(false);
			new Det();
		}
		
	}
	float calcu(float a, float b, float c,float d, float e, float f, float g, float h, float i){
		float x=a*(e*i-h*f)+b*(f*g-d*i)+c*(d*h-e*g);
		return x;
	}
	///////////////////////////////////////////////////////////////////// checkbox events
	public void itemStateChanged(ItemEvent i){
		if(i.getSource()==c1){
			
			d=2;
			l1.setVisible(false);
			ll.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			setSize(500,500);
			add(l00);
			add(l01);
			add(l10);
			add(l11);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(b3);
			add(res);
			add(l2);
			add(l3);
			add(home);
			int x=30,y=50;
			l2.setBounds(x,y,2*l,b);
			y=y+h;
			l00.setBounds(x,y,w,h);
			t1.setBounds(x+w,y,l,b);
			l01.setBounds(x+w+l+10,y,w,h);
			t2.setBounds(x+2*w+l+10,y,l,b);
			y=y+h;
			l10.setBounds(x,y,w,h);
			t3.setBounds(x+w,y,l,b);
			l11.setBounds(x+w+l+10,y,w,h);
			t4.setBounds(x+2*w+l+10,y,l,b);
		
			y=y+4*h;
			b3.setBounds(x,y,l,b);
			l3.setBounds(x+3*w+10,y,l-10,h);
			res.setBounds(x+3*w+l-10,y,l,b);
			y=y+2*h;
			
			home.setBounds(x,y,l,b);
			
			t1.setFont(new Font("Arial",1,14));
			t2.setFont(new Font("Arial",1,14));
			t3.setFont(new Font("Arial",1,14));
			t4.setFont(new Font("Arial",1,14));
			l00.setFont(new Font("Arial",1,14));
			l01.setFont(new Font("Arial",1,14));
			l10.setFont(new Font("Arial",1,14));
			l11.setFont(new Font("Arial",1,14));
			res.setFont(new Font("Arial",1,15));
			b3.setFont(new Font("Arial",1,14));
			l2.setFont(new Font("Arial",1,14));
			l3.setFont(new Font("Arial",1,14));
			home.setFont(new Font("Arial",1,14));
		}
		if(i.getSource()==c2){
			
			d=3;
			ll.setVisible(false);
			l1.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			setSize(600,500);
			add(l00);
			add(l01);
			add(l02);
			add(l10);
			add(l11);
			add(l12);
			add(l20);
			add(l21);
			add(l22);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			add(t6);
			add(t7);
			add(t8);
			add(t9);
			add(b4);
			add(res);
			add(l2);
			add(l3);
			add(home);
			int x=30,y=50;
			l2.setBounds(x,y,2*l,b);
			y=y+h;
			l00.setBounds(x,y,w,h);
			t1.setBounds(x+w,y,l,b);
			l01.setBounds(x+w+l+10,y,w,h);
			t2.setBounds(x+2*w+l+10,y,l,b);
			l02.setBounds(x+2*w+2*l+20,y,w,h);
			t3.setBounds(x+3*w+2*l+20,y,l,b);
			y=y+h;
			
			l10.setBounds(x,y,w,h);
			t4.setBounds(x+w,y,l,b);
			l11.setBounds(x+w+l+10,y,w,h);
			t5.setBounds(x+2*w+l+10,y,l,b);
			l12.setBounds(x+2*w+2*l+20,y,w,h);
			t6.setBounds(x+3*w+2*l+20,y,l,b);
			y=y+h;
			
			l20.setBounds(x,y,w,h);
			t7.setBounds(x+w,y,l,b);
			l21.setBounds(x+w+l+10,y,w,h);
			t8.setBounds(x+2*w+l+10,y,l,b);
			l22.setBounds(x+2*w+2*l+20,y,w,h);
			t9.setBounds(x+3*w+2*l+20,y,l,b);
			y=y+h;
			
			y=y+3*h;
			b4.setBounds(x,y,l,b);
			l3.setBounds(x+3*w+10,y,l-10,h);
			res.setBounds(x+3*w+l-10,y,l,b);
			y=y+2*h;
			
			home.setBounds(x,y,l,b);
			
			t1.setFont(new Font("Arial",1,14));
			t2.setFont(new Font("Arial",1,14));
			t3.setFont(new Font("Arial",1,14));
			t4.setFont(new Font("Arial",1,14));
			t5.setFont(new Font("Arial",1,14));
			t6.setFont(new Font("Arial",1,14));
			t7.setFont(new Font("Arial",1,14));
			t8.setFont(new Font("Arial",1,14));
			t9.setFont(new Font("Arial",1,14));
			l00.setFont(new Font("Arial",1,14));
			l01.setFont(new Font("Arial",1,14));
			l02.setFont(new Font("Arial",1,14));
			l20.setFont(new Font("Arial",1,14));
			l21.setFont(new Font("Arial",1,14));
			l22.setFont(new Font("Arial",1,14));
			l10.setFont(new Font("Arial",1,14));
			l11.setFont(new Font("Arial",1,14));
			l12.setFont(new Font("Arial",1,14));
			res.setFont(new Font("Arial",1,15));
			b3.setFont(new Font("Arial",1,14));
			l2.setFont(new Font("Arial",1,14));
			l3.setFont(new Font("Arial",1,14));
			home.setFont(new Font("Arial",1,14));
		}
		if(i.getSource()==c3){
			
			d=4;
			ll.setVisible(false);
			l1.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			
			add(l00);
			add(l01);
			add(l02);
			add(l03);
			add(l10);
			add(l11);
			add(l12);
			add(l13);
			add(l20);
			add(l21);
			add(l22);
			add(l23);
			add(l30);
			add(l31);
			add(l32);
			add(l33);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			add(t6);
			add(t7);
			add(t8);
			add(t9);
			add(t10);
			add(t11);
			add(t12);
			add(t13);
			add(t14);
			add(t15);
			add(t16);
			add(b5);
			add(res);
			add(l2);
			add(l3);
			add(home);
			int x=30,y=50;
			l2.setBounds(x,y,2*l,b);
			y=y+h;
			l00.setBounds(x,y,w,h);
			t1.setBounds(x+w,y,l,b);
			l01.setBounds(x+w+l+10,y,w,h);
			t2.setBounds(x+2*w+l+10,y,l,b);
			l02.setBounds(x+2*w+2*l+20,y,w,h);
			t3.setBounds(x+3*w+2*l+20,y,l,b);
			l03.setBounds(x+3*w+3*l+20,y,w,h);
			t4.setBounds(x+4*w+3*l+20,y,l,b);
			y=y+h;
			
			l10.setBounds(x,y,w,h);
			t5.setBounds(x+w,y,l,b);
			l11.setBounds(x+w+l+10,y,w,h);
			t6.setBounds(x+2*w+l+10,y,l,b);
			l12.setBounds(x+2*w+2*l+20,y,w,h);
			t7.setBounds(x+3*w+2*l+20,y,l,b);
			l13.setBounds(x+3*w+3*l+20,y,w,h);
			t8.setBounds(x+4*w+3*l+20,y,l,b);
			y=y+h;
			
			l20.setBounds(x,y,w,h);
			t9.setBounds(x+w,y,l,b);
			l21.setBounds(x+w+l+10,y,w,h);
			t10.setBounds(x+2*w+l+10,y,l,b);
			l22.setBounds(x+2*w+2*l+20,y,w,h);
			t11.setBounds(x+3*w+2*l+20,y,l,b);
			l23.setBounds(x+3*w+3*l+20,y,w,h);
			t12.setBounds(x+4*w+3*l+20,y,l,b);
			y=y+h;
			
			l30.setBounds(x,y,w,h);
			t13.setBounds(x+w,y,l,b);
			l31.setBounds(x+w+l+10,y,w,h);
			t14.setBounds(x+2*w+l+10,y,l,b);
			l32.setBounds(x+2*w+2*l+20,y,w,h);
			t15.setBounds(x+3*w+2*l+20,y,l,b);
			l33.setBounds(x+3*w+3*l+20,y,w,h);
			t16.setBounds(x+4*w+3*l+20,y,l,b);
			y=y+h;
			
			y=y+2*h;
			b5.setBounds(x,y,l,b);
			l3.setBounds(x+3*w+10,y,l-10,h);
			res.setBounds(x+3*w+l-10,y,l,b);
			y=y+2*h;
			
			home.setBounds(x,y,l,b);
			
			t1.setFont(new Font("Arial",1,14));
			t2.setFont(new Font("Arial",1,14));
			t3.setFont(new Font("Arial",1,14));
			t4.setFont(new Font("Arial",1,14));
			t5.setFont(new Font("Arial",1,14));
			t6.setFont(new Font("Arial",1,14));
			t7.setFont(new Font("Arial",1,14));
			t8.setFont(new Font("Arial",1,14));
			t9.setFont(new Font("Arial",1,14));
			t10.setFont(new Font("Arial",1,14));
			t11.setFont(new Font("Arial",1,14));
			t12.setFont(new Font("Arial",1,14));
			t13.setFont(new Font("Arial",1,14));
			t14.setFont(new Font("Arial",1,14));
			t15.setFont(new Font("Arial",1,14));
			t16.setFont(new Font("Arial",1,14));
			
			l00.setFont(new Font("Arial",1,14));
			l01.setFont(new Font("Arial",1,14));
			l02.setFont(new Font("Arial",1,14));
			l03.setFont(new Font("Arial",1,14));
			l20.setFont(new Font("Arial",1,14));
			l21.setFont(new Font("Arial",1,14));
			l22.setFont(new Font("Arial",1,14));
			l23.setFont(new Font("Arial",1,14));
			l10.setFont(new Font("Arial",1,14));
			l11.setFont(new Font("Arial",1,14));
			l12.setFont(new Font("Arial",1,14));
			l13.setFont(new Font("Arial",1,14));
			l30.setFont(new Font("Arial",1,14));
			l31.setFont(new Font("Arial",1,14));
			l32.setFont(new Font("Arial",1,14));
			l33.setFont(new Font("Arial",1,14));
			l40.setFont(new Font("Arial",1,14));
			l41.setFont(new Font("Arial",1,14));
			l42.setFont(new Font("Arial",1,14));
			l43.setFont(new Font("Arial",1,14));
			res.setFont(new Font("Arial",1,15));
			b5.setFont(new Font("Arial",1,14));
			l2.setFont(new Font("Arial",1,14));
			l3.setFont(new Font("Arial",1,14));
			home.setFont(new Font("Arial",1,14));
		}
	}
	/////////////////////////////////////////////////////////////////////////////// window events
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
	/////////////////////////////////////////////////////////////////////////////////// main ()
	public static void main(String args[]){
		new Det();
	}
}