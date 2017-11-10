package dataGeneration;

import dao.RoomFacilityDAO;
import dao.RoomFacilityDAOImpl;
import entities.RoomFacility;

import java.sql.Statement;
import java.util.Random;

public class RoomFacilityGenerator {

    Statement statement;
    int id;

    public RoomFacilityGenerator(Statement statement, int id) {
        this.statement = statement;
        this.id = id;
    }

    public void generate() {
        RoomFacility roomFacility = new RoomFacility();
        roomFacility.setId(this.id);
        int k;

        if((k=bit()) != 2) {
            roomFacility.setBreakfastIncluded((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setBreakfastAndDinner((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setSelfCatering((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setFreeCancellation((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setBookWithoutCreditCard((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setNoPrepayment((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setAirConditioning((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setBath((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setCoffeeMachine((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setElectricKettle((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setFlatScreenTv((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setKitchenKitchenette((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setSoundProofing((byte) k);
        }
        if((k=bit()) != 2) {
            roomFacility.setTeaCoffeeMaker((byte) k);
        }
        RoomFacilityDAO roomFacilityDAO = new RoomFacilityDAOImpl();
        roomFacilityDAO.create(this.statement, roomFacility);
    }

    private int bit() {
        return new Random().nextInt(3);
    }
}
