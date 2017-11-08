package proyecto2_201602598;

public class Productos {
private static String [] productos=new String[500];
private static int contadorproductos=0;
private static String id1,id2,id3;
public Productos(){
    id1="1;Manzanas;Fruta que contiene corazon;Frutos rojos";
    id2="2;Banano;Fruta que contiene potasio";
}

public void setProductos(String id,String nombre,String desc,String linea){
    if(id==null){
        id=" ";
    }else if(nombre==null){
        nombre=" ";
    }else if(desc==null){
        desc=" ";
    }else if(linea==null){
        linea=" ";
    }
    productos[contadorproductos]=id+";"+nombre+";"+desc+";"+linea;
    contadorproductos++;
}

public String [] obProductos(){
    return productos;
}

public String obProductos(int i){
    return productos[i];
}


}
