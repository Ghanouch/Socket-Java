/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_chat.Cote_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp_socket_1.TP_SOCKET_2;

/**
 *
 * @author l.IsSaM.l
 */
public class Client implements Runnable{
    
    Socket sc ;
    
    public Client(Socket sc) {
        this.sc = sc;
    }
    
    
    public void BroadCasting(String msg) 
    {
        
        PrintStream pr = null ;
     
        for ( Socket ssc : ServerChat.listeClients )
        {
            if(! sc.equals(ssc))
            {
                try {
                    pr = new PrintStream(ssc.getOutputStream());
                } catch (IOException ex) {
                    System.out.println(" Erreur du BroadCasting Message");
                }
              pr.print("\nMESSAGE RECU  : "+msg+"\n");
            }
        }
        
    }
    
    
    public void run()
    {
        try{
         System.out.println(" Thread "+Thread.currentThread().getName()+" Creee ");
         PrintStream pr = new PrintStream(sc.getOutputStream());
         Scanner in = new Scanner(sc.getInputStream());
      
         while(true)
         {
             pr.print(" Envoyer votre Message \n");
             BroadCasting(in.nextLine());
             
             
         }
         
         
          }
        catch(Exception e)
      {
        System.out.println("Erreu run du thread " + e.getMessage());  
      }
       finally {  try {
           sc.close();
            } catch (IOException ex) {
               
            }
              }
      
    }
    
    
}
    
