package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Inverse extends JFrame 
implements WindowListener,ActionListener,ItemListener
{
	CheckboxGroup c=new CheckboxGroup();
	Checkbox c1=new Checkbox("2x2",c,false);
	Checkbox c2=new Checkbox("3x3",c,false);
	Checkbox c3=new Checkbox("4x4",c,false);
	
	JLabel l1=new JLabel("Choose the degree of the matrix:");
	JLabel l2=new JLabel("Enter the elements of the Matrix:");
	JLabel l3=new JLabel("Inverse of the Matrix:");
	JLabel l4=new JLabel("To Calculate the Inverse of a Square Matrix");
	JLabel l00=new JLabel("A [0][0]:");
	JLabel l01=new JLabel("A [0][1]:");
	JLabel l02=new JLabel("A [0][2]:");
	
	JLabel l10=new JLabel("A [1][0]:");
	JLabel l11=new JLabel("A [1][1]:");
	JLabel l12=new JLabel("A [1][2]:");
	
	JLabel l20=new JLabel("A [2][0]:");
	JLabel l21=new JLabel("A [2][1]:");
	JLabel l22=new JLabel("A [2][2]:");
	
	JLabel i00=new JLabel("I [0][0]:");
	JLabel i01=new JLabel("I [0][1]:");
	JLabel i02=new JLabel("I [0][2]:");
	
	JLabel i10=new JLabel("I [1][0]:");
	JLabel i11=new JLabel("I [1][1]:");
	JLabel i12=new JLabel("I [1][2]:");
	
	JLabel i20=new JLabel("I [2][0]:");
	JLabel i21=new JLabel("I [2][1]:");
	JLabel i22=new JLabel("I [2][2]:");
	
	
	
	JTextField t1=new JTextField("",100);
	JTextField t2=new JTextField("",100);
	JTextField t3=new JTextField("",100);
	JTextField t4=new JTextField("",100);
	JTextField t5=new JTextField("",100);
	JTextField t6=new JTextField("",100);
	JTextField t7=new JTextField("",100);
	JTextField t8=new JTextField("",100);
	JTextField t9=new JTextField("",100);
	
	JTextField i1=new JTextField("",100);
	JTextField i2=new JTextField("",100);
	JTextField i3=new JTextField("",100);
	JTextField i4=new JTextField("",100);
	JTextField i5=new JTextField("",100);
	JTextField i6=new JTextField("",100);
	JTextField i7=new JTextField("",100);
	JTextField i8=new JTextField("",100);
	JTextField i9=new JTextField("",100);
	
	
	JButton b3=new JButton("Calculate");
	JButton b4=new JButton("Calculate");
	JButton home=new JButton("Home");
	
	int w=60,h=40,l=120,b=40;
	
	///////////////////////////////////////////////////////////////// constructor
	Inverse(){
		super("Inverse of a Matrix");
		setSize(700,600);
		setLayout(null);
		
		getContentPane().setBackground(Color.cyan);
			add(c1);
			add(c2);
			add(c3);
			add(l1);
			add(l4);
			l4.setBounds(100,50,400,40);
			l1.setBounds(100,150,300,40);
			c1.setBounds(100,200,50,40);
			c2.setBounds(100,250,50,40);
			c1.setFont(new Font("Arial",1,16));
			c2.setFont(new Font("Arial",1,16));
			l1.setFont(new Font("Arial",1,16));
			l4.setFont(new Font("Arial",1,17));
			
		//t3.setEditable(false);
		i1.setEditable(false);
		i2.setEditable(false);
		i3.setEditable(false);
		i4.setEditable(false);
		i5.setEditable(false);
		i6.setEditable(false);
		i7.setEditable(false);
		i8.setEditable(false);
		i9.setEditable(false);

		c1.addItemListener(this);
		c2.addItemListener(this);
		
		b3.addActionListener(this);
		b4.addActionListener(this);
//		
		home.addActionListener(this);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent i){
		if(i.getSource()==b3){
			try{
			float a[][]=new float[2][2];
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			Float f1=new Float(s1);
			Float f2=new Float(s2);
			Float f3=new Float(s3);
			Float f4=new Float(s4);
			
			a[0][0]=f1.floatValue();
			a[0][1]=f2.floatValue();
			a[1][0]=f3.floatValue();
			a[1][1]=f4.floatValue();
			float d=det(a[0][0],a[0][1],a[1][0],a[1][1]);
			System.out.println(d);
			a[0][0]=a[0][0]/d;
			a[1][0]=a[1][0]/d;
			a[0][1]=a[0][1]/d;
			a[1][1]=a[1][1]/d;
			
			
			i1.setText(""+a[1][1]); 
			i2.setText(""+-1*a[0][1]);
			i3.setText(""+-1*a[1][0]);
			i4.setText(""+a[0][0]);		
			}catch(Exception e){
				i1.setText("Error"); 
			i2.setText("Error");
			i3.setText("Error");
			i4.setText("Error");		
			}
		}
		
		if(i.getSource()==b4){
			try{
			float a[][]=new float[3][3];
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			String s6=t6.getText();
			String s7=t7.getText();
			String s8=t8.getText();
			String s9=t9.getText();
			
			Float f1=new Float(s1);
			Float f2=new Float(s2);
			Float f3=new Float(s3);
			Float f4=new Float(s4);
			Float f5=new Float(s5);
			Float f6=new Float(s6);
			Float f7=new Float(s7);
			Float f8=new Float(s8);
			Float f9=new Float(s9);
			
			a[0][0]=f1.floatValue();
			a[0][1]=f2.floatValue();
			a[0][2]=f3.floatValue();
			a[1][0]=f4.floatValue();
			a[1][1]=f5.floatValue();
			a[1][2]=f6.floatValue();
			a[2][0]=f7.floatValue();
			a[2][1]=f8.floatValue();
			a[2][2]=f9.floatValue();

			float d=det(a[0][0],a[0][1],a[0][2],a[1][0],a[1][1],a[1][2],a[2][0],a[2][1],a[2][2]);
			float ii[][]=new float[3][3];
			System.out.println(d);
			ii[0][0]=det(a[1][1],a[1][2],a[2][1],a[2][2])/d;
			ii[0][1]=-1*det(a[1][0],a[1][2],a[2][0],a[2][2])/d;
			ii[0][2]=det(a[1][0],a[1][1],a[2][0],a[2][1])/d;
			ii[1][0]=-1*det(a[0][1],a[2][1],a[0][2],a[2][2])/d;
			ii[1][1]=det(a[0][0],a[0][2],a[2][0],a[2][2])/d;
			ii[1][2]=-1*det(a[0][0],a[0][1],a[2][0],a[2][1])/d;
			ii[2][0]=det(a[0][1],a[0][2],a[1][1],a[1][2])/d;
			ii[2][1]=-1*det(a[0][0],a[0][2],a[1][0],a[1][2])/d;
			ii[2][2]=det(a[0][0],a[0][1],a[1][0],a[1][1])/d;			
			
			i1.setText(""+ii[0][0]); 
			i2.setText(""+ii[1][0]);
			i3.setText(""+ii[2][0]);
			i4.setText(""+ii[0][1]);
			i5.setText(""+ii[1][1]);
			i6.setText(""+ii[2][1]);		
			i7.setText(""+ii[0][2]);
			i8.setText(""+ii[1][2]);
			i9.setText(""+ii[2][2]);		
			
			}catch(Exception e){
			i1.setText("Error"); 
			i2.setText("Error");
			i3.setText("Error");
			i4.setText("Error");		
			i5.setText("Error"); 
			i6.setText("Error");
			i7.setText("Error");
			i8.setText("Error");
			i9.setText("Error");
			}
		}
		
		if(i.getSource()==home){
			setVisible(false);
			new Inverse();
		}
	}
	public void itemStateChanged(ItemEvent i){
		if(i.getSource()==c1){
			l4.setVisible(false);
			l1.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			setSize(500,500);
			add(l00);
			add(l01);
			add(l10);
			add(l11);
			add(i00);
			add(i01);
			add(i10);
			add(i11);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(i1);
			add(i2);
			add(i3);
			add(i4);
			add(b3);
			
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
		
			y=y+2*h;
			
			l3.setBounds(x,y,2*l,b);
			y+=h;
			i00.setBounds(x,y,w,h);
			i1.setBounds(x+w,y,l,b);
			i01.setBounds(x+w+l+10,y,w,h);
			i2.setBounds(x+2*w+l+10,y,l,b);
			y=y+h;
			i10.setBounds(x,y,w,h);
			i3.setBounds(x+w,y,l,b);
			i11.setBounds(x+w+l+10,y,w,h);
			i4.setBounds(x+2*w+l+10,y,l,b);
			
			y=y+2*h;
			
			b3.setBounds(x,y,l,b);
			home.setBounds(x+l+20,y,l,b);
			
			t1.setFont(new Font("Arial",1,14));
			t2.setFont(new Font("Arial",1,14));
			t3.setFont(new Font("Arial",1,14));
			t4.setFont(new Font("Arial",1,14));
			l00.setFont(new Font("Arial",1,14));
			l01.setFont(new Font("Arial",1,14));
			l10.setFont(new Font("Arial",1,14));
			l11.setFont(new Font("Arial",1,14));
			i1.setFont(new Font("Arial",1,14));
			i2.setFont(new Font("Arial",1,14));
			i3.setFont(new Font("Arial",1,14));
			i4.setFont(new Font("Arial",1,14));
			i00.setFont(new Font("Arial",1,14));
			i01.setFont(new Font("Arial",1,14));
			i10.setFont(new Font("Arial",1,14));
			i11.setFont(new Font("Arial",1,14));
			
			b3.setFont(new Font("Arial",1,14));
			l2.setFont(new Font("Arial",1,14));
			l3.setFont(new Font("Arial",1,14));
			home.setFont(new Font("Arial",1,14));
		}
		
		if(i.getSource()==c2){
			
			l4.setVisible(false);
			l1.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			setSize(700,600);
			add(l00);
			add(l01);
			add(l02);
			add(l10);
			add(l11);
			add(l12);
			add(l20);
			add(l21);
			add(l22);
			add(i00);
			add(i01);
			add(i02);
			add(i10);
			add(i11);
			add(i12);
			add(i20);
			add(i21);
			add(i22);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			add(t6);
			add(t7);
			add(t8);
			add(t9);
			add(i1);
			add(i2);
			add(i3);
			add(i4);
			add(i5);
			add(i6);
			add(i7);
			add(i8);
			add(i9);
			add(b4);
			
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
			y=y+2*h;
			
			l3.setBounds(x,y,2*l,b);
			y=y+h;
			i00.setBounds(x,y,w,h);
			i1.setBounds(x+w,y,l,b);
			i01.setBounds(x+w+l+10,y,w,h);
			i2.setBounds(x+2*w+l+10,y,l,b);
			i02.setBounds(x+2*w+2*l+20,y,w,h);
			i3.setBounds(x+3*w+2*l+20,y,l,b);
			y=y+h;
			
			i10.setBounds(x,y,w,h);
			i4.setBounds(x+w,y,l,b);
			i11.setBounds(x+w+l+10,y,w,h);
			i5.setBounds(x+2*w+l+10,y,l,b);
			i12.setBounds(x+2*w+2*l+20,y,w,h);
			i6.setBounds(x+3*w+2*l+20,y,l,b);
			y=y+h;
			
			i20.setBounds(x,y,w,h);
			i7.setBounds(x+w,y,l,b);
			i21.setBounds(x+w+l+10,y,w,h);
			i8.setBounds(x+2*w+l+10,y,l,b);
			i22.setBounds(x+2*w+2*l+20,y,w,h);
			i9.setBounds(x+3*w+2*l+20,y,l,b);
			
			y=y+2*h;
			b4.setBounds(x,y,l,b);
			home.setBounds(x+l+20,y,l,b);
			
			t1.setFont(new Font("Arial",1,14));
			t2.setFont(new Font("Arial",1,14));
			t3.setFont(new Font("Arial",1,14));
			t4.setFont(new Font("Arial",1,14));
			t5.setFont(new Font("Arial",1,14));
			t6.setFont(new Font("Arial",1,14));
			t7.setFont(new Font("Arial",1,14));
			t8.setFont(new Font("Arial",1,14));
			t9.setFont(new Font("Arial",1,14));
			i1.setFont(new Font("Arial",1,14));
			i2.setFont(new Font("Arial",1,14));
			i3.setFont(new Font("Arial",1,14));
			i4.setFont(new Font("Arial",1,14));
			i5.setFont(new Font("Arial",1,14));
			i6.setFont(new Font("Arial",1,14));
			i7.setFont(new Font("Arial",1,14));
			i8.setFont(new Font("Arial",1,14));
			i9.setFont(new Font("Arial",1,14));
			l00.setFont(new Font("Arial",1,14));
			l01.setFont(new Font("Arial",1,14));
			l02.setFont(new Font("Arial",1,14));
			l20.setFont(new Font("Arial",1,14));
			l21.setFont(new Font("Arial",1,14));
			l22.setFont(new Font("Arial",1,14));
			l10.setFont(new Font("Arial",1,14));
			l11.setFont(new Font("Arial",1,14));
			l12.setFont(new Font("Arial",1,14));
			i00.setFont(new Font("Arial",1,14));
			i01.setFont(new Font("Arial",1,14));
			i02.setFont(new Font("Arial",1,14));
			i20.setFont(new Font("Arial",1,14));
			i21.setFont(new Font("Arial",1,14));
			i22.setFont(new Font("Arial",1,14));
			i10.setFont(new Font("Arial",1,14));
			i11.setFont(new Font("Arial",1,14));
			i12.setFont(new Font("Arial",1,14));
			
			b4.setFont(new Font("Arial",1,14));
			l2.setFont(new Font("Arial",1,14));
			l3.setFont(new Font("Arial",1,14));
			home.setFont(new Font("Arial",1,14));
		}
	}
	float det(float a, float b, float c, float d){
		return (a*d-c*b);
	}
	float det(float a, float b, float c,float d, float e, float f, float g, float h, float i){
		float x=a*(e*i-h*f)+b*(f*g-d*i)+c*(d*h-e*g);
		return x;
	}
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
	public static void main(String args[]){
		new Inverse();
	}
}