package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.HallBooking;


public class HallBookingDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES ={"Booking_ID","Name","Package"};
    private static ArrayList<HallBooking> list;
    
    public HallBookingDetails(ArrayList<HallBooking> h){
        list=h;
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
                return list.get(rowIndex).getBookingIndex();
            case 1 :
                return list.get(rowIndex).getCustomer().getName();
            case 2 :
                return list.get(rowIndex).getPack();
            default :
                return "Error";
        }
    }   
}
