/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_socket_1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.IsSaM.l
 * 
 * 
 * 
 */


   
public class TP_SOCKET_2 {
    
    public static String getMessage(String nomFichier)
{

   String contenu = null ;
    BufferedReader sc = null ;
   
        try {
            sc = new BufferedReader(new FileReader(nomFichier));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TP_SOCKET_2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        try {
            
            contenu = sc.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TP_SOCKET_2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     return contenu;

   
 
}
    public static void main(String[] args) throws IOException {
    
           ServerSocket listner = null ;
       // String message = getMessage("index.html");
        try {
             listner = new ServerSocket(8070);
            } catch (IOException ex) {
            System.out.println("Erreur Creation SOcket");
        }

        while(true)
        {
            Socket sc = listner.accept();
            Thread T = new Thread(new Client(sc));
            T.start();
            
            
        }
        
        
}
    
}
