package Stck;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Help extends JFrame 
implements ActionListener,WindowListener
{
	JTextArea t1=new JTextArea("",30,1000);
	JButton ret=new JButton("Return");
	JLabel l1=new JLabel("JSciCalc");
	JScrollPane j1=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	Help(){
		super("Help");
		setLayout(null);
		setSize(610,600);
		setMaximumSize(new Dimension(600,500));
		add(j1);
		add(ret);
		add(l1);
		
		addWindowListener(this);
		
		ret.addActionListener(this);
		t1.setLineWrap(true);
		t1.setEditable(false);
		t1.setWrapStyleWord(true);
		j1.setBounds(10,40,580,450);
		ret.setBounds(250,500,100,40);
		t1.setBackground(Color.cyan);
		t1.setFont(new Font("Times New Roman",1,16));
		
		l1.setFont(new Font("asd",1,20));
		ret.setFont(new Font("Times New Roman",1,16));
		try{
				FileInputStream fin=new FileInputStream("Help.dat");
				File b=new File("Help.dat");
				byte ob[]=new byte[(int)b.length()];
				fin.read(ob);
				t1.setText(new String(ob));
				
			} catch(Exception e){
			t1.setText("\nError in opening Help.dat file.\n\nCheck if file is present.");
			}
			
		setVisible(true);
		validate();		
	}	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==ret)
		{
			setVisible(false);
		}
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
	public static void main(String args[]) throws Exception{
		new Help();
	}
}