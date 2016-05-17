/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.StaffMember;

/**
 *
 * @author Nethmi
 */
public class StaffMemberDetail extends AbstractTableModel {
    private static final String[] COLUMN_NAMES ={"Staff ID","Name","Designation"};
    private static ArrayList<StaffMember> list;
    
    public StaffMemberDetail(ArrayList<StaffMember> s){
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
                return list.get(rowIndex).getEmployeeID();
            case 1 :
                return list.get(rowIndex).getName();    
            case 2 :
                return list.get(rowIndex).getDesignation();
            default :
                return "Error";
        }
    }
}
