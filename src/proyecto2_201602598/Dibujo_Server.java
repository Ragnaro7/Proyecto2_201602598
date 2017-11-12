/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201602598;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hector
 */
public class Dibujo_Server extends JFrame{
    
  //  private Capa_Server fig;
    
    public Dibujo_Server(){
        setTitle("Dibujito");
        setSize(1000,600);
        this.setLocationRelativeTo(null);
        Capa_Server fig=new Capa_Server();
        add(fig);
    }
    
}

class Capa_Server extends JPanel implements Runnable{
 //   private Servidor ser;
    //private double x,y,w,h;
    //private int au=getWidth()/2;
    Pantalla palla=new Pantalla();
   static int can1=0;
   static int can2=0;
    static int can3=0;
    int tiempo=5;
    int a = 50;
    int b = 50-120;
    int c = 50-220;
    int d=50-300;
    String aviso1="";
    String aviso2="";
    String aviso3="";
    private int cola1=0;
    private int cola2=0;
    private int cola3=0;
    private int au=5;
    private String[] arr;
     Thread hilo;
     static int atendido=0;
   /* public Capa_Server(String x1,String y1,String w1,String h1){
        x=Double.parseDouble(x1);
        y=Double.parseDouble(y1);
        w=Double.parseDouble(w1);
        h=Double.parseDouble(h1);
    //    ser=new Servidor();
    }*/
     public Capa_Server(){
       //  ser=new Servidor();
      hilo=new Thread(this);
       hilo.start();
     }
     
     public void detener(){
         hilo.interrupt();
     }
     
     public int generarTipo(){
         Random r=new Random();
         return 1+r.nextInt(3);
     }
     
     public int generarCantidad(){
         Random ra=new Random();
         return 1+ra.nextInt(4);
     }
     public int obCan1(){
         return can1;
     }
     
     public int obCan2(){
         return can2;
     }
     
     public int obCan3(){
         return can3;
     }
     
     public void realizarPedido(int au){
         switch(au){
                             case 1:
                                 can1+=generarCantidad();
                                 break;
                             case 2:
                                 can2+=generarCantidad();
                                 break;
                                 
                             case 3:
                                 can3+=generarCantidad();
                                 break;
                         }
     }
     
     public int Atendidos(){
         return atendido;
     }
     
     public void arreglo(String[] r){
         arr=r;
     }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        Servidor ser=new Servidor();
        Personas per=new Personas();
        for(int i=0;i<ser.oblong();i++){
        
         //String aux=ser.obServer2(i);
         String aux=ser.obServer()[i];   
         if(aux!=null){
                String [] coo=aux.split(";");
                 Rectangle2D rectangulo=new Rectangle2D.Double(
                         Double.parseDouble(coo[2]),
                         Double.parseDouble(coo[3]),
                         Double.parseDouble(coo[4]),
                         Double.parseDouble(coo[5]));
               g2.setColor(Color.BLUE);
        g2.fill(rectangulo);
        
        int posx[]={Integer.parseInt(coo[2])+70,Integer.parseInt(coo[2])+35,
            Integer.parseInt(coo[2])+90};
        
        int posy[]={Integer.parseInt(coo[3])+20,Integer.parseInt(coo[3])+60,
        Integer.parseInt(coo[3])+60};
        
        if(coo[0].equals("1")){
            g2.drawString(aviso1, Integer.parseInt(coo[2]),Integer.parseInt(coo[3])-10);
              if(cola1!=0){
            g2.drawString(String.valueOf(cola1), posx[0], posy[0]-20);
        }
        }else if(coo[0].equals("2")){
            g2.drawString(aviso2, Integer.parseInt(coo[2]),Integer.parseInt(coo[3])-10);
              if(cola2!=0){
            g2.drawString(String.valueOf(cola2), posx[0], posy[0]-20);
        }
        }else if(coo[0].equals("3")){
            g2.drawString(aviso3, Integer.parseInt(coo[2]),Integer.parseInt(coo[3])-10);
              if(cola3!=0){
            g2.drawString(String.valueOf(cola3), posx[0], posy[0]-20);
        }
        }
      
        
        g2.setColor(Color.GREEN);
        g2.fillPolygon(posx, posy, 3);
               // System.out.println(i+","+Arrays.toString(coo));
            }//else{
               // System.out.println(ser.obServer2(i)+i);
          //  }    
            
            
            
            
        //Rectangle2D rectangulo=new Rectangle2D.Double(x, y, w, h);
     
        }
        
