package dataGeneration.booking;

import dao.booking.AccommodationDAO;
import dao.booking.AccommodationDAOImpl;
import dataGeneration.CSVReader;
import dataGeneration.NameGenerator;
import entities.booking.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.Random;

public class AccommodationGenerator {
    /*Accommodation accommodation;
    Statement statement;

    public AccommodationGenerator(Statement statement) {
        this.statement = statement;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void generate() throws IOException {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(name());
        accommodation.setType(type());
        accommodation.setStarRating(stars());
        accommodation.setPricePerNight(price_per_night());
        accommodation.setGuestRating(guestRating());
        CSVReader csvReader = new CSVReader();
        String[][] place = csvReader.getRandomPlace();
        accommodation.setCountry(place[0][0]);
        accommodation.setCity(place[1][0]);
        accommodation.setDistanceFromCityCenter(distanceFromCityCenter());
        accommodation.setGuestLocationRating(guestLocationRating());
        accommodation.setRoomType(roomType());

        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        accommodationDAO.create(this.statement, accommodation);

        this.accommodation = accommodation;
    }


    private String name() throws IOException {
        NameGenerator nameGenerator = new NameGenerator("./src/main/resources/dataFiles/names.txt");
        String name;
        name = nameGenerator.compose();
        return name;
    }

    private String type() {
        String[] types = {"Hotel", "Apartment", "Guest_house", "Hostel", "Holiday_home",
                "Boat", "Bed_and_breakfast", "Motel", "Homestay", "Vila", "Lodge"};
        int k = new Random().nextInt(types.length);
        String type = types[k];

        return type;
    }

    private int stars() {
        int k = new Random().nextInt(6);
        return k;
    }

    private int price_per_night() {
        int k = new Random().nextInt(700);
        return k;
    }

    private double guestRating() {
        double k = (new Random().nextInt(101))/10.0;
        return k;
    }

    private double distanceFromCityCenter() throws IOException {
        double k = (new Random().nextInt(101))/10.0;
        return k;
    }

    private double guestLocationRating() {
        double k = (new Random().nextInt(101))/10.0;
        return k;
    }

    private String roomType() {
        String[] roomTypes = {"Single Room", "Double Room", "Triple Room", "Quadruple Room", "Family Room"};
        int k = new Random().nextInt(roomTypes.length);
        String type = roomTypes[k];

        return type;
    }*/
}
