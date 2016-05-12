import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import javax.media.jai.operator.*;


import javax.swing.JPanel;

public class MediaPanel extends JPanel {

	public MediaPanel(URL mediaURL){
		
		setLayout( new BorderLayout() ); // use a BorderLayout
		
		// Use lightweight components for Swing compatibility 
		Manager.setHint( Manager.LIGHTWEIGHT_RENDER, true );
		
		try {
			
			// create a player to play the media specified in the URL
			Player mediaPlayer =  Manager.createRealizedPlayer( mediaURL );
			
			// get the components for the video and the playback controls
			Component video = mediaPlayer.getVisualComponent();
			Component controls = mediaPlayer.getControlPanelComponent();
			
			if ( video != null )
				add ( video, BorderLayout.CENTER); //add video component
			if ( controls != null)
				add ( controls, BorderLayout.SOUTH); // add controls
			
			mediaPlayer.start(); // start playing the media clip
		} // end try
		catch ( NoPlayerException noPlayerException ){
			
			System.err.println(" No Media Player Found ");
		} // end catch
		catch ( CannotRealizeException cannotRealizeException ) {
			
			System.err.println(" Could not realize media player ");
		} // end catch
		catch ( IOException iOException ){
			
			System.err.println( " Error reading form the source ");
		} // end catch 
	} // end Media Panel constructor
} // end class MediaPanel
