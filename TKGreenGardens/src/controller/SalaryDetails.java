/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Details;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.StaffMember;

/**
 *
 * @author Nethmi
 */
public class SalaryDetails extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES ={"Staff ID","Name","Designation"};
    private static ArrayList<Details> list;
    
    public SalaryDetails(ArrayList<Details> s){
        list=s;
    }
    @Override
    public int getRowCount() {
         return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getDate();
            case 1 :
                return list.get(rowIndex).getPurpose();    
            case 2 :
                return list.get(rowIndex).getAmount();
            default :
                return "Error";
        }
    }
    
}
