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
public class ListaEnlazada {

Nodo cabeza;
int tamaño;
    public ListaEnlazada(){
        cabeza=null;
        tamaño=0;
    }
    
 public Object obElemento(int indice){
     int contador=0;
     Nodo temporal=cabeza;
     while(contador<indice){
         temporal=temporal.obSiguiente();
         contador++;
     }
     return temporal.obEntrada();
 }
    
 public void addCabeza(Object entrada){
     if(cabeza==null){
         cabeza=new Nodo(entrada);
     }else{
         Nodo temporal=cabeza;
         Nodo nuevo=new Nodo(entrada);
         nuevo.enlazarSiguiente(temporal);
         cabeza=nuevo;
     }
     tamaño++;
 }   
 public boolean Vacia(){
     return (cabeza==null);
 }
 
 public int obTamaño(){
     return tamaño;
 }
 
 public void eliminarPrimero(){
     cabeza=cabeza.obSiguiente();
     tamaño--;
 }
 
 public void eliminar(int indice){
     if(indice==0){
         cabeza=cabeza.obSiguiente();
     }else{
     int contador=0;
     Nodo temporal=cabeza;
     while(contador<indice-1){
         temporal=temporal.siguiente;
         contador++;
     }
     temporal.enlazarSiguiente(temporal.obSiguiente().obSiguiente());
     }
     tamaño--;
 }
 
 public void cortar(int indice){
      int contador=0;
     Nodo temporal=cabeza;
     while(contador<indice-1){
         temporal=temporal.obSiguiente();
         contador++;
     }
     temporal.enlazarSiguiente(null);
     tamaño=indice;
 }
 
}
