package cobasms;
/*
 * SMSkirim.java
 *
 * Created on 20 Januari 2008, 14:27
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.*;
import javax.microedition.io.*;
import java.io.IOException;
import java.lang.System;

/**
 *
 * @author PKM
 */
public class SMSkirim extends MIDlet implements CommandListener, Runnable {
    
    /** Creates a new instance of SMSkirim */
    //public String plaintext;
    //public static String ALPHABETS[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",".",",","!","@","£","$","%","&","*","(",")","-","+","_","\n","[","]","{","}",":",";","'","\"","\\","|","/","?",">","<","`","~","1","2","3","4","5","6","7","8","9","0"};
    public static String ALPHABETS[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
    //int umpan
        
    public SMSkirim() {
           //umpan = 0;
           initialize();
    }
    
    private TextBox Inputan;//GEN-BEGIN:MVDFields
    private Command getKunci;
    private Command kembali;
    private Form Kunci;
    private TextField textField1;
    private Command Encrypt1;
    private TextBox Outputan;
    private Form NomorHP;
    private TextField textField2;
    private Command Hslanjut;
    private Command KirimLanjut;
    private Form Status;
    private Command Command8;
    private Command Kembali;
    private Command balikoutput;
    private Command baliknomor;
    private Command keluarstatus;
    private Command okCommand1;
    private Ticker ticker1;//GEN-END:MVDFields
    
//GEN-LINE:MVDMethods

    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
    // Insert global pre-action code here
        String coba;
       double jumlahinput = Inputan.getString().length();
       ticker1.setString(Double.toString(jumlahinput));
       if (displayable == Inputan) {//GEN-BEGIN:MVDCABody
           if (command == getKunci) {//GEN-END:MVDCABody
                // Insert pre-action code here                
               // encrypt(Inputan.getString(),textField1.getString());
               getDisplay().setCurrent(get_Kunci());//GEN-LINE:MVDCAAction5
                // Insert post-action code here
        //        ticker1.setString(Double.toString(jumlahinput));
           }//GEN-BEGIN:MVDCACase5
       } else if (displayable == Kunci) {
           if (command == Encrypt1) {//GEN-END:MVDCACase5
                // Insert pre-action code here
               getDisplay().setCurrent(get_Outputan());//GEN-LINE:MVDCAAction11
                // Insert post-action code here
                Outputan.setString(encrypt(Inputan.getString().toUpperCase(),textField1.getString().toUpperCase()));
           } else if (command == Command8) {//GEN-LINE:MVDCACase11
                // Insert pre-action code here
               getDisplay().setCurrent(get_Outputan());//GEN-LINE:MVDCAAction22
                // Insert post-action code here
                Outputan.setString(decrypt(Inputan.getString().toUpperCase(),textField1.getString().toUpperCase()));
           } else if (command == kembali) {//GEN-LINE:MVDCACase22
                // Insert pre-action code here
               getDisplay().setCurrent(get_Inputan());//GEN-LINE:MVDCAAction24
                // Insert post-action code here
           }//GEN-BEGIN:MVDCACase24
       } else if (displayable == Outputan) {
           if (command == Hslanjut) {//GEN-END:MVDCACase24
                // Insert pre-action code here
               // 
               getDisplay().setCurrent(get_NomorHP());//GEN-LINE:MVDCAAction17
                // Insert post-action code here
           } else if (command == balikoutput) {//GEN-LINE:MVDCACase17
                // Insert pre-action code here
               getDisplay().setCurrent(get_Kunci());//GEN-LINE:MVDCAAction26
                // Insert post-action code here
           }//GEN-BEGIN:MVDCACase26
       } else if (displayable == NomorHP) {
           if (command == KirimLanjut) {//GEN-END:MVDCACase26
                // Insert pre-action code here
                try {
                    getDisplay().setCurrent(get_Status());//GEN-LINE:MVDCAAction19
                new Thread(this).start();
                }
                catch (Exception ex) {
                ex.printStackTrace();
                }
           } else if (command == baliknomor) {//GEN-LINE:MVDCACase19
                // Insert pre-action code here
               getDisplay().setCurrent(get_Outputan());//GEN-LINE:MVDCAAction28
                // Insert post-action code here
           }//GEN-BEGIN:MVDCACase28
       } else if (displayable == Status) {
           if (command == okCommand1) {//GEN-END:MVDCACase28
                // Insert pre-action code here
               // Do nothing//GEN-LINE:MVDCAAction32
                // Insert post-action code here
           }//GEN-BEGIN:MVDCACase32
       }//GEN-END:MVDCACase32
    // Insert global post-action code here
}//GEN-LINE:MVDCAEnd

    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        // Insert pre-init code here
        getDisplay().setCurrent(get_Inputan());//GEN-LINE:MVDInitInit
        // Insert post-init code here
        double jumlah = Inputan.getString().length();
        ticker1.setString(Double.toString(jumlah));
    }//GEN-LINE:MVDInitEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
       // ticker1.setString(Double.toString(jumlahinput)); 
        return Display.getDisplay(this);
    }//GEN-LAST:MVDGetDisplay
    
    /**
     * This method should exit the midlet.
     */
    public void exitMIDlet() {//GEN-FIRST:MVDExitMidlet
        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }//GEN-LAST:MVDExitMidlet

    /** This method returns instance for Inputan component and should be called instead of accessing Inputan field directly.//GEN-BEGIN:MVDGetBegin3
     * @return Instance for Inputan component
     */
    public TextBox get_Inputan() {
        if (Inputan == null) {//GEN-END:MVDGetBegin3
            // Insert pre-init code here
            //double jumlah = Inputan.getString().length();
            Inputan = new TextBox("MASUKAN PESAN", "", 160, TextField.ANY);//GEN-BEGIN:MVDGetInit3
            Inputan.addCommand(get_getKunci());
            Inputan.setCommandListener(this);
            Inputan.setTicker(get_ticker1());//GEN-END:MVDGetInit3
            // Insert post-init code here
            //double jumlah = Inputan.getString().length();
            //ticker1.setString(Double.toString(jumlah));
        }//GEN-BEGIN:MVDGetEnd3
        return Inputan;
    }//GEN-END:MVDGetEnd3

    /** This method returns instance for getKunci component and should be called instead of accessing getKunci field directly.//GEN-BEGIN:MVDGetBegin4
     * @return Instance for getKunci component
     */
    public Command get_getKunci() {
        if (getKunci == null) {//GEN-END:MVDGetBegin4
            // Insert pre-init code here
            getKunci = new Command("Ok", Command.ITEM, 1);//GEN-LINE:MVDGetInit4
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd4
        return getKunci;
    }//GEN-END:MVDGetEnd4

    /** This method returns instance for kembali component and should be called instead of accessing kembali field directly.//GEN-BEGIN:MVDGetBegin6
     * @return Instance for kembali component
     */
    public Command get_kembali() {
        if (kembali == null) {//GEN-END:MVDGetBegin6
            // Insert pre-init code here
            kembali = new Command("Kembali", Command.BACK, 2);//GEN-LINE:MVDGetInit6
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd6
        return kembali;
    }//GEN-END:MVDGetEnd6

    /** This method returns instance for Kunci component and should be called instead of accessing Kunci field directly.//GEN-BEGIN:MVDGetBegin8
     * @return Instance for Kunci component
     */
    public Form get_Kunci() {
        if (Kunci == null) {//GEN-END:MVDGetBegin8
            // Insert pre-init code here
            Kunci = new Form(null, new Item[] {get_textField1()});//GEN-BEGIN:MVDGetInit8
            Kunci.addCommand(get_Encrypt1());
            Kunci.addCommand(get_Command8());
            Kunci.addCommand(get_kembali());
            Kunci.setCommandListener(this);//GEN-END:MVDGetInit8
            // Insert post-init code here
            //encrypt(Inputan.getString(),textField1.getString());
        }//GEN-BEGIN:MVDGetEnd8
        return Kunci;
    }//GEN-END:MVDGetEnd8

    /** This method returns instance for textField1 component and should be called instead of accessing textField1 field directly.//GEN-BEGIN:MVDGetBegin9
     * @return Instance for textField1 component
     */
    public TextField get_textField1() {
        if (textField1 == null) {//GEN-END:MVDGetBegin9
            // Insert pre-init code here
            textField1 = new TextField("Masukkan Kunci", null, 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:MVDGetInit9
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd9
        return textField1;
    }//GEN-END:MVDGetEnd9

    /** This method returns instance for Encrypt1 component and should be called instead of accessing Encrypt1 field directly.//GEN-BEGIN:MVDGetBegin10
     * @return Instance for Encrypt1 component
     */
    public Command get_Encrypt1() {
        if (Encrypt1 == null) {//GEN-END:MVDGetBegin10
            // Insert pre-init code here
            Encrypt1 = new Command("Enkripsi", Command.OK, 1);//GEN-LINE:MVDGetInit10
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd10
        return Encrypt1;
    }//GEN-END:MVDGetEnd10

    /** This method returns instance for Outputan component and should be called instead of accessing Outputan field directly.//GEN-BEGIN:MVDGetBegin13
     * @return Instance for Outputan component
     */
    public TextBox get_Outputan() {
        if (Outputan == null) {//GEN-END:MVDGetBegin13
            // Insert pre-init code here
            Outputan = new TextBox("Hasil", null, 160, TextField.ANY);//GEN-BEGIN:MVDGetInit13
            Outputan.addCommand(get_Hslanjut());
            Outputan.addCommand(get_balikoutput());
            Outputan.setCommandListener(this);//GEN-END:MVDGetInit13
            
        }//GEN-BEGIN:MVDGetEnd13
        return Outputan;
    }//GEN-END:MVDGetEnd13

    /** This method returns instance for NomorHP component and should be called instead of accessing NomorHP field directly.//GEN-BEGIN:MVDGetBegin14
     * @return Instance for NomorHP component
     */
    public Form get_NomorHP() {
        if (NomorHP == null) {//GEN-END:MVDGetBegin14
            // Insert pre-init code here
            NomorHP = new Form(null, new Item[] {get_textField2()});//GEN-BEGIN:MVDGetInit14
            NomorHP.addCommand(get_KirimLanjut());
            NomorHP.addCommand(get_baliknomor());
            NomorHP.setCommandListener(this);//GEN-END:MVDGetInit14
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd14
        return NomorHP;
    }//GEN-END:MVDGetEnd14

    /** This method returns instance for textField2 component and should be called instead of accessing textField2 field directly.//GEN-BEGIN:MVDGetBegin15
     * @return Instance for textField2 component
     */
    public TextField get_textField2() {
        if (textField2 == null) {//GEN-END:MVDGetBegin15
            // Insert pre-init code here
            textField2 = new TextField("Nomor Tujuan", null, 120, TextField.PHONENUMBER);//GEN-LINE:MVDGetInit15
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd15
        return textField2;
    }//GEN-END:MVDGetEnd15

    /** This method returns instance for Hslanjut component and should be called instead of accessing Hslanjut field directly.//GEN-BEGIN:MVDGetBegin16
     * @return Instance for Hslanjut component
     */
    public Command get_Hslanjut() {
        if (Hslanjut == null) {//GEN-END:MVDGetBegin16
            // Insert pre-init code here
            Hslanjut = new Command("Ok", Command.OK, 1);//GEN-LINE:MVDGetInit16
            // Insert post-init code here
            //Outputan.setString(Inputan.getString());
            //Outputan.setString(encrypt(Inputan.getString(),textField1.getString()));
            //Outputan.setString(decrypt(Inputan.getString(),textField1.getString()));
        }//GEN-BEGIN:MVDGetEnd16
        return Hslanjut;
    }//GEN-END:MVDGetEnd16

    /** This method returns instance for KirimLanjut component and should be called instead of accessing KirimLanjut field directly.//GEN-BEGIN:MVDGetBegin18
     * @return Instance for KirimLanjut component
     */
    public Command get_KirimLanjut() {
        if (KirimLanjut == null) {//GEN-END:MVDGetBegin18
            // Insert pre-init code here
            KirimLanjut = new Command("Kirim", Command.OK, 1);//GEN-LINE:MVDGetInit18
            // Insert post-init code 
        }//GEN-BEGIN:MVDGetEnd18
        return KirimLanjut;
    }//GEN-END:MVDGetEnd18

    /** This method returns instance for Status component and should be called instead of accessing Status field directly.//GEN-BEGIN:MVDGetBegin20
     * @return Instance for Status component
     */
    public Form get_Status() {
        if (Status == null) {//GEN-END:MVDGetBegin20
            // Insert pre-init code here
            Status = new Form(null, new Item[0]);//GEN-BEGIN:MVDGetInit20
            Status.addCommand(get_okCommand1());
            Status.setCommandListener(this);//GEN-END:MVDGetInit20
            // Insert post-init code here
            //new Thread(this).start();
        }//GEN-BEGIN:MVDGetEnd20
        return Status;
    }//GEN-END:MVDGetEnd20

    /** This method returns instance for Command8 component and should be called instead of accessing Command8 field directly.//GEN-BEGIN:MVDGetBegin21
     * @return Instance for Command8 component
     */
    public Command get_Command8() {
        if (Command8 == null) {//GEN-END:MVDGetBegin21
            // Insert pre-init code here
            Command8 = new Command("Dekripsi", Command.OK, 1);//GEN-LINE:MVDGetInit21
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd21
        return Command8;
    }//GEN-END:MVDGetEnd21

    /** This method returns instance for Kembali component and should be called instead of accessing Kembali field directly.//GEN-BEGIN:MVDGetBegin23
     * @return Instance for Kembali component
     */
    public Command get_Kembali() {
        if (Kembali == null) {//GEN-END:MVDGetBegin23
            // Insert pre-init code here
            Kembali = new Command("Back", Command.BACK, 1);//GEN-LINE:MVDGetInit23
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd23
        return Kembali;
    }//GEN-END:MVDGetEnd23

    /** This method returns instance for balikoutput component and should be called instead of accessing balikoutput field directly.//GEN-BEGIN:MVDGetBegin25
     * @return Instance for balikoutput component
     */
    public Command get_balikoutput() {
        if (balikoutput == null) {//GEN-END:MVDGetBegin25
            // Insert pre-init code here
            balikoutput = new Command("Kembali", Command.BACK, 1);//GEN-LINE:MVDGetInit25
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd25
        return balikoutput;
    }//GEN-END:MVDGetEnd25

    /** This method returns instance for baliknomor component and should be called instead of accessing baliknomor field directly.//GEN-BEGIN:MVDGetBegin27
     * @return Instance for baliknomor component
     */
    public Command get_baliknomor() {
        if (baliknomor == null) {//GEN-END:MVDGetBegin27
            // Insert pre-init code here
            baliknomor = new Command("Kembali", Command.BACK, 1);//GEN-LINE:MVDGetInit27
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd27
        return baliknomor;
    }//GEN-END:MVDGetEnd27

    /** This method returns instance for keluarstatus component and should be called instead of accessing keluarstatus field directly.//GEN-BEGIN:MVDGetBegin29
     * @return Instance for keluarstatus component
     */
    public Command get_keluarstatus() {
        if (keluarstatus == null) {//GEN-END:MVDGetBegin29
            // Insert pre-init code here
            keluarstatus = new Command("keluar", Command.OK, 1);//GEN-LINE:MVDGetInit29
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd29
        return keluarstatus;
    }//GEN-END:MVDGetEnd29

    /** This method returns instance for okCommand1 component and should be called instead of accessing okCommand1 field directly.//GEN-BEGIN:MVDGetBegin31
     * @return Instance for okCommand1 component
     */
    public Command get_okCommand1() {
        if (okCommand1 == null) {//GEN-END:MVDGetBegin31
            // Insert pre-init code here
            okCommand1 = new Command("Keluar", Command.OK, 1);//GEN-LINE:MVDGetInit31
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd31
        return okCommand1;
    }//GEN-END:MVDGetEnd31

    /** This method returns instance for ticker1 component and should be called instead of accessing ticker1 field directly.//GEN-BEGIN:MVDGetBegin33
     * @return Instance for ticker1 component
     */
    public Ticker get_ticker1() {
        if (ticker1 == null) {//GEN-END:MVDGetBegin33
            // Insert pre-init code here
            ticker1 = new Ticker("");//GEN-LINE:MVDGetInit33
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd33
        return ticker1;
    }//GEN-END:MVDGetEnd33
    
    public void startApp() {

    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void run(){
     double jumlahinput = Inputan.getString().length();
     ticker1.setString(Double.toString(jumlahinput));
     String alamat = "sms://"+textField2.getString()+":50000";
     MessageConnection address = null;
                try    {
               // address = (MessageConnection)Connector.open(alamat);
                    address = (MessageConnection)Connector.open(alamat);
                    try{
                    TextMessage pesanpendek = (TextMessage)address.newMessage(MessageConnection.TEXT_MESSAGE);
                    pesanpendek.setAddress(alamat);
                    pesanpendek.setPayloadText(Outputan.getString());
                    address.send(pesanpendek);
                    }
                    finally {
                    address.close();
                    }
                }
                catch (Throwable t) {
                System.out.println("tertangkap");
                t.printStackTrace();
                }
                
                
                if (address != null) {
            try {
                address.close();
            } catch (IOException ioe) {
                System.out.println("Menutup Koneksi: ");
                ioe.printStackTrace();
            }
        }      
    
    }
    
    private int getAlphabetPosition(String alphabet,String[] array)
    {
         for(int i=0;i<array.length;i++)
         { 
           if(alphabet.equals(array[i]))
               return i;
         }
         return -1;
    }
    
    private String[] getNextAlphabets(String posisiAwal)
    {
       int startPos = this.getAlphabetPosition(posisiAwal,this.ALPHABETS);
            if(startPos == -1)
            {
                System.out.println("karakter tidak dikenal -> "+ posisiAwal);
                return null;
            }
        String[] hasil = new String[ALPHABETS.length];
        for(int i=0;i<hasil.length;i++)
        {
            hasil[i] = ALPHABETS[(i+startPos)%ALPHABETS.length];  
        }
        return hasil;
    }
    
    private String[][] getRows(String key)
    {
        String rows[][] = new String[key.length()][ALPHABETS.length];
        for(int i=0;i<rows.length;i++)
        {
            for(int j=0;j<rows[i].length;j++)
            {
                String[] row = getNextAlphabets(""+key.charAt(i));
                for(int k=0;k<row.length;k++)
                {
                    rows[i][k] = row[k];
                }                
            }            
        }
        return rows;
    }
    
    private String encrypt(String msg,String key)
    { 
        double waktuawal = System.currentTimeMillis();
        int keySize = key.length();
        String result = "";
        String rows[][] = getRows(key);
        int counter = 0;
        for(int i=0;i<msg.length();i++)
        {
            if(!" ".equals(""+msg.charAt(i)))
            {
                String alpha = ""+msg.charAt(i);
                int alphaPos = this.getAlphabetPosition(alpha, SMSkirim.ALPHABETS);
                if(alphaPos == -1)
                {
                    System.out.println("karakter tidak dikenal-> "+ alpha);
                    return null;
                }
                result = result+rows[counter++][alphaPos];
                counter = counter == keySize?0:counter;
            }
            else result+=" ";
            
        }
        double waktuakhir = System.currentTimeMillis();
        System.out.println(waktuakhir-waktuawal);
        return result;
    }
    
    private String decrypt(String msg,String key)
    {
        double waktuawal = System.currentTimeMillis();
        int keySize = key.length();
        String result = "";
        String[][] rows = this.getRows(key);
        if(msg == null)
        {
            System.out.println("pesan kosong");
            return null;
        }
        int counter = 0;
        for(int i=0;i<msg.length();i++)
        {
            if(!" ".equals(""+msg.charAt(i)))
            {
            int pos = this.getAlphabetPosition(""+msg.charAt(i), rows[counter++]);
            if(pos == -1)
            {
                System.out.println("pesan tidak terbaca");
                return null;
            }
            result+= ALPHABETS[pos];
            counter = counter == keySize?0:counter;
            }
            else
            result+=" ";
            
        }
        double waktuakhir = System.currentTimeMillis();
        System.out.println(waktuakhir-waktuawal);
        return result;
    }
    
}
