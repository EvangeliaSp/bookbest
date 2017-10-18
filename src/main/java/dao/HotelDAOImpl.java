package dao;

import entities.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    // Override methods do not throw Exceptions

    @Override
    public void create(Statement stmt, Hotel hotel) {
        try {
            String sql = "INSERT INTO Hotel VALUES (" +
                    hotel.getIdHotel() + ", " +
                    "'"+hotel.getName()+"'" + ", " +
                    "'"+hotel.getPrice()+"'" + ", " +
                    "'"+hotel.getRating()+"'" + ", " +
                    "'"+hotel.getDistance()+"'" + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in create: " + ex.getMessage());
            System.out.println("SQLState in create: " + ex.getSQLState());
            System.out.println("VendorError in create: " + ex.getErrorCode());
        }
    }

    @Override
    public void delete(Statement stmt, int idHotel) {
        try {
            String sql = "DELETE FROM Hotel WHERE idHotel = " + idHotel;
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in delete: " + ex.getMessage());
            System.out.println("SQLState in delete: " + ex.getSQLState());
            System.out.println("VendorError in delete: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Hotel> list(Statement stmt) {
        List<Hotel> hotels = new LinkedList<>();

        try {
            String sql = "SELECT * FROM Hotel";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setIdHotel(rs.getInt("idHotel"));
                hotel.setName(rs.getString("name"));
                hotel.setPrice(rs.getString("price"));
                hotel.setRating(rs.getString("rating"));
                hotel.setDistance(rs.getString("distance"));

                hotels.add(hotel);
            }

        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in list: " + ex.getMessage());
            System.out.println("SQLState in list: " + ex.getSQLState());
            System.out.println("VendorError in list: " + ex.getErrorCode());
        }
        finally {
            return hotels;
        }
    }

    @Override
    public int count(Statement stmt) {
        int counter=0;
        try {
            String sql = "SELECT COUNT(*) AS total FROM Hotel";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next())
                counter = rs.getInt("total");
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in count: " + ex.getMessage());
            System.out.println("SQLState in count: " + ex.getSQLState());
            System.out.println("VendorError in count: " + ex.getErrorCode());
        }
        finally {
            return counter;
        }
    }

    @Override
    public Hotel find(Statement stmt, int idHotel) {
        Hotel hotel = null;

        try {
            String sql = "SELECT * FROM Hotel WHERE idHotel = "+idHotel;
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
                hotel = new Hotel();
                hotel.setIdHotel(rs.getInt("idHotel"));
                hotel.setName(rs.getString("name"));
                hotel.setPrice(rs.getString("price"));
                hotel.setRating(rs.getString("rating"));
                hotel.setDistance(rs.getString("distance"));
            }
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in list: " + ex.getMessage());
            System.out.println("SQLState in list: " + ex.getSQLState());
            System.out.println("VendorError in list: " + ex.getErrorCode());
        }
        finally {
            return hotel;
        }
    }
}
