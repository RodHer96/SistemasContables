/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import tareasic.acuenta;
import models.cuenta;

/**
 *
 * @author crist
 */
public class acuentacontrol implements ActionListener{
   
   acuenta agregarcuenta =new acuenta();
   cuenta ct=new cuenta();
   Connection con;
   
   public acuentacontrol(acuenta agregarcuenta,Connection con){
       this.agregarcuenta=agregarcuenta;
       this.con=con;
       this.agregarcuenta.jbAgregar.addActionListener(this);  
       this.agregarcuenta.jbEliminar.addActionListener(this);  
   }
   
   public void inicializarAcuenta(){
       
   }

   @Override
    public void actionPerformed(ActionEvent e) {
       
      if(e.getSource() == agregarcuenta.jbAgregar){
       try{
          
       ct.clasficacion=agregarcuenta.cbxclasificacion.getSelectedIndex()+1;
       switch(ct.clasficacion){
           case 1:{
               ct.balance=4;
           }
           case 2:{
               ct.balance=4;
               
           }
           case 3:{
               ct.balance=4;
           }
           case 4:{
               ct.balance=3;
           }
           case 5:{
               ct.balance=2;
           }
           case 6:{
               ct.balance=2;
           }
           case 7:{
               ct.balance=3;
           }
       }
       
    
    String sentenciaSql= "INSERT INTO cuenta (nombre,clasificacion,estado) values"+"(?,?,?)";
    PreparedStatement pS= con.prepareStatement(sentenciaSql);
    pS.setString(1,ct.nombre= agregarcuenta.jtnombrec.getText());
    pS.setInt(2, ct.clasficacion);
    pS.setInt(3,ct.balance);
    pS.execute();
    agregarcuenta.tablacuentas.repaint();
    consultaInicial();
    agregarcuenta.jtnombrec.setText("");
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(agregarcuenta,"Error al guardar, por favor intente de nuevo");
           ex.printStackTrace();
       }
       agregarcuenta.tablacuentas.repaint();
    }   
   }
public void inicializarTabla(){
    TableColumnModel cuentaTM1=new DefaultTableColumnModel();
    for(int i =0;i<2;i++ ){
        TableColumn col =new TableColumn(i);
        switch(i){
            case 0:
                col.setHeaderValue("Nombre");
                break;
            case 1:
                col.setHeaderValue("Clasificacion");
                break;
        }
        cuentaTM1.addColumn(col);
    }
    agregarcuenta.tablacuentas.setColumnModel(cuentaTM1);
}   
    public void consultaInicial(){
        try{
        String sentenciaSql="SELECT * FROM cuenta";
        Statement statement = this.con.createStatement();
        ResultSet r=statement.executeQuery(sentenciaSql);
       
        int cl;
        while(r.next()){
            cuenta cts=new cuenta();
            cts.nombre=r.getString("nombre");
            cl=r.getInt("clasificacion");
            switch(cl){
                case 1:
                    cts.tipo="Activo";
                    break;
                case 2:
                    cts.tipo="Contraactivo";
                    break;
                case 3:
                    cts.tipo="Pasivo";
                    break;
                case 4:
                    cts.tipo="Capital";
                    break;
                case 5:
                    cts.tipo="Ingreso";
                    break;
                case 6:
                    cts.tipo="Costo";
                    break;
                case 7:
                    cts.tipo="Gasto";
                    break;
            }
         agregarcuenta.cuentaTM.cuentas.add(cts);
        }
        agregarcuenta.tablacuentas.repaint();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(agregarcuenta, "Error al recuperar los datos de la base");
        }
      agregarcuenta.tablacuentas.repaint();

    }
    public void jbEliminarActionPerformed(ActionEvent e) {
       if(e.getSource() == agregarcuenta.jbEliminar){
        cuenta c = new cuenta();
            PreparedStatement statement =null;
            String nombre=agregarcuenta.jtnombrec.getText().toString();
            String sentenciaSql="DELETE FROM cuenta where nombre=?";
            try{
                PreparedStatement prep = con.prepareStatement(sentenciaSql);
                prep.setString(1, nombre);
                prep.executeUpdate();
                JOptionPane.showMessageDialog(agregarcuenta, "Eliminó correctamente "+ nombre); 
                consultaInicial();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(agregarcuenta,"Error al eliminar el producto " + nombre);
            ex.printStackTrace();
        }
        agregarcuenta.tablacuentas.repaint();   
       }   
    }
 
}
