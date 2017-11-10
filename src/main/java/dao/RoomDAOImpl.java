package dao;


import entities.Room;

import java.sql.SQLException;
import java.sql.Statement;

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
}
