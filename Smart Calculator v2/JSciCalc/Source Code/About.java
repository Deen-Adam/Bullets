package Stck;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class About extends JFrame{
	public About(){
		super("About JSciCalc");
		setSize(270,300);
		setVisible(true);
		setLayout(null);
		JLabel l1=new JLabel("JSciCalc");
		JLabel l2=new JLabel("Version 2.0");
		JLabel l3=new JLabel("Powered by Java");
		add(l1);
		add(l2);
		add(l3);
		l1.setFont(new Font("Arial",1,20));
		l2.setFont(new Font("Arial",1,20));
		l3.setFont(new Font("Arial",1,20));
		l1.setBounds(80,50,200,40);
		l2.setBounds(70,100,200,40);
		l3.setBounds(50,150,200,40);
		getContentPane().setBackground(Color.black);
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		addMouseListener(new A());
		validate();
	}
	class A extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			Container c=getContentPane();
			Dimension d=new Dimension();
			d=getSize();
			int x=e.getX();
			int y=e.getY();
			if(x<=d.width||y<=d.height)
				setVisible(false);
		}
	}
	public static void main(String args[]){
		new About();
	}
}