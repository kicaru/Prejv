/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Data_Access_Object;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class Themodel extends AbstractTableModel{
        private String[] columns;
        private Object[][] rows;
        
      public Themodel(Object[][] rows,String[] columns){
          this.columns=columns;
          this.rows = rows;
      }
      
      public Class getColumnClass(int Column){
        if(Column == 4){
            return Icon.class;
        }else{
          return getValueAt(0,Column).getClass();
      }
}
    
    public int getRowCount() {
    return this.rows.length;
    }

    
    public int getColumnCount() {
    return this.columns.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
    return this.rows[rowIndex][columnIndex];
    }
    public String getColumnName(int col){
        return columns[col];
    }
    
}
