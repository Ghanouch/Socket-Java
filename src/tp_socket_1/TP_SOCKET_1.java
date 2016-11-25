/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_socket_1;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.IsSaM.l
 */
public class TP_SOCKET_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listner = null ;
        String message = "<HTML><TITLE>Mon serveur</TITLE>Cette page a été envoyée par mon <B>Serveur\n" ;
        try {
             listner = new ServerSocket(8006);
            } catch (IOException ex) {
            System.out.println("Erreur Creation SOcket");
        }

        while(true)
        {
            Socket sc = listner.accept();
            System.out.println(" Client venu ");
            PrintStream pr = new PrintStream(sc.getOutputStream());
            pr.print("HTTP/1.0 200 OK\n\n"+message);
            sc.close();
            
            
        }
        
    }
    
}
