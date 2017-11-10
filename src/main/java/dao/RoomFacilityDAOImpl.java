package dao;

import entities.RoomFacility;

import java.sql.SQLException;
import java.sql.Statement;

public class RoomFacilityDAOImpl implements RoomFacilityDAO {

    @Override
    public void create(Statement stmt, RoomFacility roomFacility) {

        try {
            String columns = "(id";
            String values = "("+roomFacility.getId();
            String sql = "INSERT INTO RoomFacility";

            if(roomFacility.getBreakfastIncluded() != null) {
                columns = columns + ", breakfast_included";
                values = values + ", '" + roomFacility.getBreakfastIncluded() + "'";
            }
            if(roomFacility.getBreakfastAndDinner() != null) {
                columns = columns + ", breakfast_and_dinner";
                values = values + ", '" + roomFacility.getBreakfastAndDinner() + "'";
            }
            if(roomFacility.getSelfCatering() != null) {
                columns = columns + ", self_catering";
                values = values + ", '" + roomFacility.getSelfCatering() + "'";
            }
            if(roomFacility.getFreeCancellation() != null) {
                columns = columns + ", free_cancellation";
                values = values + ", '" + roomFacility.getFreeCancellation() + "'";
            }
            if(roomFacility.getBookWithoutCreditCard() != null) {
                columns = columns + ", book_without_credit_card";
                values = values + ", '" + roomFacility.getBookWithoutCreditCard() + "'";
            }
            if(roomFacility.getNoPrepayment() != null) {
                columns = columns + ", no_prepayment";
                values = values + ", '" + roomFacility.getNoPrepayment() + "'";
            }
            if(roomFacility.getAirConditioning() != null) {
                columns = columns + ", air_conditioning";
                values = values + ", '" + roomFacility.getAirConditioning() + "'";
            }
            if(roomFacility.getBath() != null) {
                columns = columns + ", bath";
                values = values + ", '" + roomFacility.getBath() + "'";
            }
            if(roomFacility.getCoffeeMachine() != null) {
                columns = columns + ", coffee_machine";
                values = values + ", '" + roomFacility.getCoffeeMachine() + "'";
            }
            if(roomFacility.getElectricKettle() != null) {
                columns = columns + ", electric_kettle";
                values = values + ", '" + roomFacility.getElectricKettle() + "'";
            }
            if(roomFacility.getFlatScreenTv() != null) {
                columns = columns + ", flat_screen_TV";
                values = values + ", '" + roomFacility.getFlatScreenTv() + "'";
            }
            if(roomFacility.getKitchenKitchenette() != null) {
                columns = columns + ", kitchen_kitchenette";
                values = values + ", '" + roomFacility.getKitchenKitchenette() + "'";
            }
            if(roomFacility.getSoundProofing() != null) {
                columns = columns + ", sound_proofing";
                values = values + ", '" + roomFacility.getSoundProofing() + "'";
            }
            if(roomFacility.getTeaCoffeeMaker() != null) {
                columns = columns + ", tea_coffee_maker(";
                values = values + ", '" + roomFacility.getTeaCoffeeMaker() + "'";
            }
            sql = sql + columns+") VALUES "+values+")";

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
