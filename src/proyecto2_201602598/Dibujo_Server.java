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

class Capa_Server extends JPanel{
 //   private Servidor ser;
    private double x,y,w,h;
    private String[] arr;
    
    public Capa_Server(String x1,String y1,String w1,String h1){
        x=Double.parseDouble(x1);
        y=Double.parseDouble(y1);
        w=Double.parseDouble(w1);
        h=Double.parseDouble(h1);
    //    ser=new Servidor();
    }
     public Capa_Server(){
       //  ser=new Servidor();
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
        
        
        g2.setColor(Color.GREEN);
        g2.fillPolygon(posx, posy, 3);
                System.out.println(i+","+Arrays.toString(coo));
            }else{
                System.out.println(ser.obServer2(i)+i);
            }    
            
            
            
            
        //Rectangle2D rectangulo=new Rectangle2D.Double(x, y, w, h);
     
        }
        for(int i=0;i<per.oblonper();i++){
            String aux=per.obPersonas()[i];
            if(aux!=null){
                String [] coo= aux.split(";");
                g2.setColor(Color.YELLOW);
                int radio=Integer.parseInt(coo[4]);
                g2.fillOval(Integer.parseInt(coo[0]), Integer.parseInt(coo[1]), radio*2,radio*2);
            }
        }
       
    }
    
}
