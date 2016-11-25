/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_chat.Cote_Server.Cote_Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.IsSaM.l
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Socket sc = null ;
        try {
            // TODO code application logic here
             sc = new Socket("127.0.0.1",9999);
            Scanner in = new Scanner(System.in);
            PrintStream pr = new PrintStream(sc.getOutputStream());
            Scanner inServer = new Scanner(sc.getInputStream());
            String rep = null ;
            while ( true )
            {
                if(in.hasNext())
                { rep = in.nextLine();
                pr.print(rep);
                }
                System.out.println(inServer.nextLine());
                
                
            }
          
        } catch (IOException ex) {
            Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally { try {
            sc.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
        
    }
    
}
