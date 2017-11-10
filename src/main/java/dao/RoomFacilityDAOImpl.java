package dao;

import entities.RoomFacility;

import java.sql.SQLException;
import java.sql.Statement;

public class RoomFacilityDAOImpl implements RoomFacilityDAO {

    @Override
    public void create(Statement stmt, RoomFacility roomFacility) {

        try {
            String sql = "INSERT INTO RoomFacility VALUES (" +
                roomFacility.getId() + ", " +
                "'"+roomFacility.getBreakfastIncluded()+"'" + ", " +
                "'"+roomFacility.getBreakfastAndDinner()+"'" + ", " +
                "'"+roomFacility.getSelfCatering()+"'" + ", " +
                "'"+roomFacility.getFreeCancellation()+"'" + ", " +
                "'"+roomFacility.getBookWithoutCreditCard()+"'" + ", " +
                "'"+roomFacility.getNoPrepayment()+"'" + ", " +
                "'"+roomFacility.getAirConditioning()+"'" + ", " +
                "'"+roomFacility.getBath()+"'" + ", " +
                "'"+roomFacility.getCoffeeMachine()+"'" + ", " +
                "'"+roomFacility.getElectricKettle()+"'" + ", " +
                "'"+roomFacility.getFlatScreenTv()+"'" + ", " +
                "'"+roomFacility.getKitchenKitchenette()+"'" + ", " +
                "'"+roomFacility.getSoundProofing()+"'" + ", " +
                "'"+roomFacility.getTeaCoffeeMaker()+"'" + ")";
            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in roomFacility create: " + ex.getMessage());
            System.out.println("SQLState in roomFacility create: " + ex.getSQLState());
            System.out.println("VendorError in roomFacility create: " + ex.getErrorCode());
        }
    }
}
