package proyecto2_201602598;

public class Inventario {
private static String [] produccion=new String[500];
private static int contadorproduccion=0;
private String tiempo,cantidad;

public void setInventario(String tiempo,String id,String cantidad){
    produccion[contadorproduccion]=tiempo+";"+id+","+cantidad;
    contadorproduccion++;
}

public void setInventario(int i){
    produccion[i]=null;
}

public String[] obInventario(){
    return produccion;
}

public int obLongi(){
    return produccion.length;
}

public void imprimir(){
    for(String e:produccion){
        if(e!=null)
        System.out.println(e);
    }
}
}
