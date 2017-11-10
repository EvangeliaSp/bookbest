package dao.booking;

import entities.booking.Accommodation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class AccommodationDAOImpl implements AccommodationDAO {

    @Override
    public void create(Statement stmt, Accommodation accommodation) {
        try {
            String sql = "INSERT INTO Accommodation VALUES (" +
                    accommodation.getId() + ", " +
                    "'"+accommodation.getName()+"'" + ", " +
                    "'"+accommodation.getType()+"'" + ", " +
                    "'"+accommodation.getStars()+"'" + ", " +
                    "'"+accommodation.getRoomType()+"'" + ", " +
                    "'"+accommodation.getPricePerNight()+"'" + ", " +
                    "'"+accommodation.getRating()+"'" + ", " +
                    "'"+accommodation.getCountry()+"'" + ", " +
                    "'"+accommodation.getCity()+"'" + ", " +
                    "'"+accommodation.getAddress()+"'" + ", " +
                    "'"+accommodation.getPostalCode()+"'" + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in accommodation create: " + ex.getMessage());
            System.out.println("SQLState in accommodation create: " + ex.getSQLState());
            System.out.println("VendorError in accommodation create: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Accommodation> list(Statement stmt) {
        List<Accommodation> accommodations = new LinkedList<>();

        try {
            String sql = "SELECT * FROM Accommodation";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);

            while(rs.next()) {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(rs.getInt("id"));
                accommodation.setName(rs.getString("name"));
                accommodation.setType(rs.getString("type"));
                accommodation.setStars(rs.getInt("stars"));
                accommodation.setRoomType(rs.getString("room_type"));
                accommodation.setPricePerNight(rs.getInt("price_per_night"));
                accommodation.setRating(rs.getDouble("rating"));
                accommodation.setCountry(rs.getString("country"));
                accommodation.setCity(rs.getString("city"));
                accommodation.setAddress(rs.getString("address"));
                accommodation.setPostalCode(rs.getInt("postal_code"));

                accommodations.add(accommodation);
            }

        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in accommodation list: " + ex.getMessage());
            System.out.println("SQLState in accommodation list: " + ex.getSQLState());
            System.out.println("VendorError in accommodation list: " + ex.getErrorCode());
        }
        finally {
            return accommodations;
        }
    }

}
