package database;

import controller.Details;
import model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBOperations {  

    private DateFormat dinyr = new SimpleDateFormat("D");
    private static final DBOperations db = new DBOperations();

    String url = "jdbc:mysql://localhost:3306/hotel"; //url to the DB
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private DBOperations() {

    }

    public static DBOperations getInstance() {
        return db;
    }

    public ArrayList<String> validate(String user, String pw) {

        try {

            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "SELECT * FROM login_details";
            pst = con.prepareStatement(query);
            ArrayList<String> list = new ArrayList<>();

            rs = pst.executeQuery();
            while (rs.next()) {

                if (user.equals(rs.getString(2)) && pw.equals(rs.getString(3))) {
                    list.add(rs.getString(1));
                }

            }
            return list;

        } catch (Exception e) {
            System.out.print(e);
            return null;
            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    //add bookings into room_booking table in DB
    public boolean addRoomBooking(RoomBooking b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "INSERT INTO room_booking VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            //add values to the sql query
            pst.setInt(1, 0);
            pst.setString(2, b.getCustomer().getCustomerID());
            pst.setString(3, b.getCustomer().getName());
            pst.setString(4, b.getCustomer().getAddress());
            pst.setString(5, b.getCustomer().getContactNumber());
            pst.setString(6, b.getCustomer().getNIC());
            pst.setDate(7, new java.sql.Date(b.getCheckIn().getTime()));
            pst.setDate(8, new java.sql.Date(b.getCheckOut().getTime()));
            pst.setInt(9, b.getNoOfAdults());
            pst.setInt(10, b.getNoOfChildren());
            pst.setString(11, b.getCustomer().getRegion());

            pst.executeUpdate(); //execute the sql query and insert the values to the database
            addBookedRooms(b);
            return true;

        } catch (Exception e) {

            System.out.print(e);
            return false;
            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    //add bookings into hall_booking table in DB
    public boolean addHallBooking(HallBooking b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "INSERT INTO hall_booking VALUES(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            //add values to the sql query
            pst.setInt(1, 0);
            pst.setString(2, b.getCustomer().getName());
            pst.setDate(3, new java.sql.Date(b.getDate().getTime())); // util to sql
            pst.setInt(4, b.getNoOfPeople());
            pst.setString(5, b.getCustomer().getContactNumber());
            pst.setString(6, b.getCustomer().getAddress());
            pst.setString(7, b.getPack());

            pst.executeUpdate(); //execute the sql query and insert the values to the database
            return true;
        } catch (Exception e) {
            System.out.print(e);
            return false;
            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public int checkHallAvailability(Date date) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "SELECT Date FROM hall_booking";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getDate(1));
//                
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                Date parsed = (Date) format.parse(rs.getString(1));
//                java.sql.Date sql = new java.sql.Date(parsed.getTime());

                if (date.equals(rs.getDate(1))) {
                    return 0; // date already been booked!
                }
            }
            return 1; //date is available
        } catch (Exception e) {
            System.out.println(e);
            return 2; //error while searching

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public ArrayList<HallBooking> getAllHallBookings() {
        try {
            ArrayList<HallBooking> bookinglist = new ArrayList<HallBooking>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM hall_booking ";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();
            while (rs.next()) {
                HallBooking h = new HallBooking();
                Customer c = new Customer();

                h.setBookingIndex(rs.getInt(1));
                h.setCustomer(c);
                h.getCustomer().setName(rs.getString(2));
                h.setDate(rs.getDate(3));
                h.setNoOfPeople(rs.getInt(4));
                h.getCustomer().setContactNumber(rs.getString(5));
                h.getCustomer().setAddress(rs.getString(6));
                h.setPack(rs.getString(7));
//                StaffMember s = new StaffMember();
//                s.setEmployeeID(rs.getInt(1));
//                s.setName(rs.getString(2));
//                s.setGender(rs.getString(3));
//                s.setAddress(rs.getString(4));
//                s.setBirthday(rs.getDate(5));
//                s.setRecruitmentDate(rs.getDate(6));
//                s.setDesignation(rs.getString(7));
//                s.setSalary(rs.getInt(8));
//                s.setContactNumber(rs.getString(9));
//                s.setImage(rs.getString(10));

                bookinglist.add(h);
            }
            return bookinglist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    //camcel hall booking
    public boolean cancelHallBooking(HallBooking h){
    
        try {
           
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM hall_booking WHERE Booking_ID=" + h.getBookingIndex();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.executeUpdate();
            
            return true;
        } catch (Exception e) {
            
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
    
    //add staff members into staff_members table in DB
    public boolean addStaff(StaffMember s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO staff_members VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            pst.setInt(1, s.getEmployeeID());
            pst.setString(2, s.getName());
            pst.setString(3, s.getGender());
            pst.setString(4, s.getAddress());
            pst.setDate(5, new java.sql.Date(s.getBirthday().getTime()));
            pst.setDate(6, new java.sql.Date(s.getRecruitmentDate().getTime()));
            pst.setString(7, s.getDesignation());
            pst.setInt(8, s.getSalary());
            pst.setString(9, s.getContactNumber());
            pst.setString(10, s.getImage());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    //archive staff members are added to the archive_staff
    public boolean archiveStaff(StaffMember s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query1 = "DELETE FROM staff_members WHERE employeeID=" + s.getEmployeeID();
            pst = con.prepareStatement(query1);
            pst.executeUpdate();

            String query2 = "INSERT INTO archive_staff VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query2);

            pst.setInt(1, s.getEmployeeID());
            pst.setString(2, s.getName());
            pst.setString(3, s.getGender());
            pst.setString(4, s.getAddress());
            pst.setDate(5, new java.sql.Date(s.getBirthday().getTime()));
            pst.setDate(6, new java.sql.Date(s.getRecruitmentDate().getTime()));
            pst.setString(7, s.getDesignation());
            pst.setInt(8, s.getSalary());
            pst.setString(9, s.getContactNumber());
            pst.setString(10, s.getImage());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<StaffMember> getAllMembers() {
        try {
            ArrayList<StaffMember> list = new ArrayList<>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM staff_members ";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();
            while (rs.next()) {
                StaffMember s = new StaffMember();
                s.setEmployeeID(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setGender(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setBirthday(rs.getDate(5));
                s.setRecruitmentDate(rs.getDate(6));
                s.setDesignation(rs.getString(7));
                s.setSalary(rs.getInt(8));
                s.setContactNumber(rs.getString(9));
                s.setImage(rs.getString(10));

                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public StaffMember getMember(int employeeID) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM staff_members";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            StaffMember s = new StaffMember();
            while (rs.next()) {

                if (Integer.toString(employeeID).equals(Integer.toString(rs.getInt(1)))) {
                    s.setEmployeeID(rs.getInt(1));
                    s.setName(rs.getString(2));
                    s.setGender(rs.getString(3));
                    s.setAddress(rs.getString(4));
                    s.setBirthday(rs.getDate(5));
                    s.setRecruitmentDate(rs.getDate(6));
                    s.setDesignation(rs.getString(7));
                    s.setSalary(rs.getInt(8));
                    s.setContactNumber(rs.getString(9));
                    s.setImage(rs.getString(10));
                }

            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    //get details of salary payments
    public ArrayList<Details> showSalaryDetails(String month, int employeeID) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM salary_payments";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            ArrayList<Details> list = new ArrayList<>();

            while (rs.next()) {

                if (Integer.toString(employeeID).equals(Integer.toString(rs.getInt(1))) && month.equals(Integer.toString(rs.getDate(4).getMonth() + 1))) {

                    Details d = new Details();
                    d.setDate(rs.getDate(4));
                    d.setPurpose(rs.getString(5));
                    d.setAmount(rs.getInt(6));

                    list.add(d);
                }

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    //add details to salary payments
    public boolean addSalaryDetails(StaffMember s, Date date, String purpose, int amount) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO salary_payments VALUES(?,?,?,?,?,?)";
            pst = con.prepareStatement(query);

            pst.setInt(1, s.getEmployeeID());
            pst.setString(2, s.getName());
            pst.setString(3, s.getDesignation());
            pst.setDate(4, date);
            pst.setString(5, purpose);
            pst.setInt(6, amount);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    //get booked rooms on a specified date
    public ArrayList<Room> getBookedRooms(Date date) {
        //System.out.println(date);
        try {
            ArrayList<Room> list = new ArrayList<>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM room_booked";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();
            while (rs.next()) {
                int status = date.toString().compareTo(rs.getDate(1).toString());
                if (status == 0) {
                    // System.out.println("");

                    Room r = new Room(rs.getInt(2));
                    list.add(r);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    private void addBookedRooms(RoomBooking b) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "INSERT INTO room_booked VALUES (?,?)";
            pst = con.prepareStatement(query);

            int dateDifference = (Integer.parseInt(dinyr.format(b.getCheckOut())) + 1 - Integer.parseInt(dinyr.format(b.getCheckIn())));
            for (int i = 0; i < dateDifference; i++) {
                pst.setDate(1, new java.sql.Date(b.getDateList().get(i).getTime()));
                pst.setString(2, Integer.toString(b.getRoom().getRoomNo()));
                pst.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();

            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public boolean addGain(Date date, String purpose, int amount) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "INSERT INTO gain VALUES(?,?,?)";
            pst = con.prepareStatement(query);

            //add values to the sql query
            pst.setDate(1, date);
            pst.setString(2, purpose);
            pst.setInt(3, amount);

            pst.executeUpdate(); //execute the sql query and insert the values to the database

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean addExpenditure(Date date, String purpose, int amount) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);  //get the connection to the database
            String query = "INSERT INTO expenditures VALUES(?,?,?)";
            pst = con.prepareStatement(query);

            //add values to the sql query
            pst.setDate(1, date);
            pst.setString(2, purpose);
            pst.setInt(3, amount);

            pst.executeUpdate(); //execute the sql query and insert the values to the database

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            //close all the resources
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
