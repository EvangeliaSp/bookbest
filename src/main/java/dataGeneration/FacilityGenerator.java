package dataGeneration;

import java.sql.Statement;
import java.util.Random;

public class FacilityGenerator {

    Statement statement;
    int id;

    public FacilityGenerator(Statement statement, int id) {
        this.statement = statement;
        this.id = id;
    }

    public void generate() {
        Facility facility = new Facility();
        facility.setId(this.id);
        int k;

        if((k=bit()) != 2) {
            facility.setPetsAllowed((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setParking((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setNonSmokingRooms((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setRoomService((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setRestaurant((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setForDisabledGuests((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeWifi((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFitnessCentre((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFamilyRooms((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSwimmingPool((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSpaAndWellnessCentre((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setAirportShuttle((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setReception24Hour((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSauna((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setMassage((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setBicycleRental((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setCycling((byte) k);
        }
        FacilityDAO facilityDAO = new FacilityDAOImpl();
        facilityDAO.create(this.statement, facility);
    }

    private int bit() {
        return new Random().nextInt(3);
    }

}