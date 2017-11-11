package dao.priceline;

import entities.priceline.Accommodation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccommodationDAOImpl implements AccommodationDAO {

    @Override
    public void create(Statement statement, Accommodation accommodation) {
        try {
            String sql = "INSERT INTO priceline.Accommodation VALUES (" +
                    accommodation.getId() + ", " +
                    "'"+accommodation.getName()+"'" + ", " +
                    "'"+accommodation.getType()+"'" + ", " +
                    "'"+accommodation.getStarRating()+"'" + ", " +
                    "'"+accommodation.getPricePerNight()+"'" + ", " +
                    "'"+accommodation.getCountry()+"'" + ", " +
                    "'"+accommodation.getCity()+"'" + ", " +
                    "'"+accommodation.getPeople()+"'" + ", " +
                    "'"+accommodation.getLocation()+"'" + ", " +
                    "'"+accommodation.getGuestRating()+"'" + ", " + ")";
            statement.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in accommodation create: " + ex.getMessage());
            System.out.println("SQLState in accommodation create: " + ex.getSQLState());
            System.out.println("VendorError in accommodation create: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Accommodation> list(Statement statement) {
        List<Accommodation> accommodations = new LinkedList<>();

        try {
            String sql = "SELECT * FROM priceline.Accommodation";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(rs);

            while(rs.next()) {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(rs.getInt("id"));
                accommodation.setName(rs.getString("name"));
                accommodation.setType(rs.getString("type"));
                accommodation.setStarRating(rs.getInt("starRating"));
                accommodation.setPricePerNight(rs.getInt("pricePerNight"));
                accommodation.setCountry(rs.getString("country"));
                accommodation.setCity(rs.getString("city"));
                accommodation.setPeople(rs.getInt("people"));
                accommodation.setLocation(rs.getDouble("location"));
                accommodation.setGuestRating(rs.getDouble("guestRating"));

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