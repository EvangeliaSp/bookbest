package dao;

import entities.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public void create(Statement stmt, Room room) {
        try {
            String sql = "INSERT INTO Room VALUES (" +
                room.getId() + ", " +
                "'"+room.getAccId()+"'" + ", " +
                "'"+room.getPricePerNight()+"'" + ", " +
                "'"+room.getRating()+"'" + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in room create: " + ex.getMessage());
            System.out.println("SQLState in room create: " + ex.getSQLState());
            System.out.println("VendorError in room create: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Room> list(Statement statement) {
        List<Room> rooms = new LinkedList<>();

        try {
            String sql = "SELECT * FROM Room";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(rs);

            while(rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setAccId(rs.getInt("acc_id"));
                room.setPricePerNight(rs.getInt("price_per_night"));
                room.setRating(rs.getDouble("rating"));

                rooms.add(room);
            }

        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in accommodation list: " + ex.getMessage());
            System.out.println("SQLState in accommodation list: " + ex.getSQLState());
            System.out.println("VendorError in accommodation list: " + ex.getErrorCode());
        }
        finally {
            return rooms;
        }
    }
}
