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
public class RecoleccionDatos {
   private static String[] datos1=new String[1000];
   private static int contadordatos1=0;
   private static String[] datos2=new String[1000];
   private static int contadordatos2=0;
   private static String[] datos3=new String[1000];
   private static int contadordatos3=0;
   private static int c1=0;
   private static int c2=0;
   private static int c3=0;
   
   public int obC1(){
       return c1;
   }
   
   public int obC2(){
       return c2;
   }
   
   public int obC3(){
       return c3;
   }
   
   public void setRecoleccion1(String dato){
       datos1[contadordatos1]=dato;
       contadordatos1++;
       c1++;
   }
   
   public String[] obRecoleccion1(){
       return datos1;
   }
   
    public void setRecoleccion2(String dato){
       datos2[contadordatos2]=dato;
       contadordatos2++;
       c2++;
   }
   
   public String[] obRecoleccion2(){
       return datos2;
   }
   
    public void setRecoleccion3(String dato){
       datos3[contadordatos3]=dato;
       contadordatos3++;
       c3++;
   }
   
   public String[] obRecoleccion3(){
       return datos3;
   }
}
