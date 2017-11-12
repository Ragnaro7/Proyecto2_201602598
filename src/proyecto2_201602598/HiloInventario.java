/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201602598;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector
 */
public class HiloInventario implements Runnable {
    static int c1=0;
    static int c2=0;
    static int c3=0;
Thread t=new Thread(this);
Pantalla pa=new Pantalla();
ListaEnlazada lista=new ListaEnlazada();
Inventario inv=new Inventario();
RecoleccionDatos raw=new RecoleccionDatos();
Productos pr=new Productos();

public HiloInventario(){
   // t.start();
}

public int obC1(){
    return c1;
}
public int obC2(){
    return c2;
}
public int obC3(){
    return c3;
}

public void qewr(){
    t.start();
}
    @Override
    public void run() {
    
        for(int i=0;i<inv.obInventario().length;i++){
            String aux=inv.obInventario()[i];
            if(aux!=null){
                String[] coo=aux.split(";");
                switch(coo[1]){
                    case "1":
                        int cont=0;
                    while(cont<Integer.parseInt(coo[2])){
                        //pa.ingresarProd("dsaf");
                        raw.setRecoleccion1(pr.obProductos()[0]);
                   //     System.out.println("se agrego");
                        cont++;
                        c1++;
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HiloInventario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    
                    case "2":
                         int cont2=0;
                    while(cont2<Integer.parseInt(coo[2])){
                        //pa.ingresarProd("dsaf");
                        raw.setRecoleccion2(pr.obProductos()[1]);
                     //   System.out.println("se agrego");
                        cont2++;
                        c2++;
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HiloInventario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    
                    case "3":
                         int cont3=0;
                    while(cont3<Integer.parseInt(coo[2])){
                        //pa.ingresarProd("dsaf");
                        raw.setRecoleccion3(pr.obProductos()[2]);
             //           System.out.println("se agrego");
                        cont3++;
                        c3++;
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HiloInventario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    
                }//swtich
                }
        }
        
    
    }
    
}
