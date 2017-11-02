/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.cuenta;

/**
 *
 * @author crist
 */
public class cuentaTMC extends AbstractTableModel{
    List<cuenta> cuentas=new ArrayList<cuenta>();

    @Override
    public int getRowCount() {
    return cuentas.size();
        }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        cuenta cuenta= cuentas.get(rowIndex);
        Object valor=null;
        switch(columnIndex){
            case 0:
                valor=cuenta.nombre;
                break;
            case 1:
                valor=cuenta.tipo;
        }
    return valor;
    }
    
}
