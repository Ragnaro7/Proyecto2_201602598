package proyecto2_201602598;

public class Inicio {
    private static String [] inicio=new String[500];
private static int contadorinicio=0;
private String tiempo,cantidad;

public void setInicio(String id,String cantidad){
    inicio[contadorinicio]=id+";"+cantidad;
    contadorinicio++;
}

public void setInicio(int i){
    inicio[i]=null;
}

public String[] obInicio(){
    return inicio;
}

public int obLongi(){
    return inicio.length;
}

public void imprimir(){
    for(String e:inicio){
        if(e!=null)
        System.out.println(e);
    }
}
}
