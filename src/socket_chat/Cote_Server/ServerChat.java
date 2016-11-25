/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_chat.Cote_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author l.IsSaM.l
 */
public class ServerChat {
    
    protected static LinkedList<Socket> listeClients;

    public ServerChat() 
    {
        
        listeClients = new LinkedList<Socket>();
    }
    
    
        public static void main(String[] args) throws IOException {
    
           ServerSocket listner = null ;
        try {
             listner = new ServerSocket(9999);
            } catch (IOException ex) {
            System.out.println("Erreur Creation SOcket");
          }
        
            System.out.println(" Server Demarre ");
            new ServerChat();

        while(true)
        {
            Socket sc = listner.accept();
            listeClients.add(sc);
            Thread T = new Thread(new Client(sc));
            T.start();    
            
        }
        
        
}
    
    
    
}
