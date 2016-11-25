/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_socket_1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.IsSaM.l
 */
public class Client implements Runnable{
    
    Socket sc ;
    
    
    public Client(Socket s)
    {
        sc = s ;
    }
    
    public void run()
    {
         System.out.println(" Thread "+Thread.currentThread().getName()+" Creee ");
            PrintStream pr = null;
        try {
            pr = new PrintStream(sc.getOutputStream());
        
            pr.print("HTTP/1.0 200 OK\n\n"+TP_SOCKET_2.getMessage("index.html"));
            
            pr.close();
            
           }  catch (IOException ex) {
         
        }
       
        
        
      
    }
}
