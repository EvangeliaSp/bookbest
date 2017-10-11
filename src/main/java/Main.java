import dao.*;
import entities.*;
import hotelGeneration.NameGenerator;
import hotelGeneration.RandomValues;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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


            try {
                List<Hotel> hotels = new ArrayList<>();
                RandomValues randomValues = new RandomValues();
                NameGenerator nameGenerator = new NameGenerator("./src/main/resources/names.txt");
                System.out.println("Generate Hotels");
                for(int i=0; i<10; i++) {
                    Hotel hotel = new Hotel();
                    hotel.setIdHotel(i+1);
                    hotel.setName(nameGenerator.compose(3));
                    hotel.setPrice(randomValues.price());
                    hotel.setRating(randomValues.rating());
                    hotel.setDistance(randomValues.distance());
                    hotels.add(hotel);
                }
                for(Hotel h:hotels) {
                    System.out.println("Hotel: "+h.getName()+" "+h.getIdHotel());
                    System.out.println("~"+h.getPrice()+", "+h.getRating()+", "+h.getRating()+", "+h.getDistance()+"~");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }




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
