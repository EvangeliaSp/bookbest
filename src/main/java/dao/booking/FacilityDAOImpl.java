package dao.booking;

import entities.booking.Facility;

import java.sql.SQLException;
import java.sql.Statement;

public class FacilityDAOImpl implements FacilityDAO {

    @Override
    public void create(Statement stmt, Facility facility) {
        try {
            String columns = "(id";
            String values = "("+facility.getId();
            String sql = "INSERT INTO booking.Facility";

            if(facility.getPetsAllowed() != null) {
                columns = columns + ", petsAllowed";
                values = values + ", '" + facility.getPetsAllowed() + "'";
            }
            if(facility.getParking() != null) {
                columns = columns + ", parking";
                values = values + ", '" + facility.getParking() + "'";
            }
            if(facility.getNonSmokingRooms() != null) {
                columns = columns + ", nonSmokingRooms";
                values = values + ", '" + facility.getNonSmokingRooms() + "'";
            }
            if(facility.getRoomService() != null) {
                columns = columns + ", roomService";
                values = values + ", '" + facility.getRoomService() + "'";
            }
            if(facility.getRestaurant() != null) {
                columns = columns + ", restaurant";
                values = values + ", '" + facility.getRestaurant() + "'";
            }
            if(facility.getForDisabledGuests() != null) {
                columns = columns + ", forDisabledGuests";
                values = values + ", '" + facility.getForDisabledGuests() + "'";
            }
            if(facility.getFreeWifi() != null) {
                columns = columns + ", freeWifi";
                values = values + ", '" + facility.getFreeWifi() + "'";
            }
            if(facility.getFitnessCentre() != null) {
                columns = columns + ", fitnessCentre";
                values = values + ", '" + facility.getFitnessCentre() + "'";
            }
            if(facility.getFamilyRooms() != null) {
                columns = columns + ", familyRooms";
                values = values + ", '" + facility.getFamilyRooms() + "'";
            }
            if(facility.getSwimmingPool() != null) {
                columns = columns + ", swimmingPool";
                values = values + ", '" + facility.getSwimmingPool() + "'";
            }
            if(facility.getSpaAndWellnessCentre() != null) {
                columns = columns + ", spaAndWellnessCentre";
                values = values + ", '" + facility.getSpaAndWellnessCentre() + "'";
            }
            if(facility.getAirportShuttle() != null) {
                columns = columns + ", airportShuttle";
                values = values + ", '" + facility.getAirportShuttle() + "'";
            }
            if(facility.getReception24Hour() != null) {
                columns = columns + ", reception24Hour";
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
                columns = columns + ", bicycleRental";
                values = values + ", '" + facility.getBicycleRental() + "'";
            }
            if(facility.getCycling() != null) {
                columns = columns + ", cycling";
                values = values + ", '" + facility.getCycling() + "'";
            }
            if(facility.getBreakfastIncluded() != null) {
                columns = columns + ", breakfastIncluded";
                values = values + ", '" + facility.getBreakfastIncluded() + "'";
            }
            if(facility.getBreakfastAndDinner() != null) {
                columns = columns + ", breakfastAndDinner";
                values = values + ", '" + facility.getBreakfastAndDinner() + "'";
            }
            if(facility.getSelfCatering() != null) {
                columns = columns + ", selfCatering";
                values = values + ", '" + facility.getSelfCatering() + "'";
            }
            if(facility.getFreeCancellation() != null) {
                columns = columns + ", freeCancellation";
                values = values + ", '" + facility.getFreeCancellation() + "'";
            }
            if(facility.getBookWithoutCreditCard() != null) {
                columns = columns + ", bookWithoutCreditCard";
                values = values + ", '" + facility.getBookWithoutCreditCard() + "'";
            }
            if(facility.getNoPrepayment() != null) {
                columns = columns + ", noPrepayment";
                values = values + ", '" + facility.getNoPrepayment() + "'";
            }
            if(facility.getAirConditioning() != null) {
                columns = columns + ", airConditioning";
                values = values + ", '" + facility.getAirConditioning() + "'";
            }
            if(facility.getBath() != null) {
                columns = columns + ", bath";
                values = values + ", '" + facility.getBath() + "'";
            }
            if(facility.getCoffeeMachine() != null) {
                columns = columns + ", coffeeMachine";
                values = values + ", '" + facility.getCoffeeMachine() + "'";
            }
            if(facility.getElectricKettle() != null) {
                columns = columns + ", electricKettle";
                values = values + ", '" + facility.getElectricKettle() + "'";
            }
            if(facility.getFlatScreenTv() != null) {
                columns = columns + ", flatScreenTV";
                values = values + ", '" + facility.getFlatScreenTv() + "'";
            }
            if(facility.getKitchenKitchenette() != null) {
                columns = columns + ", kitchenKitchenette";
                values = values + ", '" + facility.getKitchenKitchenette() + "'";
            }
            if(facility.getSoundProofing() != null) {
                columns = columns + ", soundProofing";
                values = values + ", '" + facility.getSoundProofing() + "'";
            }
            if(facility.getTeaCoffeeMaker() != null) {
                columns = columns + ", teaCoffeeMaker(";
                values = values + ", '" + facility.getTeaCoffeeMaker() + "'";
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