        //PERSONAS
        for(int i=0;i<per.oblonper();i++){
            String aux=per.obPersonas()[i];
            if(aux!=null){
                String [] coo= aux.split(";");
                g2.setColor(Color.YELLOW);
                int radio=Integer.parseInt(coo[4]);
                
               // int auxx=Integer.parseInt(coo[0]);
              // a =Integer.parseInt(coo[0]);
               //b=Integer.parseInt(coo[0]);
               //c=Integer.parseInt(coo[0]);
               
               g2.fillOval(a, Integer.parseInt(coo[1]), radio*2,radio*2);
                g2.fillOval(b, Integer.parseInt(coo[1]), radio*2,radio*2);
                g2.fillOval(c, Integer.parseInt(coo[1]), radio*2,radio*2);
                g2.fillOval(d, Integer.parseInt(coo[1]), radio*2,radio*2);
            }
        }
       
    }

    @Override
    public void run() {
        HiloInventario hilito=new HiloInventario();
                         hilito.qewr();
        try{
              while(true){
        while (a < 200) {
            Thread.sleep(tiempo);
                    a += 20;
                    b += 20;
                    c += 20;
                    d+=20;
                    repaint();
                    if(a==190){
                       
                        aviso1="Cola";
                        cola1++;
                         Thread.sleep(5000);
                         System.out.println("cola1 llego");
                         
                         aviso1="";
                         //a+=20;
                       cola1=0;
                        a+=20;
                         repaint();
                         int auxinu=generarTipo();
                         realizarPedido(auxinu);
                         
                    }
                }
//                while (x < 200) {
//                    Thread.sleep(500);
//                    x += 117;
//                    repaint();
//                }
                while (b < 200) {
                     Thread.sleep(tiempo);
                    a += 20;
                    b += 20;
                    c += 20;
                    d+=20;
                    repaint();
                      if(b==190){
                          a+=20;
                          c+=20;
                          d+=20;
                          cola1++;
                        aviso1="Cola";
                        cola1++;
                         Thread.sleep(5000);
                         System.out.println("Cola2 llego");
                         cola1=0;
                         b+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
               //          aviso2="";
                         //a+=20;
            //            cola2--;
                    }
                    
                }

                while (c < 200) {
                    Thread.sleep(tiempo);
                    a += 20;
                    b += 20;
                    c += 20;
                    d+=20;
                    repaint();
                    if(c==190){
                        aviso1="Cola";
                        cola1++;
                         Thread.sleep(5000);
                         System.out.println("cola c llego a 1");
                         c+=20;
                         cola1--;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                 //        aviso3="";
                         //a+=20;
                 //      cola3--;
                    }
                    if(a==370 ){
                          aviso2="Cola";
                        cola2++;
                         repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaA llego a 2");
                         cola2--;
                         a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                    }
                }
                while (d < 200) {
                    Thread.sleep(tiempo);
                    d += 20;
                    a+=20;
                    b+=20;
                    c+=20;
                   repaint();
                    if(d==190){
                       aviso1="Cola";
                        cola1++;
                        repaint();
                         Thread.sleep(5000);
                         System.out.println("PersonaD llego a A");
                         d+=20;
                         cola1--;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                         
                    //     aviso1="";
                         //a+=20;
                      // cola1--;
                  
                    }
                   
                }
                
                while(d<650){
                    Thread.sleep(tiempo);
                    d += 20;
                    a+=20;
                    b+=20;
                    c+=20;
                   repaint();
                   
                        if(b>380&&b<401){
                           aviso2="Cola";
                     //   cola2++;
                         repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaB llego a 2");
                        // cola2--;
                         a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                         int auxinu=generarTipo();
                         realizarPedido(auxinu);
                    }
                   
                   
                  if(a>580&&a<601){
                        aviso3="Cola";
                        cola3++;
                 
                         repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaA llego a 3");
                         cola3--;
                       atendido++;
                       palla.setAtendidos(atendido);
                         a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                        
                   }
                   
                   
                   if(b>580&&b<601){
                        aviso3="Cola";
                        cola3++;
                  cola3++;
                         repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaB llego a 3");
                         cola3--;
                       atendido++;
                       palla.setAtendidos(atendido);
                         a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                        
                   }
                         
                   if(c>580&&c<601){
                        aviso3="Cola";
                        cola3++;
                        repaint();
                         Thread.sleep(5000);
                         System.out.println("Cola3 llego a 3");
                         cola3--;
                         atendido++;
                         palla.setAtendidos(atendido);
                            a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                   }
                   
                   if(d>580&&d<601){
                        aviso3="Cola";
                     //   cola3++;
                 atendido++;
                 palla.setAtendidos(atendido);
                         repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaD llego a 3");
                       //  cola3--;
                       
                         a+=20;
                         b+=20;
                         c+=20;
                         d+=20;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                        
                   }
                   
                  if(d==390){
                      aviso2="Cola";
                 //       cola2++;
                        repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaD llego a 2");
                         d+=20;
                         a+=20;
                         b+=20;
                         c+=20;
                   //      cola2--;
                         repaint();
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                  }
                  
                  if(c==390){
                           aviso2="Cola";
                        cola2++;
                        repaint();
                         Thread.sleep(5000);
                         System.out.println("ColaC llego a 2");
                         d+=20;
                         a+=20;
                         b+=20;
                         c+=20;
                         cola2--;
                         repaint(); 
                          int auxinu=generarTipo();
                         realizarPedido(auxinu);
                  }
                    
                }
                /*
                while (a < 800 && b < 800 && c < 500) {
                    Thread.sleep(2000);
                    a += 260;
                    b += 260;
                    c += 260;
                    repaint();

                }

                while (a > 1020 && b < 800 && c < 800) {
                    Thread.sleep(2000);
                    b += 260;
                    c += 260;
                    a -= 897;
                    repaint();
                }
                while (a < 200 && b > 1020 && c < 800) {
                    Thread.sleep(2000);
                    a += 117;
                    c += 260;
                    b -= 897;
                    repaint();
                }
                
     while (a< 500 && b < 200 && c > 1020) {
                    Thread.sleep(2000);
                    a += 260;
                    b += 117;
                    c -= 897;
                    repaint();
                }
//                if (x > 1020 && z > 1020&&z > 1020) {
//                    Thread.sleep(Integer.parseInt(Archivo.arreglo[64]) * 1000);
//                    x -= 897;
//                    z -= 897;
//                    w -= 897;
//                    repaint();
*/
    }
        }catch(Exception e){
            
        }
  
    
    }
    
}
