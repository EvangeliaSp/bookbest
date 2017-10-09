import dao.*;
import entities.*;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Hotel hotel2 = new Hotel();
        hotel.setIdHotel(2);
        hotel.setDistance("Away");
        hotel.setName("HotelMy2");
        hotel.setPrice("Cheap");
        hotel.setRating("Good");

        hotel2.setIdHotel(3);
        hotel2.setDistance("FarAway");
        hotel2.setName("HotelMy3");
        hotel2.setPrice("VeryCheap");
        hotel2.setRating("Good");

        HotelDAO hotelDAO = new HotelDAOImpl();

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

        try {
            stmt = conn.createStatement();
           // hotelDAO.create(stmt, hotel);
           // hotelDAO.create(stmt, hotel2);
            List<Hotel> hotels = hotelDAO.list(stmt);
            for(Hotel h:hotels) {
                System.out.println("Hotel: "+h.getName()+" "+h.getIdHotel());
                //System.out.println("~"+h.getPrice()+", "+h.getRating()+", "+h.getRating()+", "+h.getDistance()+"~");
            }
            System.out.println("Counter: "+hotelDAO.count(stmt));
            System.out.println();
            hotelDAO.delete(stmt, 3);

            hotels = hotelDAO.list(stmt);
            for(Hotel h:hotels) {
                System.out.println("Hotel: "+h.getName()+" "+h.getIdHotel());
                //System.out.println("~"+h.getPrice()+", "+h.getRating()+", "+h.getRating()+", "+h.getDistance()+"~");
            }

            System.out.println("Counter: "+hotelDAO.count(stmt));

        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }
}
