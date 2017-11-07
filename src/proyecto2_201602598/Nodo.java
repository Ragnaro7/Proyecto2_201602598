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
public class Nodo {
Object entrada;
Nodo siguiente;

    public Nodo(Object valor){
        this.entrada=valor;
        this.siguiente=null;
    }
    
    public Object obEntrada(){
        return entrada;
    }
    
    public void enlazarSiguiente(Nodo n){
        siguiente=n;
    }
    
    public Nodo obSiguiente(){
        return siguiente;
    }
}
