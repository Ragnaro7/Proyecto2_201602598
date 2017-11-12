/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201602598;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector
 */
public class Pantalla extends javax.swing.JFrame {
private DefaultTableModel modelo;
private String ruta;
private String[] columnas;
private static int c1=0;
private static int c2=0;
private static int c3=0;
private static int ca1=0;
private static int ca2=0;
private static int ca3=0;
Calendar calendario = Calendar.getInstance();
Calendar calendario2 = Calendar.getInstance();
int hora0, minutos0, segundos0;
int hora1, minutos1, segundos1;
private static int patendidos=0;
//private String[] server;
//int contadorserver;
Servidor servidor;
Personas persona;
Inventario inventario;
Inicio inicio;
ListaEnlazada listaproductos;
Productos producto;
RecoleccionDatos reda=new RecoleccionDatos();
//Dibujo_Server dibujoserver;
    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
        hora0 =calendario.get(Calendar.HOUR_OF_DAY);
        minutos0 = calendario.get(Calendar.MINUTE);
        segundos0 = calendario.get(Calendar.SECOND);
        ruta="";
        this.setLocationRelativeTo(null);
        columnas=new String[] {"Accion","NoServidor","Siguiente","X","Y","Alto","Ancho","TasaLlegada",
        "Tiempo","Tamaño","IdProducto","Nombre","Descripcion","Linea","Cantidad"};
        modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
      //  server=new String[500];
        //contadorserver=0;
        servidor=new Servidor();
        persona=new Personas();
        inventario=new Inventario();
        inicio=new Inicio();
        listaproductos=new ListaEnlazada();
        producto=new Productos();
        /*modelo.addColumn("Accion");
        modelo.addColumn("NoServidor");
        modelo.addColumn("Siguiente");
        modelo.addColumn("X");
        modelo.addColumn("Y");
        modelo.addColumn("Alto");
        modelo.addColumn("Ancho");
        modelo.addColumn("Tasa Llegada");
        modelo.addColumn("Tiempo");
        modelo.addColumn("Tamaño");
        modelo.addColumn("idProducto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Linea");
        modelo.addColumn("Cantidad");*/
        this.tabla.setModel(modelo);
    }
    
    public void limpiarTabla(){
        int cantidadfilas=tabla.getRowCount();
        for(int i=cantidadfilas-1;i>=0;i--){
            modelo.removeRow(i);
        }
    }
    
    public void ingresarProd(String producto){
        listaproductos.addCabeza(producto);
    }
    
    public void Llenar(String tipo,String[] datos){
        
        if(tipo.equalsIgnoreCase("Servidores")){
           servidor.setServer(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
           System.out.println(Arrays.toString(datos));
           }else if(tipo.equalsIgnoreCase("Personas")){
             persona.setPersonas(datos[3], datos[4], datos[7], datos[8], datos[9]);
           }else if(tipo.equalsIgnoreCase("Inventario")){
               inventario.setInventario(datos[8], datos[10], datos[14]);
           }//else if(tipo.equalsIgnoreCase("Inicio")){
              // inicio.setInicio(datos[10], datos[14]);
//           }
           else if(tipo.equalsIgnoreCase("Productos")){
            producto.setProductos(datos[10], datos[11], datos[12], datos[13]);
           }
        else if(tipo.equalsIgnoreCase("Inicio")){
               String aux1=producto.obProductos(0);
               String[] coo1=aux1.split(";");
               String aux2=producto.obProductos(1);
               String[] coo2=aux2.split(";");
               String aux3=producto.obProductos(2);
               String[] coo3=aux3.split(";");
               if(datos[10].equalsIgnoreCase(coo1[0])){
                   int contador=0;
                   while(contador<Integer.parseInt(datos[14])){
                       listaproductos.addCabeza(Arrays.toString(coo1).substring(1).replaceAll("]",""));
                          //reda.setRecoleccion1((String)listaproductos.obElemento(i));
                          reda.setRecoleccion1(Arrays.toString(coo1).substring(1).replaceAll("]",""));
                       contador++;
                       ca1++;
                   }
               }else if(datos[10].equalsIgnoreCase(coo2[0])){
                   int contador=0;
                   while(contador<Integer.parseInt(datos[14])){
                       listaproductos.addCabeza(Arrays.toString(coo2).substring(1).replaceAll("]",""));
                        reda.setRecoleccion2(Arrays.toString(coo2).substring(1).replaceAll("]",""));
                       contador++;
                       ca2++;
                   }
               }else if(datos[10].equalsIgnoreCase(coo3[0])){
                   int contador=0;
                   while(contador<Integer.parseInt(datos[14])){
                       listaproductos.addCabeza(Arrays.toString(coo3).substring(1).replaceAll("]",""));
                        reda.setRecoleccion3(Arrays.toString(coo3).substring(1).replaceAll("]",""));
                       contador++;
                       ca3++;
                   }
               }
           }
        
    }
    
   /* public void setServer(String noserver,String siguiente,String x,String y,String alto,String ancho,
            String tiempo){
        server[contadorserver]=noserver+";"+siguiente+";"+x+";"+y+";"+alto+";"+ancho+";"+tiempo;
        contadorserver++;
    }*/
    
    /*public String[] obServer(){
    return server;
}*/
   /* public String obServerpo(int i){
        return server[i];
    }*/
    
   /* public int lonserver(){
        return server.length;
    }*/
    
    public String obRuta(){
        return ruta;
    }
    public void setAtendidos(int i){
        patendidos=i;
    }
    public int obAtendidos(){
        return patendidos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        btnabrir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnguardarcomo = new javax.swing.JButton();
        btnplay = new javax.swing.JButton();
        btnstop = new javax.swing.JButton();
        btnresultados = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Texto = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        frame2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtresultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnabrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abrir-el-archivo-icono-8581-128.png"))); // NOI18N
        btnabrir.setToolTipText("Abrir");
        btnabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnabrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 70, 50));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnguardar.setToolTipText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 70, 50));

        btnguardarcomo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarcomo.png"))); // NOI18N
        btnguardarcomo.setToolTipText("Guardar Como");
        btnguardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarcomoActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardarcomo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 70, 50));

        btnplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N
        btnplay.setToolTipText("Play");
        btnplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplayActionPerformed(evt);
            }
        });
        jPanel1.add(btnplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 70, 50));

        btnstop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stop.png"))); // NOI18N
        btnstop.setToolTipText("Stop");
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });
        jPanel1.add(btnstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 70, 50));

        btnresultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resultados.png"))); // NOI18N
        btnresultados.setToolTipText("Resultados");
        btnresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresultadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnresultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 70, 50));

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnsalir.setToolTipText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 70, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 80));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Texto.setViewportView(tabla);

        jTabbedPane2.addTab("Solo lectura", Texto);

        frame2.setVisible(true);
        jTabbedPane2.addTab("Simulacion", frame2);

        txtresultados.setColumns(20);
        txtresultados.setRows(5);
        jScrollPane1.setViewportView(txtresultados);

        jTabbedPane2.addTab("Resultados", jScrollPane1);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 890, 340));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 890, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabrirActionPerformed
        // TODO add your handling code here:
        
        //FILECHOOSER
        limpiarTabla();
        try{
        
            int resultado=fc.showOpenDialog(this);
            if(resultado==JFileChooser.CANCEL_OPTION){
                return;
            }else{
            
                ruta=fc.getSelectedFile().getAbsolutePath();
                FileReader archivo=new FileReader(ruta);
                BufferedReader bfr=new BufferedReader(archivo);
                String linea="";

                while(linea!=null){
                    linea=bfr.readLine();
                    if(linea!=null){
                   String aux[]=linea.split(";");
                   modelo.addRow(aux);
                   Llenar(aux[0],aux);
                   }
                }
                modelo.removeRow(0);
                archivo.close();
                }
    }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }//GEN-LAST:event_btnabrirActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    try {
        // TODO add your handling code here:
        
        
            for(int as=0;as<servidor.oblong();as++){
                servidor.setServer(as);
            }
            servidor.reiniciarcont();
            
            for(int as=0;as<persona.oblonper();as++){
                persona.setPersonas(as);
            }
            persona.reiniciarCont();
        
        
        String fila="";//
        String auxi="";
        FileWriter rutasave=new FileWriter(obRuta());
        BufferedWriter escribir=new BufferedWriter(rutasave);
        for(int w=0;w<columnas.length;w++){
            escribir.write(columnas[w]+";");
        }
        escribir.newLine();
        for(int i=0;i<tabla.getRowCount();i++){
            for(int j=0;j<tabla.getColumnCount();j++){
                 Object auxi2=tabla.getValueAt(i,j);
                if(auxi2!=null){
                    auxi=(String)auxi2; 
                    escribir.write(auxi+";");
                    fila=fila+auxi+";";//
                 }else{
                    escribir.write(";");
                   fila=fila+";";//
                }
                
              
            }
            String[] coo=fila.split(";");//
            Llenar(coo[0],coo);//
            fila="";//HASTA ACA
            escribir.newLine();
        }
        escribir.close();
        rutasave.close();
        JOptionPane.showMessageDialog(null, "Guardado exitosamente");
    } catch (IOException ex) {
        Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        //GUARDAR
        
        
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarcomoActionPerformed
        // TODO add your handling code here:
        //Guardar Como
        int resultado=fc.showSaveDialog(this);
        if(resultado==JFileChooser.CANCEL_OPTION){
            return;
        }else{
            File archivo=fc.getSelectedFile();
            try {
                FileWriter esc=new FileWriter(archivo);
                BufferedWriter bf=new BufferedWriter(esc);
                for(int r=0;r<columnas.length;r++){
                    bf.write(columnas[r]+";");
                }
                bf.newLine();
                for(int i=0;i<tabla.getRowCount();i++){
                    for(int j=0;j<tabla.getColumnCount();j++){
                        Object o=tabla.getValueAt(i, j);
                        if(o!=null){
                            bf.write((String)o+";");
                        }else{
                            bf.write(";");
                        }
                    }
                    bf.newLine();
                }
                bf.close();
                esc.close();
                JOptionPane.showMessageDialog(null, archivo+" Se ha guardado exitosamente");
            } catch (IOException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
        
        
        //Guardar como
    }//GEN-LAST:event_btnguardarcomoActionPerformed

    private void btnplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplayActionPerformed
        // TODO add your handling code here:
        //  play
        // jTabbedPane2.setSelectedIndex(1);
    //  Dibujo di=new Dibujo();
      //di.setVisible(true);
        //PLAY
        jTabbedPane2.setSelectedIndex(jTabbedPane2.indexOfTab("Simulacion"));
         Capa_Server fig=new Capa_Server();
       
     //Dibujo_Server dibujoserver=new Dibujo_Server();
     frame2.add(fig);
        //dibujoserver.setVisible(true);
        
       
        
        
        
      
    }//GEN-LAST:event_btnplayActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        // TODO add your handling code here:
         Capa_Server fig=new Capa_Server();
         fig.detener();
         c1=fig.obCan1();
         c2=fig.obCan2();
         c3=fig.obCan3();
         hora1 =calendario2.get(Calendar.HOUR_OF_DAY);
        minutos1 = calendario2.get(Calendar.MINUTE);
        segundos1 = calendario2.get(Calendar.SECOND);
        
         System.out.println(hora0);
         System.out.println(minutos0);
         System.out.println(segundos0); 
        
        System.out.println(hora1);
         System.out.println(minutos1);
         System.out.println(segundos1);
        
        
        
    }//GEN-LAST:event_btnstopActionPerformed

    private void btnresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresultadosActionPerformed
        // TODO add your handling code here:
          HiloInventario hil=new HiloInventario();
      jTabbedPane2.setSelectedIndex(jTabbedPane2.indexOfTab("Resultados"));
        int totalc1=ca1+hil.obC1();
        int totalc2=ca2+hil.obC2();
        int totalc3=ca3+hil.obC3();
        
        int final1=totalc1-c1;
        int final2=totalc2-c2;
        int final3=totalc3-c3;
        txtresultados.append("------------------------------------------\nCantidad de personas que ingresaron"
                + "al sistema:\n");
        txtresultados.append("4\n");
         txtresultados.append("------------------------------------------\nCantidad de personas que Salieron"
                + "al sistema:\n");
        txtresultados.append(String.valueOf(obAtendidos())+"\n");
        
        
        txtresultados.append("------------------------------------------\nDurante la simulacion existieron:\n");
        txtresultados.append("Productos con id 1: "+totalc1+"\n");
        txtresultados.append("Productos con id 2: "+totalc2+"\n");
        txtresultados.append("Productos con id 3: "+totalc3+"\n");
        
        txtresultados.append("------------------------------------------\nDe los cuales se vendieron:\n");
        txtresultados.append("Productos con id 1: "+c1+"\n");
        txtresultados.append("Productos con id 2: "+c2+"\n");
        txtresultados.append("Productos con id 3: "+c3+"\n");
        
        txtresultados.append("------------------------------------------\nInventario final:\n"); 
        txtresultados.append("producto(s) con id 1: "+final1+"\n");
        txtresultados.append("producto(s) con id 2: "+final2+"\n");
        txtresultados.append("producto(s) con id 3: "+final3+"\n");
      
        txtresultados.append("------------------------------------------\nDetalles Inventario:\n");
        txtresultados.append("producto(s) con id 1: "+producto.obProductos(0)+"\n");
        txtresultados.append("producto(s) con id 2: "+producto.obProductos(1)+"\n");
        txtresultados.append("producto(s) con id 3: "+producto.obProductos(2)+"\n");
           
        String hf=String.valueOf(hora1-hora0);
        String mf=String.valueOf(minutos1-minutos0);
        String sf=String.valueOf(segundos1-segundos0);
        
        txtresultados.append("------------------------------------------\nTiempo de ejecucion:\n");
        txtresultados.append(hf+" horas "+mf+" minutos "+sf+" segundos");
//  System.out.println(totalc1);
       /* for(int i=0;i<listaproductos.obTamaño();i++){
            //ca1,ca2,ca3 llevan cuantos productos hay inicialmente
            
            
        }
        */
        
    }//GEN-LAST:event_btnresultadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Texto;
    private javax.swing.JButton btnabrir;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarcomo;
    private javax.swing.JButton btnplay;
    private javax.swing.JButton btnresultados;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnstop;
    private javax.swing.JFileChooser fc;
    private javax.swing.JInternalFrame frame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txtresultados;
    // End of variables declaration//GEN-END:variables
}
