package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Linear extends JFrame
implements ActionListener,ItemListener
{
	CheckboxGroup c=new CheckboxGroup();
	Checkbox c1=new Checkbox("Equation in 2 variables",c,false);
	Checkbox c2=new Checkbox("Equation in 3 variables",c,false);
	Checkbox c3=new Checkbox("Equation in 4 variables",c,false);
	
	JLabel xx=new JLabel("X = ");
	JLabel yy=new JLabel("Y = ");
	JLabel ww=new JLabel("W = ");
	JLabel zz=new JLabel("Z = ");
	JLabel xx1=new JLabel("*X");
	JLabel yy1=new JLabel("*Y");
	JLabel zz1=new JLabel("*Z");
	JLabel ww1=new JLabel("*W");
	JLabel xx2=new JLabel("*X");
	JLabel yy2=new JLabel("*Y");
	JLabel zz2=new JLabel("*Z");
	JLabel ww2=new JLabel("*W");
	JLabel xx3=new JLabel("*X");
	JLabel yy3=new JLabel("*Y");
	JLabel zz3=new JLabel("*Z");
	JLabel ww3=new JLabel("*W");
	JLabel xx4=new JLabel("*X");
	JLabel yy4=new JLabel("*Y");
	JLabel zz4=new JLabel("*Z");
	JLabel ww4=new JLabel("*W");
	JLabel l4=new JLabel("=");
	JLabel l5=new JLabel("=");
	JLabel l6=new JLabel("=");
	JLabel l7=new JLabel("=");
	JLabel l8=new JLabel("+");
	JLabel l9=new JLabel("+");
	JLabel l10=new JLabel("+");
	JLabel l11=new JLabel("+");
	JLabel l12=new JLabel("+");
	JLabel l13=new JLabel("+");
	JLabel l14=new JLabel("+");
	JLabel l15=new JLabel("+");
	JLabel l16=new JLabel("+");
	JLabel l17=new JLabel("+");
	JLabel l18=new JLabel("+");
	JLabel l19=new JLabel("+");
	JLabel l20=new JLabel("+");
	
	
	JLabel l1=new JLabel("Solution of Simultaneous Linear Equations");
	JLabel l2=new JLabel("Enter the number of variables:");
	JLabel l3=new JLabel("Enter the coefficients of the variables:");
	
	JButton home=new JButton("Home");
	JButton b1=new JButton("Solve");
	JButton b2=new JButton("Solve");
	JButton b3=new JButton("Solve");
	
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
	JTextField tx=new JTextField("",100);
	JTextField ty=new JTextField("",100);
	JTextField tz=new JTextField("",100);
	JTextField tw=new JTextField("",100);
		
	int w=20,h=40,l=100,b=40;
	
	Linear(){
		
	super("Solution of Linear Equations");
	setSize(600,500);
	setVisible(true);
	setLayout(null);
	getContentPane().setBackground(Color.cyan);
	
	add(l1);
	add(l2);
	add(c1);
	add(c2);
	add(c3);
	l1.setBounds(100,50,400,50);
	l2.setBounds(100,100,400,50);
	c1.setBounds(100,200,250,40);
	c2.setBounds(100,250,250,40);
	//c3.setBounds(100,300,250,40);
	tx.setEditable(false);
	ty.setEditable(false);
	tz.setEditable(false);
	
	c1.addItemListener(this);
	c2.addItemListener(this);
	c3.addItemListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	home.addActionListener(this);
	c1.setFont(new Font("Arial",1,16));
	c2.setFont(new Font("Arial",1,16));
	c3.setFont(new Font("Arial",1,16));
	l1.setFont(new Font("Arial",1,16));
	l2.setFont(new Font("Arial",1,16));
	validate();
	}
	float det(float a, float b, float c, float d){
		return (a*d-c*b);
	}
	float det(float a, float b, float c,float d, float e, float f, float g, float h, float i){
		float x=a*(e*i-h*f)+b*(f*g-d*i)+c*(d*h-e*g);
		return x;
	}
	public void actionPerformed(ActionEvent i){
		if(i.getSource()==b1){
			try{
			float a[][]=new float[2][2];
			float b[][]=new float[2][2];
			float d[][]=new float[2][2];
			String tt1=t1.getText();
			String tt2=t2.getText();
			String tt3=t3.getText();
			String tt4=t4.getText();
			String tt5=t5.getText();
			String tt6=t6.getText();
			Float f1=new Float(tt1);
			Float f2=new Float(tt2);
			Float f3=new Float(tt3);
			Float f4=new Float(tt4);
			Float f5=new Float(tt5);
			Float f6=new Float(tt6);
			
			a[0][0]=f2.floatValue();
			a[0][1]=f3.floatValue();
			a[1][0]=f5.floatValue();
			a[1][1]=f6.floatValue();
			
			b[0][0]=f1.floatValue();
			b[0][1]=f3.floatValue();
			b[1][0]=f4.floatValue();
			b[1][1]=f6.floatValue();
			
			d[0][0]=f1.floatValue();
			d[0][1]=f2.floatValue();
			d[1][0]=f4.floatValue();
			d[1][1]=f5.floatValue();
			float x=-1*det(a[0][0],a[0][1],a[1][0],a[1][1])/det(d[0][0],d[0][1],d[1][0],d[1][1]);
			float y=det(b[0][0],b[0][1],b[1][0],b[1][1])/det(d[0][0],d[0][1],d[1][0],d[1][1]);
			tx.setText(""+x);
			ty.setText(""+y);
			}catch(Exception e){tx.setText("Error");
			ty.setText("Error");
			}
		}
		if(i.getSource()==b2){
			try{
			float a[][]=new float[3][3];
			float b[][]=new float[3][3];
			float c[][]=new float[3][3];
			float d[][]=new float[3][3];
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
			
			a[0][0]=f4.floatValue();
			a[0][1]=f2.floatValue();
			a[0][2]=f3.floatValue();
			a[1][0]=f8.floatValue();
			a[1][1]=f6.floatValue();
			a[1][2]=f7.floatValue();
			a[2][0]=f12.floatValue();
			a[2][1]=f10.floatValue();
			a[2][2]=f11.floatValue();
			
			b[0][0]=f1.floatValue();
			b[0][1]=f4.floatValue();
			b[0][2]=f3.floatValue();
			b[1][0]=f5.floatValue();
			b[1][1]=f8.floatValue();
			b[1][2]=f7.floatValue();
			b[2][0]=f9.floatValue();
			b[2][1]=f12.floatValue();
			b[2][2]=f11.floatValue();
			
			c[0][0]=f1.floatValue();
			c[0][1]=f2.floatValue();
			c[0][2]=f4.floatValue();
			c[1][0]=f5.floatValue();
			c[1][1]=f6.floatValue();
			c[1][2]=f8.floatValue();
			c[2][0]=f9.floatValue();
			c[2][1]=f10.floatValue();
			c[2][2]=f12.floatValue();
			
			d[0][0]=f1.floatValue();
			d[0][1]=f2.floatValue();
			d[0][2]=f3.floatValue();
			d[1][0]=f5.floatValue();
			d[1][1]=f6.floatValue();
			d[1][2]=f7.floatValue();
			d[2][0]=f9.floatValue();
			d[2][1]=f10.floatValue();
			d[2][2]=f11.floatValue();
			
			float x=det(a[0][0],a[0][1],a[0][2],a[1][0],a[1][1],a[1][2],a[2][0],a[2][1],a[2][2])/det(d[0][0],d[0][1],d[0][2],d[1][0],d[1][1],d[1][2],d[2][0],d[2][1],d[2][2]);
			float y=det(b[0][0],b[0][1],b[0][2],b[1][0],b[1][1],b[1][2],b[2][0],b[2][1],b[2][2])/det(d[0][0],d[0][1],d[0][2],d[1][0],d[1][1],d[1][2],d[2][0],d[2][1],d[2][2]);
			float z=det(c[0][0],c[0][1],c[0][2],c[1][0],c[1][1],c[1][2],c[2][0],c[2][1],c[2][2])/det(d[0][0],d[0][1],d[0][2],d[1][0],d[1][1],d[1][2],d[2][0],d[2][1],d[2][2]);
			tx.setText(""+x);
			ty.setText(""+y);
			tz.setText(""+z);
			}catch(Exception e){
				tx.setText("Error");
			ty.setText("Error");
			tz.setText("Error");
			}
			
		}
		if(i.getSource()==home){
			setVisible(false);
			new Linear();
		}
	}
	public void itemStateChanged(ItemEvent a){
		if(a.getSource()==c1){
			l1.setVisible(false);
			l2.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			setSize(500,500);
			add(l3);
			add(l4);
			add(xx1);
			add(yy1);
			add(xx2);
			add(yy2);
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			add(t6);
			add(l5);
			add(l8);
			add(l9);
			add(tx);
			add(ty);
			add(xx);
			add(yy);
			add(home);
			add(b1);
			int x=30,y=50;
			l3.setBounds(x,y,4*l,b);
			y=y+h+10;
			
			t1.setBounds(x,y,l,b);x+=l;
			xx1.setBounds(x,y,w,h);x+=w+10;
			l8.setBounds(x,y,w,h);x+=w;
			t2.setBounds(x,y,l,b);x+=l;
			yy1.setBounds(x,y,w,b);x+=w+10;
			l4.setBounds(x,y,w,h);x+=w;
			t3.setBounds(x,y,l,b);			
			y=y+h+10;
			x=30;
			
			t4.setBounds(x,y,l,b);x+=l;
			xx2.setBounds(x,y,w,h);x+=w+10;
			l9.setBounds(x,y,w,h);x+=w;
			t5.setBounds(x,y,l,b);x+=l;
			yy2.setBounds(x,y,w,b);x+=w+10;
			l5.setBounds(x,y,w,h);x+=w;
			t6.setBounds(x,y,l,b);			
			y=y+2*h+10;
			x=30;

			b1.setBounds(x,y,l,b); x=x+2*l; 
			xx.setBounds(x,y,w*2,h); tx.setBounds(x+2*w,y,l+w,b); y=y+h+10;
			x=30+2*l; yy.setBounds(x,y,w*2,h); ty.setBounds(x+2*w,y,l+w,b); x=30;
			
			
			home.setBounds(x,y,l,b);
			
			
			l3.setFont(new Font("Arial",1,16));
			t1.setFont(new Font("Arial",1,16));
			xx1.setFont(new Font("Arial",1,16));
			yy1.setFont(new Font("Arial",1,16));
			l8.setFont(new Font("Arial",1,16));
			t2.setFont(new Font("Arial",1,16));
			t3.setFont(new Font("Arial",1,16));
			l4.setFont(new Font("Arial",1,16));
			l8.setFont(new Font("Arial",1,16));
			t4.setFont(new Font("Arial",1,16));
			xx2.setFont(new Font("Arial",1,16));
			yy2.setFont(new Font("Arial",1,16));
			l4.setFont(new Font("Arial",1,16));
			t5.setFont(new Font("Arial",1,16));
			t6.setFont(new Font("Arial",1,16));
			l9.setFont(new Font("Arial",1,16));
			l5.setFont(new Font("Arial",1,16));
			home.setFont(new Font("Arial",1,16));
			xx.setFont(new Font("Arial",1,16));
			yy.setFont(new Font("Arial",1,16));
			tx.setFont(new Font("Arial",1,16));
			ty.setFont(new Font("Arial",1,16));
			b1.setFont(new Font("Arial",1,16));
			//l4.setBounds(x,y,w,h);
			//t3.setBounds(x+w,y,l,b);
			//l11.setBounds(x+w+l+10,y,w,h);
			//t4.setBounds(x+2*w+l+10,y,l,b);
		
		}
		if(a.getSource()==c2){
			l1.setVisible(false);
			l2.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			setSize(600,500);
			add(l3);
			add(l4);
			add(xx1);
			add(yy1);
			add(zz1);
			add(xx2);
			add(yy2);
			add(zz2);
			add(xx3);
			add(yy3);
			add(zz3);
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
			add(l5);
			add(l6);
			add(l8);
			add(l9);
			add(l10);
			add(l11);
			add(l12);
			add(l13);
			add(tx);
			add(ty);
			add(tz);
			add(xx);
			add(yy);
			add(zz);
			add(home);
			add(b2);
			int x=30,y=50;
			l3.setBounds(x,y,4*l,b);
			y=y+h+10;
			
			t1.setBounds(x,y,l,b);x+=l;
			xx1.setBounds(x,y,w,h);x+=w+10;
			l8.setBounds(x,y,w,h);x+=w;
			t2.setBounds(x,y,l,b);x+=l;
			yy1.setBounds(x,y,w,b);x+=w+10;
			l9.setBounds(x,y,w,b); x+=w;
			t3.setBounds(x,y,l,b);	x+=l;		
			zz1.setBounds(x,y,w,b); x+=w;
			l4.setBounds(x,y,w,h);x+=w;
			t4.setBounds(x,y,l,b);			
			y=y+h+10;
			x=30;
			
			t5.setBounds(x,y,l,b);x+=l;
			xx2.setBounds(x,y,w,h);x+=w+10;
			l10.setBounds(x,y,w,h);x+=w;
			t6.setBounds(x,y,l,b);x+=l;
			yy2.setBounds(x,y,w,b);x+=w+10;
			l11.setBounds(x,y,w,b); x+=w;
			t7.setBounds(x,y,l,b);	x+=l;	
			zz2.setBounds(x,y,w,b); x+=w;
			l5.setBounds(x,y,w,h);x+=w;
			t8.setBounds(x,y,l,b);			
			y=y+h+10;
			x=30;
			
			t9.setBounds(x,y,l,b);x+=l;
			xx3.setBounds(x,y,w,h);x+=w+10;
			l12.setBounds(x,y,w,h);x+=w;
			t10.setBounds(x,y,l,b);x+=l;
			yy3.setBounds(x,y,w,b);x+=w+10;
			l13.setBounds(x,y,w,b); x+=w;
			t11.setBounds(x,y,l,b);	x+=l;	
			zz3.setBounds(x,y,w,b); x+=w;
			l6.setBounds(x,y,w,h);x+=w;
			t12.setBounds(x,y,l,b);			
			y=y+h+10;
			x=30;
			
			y=y+h;
			b2.setBounds(x,y,l,b); x=x+2*l; 
			xx.setBounds(x,y,w*2,h); tx.setBounds(x+2*w,y,l+w,b); y=y+h+10;
			x=30+2*l;
			 
			yy.setBounds(x,y,w*2,h); ty.setBounds(x+2*w,y,l+w,b); x=30+2*l;y=y+h+10;
			
			zz.setBounds(x,y,w*2,h); tz.setBounds(x+2*w,y,l+w,b); x=30;
			
			
			
			home.setBounds(x,y-h,l,b);
			
			
			l3.setFont(new Font("Arial",1,16));
			l4.setFont(new Font("Arial",1,16));
			l10.setFont(new Font("Arial",1,16));
			l8.setFont(new Font("Arial",1,16));
			l11.setFont(new Font("Arial",1,16));
			l9.setFont(new Font("Arial",1,16));
			l5.setFont(new Font("Arial",1,16));
			l6.setFont(new Font("Arial",1,16));
			l12.setFont(new Font("Arial",1,16));
			l13.setFont(new Font("Arial",1,16));
				
			xx1.setFont(new Font("Arial",1,16));
			yy1.setFont(new Font("Arial",1,16));
			zz1.setFont(new Font("Arial",1,16));
			xx2.setFont(new Font("Arial",1,16));
			yy2.setFont(new Font("Arial",1,16));
			zz2.setFont(new Font("Arial",1,16));
			xx3.setFont(new Font("Arial",1,16));
			yy3.setFont(new Font("Arial",1,16));
			zz3.setFont(new Font("Arial",1,16));
			
			t1.setFont(new Font("Arial",1,16));
			t2.setFont(new Font("Arial",1,16));
			t3.setFont(new Font("Arial",1,16));
			t4.setFont(new Font("Arial",1,16));
			t5.setFont(new Font("Arial",1,16));
			t6.setFont(new Font("Arial",1,16));
			t7.setFont(new Font("Arial",1,16));
			t8.setFont(new Font("Arial",1,16));
			t9.setFont(new Font("Arial",1,16));
			t10.setFont(new Font("Arial",1,16));
			t11.setFont(new Font("Arial",1,16));
			t12.setFont(new Font("Arial",1,16));
			
			
			home.setFont(new Font("Arial",1,16));
			xx.setFont(new Font("Arial",1,16));
			zz.setFont(new Font("Arial",1,16));
			yy.setFont(new Font("Arial",1,16));
			tx.setFont(new Font("Arial",1,16));
			ty.setFont(new Font("Arial",1,16));
			tz.setFont(new Font("Arial",1,16));
			b2.setFont(new Font("Arial",1,16));
			//l4.setBounds(x,y,w,h);
			//t3.setBounds(x+w,y,l,b);
			//l11.setBounds(x+w+l+10,y,w,h);
			//t4.setBounds(x+2*w+l+10,y,l,b);
		
		}
		
	}
	public static void main(String args[]){
		new Linear();
	}
}