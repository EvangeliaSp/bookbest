import dao.*;
import entities.*;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        hotel.setIdHotel(1);
        hotel.setDistance("Away");
        hotel.setName("HotelMy");
        hotel.setPrice("Cheap");
        hotel.setRating("Good");

        /*HotelDAO hotelDAO = new HotelDAOImpl();
        hotelDAO.create(hotel);
        List<Hotel> hotels = hotelDAO.list();
        for(Hotel h:hotels) {
            System.out.println("Hotel: "+h.getName());
            System.out.println("~price: "+h.getPrice()+", rating"+h.getRating()+", distance: "+h.getDistance()+"~");
        }*/


        // Load driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtaining a connection from the DriverManager
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bookbest?" + "user=root&password=5698");
        } catch (SQLException ex) {
            // handle the errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }



        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {

                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }
}
