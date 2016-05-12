package deenyzard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ShowColors2JFrame extends JFrame {

	private JButton changeColorJButton;
	private Color color = Color.GREEN;
	private JPanel colorJPanel;
	private JTextField jtextfield;
	private JLabel jlabel;
	private JCheckBox jcheckbox;
	private JRadioButton radiobutton;
	
	
	//set up GUI
	public ShowColors2JFrame(){
		
		super ("Using JColorChooser");
		
		jlabel = new JLabel(" Enter Text ");
		jtextfield = new JTextField();
		jcheckbox = new JCheckBox("Bold");
		
		jcheckbox.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						
						boolean boldcheck = false;
						
						if ( jcheckbox.isSelected() != boldcheck){
							
							jtextfield = new JTextField(20);
							
						}
					}
				}
				);
		
		//create JPanel for display color
		colorJPanel = new JPanel();
		colorJPanel.setBackground(color);
		
		//set up changeColor JButton and register its event handler
		
		changeColorJButton = new JButton("Change Color");
		changeColorJButton.addActionListener(
				new ActionListener() // anonymous inner class within parameter
				{
					//display JColor chooser when user clicks button
					public void actionPerformed(ActionEvent event){
						color = JColorChooser.showDialog(
								ShowColors2JFrame.this, "Choose a color", color);
						
						//set default color, if no color is returned
						if (JColorChooser.SELECTION_MODEL_PROPERTY != null ){
							
							//Change content pane's background color
							colorJPanel.setBackground(color);
						}
						else if (JColorChooser.SELECTION_MODEL_PROPERTY == null){
							
							//Switch back to default color
							colorJPanel.setBackground(Color.GREEN);
						}
					}// end method actionPerform
				}//end anonymous inner class within parameter
				);// end call to add ActionListener 
				
		colorJPanel.setBackground(Color.GREEN);
				add(colorJPanel, BorderLayout.CENTER); //add colorJPanel
				add(changeColorJButton, BorderLayout.SOUTH); // add button
				
				setSize( 500, 800); //set frame size
				setVisible(true); //display frame
		
	}// end ShowColor2JFrame constructor
} // end class ShowColors2JFrame 
