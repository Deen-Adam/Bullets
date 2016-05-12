package javadeez.deenyzard;

// Advance Encryption Program

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;

import javax.swing.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import com.sun.crypto.provider.SunJCE;
// Note this is a third party packages you may not have it installed
import com.sun.crypto.provider.SunJCE.*;


public class StrictEncryption extends JFrame {
	
	// salt for a secret password - based encryption-decryption algorirthm 
	private static final byte[] salt = { (byte)0xf5, (byte)0x33,
		(byte)0x01, (byte)0x2a, (byte)0xb2, (byte)0xcc, (byte)0xe4, (byte)0x7f
	};
	
	// iteration count
	private int iteration = 100;
	
	// user input components.
	
	private JTextField passwordTextField;
	private JTextField fileNameTextField;
	private JEditorPane fileContentsEditorPane;
	
	// frame constructor
	public StrictEncryption (){
		
		// set security provider
		Security.addProvider( new SunJCE() );
		
		// initialize main frame
		
		setSize (new Dimension (400, 400));
		setTitle("Advance Encryption and Decryption");
		
		// construct top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder ( BorderFactory.createLineBorder(Color.black));
		topPanel.setLayout(new BorderLayout());
		
		// panel where password and file name labels will be placed
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridLayout(2, 1));
		JLabel passwordLabel = new JLabel("Password");
		JLabel fileNameLabel = new JLabel("File Name");
		labelsPanel.add(fileNameLabel);
		labelsPanel.add(passwordLabel);
		topPanel.add(labelsPanel, BorderLayout.WEST);
		
		// panel where password and file name text fields will be placed
		JPanel textFieldsPanel = new JPanel();
		textFieldsPanel.setLayout(new GridLayout(2, 1) );
		passwordTextField = new JPasswordField();
		fileNameTextField = new JTextField();
		textFieldsPanel.add(fileNameTextField);
		textFieldsPanel.add(passwordTextField);
		topPanel.add(textFieldsPanel, BorderLayout.CENTER);
		
		// construct middle panel
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		
		// construct and place title label for contents pane
		JLabel fileContentsLabel = new JLabel();
		fileContentsLabel.setText("File Contents" );
		middlePanel.add( fileContentsLabel, BorderLayout.NORTH);
		
		// initialize and place editor pane within scroll panel
		fileContentsEditorPane = new JEditorPane();
		middlePanel.add( new JScrollPane ( fileContentsEditorPane),
				BorderLayout.CENTER);
		
		// construct bottom panel
		JPanel bottomPanel = new JPanel();
		
		// create encrypt button
		JButton encryptButton = new JButton ( "Encrypt and Write to File ");
		encryptButton.addActionListener(
				
				new ActionListener() {
					
					public void actionPerformed( ActionEvent ae) {
						
						encryptAndWriteToFile();
					}
					
				}
				
			);
		
		bottomPanel.add( encryptButton);
		
