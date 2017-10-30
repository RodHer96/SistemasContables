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
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
   }
   
   public void inicializarAcuenta(){
       
   }

   @Override
    public void actionPerformed(ActionEvent e) {
       
       
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
       
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(agregarcuenta,"Error al guardad por facovr intente de nuevo");
           ex.printStackTrace();
       }
   
    }   
   
   
   
    
}
