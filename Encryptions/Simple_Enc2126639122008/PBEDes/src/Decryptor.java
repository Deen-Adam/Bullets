
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ProgressMonitorInputStream;
public class Decryptor {
    
	public static void aksi()
    {
    matchPassword();
    createKey();
    
        }

   static void openFile() {
        
    fd= new FileDialog( dummyFrame, "Browse the file to be decrypted");
    fd.setVisible(true);
    inputFile=fd.getDirectory()+fd.getFile();
   
        
    }
	
	private static void matchPassword()
	{
		while(true)
		{
			pwd1 = new JPasswordField(25);
			pwd2 = new JPasswordField(25);
			JOptionPane.showConfirmDialog(null, pwd1,"Enter Password",JOptionPane.OK_CANCEL_OPTION); 
			JOptionPane.showConfirmDialog(null, pwd2," Enter Password Again",JOptionPane.OK_CANCEL_OPTION); 
			outputFile = JOptionPane.showInputDialog(dummyFrame,"Enter name of output decrypted file");
			passWord1=new String(pwd1.getPassword());
			//System.out.println("pass1"+passWord1);
			
			passWord2=new String(pwd2.getPassword());
			//System.out.println("pass1"+passWord2);
			
		if(passWord1.equals(passWord2))
		{
			manageKeystrengthMethod();
			passByte=passWord1.getBytes();
			createExtensionForOutputFile();
			break;
		}
		else	
		{
			JOptionPane.showMessageDialog(null,"Password Mismatch");
			continue;
		}
		}
	}
	
	private static void  createExtensionForOutputFile()
	{
		inputfileName=fd.getFile();
		int i=0;
		//System.out.println("input file is "+inputfileName);		
	//System.out.println("extensuon  is :	"+inputfileName.indexOf("."));	
	i=inputfileName.indexOf(".");
	
	outputFile=outputFile+inputfileName.substring(i,inputfileName.length());
	
	}
	
	
	private static void createKey()
	{

		try
		{
			keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec dspec= new DESKeySpec(passByte);
			key = keyFactory.generateSecret(dspec);
			//System.out.println("key is :"+key);	
			createCipher();
			
			new Thread()
			{
				
			public void run()
			{
				
			try
			{
			decryptFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			}.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	private static void manageKeystrengthMethod()
	{
		if(passWord1.length()<8)
		{
			int counter=passWord1.length();
			//System.out.println("length is"+passWord1.length());
			while(counter<8)
			{
				passWord1+='@';
				counter++;
			}
			//System.out.println("length is"+passWord1.length()+  "Password1 is:"+passWord1);
		}
	}
	private  static void  createCipher()
	{
		try
		{
		cipher=Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE,key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private static void  decryptFile() throws IOException, ShortBufferException, IllegalBlockSizeException, BadPaddingException
	{
		
		int blockSize = cipher.getBlockSize();
	    int outputSize = cipher.getOutputSize(blockSize);
	    byte[] inBytes = new byte[blockSize];
	    byte[] outBytes = new byte[outputSize];
	    in= new FileInputStream(inputFile);
	    out=new FileOutputStream(outputFile);
	    ProgressMonitorInputStream progressIn = new ProgressMonitorInputStream(dummyFrame,"Decrypting file...",in);
	    
	    BufferedInputStream inStream = new BufferedInputStream(progressIn);
	    int inLength = 0;;
	    boolean more = true;
	    while (more)
	      {
	         inLength = inStream.read(inBytes);
	         if (inLength == blockSize)
	         {
	            int outLength 
	               = cipher.update(inBytes, 0, blockSize, outBytes);
	            out.write(outBytes, 0, outLength);
	           // System.out.println(outLength);
	         }
	         else more = false;         
	      }
	      if (inLength > 0)
	         outBytes = cipher.doFinal(inBytes, 0, inLength);
	      else
	         outBytes = cipher.doFinal();
            JOptionPane.showMessageDialog(dummyFrame, "Decription Finished..!!");
	     // System.out.println(outBytes.length);
	      out.write(outBytes);
		
	}
	private static JFrame dummyFrame = new JFrame();
	private static FileDialog fd;
	public static String inputFile;
	private static String passWord1;
	private static String passWord2;
	private static byte[] passByte;
	private static SecretKeyFactory keyFactory;
	private static Key key;
	private static JPasswordField pwd1;
	private static JPasswordField pwd2;
	private static Cipher cipher;
	private static String outputFile;
	private static InputStream in;
	private static OutputStream out;
	private static String inputfileName;


	
}
