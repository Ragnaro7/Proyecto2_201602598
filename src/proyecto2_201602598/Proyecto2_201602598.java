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
public class Proyecto2_201602598 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* IngresarSistema is=new IngresarSistema();
        is.setVisible(true);*/
       
       ListaEnlazada lista=new ListaEnlazada();
       
        System.out.println("Esta vacia? "+lista.Vacia());
        lista.addCabeza("Hola1");
        lista.addCabeza(2);
        lista.addCabeza("xd3");
        lista.addCabeza("was4");
        
        
        lista.eliminar(2);
        System.out.println("Primer elemento "+lista.obElemento(0));
        System.out.println("Ultimo elemento "+lista.obElemento(lista.obTamaño()-1));
        System.out.println("indice 2 "+lista.obElemento(2));
        System.out.println(lista.tamaño);
        
        
        System.out.println("Esta vacia? "+lista.Vacia());
    }
    
}
