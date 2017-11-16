package dataGeneration.hotelclub;

import dao.hotelclub.FacilityDAO;
import dao.hotelclub.FacilityDAOImpl;
import entities.hotelclub.Facility;

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
            facility.setAirportTransfer((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setBar((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setBusinessFacilities((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setChildcare((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setCribsAvailable((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeBreakfast((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeParking((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setFreeWifi((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setGym((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setPetFriendly((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setPool((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setRestaurant((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSmokingAreas((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setSpa((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setBathtubInRoom((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setKitchen((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setAccessibleBathroom((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setInRoomAccessibility((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setRollInShower((byte) k);
        }
        if((k=bit()) != 2) {
            facility.setWheelchairAccess((byte) k);
        }

        FacilityDAO facilityDAO = new FacilityDAOImpl();
        facilityDAO.create(this.statement, facility);
    }

    private int bit() {
        return new Random().nextInt(3);
    }
}
