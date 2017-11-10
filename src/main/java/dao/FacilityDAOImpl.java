package dao;

import entities.Facility;

import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement stmt, Facility facility) {
        try {
            String sql = "INSERT INTO Facility VALUES (" +
                    facility.getId() + ", ";// +
                    //"'"+facility.getPetsAllowed()+"'" + ", " +
                    //"'"+facility.getParking()+"'" + ", " +
                    //"'"+facility.getNonSmokingRooms()+"'" + ", " +
                    //"'"+facility.getRoomService()+"'" + ", " +
                    //"'"+facility.getRestaurant()+"'" + ", " +
                    //"'"+facility.getForDisabledGuests()+"'" + ", " +
                    //"'"+facility.getFreeWifi()+"'" + ", " +
                    //"'"+facility.getFitnessCentre()+"'" + ", " +
                    //"'"+facility.getFamilyRooms()+"'" + ", " +
                    //"'"+facility.getSwimmingPool()+"'" + ", " +
                    //"'"+facility.getSpaAndWellnessCentre()+"'" + ", " +
                    //"'"+facility.getAirportShuttle()+"'" + ", " +
                    //"'"+facility.getReception24Hour()+"'" + ", " +
                    //"'"+facility.getSauna()+"'" + ", " +
                    //"'"+facility.getMassage()+"'" + ", " +
                    //"'"+facility.getBicycleRental()+"'" + ", " +
                    //"'"+facility.getCycling()+"'" + ")";

            if(facility.getPetsAllowed() != null)
                sql = sql+", '"+facility.getPetsAllowed()+"'";
            if(facility.getParking() != null)
                sql = sql+", '"+facility.getParking()+"'";
            if(facility.getNonSmokingRooms() != null)
                sql = sql+", '"+facility.getNonSmokingRooms()+"'";
            if(facility.getRoomService() != null)
                sql = sql+", '"+facility.getRoomService()+"'";
            if(facility.getRestaurant() != null)
                sql = sql+", '"+facility.getRestaurant()+"'";
            if(facility.getForDisabledGuests() != null)
                sql = sql+", '"+facility.getForDisabledGuests()+"'";
            if(facility.getFreeWifi() != null)
                sql = sql+", '"+facility.getFreeWifi()+"'";
            if(facility.getFitnessCentre() != null)
                sql = sql+", '"+facility.getFitnessCentre()+"'";
            if(facility.getFamilyRooms() != null)
                sql = sql+", '"+facility.getFamilyRooms()+"'";
            if(facility.getSwimmingPool() != null)
                sql = sql+", '"+facility.getSwimmingPool()+"'";
            if(facility.getSpaAndWellnessCentre() != null)
                sql = sql+", '"+facility.getSpaAndWellnessCentre()+"'";
            if(facility.getAirportShuttle() != null)
                sql = sql+", '"+facility.getAirportShuttle()+"'";
            if(facility.getReception24Hour() != null)
                sql = sql+", '"+facility.getReception24Hour()+"'";
            if(facility.getSauna() != null)
                sql = sql+", '"+facility.getSauna()+"'";
            if(facility.getMassage() != null)
                sql = sql+", '"+facility.getMassage()+"'";
            if(facility.getBicycleRental() != null)
                sql = sql+", '"+facility.getBicycleRental()+"'";
            if(facility.getCycling() != null)
                sql = sql+", '"+facility.getCycling()+"'";

            sql = sql+")";


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