		// create decrypt button
		JButton decryptButton = new JButton ("Read File And Decrypt");
		decryptButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent ae){
				
				readFromFileAndDecrypt();
			}
			
		}
	);
		
	bottomPanel.add(decryptButton);
	
	// initialize main frame window
	JPanel contentPane = ( JPanel ) this.getContentPane();
	contentPane.setLayout(new BorderLayout());
	contentPane.add(topPanel, BorderLayout.NORTH);
	contentPane.add(middlePanel, BorderLayout.CENTER);
	contentPane.add(bottomPanel, BorderLayout.SOUTH);
	
	} // end constructor
	
	// obtain contents from editor pane and encrypt
	private void encryptAndWriteToFile() {
		
		// obtain user input
		String originalText = fileContentsEditorPane.getText();
		String password = passwordTextField.getText();
		String fileName = fileNameTextField.getText();
		
		// create secret key and get cipher instance
		Cipher cipher = null;
		
		try {
			
			// create password based encryption key object
			PBEKeySpec keySpec = new PBEKeySpec ( password.toCharArray());
			
			// obtain instance for secret key factory
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance ("PBEWithMD5AndDES");
			
			// generate secret key for encryption
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			
			//specifies parameters used with password based enryption
			PBEParameterSpec parameterSpec = new PBEParameterSpec (salt, iteration);
			
			// obtain cipher instance reference
			cipher = Cipher.getInstance("PBEWithMD5AndDES");
			
			// initialize cipher in encrypt mode
			cipher.init ( Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		}
		
		// handle NoSuchAlgorithmException
		catch ( NoSuchAlgorithmException exception) {
			exception.printStackTrace();
			System.exit(1);
			
		}
		
		// handle InvalidKeySpecException
		catch ( InvalidKeySpecException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle InvalidKeyException
		catch ( InvalidKeyException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle NoSuchPaddingException
		catch ( NoSuchPaddingException exception ) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle InvalidAlgorithmParameterException
		catch ( InvalidAlgorithmParameterException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		
		// create array of bytes
		byte[] outputArray = null;
		
		
		try {
			
			outputArray = originalText.getBytes("ISO-8859-1");
		}
		
		// handle UnsupportedEncodingException
		catch ( UnsupportedEncodingException exception ) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// create FileOuptStream
		File file = new File ( fileName);
		FileOutputStream fileOutputStream = null;
		
		try {
			
			fileOutputStream = new FileOutputStream (file);
		}
		
		// handle IOException
		catch ( IOException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// creates CipherOutputStream
		CipherOutputStream out = new CipherOutputStream ( fileOutputStream, cipher );
		
		// write contents to file and close
		try {
			out.write(outputArray);
			out.flush();
			out.close();
		}
		
		// handle IOException
		catch ( IOException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// contents bytes read from file
		Vector fileBytes = new Vector();
		
		// read contents from file to show user encrytped text
		try {
			
			FileInputStream in = new FileInputStream (file);
			
			// read bytes from stream
			byte contents;
			
			while ( in.available() > 0 ) {
				contents = (byte) in.read();
				fileBytes.add(new Byte(contents));
			}
			
			in.close();
		}
		
		// handle IOException
		catch ( IOException exception ) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// crate byte array from contents in Vector fileBytes
		byte[] encryptedText = new byte [fileBytes.size() ];
		
		for ( int i = 0; i < fileBytes.size(); i++) {
			encryptedText[i] = ((Byte) fileBytes.elementAt(i)).byteValue();
		}
		
		// update Editor Pane contents
		fileContentsEditorPane.setText(new String(encryptedText));
	}
	
	
	// obtain contents from file and decrypt
	private void readFromFileAndDecrypt() {
		
		// used to rebuild byte list
		Vector fileBytes = new Vector();
		
		// obtain user input
		String password = passwordTextField.getText();
		String fileName = fileNameTextField.getText();
		
		// crate secret key
		Cipher cipher = null;
		
		try {
			// create password based encryption key oject
			PBEKeySpec keySpec = new PBEKeySpec ( password.toCharArray());
			
			// obtain instance for secret key factory
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			
			// generate secret key for encryption
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			
			// specifies parameter used with password based encryption
			PBEParameterSpec parameterSpec = new PBEParameterSpec (salt, iteration);
			
			// obtain cipher instance reference.
			cipher = Cipher.getInstance("PBEWithMD5AndDES");
			
			// initialize cipher in decrpt mode
			cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec );
			
		}
		
		// handle NoSuchAlgorithmException
		catch (NoSuchAlgorithmException exception ) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle InvalidKeySpecExcepiton
		catch ( InvalidKeySpecException exception ) {
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle InvalidKeyException
		catch ( InvalidKeyException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle NoSuchPaddingException
		catch ( NoSuchPaddingException exception) {
			exception.printStackTrace();
			System.exit(1);
		}
		
		// handle InvalidAlgorithmParameterException
		catch ( InvalidAlgorithmParameterException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// read and decrpt contents from file
		try {
			
			File file = new File (fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			CipherInputStream in = new CipherInputStream(fileInputStream, cipher);
			
			// read bytes from stream
			byte contents = ( byte ) in.read();
			
			while ( contents != -1 ) {
				
				fileBytes.add( new Byte ( contents ));
				contents = (byte) in.read();
			}
			
			in.close();
		}
		
		// handle IOException
		catch ( IOException exception) {
			
			exception.printStackTrace();
			System.exit(1);
		}
		
		// create byte array from contents in Vector fileBytes
		byte[] decryptedText = new byte [ fileBytes.size()];
		
		for ( int i = 0; i < fileBytes.size(); i++) {
			
			decryptedText[i] = ((Byte) fileBytes.elementAt(i) ).byteValue();
		}
		
		// update Editor Pane contents
		fileContentsEditorPane.setText(new String (decryptedText));
	}
	
	
		// create frame and display
		public static void main ( String[] args ) {
			
			StrictEncryption Strict = new StrictEncryption();
			Strict.validate();
			Strict.setVisible(true);
		}	
	

}
