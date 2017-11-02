package dataGeneration;

import entities.Room;

import java.util.Random;

public class RoomGenerator {

    public RoomGenerator() {
        Room room = new Room();
        room.setPricePerNight(price_per_night());
        room.setRating(rating());
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
