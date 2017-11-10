package dao;

import entities.Reservation;

import java.sql.SQLException;
import java.sql.Statement;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public void create(Statement stmt, Reservation reservation) {
        try {
            String sql = "INSERT INTO Reservation VALUES (" +
                    reservation.getId() + ", " +
                    "'"+reservation.getRoomId()+"'" + ", " +
                    "'"+reservation.getArrival()+"'" + ", " +
                    "'"+reservation.getDeparture()+"'" + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in reservation create: " + ex.getMessage());
            System.out.println("SQLState in reservation create: " + ex.getSQLState());
            System.out.println("VendorError in reservation create: " + ex.getErrorCode());
        }
    }
}
