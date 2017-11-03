/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import tareasic.vistaOpciones;
import models.Catalogo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author crist
 */
public class opcionesControl implements ActionListener{
vistaOpciones vo=new vistaOpciones();
Catalogo ctl=new Catalogo();
SimpleDateFormat formatoF=new SimpleDateFormat("dd-mm-yy");
SimpleDateFormat formatoF2=new SimpleDateFormat("dd-mm-yy");
Connection con;
    public opcionesControl(vistaOpciones vo,Connection con){
        this.vo=vo;
        this.con=con;
        vo.jbCrearPeriodo.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            
          ctl.fechaC=formatoF.format(vo.cbxfc.getDate());
          vo.cbxfc.getCalendar().get(Calendar.YEAR);
          
          String sentenciaSql="INSERT INTO catalogo (fechai,fechac) values"+"(?,?)";
          PreparedStatement ps=con.prepareStatement(sentenciaSql);
          Date dt=new Date(vo.cbxfi.getCalendar().get(Calendar.YEAR)-1900,vo.cbxfi.getCalendar().get(Calendar.MONTH),vo.cbxfi.getCalendar().get(Calendar.DAY_OF_MONTH));
          Date dt2=new Date(vo.cbxfc.getCalendar().get(Calendar.YEAR)-1900,vo.cbxfc.getCalendar().get(Calendar.MONTH),vo.cbxfc.getCalendar().get(Calendar.DAY_OF_MONTH));
      
          ps.setDate(1, dt);
          ps.setDate(2,dt2);
          ps.execute();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(vo,"Error al guardad por facovr intente de nuevo");
                ex.printStackTrace();
      
   
    }   
    
    
}
}