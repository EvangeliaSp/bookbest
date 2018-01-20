package dataGeneration.priceline;

import dao.priceline.FacilityDAO;
import dao.priceline.FacilityDAOImpl;
import entities.priceline.Facility;

import java.sql.Statement;
import java.util.Random;

public class FacilityGenerator {
/*
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
            facility.setFreeInternet((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeParking((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeBreakfast((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setPetsAllowed((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSwimmingPool((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setAirportShuttle((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setNoSmokingRoomsFacilities((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFitnessCenter((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setHandicappedRoomsFacilities((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setBusinessCenter((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setCasino((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSpa((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setRestaurant((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeCancellation((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setPayLater((byte) k);
        }

        FacilityDAO facilityDAO = new FacilityDAOImpl();
        facilityDAO.create(this.statement, facility);
    }

    private int bit() {
        return new Random().nextInt(3);
    }*/
}
