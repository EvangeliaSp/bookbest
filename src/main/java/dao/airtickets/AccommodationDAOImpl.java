package dao.airtickets;

import entities.airtickets.Accommodation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccommodationDAOImpl implements AccommodationDAO {

    @Override
    public void create(Statement statement, Accommodation accommodation) {
        try {
            String sql = "INSERT INTO airtickets.Accommodation VALUES (" +
                    accommodation.getId() + ", " +
                    "'"+accommodation.getName() +"'" + ", " +
                    "'"+accommodation.getType() +"'" + ", " +
                    accommodation.getStarRating() + ", " +
                    accommodation.getPricePerNight() + ", " +
                    accommodation.getGuestRating() + ", " +
                    "'"+accommodation.getCountry()+"'" + ", " +
                    "'"+accommodation.getCity()+"'" + ", " +
                    accommodation.getDistanceFromCityCenter() + ", " +
                    accommodation.getGuestLocationRating() + ", " +
                    "'"+accommodation.getRoomType()+"'" + ")";

            statement.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("Airtickets: SQLException in accommodation create: " + ex.getMessage());
            System.out.println("Airtickets: SQLState in accommodation create: " + ex.getSQLState());
            System.out.println("Airtickets: VendorError in accommodation create: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Accommodation> list(Statement statement) {
        List<Accommodation> accommodations = new LinkedList<>();

        try {
            String sql = "SELECT * FROM airtickets.Accommodation";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(rs.getInt("id"));
                accommodation.setName(rs.getString("name"));
                accommodation.setType(rs.getString("type"));
                accommodation.setStarRating(rs.getInt("starRating"));
                accommodation.setPricePerNight(rs.getInt("pricePerNight"));
                accommodation.setGuestRating(rs.getDouble("guestRating"));
                accommodation.setCountry(rs.getString("country"));
                accommodation.setCity(rs.getString("city"));
                accommodation.setDistanceFromCityCenter(rs.getDouble("distanceFromCityCenter"));
                accommodation.setGuestLocationRating(rs.getDouble("guestLocationRating"));
                accommodation.setRoomType(rs.getString("roomType"));

                accommodations.add(accommodation);
            }

        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("Airtickets: SQLException in accommodation list: " + ex.getMessage());
            System.out.println("Airtickets: SQLState in accommodation list: " + ex.getSQLState());
            System.out.println("Airtickets: VendorError in accommodation list: " + ex.getErrorCode());
        }
        finally {
            return accommodations;
        }
    }
}
