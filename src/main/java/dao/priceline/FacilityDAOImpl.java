package dao.priceline;

import entities.priceline.Facility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement statement, Facility facility) {
        try {
            String columns = "id";
            String values = String.valueOf(facility.getId());
            String sql = "INSERT INTO priceline.Facility";

            if(facility.getFreeInternet() != null) {
                columns = columns + ", freeInternet";
                values = values + ", " + facility.getFreeInternet();
            }
            if(facility.getFreeParking() != null) {
                columns = columns + ", freeParking";
                values = values + ", " + facility.getFreeParking();
            }
            if(facility.getFreeBreakfast() != null) {
                columns = columns + ", freeBreakfast";
                values = values + ", " + facility.getFreeBreakfast();
            }
            if(facility.getPetsAllowed() != null) {
                columns = columns + ", petsAllowed";
                values = values + ", " + facility.getPetsAllowed();
            }
            if(facility.getSwimmingPool() != null) {
                columns = columns + ", swimmingPool";
                values = values + ", " + facility.getSwimmingPool();
            }
            if(facility.getAirportShuttle() != null) {
                columns = columns + ", airportShuttle";
                values = values + ", " + facility.getAirportShuttle();
            }
            if(facility.getNoSmokingRoomsFacilities() != null) {
                columns = columns + ", noSmokingRoomsFacilities";
                values = values + ", " + facility.getNoSmokingRoomsFacilities();
            }
            if(facility.getFitnessCenter() != null) {
                columns = columns + ", fitnessCenter";
                values = values + ", " + facility.getFitnessCenter();
            }
            if(facility.getHandicappedRoomsFacilities() != null) {
                columns = columns + ", handicappedRoomsFacilities";
                values = values + ", " + facility.getHandicappedRoomsFacilities();
            }
            if(facility.getBusinessCenter() != null) {
                columns = columns + ", businessCenter";
                values = values + ", " + facility.getBusinessCenter();
            }
            if(facility.getCasino() != null) {
                columns = columns + ", casino";
                values = values + ", " + facility.getCasino();
            }
            if(facility.getSpa() != null) {
                columns = columns + ", spa";
                values = values + ", " + facility.getSpa();
            }
            if(facility.getRestaurant() != null) {
                columns = columns + ", restaurant";
                values = values + ", " + facility.getRestaurant();
            }
            if(facility.getFreeCancellation() != null) {
                columns = columns + ", freeCancellation";
                values = values + ", " + facility.getFreeCancellation();
            }
            if(facility.getPayLater() != null) {
                columns = columns + ", payLater";
                values = values + ", " + facility.getPayLater();
            }

            sql = sql + "(" + columns + ") VALUES " + "(" + values + ")";

            statement.executeUpdate(sql);
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("Priceline: SQLException in facility create: " + ex.getMessage());
            System.out.println("Priceline: SQLState in facility create: " + ex.getSQLState());
            System.out.println("Priceline: VendorError in facility create: " + ex.getErrorCode());
        }
    }

    @Override
    public Facility find(Statement statement, int id) {
        Facility facility = null;

        try {
            String sql = "SELECT * FROM priceline.Facility WHERE id=" + id;
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()) {
                facility = new Facility();
                facility.setFreeInternet(rs.getByte("freeInternet"));
                facility.setFreeParking(rs.getByte("freeParking"));
                facility.setFreeBreakfast(rs.getByte("freeBreakfast"));
                facility.setPetsAllowed(rs.getByte("petsAllowed"));
                facility.setSwimmingPool(rs.getByte("swimmingPool"));
                facility.setAirportShuttle(rs.getByte("airportShuttle"));
                facility.setNoSmokingRoomsFacilities(rs.getByte("noSmokingRoomsFacilities"));
                facility.setFitnessCenter(rs.getByte("fitnessCenter"));
                facility.setHandicappedRoomsFacilities(rs.getByte("handicappedRoomsFacilities"));
                facility.setBusinessCenter(rs.getByte("businessCenter"));
                facility.setCasino(rs.getByte("casino"));
                facility.setSpa(rs.getByte("spa"));
                facility.setRestaurant(rs.getByte("restaurant"));
                facility.setFreeCancellation(rs.getByte("freeCancellation"));
                facility.setPayLater(rs.getByte("payLater"));
            }
        }
        catch (SQLException ex) {
            // Handle the errors
            System.out.println("Booking: SQLException in facility find: " + ex.getMessage());
            System.out.println("Booking: SQLState in facility find: " + ex.getSQLState());
            System.out.println("Booking: VendorError in facility find: " + ex.getErrorCode());
        }
        finally {
            return facility;
        }
    }
}
