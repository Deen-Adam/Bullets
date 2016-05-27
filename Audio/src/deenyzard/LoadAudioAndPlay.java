package deenyzard;

import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class LoadAudioAndPlay extends JApplet{

	private AudioClip sound1, sound2, currentSound;
	private JButton playJButton, loopJButton, stopJButton;
	private JComboBox soundJComboBox;
	
	// load the audio when the applet begins executing
	public void init(){
		
		setLayout( new FlowLayout());
			
			String choices[] = {"Welcome", "Hi"};
			soundJComboBox = new JComboBox( choices ); // create JComboBox
			soundJComboBox.addItemListener(
					new ItemListener(){
						
						//stop sound and change sound to user's selection
						public void itemStateChanged( ItemEvent e){
							
							currentSound.stop();
							currentSound = soundJComboBox.getSelectedIndex() == 0 ? 
									sound1 : sound2;
						} // end method itemStateChanged
					} // end anonymous inner class
					); // end addItemListener method call
			
			add( soundJComboBox ); // add JComboBox to applet
			
			// set up button event handler and buttons
			ButtonHandler handler = new ButtonHandler();
			
			// create Play JButton
			playJButton = new JButton("Play");
			playJButton.addActionListener( handler );
			add( playJButton );
			
			// create Loop JButton
			loopJButton = new JButton ("Loop");
			loopJButton.addActionListener(handler);
			add( loopJButton );
			
			// create Stop JButton
			stopJButton = new JButton ("Stop");
			stopJButton.addActionListener(handler);
			add( stopJButton );
			
			// load sounds and set currrentSound
			sound1 = getAudioClip( getDocumentBase(), "welcome.wav");
			sound2 = getAudioClip( getDocumentBase(), "hi.au");
			currentSound = sound1;
			
		} // end method init
		
		// stop the sound when the user switches web pages
		public void stop(){
			
			currentSound.stop(); // stop AudioClip
			
		} // end method stop
		
		// private inner class to handle button events
		private class ButtonHandler implements ActionListener {
			
			// process play, loop and stop button events
			public void actionPerformed( ActionEvent actionEvent){
				
				if ( actionEvent.getSource() == playJButton)
					currentSound.play(); // play AudioClip once
				else if ( actionEvent.getSource() == loopJButton)
					currentSound.loop(); // play AudioClip continuosly 
				else if ( actionEvent.getSource() == stopJButton)
					currentSound.stop(); // stop AudioClip
			} // end method actionPerformed
		} // end ButtonHandler
	} // end class LoadAudioAndPlay
