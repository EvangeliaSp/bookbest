package dataGeneration;

import entities.RoomFacility;

import java.util.Random;

public class RoomFacilityGenerator {

    public RoomFacilityGenerator() {
        RoomFacility roomFacility = new RoomFacility();
        int k;
        byte[] bit = new byte[1];

        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setBreakfastIncluded(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setBreakfastAndDinner(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setSelfCatering(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setFreeCancellation(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setBookWithoutCredit(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setNoPrepayment(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setAirConditioning(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setBath(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setCoffeeMachine(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setElectricKettle(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setFlatScreenTv(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setKitchenKitchenette(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setSoundProofing(bit);
        }
        if((k=bit()) != 2) {
            bit[0] = (byte) k;
            roomFacility.setTeaCoffeeMaker(bit);
        }
    }

    private int bit() {
        return new Random().nextInt(3);
    }
}
