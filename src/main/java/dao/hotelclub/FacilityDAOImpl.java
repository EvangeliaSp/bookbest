package dao.hotelclub;

import entities.hotelclub.Facility;

import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement stmt, Facility facility) {
        try {
            String columns = "id";
            String values = String.valueOf(facility.getId());
            String sql = "INSERT INTO hotelclub.Facility";

            if(facility.getAirportTransfer() != null) {
                columns = columns + ", airportTransfer";
                values = values + ", " + facility.getAirportTransfer();
            }
            if(facility.getBar() != null) {
                columns = columns + ", bar";
                values = values + ", " + facility.getBar();
            }
            if(facility.getBusinessFacilities() != null) {
                columns = columns + ", businessFacilities";
                values = values + ", " + facility.getBusinessFacilities();
            }
            if(facility.getChildcare() != null) {
                columns = columns + ", childcare";
                values = values + ", " + facility.getChildcare();
            }
            if(facility.getConnectingRoomsAvailable() != null) {
                columns = columns + ", connectingRoomsAvailable";
                values = values + ", " + facility.getConnectingRoomsAvailable();
            }
            if(facility.getCribsAvailable() != null) {
                columns = columns + ", cribsAvailable";
                values = values + ", " + facility.getCribsAvailable();
            }
            if(facility.getFreeBreakfast() != null) {
                columns = columns + ", freeBreakfast";
                values = values + ", " + facility.getFreeBreakfast();
            }
            if(facility.getFreeParking() != null) {
                columns = columns + ", freeParking";
                values = values + ", " + facility.getFreeParking();
            }
            if(facility.getFreeWifi() != null) {
                columns = columns + ", freeWifi";
                values = values + ", " + facility.getFreeWifi();
            }
            if(facility.getGym() != null) {
                columns = columns + ", gym";
                values = values + ", " + facility.getGym();
            }
            if(facility.getPetFriendly() != null) {
                columns = columns + ", petFriendly";
                values = values + ", " + facility.getPetFriendly();
            }
            if(facility.getPool() != null) {
                columns = columns + ", pool";
                values = values + ", " + facility.getPool();
            }
            if(facility.getRestaurant() != null) {
                columns = columns + ", restaurant";
                values = values + ", " + facility.getRestaurant();
            }
            if(facility.getSmokingAreas() != null) {
                columns = columns + ", smokingAreas";
                values = values + ", " + facility.getSmokingAreas();
            }
            if(facility.getSpa() != null) {
                columns = columns + ", spa";
                values = values + ", " + facility.getSpa();
            }
            if(facility.getBathtubInRoom() != null) {
                columns = columns + ", bathtubInRoom";
                values = values + ", " + facility.getBathtubInRoom();
            }
            if(facility.getKitchen() != null) {
                columns = columns + ", kitchen";
                values = values + ", " + facility.getKitchen();
            }
            if(facility.getAccessibleBathroom() != null) {
                columns = columns + ", accessibleBathroom";
                values = values + ", " + facility.getAccessibleBathroom();
            }
            if(facility.getInRoomAccessebility() != null) {
                columns = columns + ", inRoomAccessebility";
                values = values + ", " + facility.getInRoomAccessebility();
            }
            if(facility.getRollInShower() != null) {
                columns = columns + ", rollInShower";
                values = values + ", " + facility.getRollInShower();
            }
            if(facility.getWheelchairAccess() != null) {
                columns = columns + ", wheelchairAccess";
                values = values + ", " + facility.getWheelchairAccess();
            }
            if(facility.getFamilyFriendly() != null) {
                columns = columns + ", familyFriendly";
                values = values + ", " + facility.getFamilyFriendly();
            }
            if(facility.getBusiness() != null) {
                columns = columns + ", business";
                values = values + ", " + facility.getBusiness();
            }
            if(facility.getRomantic() != null) {
                columns = columns + ", romantic";
                values = values + ", " + facility.getRomantic();
            }
            if(facility.getAdventure() != null) {
                columns = columns + ", adventure";
                values = values + ", " + facility.getAdventure();
            }
            if(facility.getLuxury() != null) {
                columns = columns + ", luxury";
                values = values + ", " + facility.getLuxury();
            }

            sql = sql + "(" + columns + ") VALUES " + "(" + values + ")";

            stmt.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("Hotelclub: SQLException in facility create: " + ex.getMessage());
            System.out.println("Hotelclub: SQLState in facility create: " + ex.getSQLState());
            System.out.println("Hotelclub: VendorError in facility create: " + ex.getErrorCode());
        }
    }
}
