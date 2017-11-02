package dataGeneration;

import entities.Facility;

import java.util.Random;

public class FacilityGenerator {

    public FacilityGenerator() {
        Facility facility = new Facility();
        int k;
        byte[] bit = new byte[1];

        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setPetsAllowed(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setParking(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setNonSmokingRooms(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setRoomService(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setRestaurant(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setForDisabledGuests(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setFreeWifi(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setFitnessCentre(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setFamilyRooms(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setSwimmingPool(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setSpaAndWellnessCentre(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setAirportShuttle(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setReception24Hour(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setSauna(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setMassage(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setBicycleRental(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            facility.setCycling(bit);
        }

    }

    private int bit() {
        return new Random().nextInt(3);
    }

}