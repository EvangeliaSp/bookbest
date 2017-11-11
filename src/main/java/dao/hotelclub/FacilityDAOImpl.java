package dao.hotelclub;

import entities.hotelclub.Facility;

import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement stmt, Facility facility) {
        try {
            String columns = "(id";
            String values = "("+facility.getId();
            String sql = "INSERT INTO Facility";

            if(facility.getAirportTransfer() != null) {
                columns = columns + ", airport_transfer";
                values = values + ", '" + facility.getAirportTransfer() + "'";
            }
            if(facility.getBar() != null) {
                columns = columns + ", bar";
                values = values + ", '" + facility.getBar() + "'";
            }
            if(facility.getBusinessFacilities() != null) {
                columns = columns + ", business_facilities";
                values = values + ", '" + facility.getBusinessFacilities() + "'";
            }
            if(facility.getChildcare() != null) {
                columns = columns + ", childcare";
                values = values + ", '" + facility.getChildcare() + "'";
            }
            if(facility.getConnectingRoomsAvailable() != null) {
                columns = columns + ", connecting_rooms_available";
                values = values + ", '" + facility.getConnectingRoomsAvailable() + "'";
            }
            if(facility.getCribsAvailable() != null) {
                columns = columns + ", cribs_available";
                values = values + ", '" + facility.getCribsAvailable() + "'";
            }
            if(facility.getFreeBreakfast() != null) {
                columns = columns + ", free_breakfast";
                values = values + ", '" + facility.getFreeBreakfast() + "'";
            }
            if(facility.getFreeParking() != null) {
                columns = columns + ", free_parking";
                values = values + ", '" + facility.getFreeParking() + "'";
            }
            if(facility.getFreeWifi() != null) {
                columns = columns + ", free_wifi";
                values = values + ", '" + facility.getFreeWifi() + "'";
            }
            if(facility.getGym() != null) {
                columns = columns + ", gym";
                values = values + ", '" + facility.getGym() + "'";
            }
            if(facility.getPetFriendly() != null) {
                columns = columns + ", pet_friendly";
                values = values + ", '" + facility.getPetFriendly() + "'";
            }
            if(facility.getPool() != null) {
                columns = columns + ", pool";
                values = values + ", '" + facility.getPool() + "'";
            }
            if(facility.getRestaurant() != null) {
                columns = columns + ", restaurant";
                values = values + ", '" + facility.getRestaurant() + "'";
            }
            if(facility.getSmokingAreas() != null) {
                columns = columns + ", smoking_areas";
                values = values + ", '" + facility.getSmokingAreas() + "'";
            }
            if(facility.getSpa() != null) {
                columns = columns + ", spa";
                values = values + ", '" + facility.getSpa() + "'";
            }
            if(facility.getBathtubInRoom() != null) {
                columns = columns + ", bathtub_in_room";
                values = values + ", '" + facility.getBathtubInRoom() + "'";
            }
            if(facility.getKitchen() != null) {
                columns = columns + ", kitchen";
                values = values + ", '" + facility.getKitchen() + "'";
            }
            if(facility.getAccessibleBathroom() != null) {
                columns = columns + ", accessible_bathroom";
                values = values + ", '" + facility.getAccessibleBathroom() + "'";
            }
            if(facility.getInRoomAccessebility() != null) {
                columns = columns + ", in_room_accessibility";
                values = values + ", '" + facility.getInRoomAccessebility() + "'";
            }
            if(facility.getRollInShower() != null) {
                columns = columns + ", roll_in_shower";
                values = values + ", '" + facility.getRollInShower() + "'";
            }
            if(facility.getWheelchairAccess() != null) {
                columns = columns + ", wheelchair_access";
                values = values + ", '" + facility.getWheelchairAccess() + "'";
            }
            if(facility.getFamilyFriendly() != null) {
                columns = columns + ", family_friendly";
                values = values + ", '" + facility.getFamilyFriendly() + "'";
            }
            if(facility.getBusiness() != null) {
                columns = columns + ", business";
                values = values + ", '" + facility.getBusiness() + "'";
            }
            if(facility.getRomantic() != null) {
                columns = columns + ", romantic";
                values = values + ", '" + facility.getRomantic() + "'";
            }
            if(facility.getAdventure() != null) {
                columns = columns + ", adventure";
                values = values + ", '" + facility.getAdventure() + "'";
            }
            if(facility.getLuxury() != null) {
                columns = columns + ", luxury";
                values = values + ", '" + facility.getLuxury() + "'";
            }

            sql = sql + columns+") VALUES "+values+")";

            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException in facility create: " + ex.getMessage());
            System.out.println("SQLState in facility create: " + ex.getSQLState());
            System.out.println("VendorError in facility create: " + ex.getErrorCode());
        }
    }
}
