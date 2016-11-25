/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_socket_1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author l.IsSaM.l
 */
public class ProverbeDuJour {
    
    public static void main(String str[]) throws IOException
    {
         String[] proverbe = {
                                        "Quand la pauvrete entre par la porte, l'amour s'en va par la fenetre"  ,
                                        "On ne peut empecher le chien d'aboyer, ni le menteur de mentir" ,
                                        "Aime-toi et tu auras des amis" ,
                                        "Un bon pere de famille doit être partout, Dernier couche premier debout" ,
                                        "La douceur du miel ne console pas de la piqûre de l'abeille" ,
                                        "Avec du temps et de la patience, on vient a bout de tout" ,
                                        "Vieille amitie ne craint pas la rouille" ,
                                        "Il n'y a pas de grenouille qui ne trouve son crapaud" ,
                                        "Plus on desire une chose, plus elle se fait attendre" ,
                                        "Celui qui seme l'injustice moissonne le malheur"
                              };
         
         ServerSocket sock = new ServerSocket(9002);
         int i = 0 ;
         System.out.println(" Server Démarré ");
         while(true)
         {
             Socket sc = sock.accept();
             System.out.println(" Nouveau Client");
             PrintStream pr = new PrintStream(sc.getOutputStream());
             pr.print(proverbe[ i++ % proverbe.length ]);
             sc.close();
         }
         
         
        
        
        
    }
    
}
