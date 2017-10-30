/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.cuenta;
import tareasic.acuenta;

/**
 *
 * @author crist
 */
public class conexion {
    public Connection conexion;
    acuenta ct=new acuenta();
    
    public Connection conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tareaSic", "postgres", "mb14008");
            
            } catch (SQLException ex) {
            Logger.getLogger(cuenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(ct, "Error");
                                        }
    return conexion;
    }
}
