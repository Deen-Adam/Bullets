/*
 * SMSterima.java
 *
 * Created on 22 Januari 2008, 20:46
 */

package cobasms;


import javax.microedition.midlet.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.*;

import java.io.IOException;

/**
 *
 * @author PKM
 */
public class SMSterima extends MIDlet 
        implements CommandListener, Runnable, MessageListener{
    
    /** Creates a new instance of SMSterima */
    public static String ALPHABETS[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
    
    MessageConnection smsconn;
 
    String[] connections;
    
    boolean done;
    
    Thread thread;
    
    Message msg;
    
    String senderAddress;
    
    Alert content;
    
    Display display;
    
    //Command replyCommand = new Command("Reply", Command.OK, 1);
    
    public SMSterima() {
        initialize();
    }
    
    private TextBox Terima;//GEN-BEGIN:MVDFields
    private Form Kunci;
    private TextField KunciPesan;
    private TextBox Hasil;
    private Form Kirim;
    private TextField textField2;
    private Form form3;
    private Command okCommand1;
    private Command okCommand2;
    private Command okCommand3;
    private Command okCommand4;
    private Command okCommand5;
    private Command okCommand6;
    private TextBox BALASAN;
    private Command okCommand7;
    private Command okCommand8;//GEN-END:MVDFields
    
//GEN-LINE:MVDMethods

    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
    // Insert global pre-action code here
        if (displayable == Kunci) {//GEN-BEGIN:MVDCABody
            if (command == okCommand3) {//GEN-END:MVDCABody
                // Insert pre-action code here
                getDisplay().setCurrent(get_Hasil());//GEN-LINE:MVDCAAction14
                // Insert post-action code here
                Hasil.setString(encrypt(Terima.getString().toUpperCase(),KunciPesan.getString().toUpperCase()));
            } else if (command == okCommand6) {//GEN-LINE:MVDCACase14
                // Insert pre-action code here
                getDisplay().setCurrent(get_Hasil());//GEN-LINE:MVDCAAction22
                // Insert post-action code here
                Hasil.setString(decrypt(Terima.getString().toUpperCase(), KunciPesan.getString().toUpperCase()));
            }//GEN-BEGIN:MVDCACase22
        } else if (displayable == Kirim) {
            if (command == okCommand5) {//GEN-END:MVDCACase22
                // Insert pre-action code here
                getDisplay().setCurrent(get_form3());//GEN-LINE:MVDCAAction18
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase18
        } else if (displayable == Terima) {
            if (command == okCommand1) {//GEN-END:MVDCACase18
                // Insert pre-action code here
                getDisplay().setCurrent(get_Kunci());//GEN-LINE:MVDCAAction10
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase10
        } else if (displayable == Hasil) {
            if (command == okCommand4) {//GEN-END:MVDCACase10
                // Insert pre-action code here
                getDisplay().setCurrent(get_BALASAN());//GEN-LINE:MVDCAAction16
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase16
        } else if (displayable == BALASAN) {
            if (command == okCommand7) {//GEN-END:MVDCACase16
                // Insert pre-action code here
                getDisplay().setCurrent(get_Kirim());//GEN-LINE:MVDCAAction25
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase25
        } else if (displayable == form3) {
            if (command == okCommand8) {//GEN-END:MVDCACase25
                // Insert pre-action code here
                exitMIDlet();//GEN-LINE:MVDCAAction27
                // Insert post-action code here
            }//GEN-BEGIN:MVDCACase27
        }//GEN-END:MVDCACase27
    // Insert global post-action code here
        
}//GEN-LINE:MVDCAEnd

    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        // Insert pre-init code here
        getDisplay().setCurrent(get_Terima());//GEN-LINE:MVDInitInit
        // Insert post-init code here
    }//GEN-LINE:MVDInitEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
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

    /** This method returns instance for Terima component and should be called instead of accessing Terima field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for Terima component
     */
    public TextBox get_Terima() {
        if (Terima == null) {//GEN-END:MVDGetBegin2
            // Insert pre-init code here
            Terima = new TextBox(null, null, 160, TextField.ANY);//GEN-BEGIN:MVDGetInit2
            Terima.addCommand(get_okCommand1());
            Terima.setCommandListener(this);//GEN-END:MVDGetInit2
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd2
        return Terima;
    }//GEN-END:MVDGetEnd2

    /** This method returns instance for Kunci component and should be called instead of accessing Kunci field directly.//GEN-BEGIN:MVDGetBegin3
     * @return Instance for Kunci component
     */
    public Form get_Kunci() {
        if (Kunci == null) {//GEN-END:MVDGetBegin3
            // Insert pre-init code here
            Kunci = new Form(null, new Item[] {get_KunciPesan()});//GEN-BEGIN:MVDGetInit3
            Kunci.addCommand(get_okCommand3());
            Kunci.addCommand(get_okCommand6());
            Kunci.setCommandListener(this);//GEN-END:MVDGetInit3
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd3
        return Kunci;
    }//GEN-END:MVDGetEnd3

    /** This method returns instance for KunciPesan component and should be called instead of accessing KunciPesan field directly.//GEN-BEGIN:MVDGetBegin4
     * @return Instance for KunciPesan component
     */
    public TextField get_KunciPesan() {
        if (KunciPesan == null) {//GEN-END:MVDGetBegin4
            // Insert pre-init code here
            KunciPesan = new TextField("MASUKKAN KUNCI", null, 32, TextField.ANY | TextField.PASSWORD);//GEN-LINE:MVDGetInit4
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd4
        return KunciPesan;
    }//GEN-END:MVDGetEnd4

    /** This method returns instance for Hasil component and should be called instead of accessing Hasil field directly.//GEN-BEGIN:MVDGetBegin5
     * @return Instance for Hasil component
     */
    public TextBox get_Hasil() {
        if (Hasil == null) {//GEN-END:MVDGetBegin5
            // Insert pre-init code here
            Hasil = new TextBox("HASIL", null, 160, TextField.ANY);//GEN-BEGIN:MVDGetInit5
            Hasil.addCommand(get_okCommand4());
            Hasil.setCommandListener(this);//GEN-END:MVDGetInit5
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd5
        return Hasil;
    }//GEN-END:MVDGetEnd5

    /** This method returns instance for Kirim component and should be called instead of accessing Kirim field directly.//GEN-BEGIN:MVDGetBegin6
     * @return Instance for Kirim component
     */
    public Form get_Kirim() {
        if (Kirim == null) {//GEN-END:MVDGetBegin6
            // Insert pre-init code here
            Kirim = new Form(null, new Item[] {get_textField2()});//GEN-BEGIN:MVDGetInit6
            Kirim.addCommand(get_okCommand5());
            Kirim.setCommandListener(this);//GEN-END:MVDGetInit6
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd6
        return Kirim;
    }//GEN-END:MVDGetEnd6

    /** This method returns instance for textField2 component and should be called instead of accessing textField2 field directly.//GEN-BEGIN:MVDGetBegin7
     * @return Instance for textField2 component
     */
    public TextField get_textField2() {
        if (textField2 == null) {//GEN-END:MVDGetBegin7
            // Insert pre-init code here
            textField2 = new TextField("NOMOR TUJUAN", null, 120, TextField.PHONENUMBER);//GEN-LINE:MVDGetInit7
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd7
        return textField2;
    }//GEN-END:MVDGetEnd7

    /** This method returns instance for form3 component and should be called instead of accessing form3 field directly.//GEN-BEGIN:MVDGetBegin8
     * @return Instance for form3 component
     */
    public Form get_form3() {
        if (form3 == null) {//GEN-END:MVDGetBegin8
            // Insert pre-init code here
            form3 = new Form(null, new Item[0]);//GEN-BEGIN:MVDGetInit8
            form3.addCommand(get_okCommand8());
            form3.setCommandListener(this);//GEN-END:MVDGetInit8
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd8
        return form3;
    }//GEN-END:MVDGetEnd8

    /** This method returns instance for okCommand1 component and should be called instead of accessing okCommand1 field directly.//GEN-BEGIN:MVDGetBegin9
     * @return Instance for okCommand1 component
     */
    public Command get_okCommand1() {
        if (okCommand1 == null) {//GEN-END:MVDGetBegin9
            // Insert pre-init code here
            okCommand1 = new Command("Balas", Command.OK, 1);//GEN-LINE:MVDGetInit9
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd9
        return okCommand1;
    }//GEN-END:MVDGetEnd9

    /** This method returns instance for okCommand2 component and should be called instead of accessing okCommand2 field directly.//GEN-BEGIN:MVDGetBegin11
     * @return Instance for okCommand2 component
     */
    public Command get_okCommand2() {
        if (okCommand2 == null) {//GEN-END:MVDGetBegin11
            // Insert pre-init code here
            okCommand2 = new Command("Enkripsi", Command.OK, 2);//GEN-LINE:MVDGetInit11
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd11
        return okCommand2;
    }//GEN-END:MVDGetEnd11

    /** This method returns instance for okCommand3 component and should be called instead of accessing okCommand3 field directly.//GEN-BEGIN:MVDGetBegin13
     * @return Instance for okCommand3 component
     */
    public Command get_okCommand3() {
        if (okCommand3 == null) {//GEN-END:MVDGetBegin13
            // Insert pre-init code here
            okCommand3 = new Command("Enkripsi", Command.OK, 1);//GEN-LINE:MVDGetInit13
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd13
        return okCommand3;
    }//GEN-END:MVDGetEnd13

    /** This method returns instance for okCommand4 component and should be called instead of accessing okCommand4 field directly.//GEN-BEGIN:MVDGetBegin15
     * @return Instance for okCommand4 component
     */
    public Command get_okCommand4() {
        if (okCommand4 == null) {//GEN-END:MVDGetBegin15
            // Insert pre-init code here
            okCommand4 = new Command("Lanjut", Command.OK, 1);//GEN-LINE:MVDGetInit15
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd15
        return okCommand4;
    }//GEN-END:MVDGetEnd15

    /** This method returns instance for okCommand5 component and should be called instead of accessing okCommand5 field directly.//GEN-BEGIN:MVDGetBegin17
     * @return Instance for okCommand5 component
     */
    public Command get_okCommand5() {
        if (okCommand5 == null) {//GEN-END:MVDGetBegin17
            // Insert pre-init code here
            okCommand5 = new Command("kirim", Command.OK, 1);//GEN-LINE:MVDGetInit17
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd17
        return okCommand5;
    }//GEN-END:MVDGetEnd17
 
    /** This method returns instance for okCommand6 component and should be called instead of accessing okCommand6 field directly.//GEN-BEGIN:MVDGetBegin21
     * @return Instance for okCommand6 component
     */
    public Command get_okCommand6() {
        if (okCommand6 == null) {//GEN-END:MVDGetBegin21
            // Insert pre-init code here
            okCommand6 = new Command("Dekripsi", Command.OK, 1);//GEN-LINE:MVDGetInit21
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd21
        return okCommand6;
    }//GEN-END:MVDGetEnd21

    /** This method returns instance for BALASAN component and should be called instead of accessing BALASAN field directly.//GEN-BEGIN:MVDGetBegin23
     * @return Instance for BALASAN component
     */
    public TextBox get_BALASAN() {
        if (BALASAN == null) {//GEN-END:MVDGetBegin23
            // Insert pre-init code here
            BALASAN = new TextBox("Masukkan Balasan Teks", null, 160, TextField.ANY);//GEN-BEGIN:MVDGetInit23
            BALASAN.addCommand(get_okCommand7());
            BALASAN.setCommandListener(this);//GEN-END:MVDGetInit23
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd23
        return BALASAN;
    }//GEN-END:MVDGetEnd23

    /** This method returns instance for okCommand7 component and should be called instead of accessing okCommand7 field directly.//GEN-BEGIN:MVDGetBegin24
     * @return Instance for okCommand7 component
     */
    public Command get_okCommand7() {
        if (okCommand7 == null) {//GEN-END:MVDGetBegin24
            // Insert pre-init code here
            okCommand7 = new Command("Lanjut", Command.OK, 1);//GEN-LINE:MVDGetInit24
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd24
        return okCommand7;
    }//GEN-END:MVDGetEnd24

    /** This method returns instance for okCommand8 component and should be called instead of accessing okCommand8 field directly.//GEN-BEGIN:MVDGetBegin26
     * @return Instance for okCommand8 component
     */
    public Command get_okCommand8() {
        if (okCommand8 == null) {//GEN-END:MVDGetBegin26
            // Insert pre-init code here
            okCommand8 = new Command("keluar", Command.OK, 1);//GEN-LINE:MVDGetInit26
            // Insert post-init code here
        }//GEN-BEGIN:MVDGetEnd26
        return okCommand8;
    }//GEN-END:MVDGetEnd26
    
       public void startApp() {
        String koneksisms = "sms://:50000";
        
        if (smsconn == null) {
            try 
            {
                smsconn = (MessageConnection) Connector.open(koneksisms);
                smsconn.setMessageListener(this);
                              
            } 
            catch (IOException ioe) 
            {
                ioe.printStackTrace();
            }
        }
        done = false;
        thread = new Thread(this);
        thread.start();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void notifyIncomingMessage(MessageConnection conn) {
         if (thread == null) {
            done = false;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public void run(){
        try {
            msg = smsconn.receive();
            if (msg != null) {
                senderAddress = msg.getAddress();
                Terima.setTitle("Dari: "+senderAddress);
                if (msg instanceof TextMessage) 
                {
                    Terima.setString(((TextMessage)msg).getPayloadText());
                } 
               // else 
               // {
               // }
                //content.addCommand(replyCommand);
                //display.setCurrent(content);
                //form1.addCommand(get_okCommand1());
                //display.setCurrent(form1);
                //getDisplay().setCurrent(get_Terima());
            }
        } catch (IOException e) {
             e.printStackTrace();
        }
               
}
    
    private int getAlphabetPosition(String alphabet, String[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            if(alphabet.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }
    
    private String[] getNextAlphabets(String posisiAwal)
    {
        int startpos = this.getAlphabetPosition(posisiAwal, this.ALPHABETS);
        if (startpos == -1)
        {
            System.out.println("karakter tidak dikenal"+posisiAwal);
        }
        String[] hasil = new String[ALPHABETS.length];
        for (int i=0; i<hasil.length; i++)
        {
            hasil[i] = ALPHABETS[(i+startpos)%ALPHABETS.length];
        }
        return hasil;
    }
    
    private String[][] getRows(String key)
    {
        String[][] rows = new String[key.length()][ALPHABETS.length];
        for(int i=0; i<rows.length; i++)
        {
            for (int j=0; j<rows[i].length; j++)
            {
                String[] row = this.getNextAlphabets(""+key.charAt(i));
                for(int k=0 ; k<row.length; k++)
                {
                    rows[i][k] = row[k];
                }
            }
        }
        return rows;
    }
    
     private String encrypt(String msg,String key){ 
        double waktuawal = System.currentTimeMillis();
        int keySize = key.length();
        String result = "";
        String rows[][] = getRows(key);
        int counter = 0;
        for(int i=0;i<msg.length();i++){
            if(!" ".equals(""+msg.charAt(i))){
                String alpha = ""+msg.charAt(i);
                int alphaPos = this.getAlphabetPosition(alpha, SMSkirim.ALPHABETS);
                if(alphaPos == -1){
                    System.out.println("Karakter ilegal-> "+ alpha);
                    return null;
                }
                result = result+rows[counter++][alphaPos];
                counter = counter == keySize?0:counter;
                System.out.println(counter);
            }
            else result+=" ";
            
        }
        double waktuakhir = System.currentTimeMillis();
        System.out.println(waktuakhir-waktuawal);
        return result;
    }
    
    private String decrypt(String msg,String key){
        double waktuawal = System.currentTimeMillis();
        int keySize = key.length();
        String result = "";
        String[][] rows = this.getRows(key);
        if(msg == null){
            System.out.println("string null");
            return null;
        }
        int counter = 0;
        for(int i=0;i<msg.length();i++){
            if(!" ".equals(""+msg.charAt(i))){
            int pos = this.getAlphabetPosition(""+msg.charAt(i), rows[counter++]);
            if(pos == -1){
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
