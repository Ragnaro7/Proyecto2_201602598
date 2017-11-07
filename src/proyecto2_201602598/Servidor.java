/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201602598;

/**
 *
 * @author Hector
 */
public class Servidor {
 
public static String[] server=new String[500];
private int contadorserver=0;

    public Servidor(){
        //server=new String[500];
        //contadorserver=0;
    }
 public void reiniciarcont(){
     contadorserver=0;
 }   
 public void setServer(int i){
     server[i]=null;
 }   
 public void setServer(String noserver,String siguiente,String x,String y,String alto,String ancho,
            String tiempo){
        server[contadorserver]=noserver+";"+siguiente+";"+x+";"+y+";"+alto+";"+ancho+";"+tiempo;
        contadorserver++;
    }
 
 public String[] obServer(){
    return server;
}
 
 public String obServer2(int i){
     return server[i];
 }
 
 public int oblong(){
     return server.length;
 }
 
 public void imprimir(){
     for(String e:server){
         if(e!=null)
         System.out.println(e);
     }
 }


}
