/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.table.AbstractTableModel;


/**
 *
 * @author crist
 */
public class tablaRTM extends AbstractTableModel{
    //List<cuenta> cuentas=new ArrayList<cuenta>();

    @Override
    public int getRowCount() {
    return 4;
        }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Object valor=null;
       
    return valor;
    }
    
}
