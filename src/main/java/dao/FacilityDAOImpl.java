package dao;

import entities.Facility;

import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement stmt, Facility facility) {
        try {
            String columns = "(id";
            String values = "("+facility.getId();
            String sql = "INSERT INTO Facility";

            if(facility.getPetsAllowed() != null) {
                columns = columns + ", pets_allowed";
                values = values + ", '" + facility.getPetsAllowed() + "'";
            }
            if(facility.getParking() != null) {
                columns = columns + ", parking";
                values = values + ", '" + facility.getParking() + "'";
            }
            if(facility.getNonSmokingRooms() != null) {
                columns = columns + ", non_smoking_rooms";
                values = values + ", '" + facility.getNonSmokingRooms() + "'";
            }
            if(facility.getRoomService() != null) {
                columns = columns + ", room_service";
                values = values + ", '" + facility.getRoomService() + "'";
            }
            if(facility.getRestaurant() != null) {
                columns = columns + ", restaurant";
                values = values + ", '" + facility.getRestaurant() + "'";
            }
            if(facility.getForDisabledGuests() != null) {
                columns = columns + ", for_disabled_guests";
                values = values + ", '" + facility.getForDisabledGuests() + "'";
            }
            if(facility.getFreeWifi() != null) {
                columns = columns + ", free_wifi";
                values = values + ", '" + facility.getFreeWifi() + "'";
            }
            if(facility.getFitnessCentre() != null) {
                columns = columns + ", fitness_centre";
                values = values + ", '" + facility.getFitnessCentre() + "'";
            }
            if(facility.getFamilyRooms() != null) {
                columns = columns + ", family_rooms";
                values = values + ", '" + facility.getFamilyRooms() + "'";
            }
            if(facility.getSwimmingPool() != null) {
                columns = columns + ", swimming_pool";
                values = values + ", '" + facility.getSwimmingPool() + "'";
            }
            if(facility.getSpaAndWellnessCentre() != null) {
                columns = columns + ", spa_and_wellness_centre";
                values = values + ", '" + facility.getSpaAndWellnessCentre() + "'";
            }
            if(facility.getAirportShuttle() != null) {
                columns = columns + ", airport_shuttle";
                values = values + ", '" + facility.getAirportShuttle() + "'";
            }
            if(facility.getReception24Hour() != null) {
                columns = columns + ", reception_24_hour";
                values = values + ", '" + facility.getReception24Hour() + "'";
            }
            if(facility.getSauna() != null) {
                columns = columns + ", sauna";
                values = values + ", '" + facility.getSauna() + "'";
            }
            if(facility.getMassage() != null) {
                columns = columns + ", massage";
                values = values + ", '" + facility.getMassage() + "'";
            }
            if(facility.getBicycleRental() != null) {
                columns = columns + ", bicycle_rental";
                values = values + ", '" + facility.getBicycleRental() + "'";
            }
            if(facility.getCycling() != null) {
                columns = columns + ", cycling";
                values = values + ", '" + facility.getCycling() + "'";
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
