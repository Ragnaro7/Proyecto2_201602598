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
public class Personas {
    private static String [] personas=new String[500];
    private int contadorpersonas=0;
    
    
public void setPersonas(String tasa,String tiempo,String tamaño,String x,String y){
    personas[contadorpersonas]=tasa+";"+tiempo+";"+tamaño+";"+x+";"+y;
    contadorpersonas++;
}

public String[] obPersonas(){
    return personas;
}

public int oblonper(){
    return personas.length;
}

public void setPersonas(int i){
    personas[i]=null;
}

public void reiniciarCont(){
    contadorpersonas=0;
}

public void imprimirper(){
    for(String e:personas){
        if(e!=null){
            System.out.println(e);
        }
    }
}
    
}
