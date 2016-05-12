import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.crypto.spec.*;
import javax.swing.filechooser.FileFilter;
import java.util.*;
import javax.crypto.*;
import javax.swing.*;
import javax.swing.border.*;

public class SFEncryptor extends JFrame implements ActionListener


    {

    	private JButton EButton;
    	private JButton DButton;
    	private Cipher ciper;
       	private JFileChooser fChoose;
    	private JPasswordField PText;
    	private PBEParameterSpec ps;
    	private PBEKeySpec ciperSpe;
       	private SecretKey secNum;

    	private SFEncryptor()


        	{
        		setTitle("SF ENCRYPTOR 1.0 DONE BY MANOJ");
        		try


            		{
						EButton = new JButton("EncryptFile");
            			DButton = new JButton("DecryptFile");
            			fChoose = new JFileChooser();
            			JPanel MainPanel = new JPanel(new BorderLayout());
            			PText = new JPasswordField();
            			EButton.addActionListener(this);
            			PText.setBackground(Color.black);
            			DButton.addActionListener(this);
            			MainPanel.setBorder(new TitledBorder(new EtchedBorder(), "ENTER YOUR PASSWORD"));
            			MainPanel.add(PText, BorderLayout.NORTH);
                      	PText.setForeground(Color.green);
            			MainPanel.add(EButton, BorderLayout.WEST);
            			MainPanel.add(DButton, BorderLayout.EAST);
            			addWindowListener(new WindowAdapter()


                			{
                				public void windowClosing(WindowEvent e)


                    				{
                    					System.exit(0);
                    				}
                    			});
                    			getContentPane().add(MainPanel);
                    			setResizable(false);
                    			setSize(266, 100);
                    		}
                    		catch(Throwable t) {}
                    	}

                            	private void InitiateCipher(int Mode)


                                	{
                                		try


                                    		{
                                    			ps = new PBEParameterSpec(Salt, Count);
                                    			ciperSpe = new PBEKeySpec(PText.getPassword());
                                    			secNum = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(ciperSpe);
                                    			ciper = Cipher.getInstance("PBEWithMD5AndDES");
                                    			ciper.init(Mode, secNum, ps);
                                    		}
                                    		catch(Throwable t) {t.printStackTrace();}
                                    	}
                                    	private void Encrypt()


                                        	{
                                        		try


                                            		{
                                            			InitiateCipher(Cipher.ENCRYPT_MODE);
                                            			fChoose.removeChoosableFileFilter(FilenameFilter.getInstance());
                                            			fChoose.setSelectedFile(new File("*.*"));
                                            			if(fChoose.showOpenDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
                                            				return;
                                            			String FileChosen = fChoose.getSelectedFile().getName();
                                            			BufferedInputStream In = new BufferedInputStream(new FileInputStream(fChoose.getSelectedFile()));
                                            			fChoose.addChoosableFileFilter(FilenameFilter.getInstance());
                                            			fChoose.setSelectedFile(new File((FileChosen.indexOf(".") != -1 ? FileChosen.substring(0, FileChosen.indexOf(".")) : FileChosen) + ".manojf"));
                                            			if(fChoose.showSaveDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
                                            				return;
                                            			CipherOutputStream Out = new CipherOutputStream(new FileOutputStream(fChoose.getSelectedFile()), ciper);
                                            			int Buffer;
                                            			while ((Buffer = In.read()) != -1)
                                            				Out.write(Buffer);
                                            			Out.close();
                                            			In.close();
                                            		}
                                            		catch(Throwable t) {}
                                            	}
                                            	public void actionPerformed(ActionEvent e)


												                                                       {
												                                                        		try


												                                                            		{
												                                                            			if(e.getSource() == EButton)
												                                                            				Encrypt();
												                                                            			if(e.getSource() == DButton)
												                                                            				DAction();
												                                                            		}
												                                                            		catch(Throwable t) {}
                                                            	}
                                            	private void DAction()


                                                	{
                                                		try


                                                    		{
                                                    			InitiateCipher(Cipher.DECRYPT_MODE);
                                                    			fChoose.addChoosableFileFilter(FilenameFilter.getInstance());
                                                    			fChoose.setSelectedFile(new File("*.manojf"));
                                                    			if(fChoose.showOpenDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
                                                    				return;
                                                    			String FileChosen = fChoose.getSelectedFile().getName();
                                                    			CipherInputStream In = new CipherInputStream(new FileInputStream(fChoose.getSelectedFile()), ciper);
                                                    			fChoose.removeChoosableFileFilter(FilenameFilter.getInstance());
                                                    			fChoose.setSelectedFile(new File((FileChosen.indexOf(".") != -1 ? FileChosen.substring(0, FileChosen.indexOf(".")) : FileChosen) + ".txt"));
                                                    			if(fChoose.showSaveDialog(new JFrame()) != JFileChooser.APPROVE_OPTION)
                                                    				return;
                                                    			BufferedOutputStream Out = new BufferedOutputStream(new FileOutputStream(fChoose.getSelectedFile()));
                                                    			int Buffer;
                                                    			while ((Buffer = In.read()) != -1)
                                                    				Out.write(Buffer);
                                                    			Out.close();
                                                    			In.close();
                                                    		}
                                                    		catch(Throwable t) {}
                                                    	}

                                                            	private static class FilenameFilter extends FileFilter


                                                                	{
                                                                		public boolean accept(File FileChosen)


                                                                    		{
                                                                    			return FileChosen.isDirectory() || FileChosen.getAbsolutePath().substring(FileChosen.getAbsolutePath().lastIndexOf(".")).equalsIgnoreCase(".manojf");
                                                                    		}
                                                                    		public String getDescription()


                                                                        		{
                                                                        			return "EncryptDecrypt Files (*.manojf)";
                                                                        		}
                                                                        		public static FilenameFilter getInstance()


                                                                            		{
                                                                            			return new FilenameFilter();
                                                                            		}
                                                                            	}
                                                                            	private final static int Count = 20;
    																			private final static byte[] Salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};


    																public static void main(String[] args){
																		Splash ap = new Splash();
																		  try{

																		             Thread.sleep(5000);
																		             ap.setVisible(false);
																		          }
																		          catch(Exception e)
        																		{}


																		try


																			{
																			new SFEncryptor().setVisible(true);
																		}
																	catch(Throwable t) {}


                            												}

}