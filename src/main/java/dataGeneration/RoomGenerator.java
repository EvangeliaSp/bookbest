package dataGeneration;

import java.sql.Statement;
import java.util.Random;

public class RoomGenerator {

    Statement statement;
    private Room room;
    int accId;

    public RoomGenerator(Statement statement, int accId) {
        this.statement = statement;
        this.accId = accId;
    }

    public Room getRoom() {
        return room;
    }

    public void generate() {
        Room room = new Room();
        room.setAccId(this.accId);
        room.setPricePerNight(price_per_night());
        room.setRating(rating());
        RoomDAO roomDAO = new RoomDAOImpl();
        roomDAO.create(this.statement, room);
        this.room = room;
    }

    private int price_per_night() {
        int k = new Random().nextInt(2000);
        return k;
    }

    private double rating() {
        double k = (new Random().nextInt(100-10+1) + 10)/10.0;
        return k;
    }
}
