package dataGeneration.hotelclub;

import dao.hotelclub.AccommodationDAO;
import dao.hotelclub.AccommodationDAOImpl;
import dataGeneration.CSVReader;
import dataGeneration.NameGenerator;
import entities.hotelclub.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.Random;

public class AccommodationGenerator {
    Accommodation accommodation;
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
        accommodation.setStars(stars());
        accommodation.setRoomType(roomType());
        accommodation.setPricePerNight(price_per_night());
        accommodation.setRating(rating());
        CSVReader csvReader = new CSVReader();
        String[][] place = csvReader.getRandomPlace();
        accommodation.setCountry(place[0][0]);
        accommodation.setCity(place[1][0]);
        accommodation.setAddress(address());
        accommodation.setPostalCode(postal_code());

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
        String[] types = {"Apart-hotel", "Apartment", "Cottage", "Guest house", "Motel",
                "Hotel", "House_boat", "Hostel", "Pension", "Vacation_Home", "Condo"};
        int k = new Random().nextInt(types.length);
        String type = types[k];

        return type;
    }

    private int stars() {
        int k = new Random().nextInt(5) + 1;
        return k;
    }

    private String roomType() {
        String[] roomTypes = {"1_guest", "2_guests", "3_guests", "4_guests", "5+_guests"};
        int k = new Random().nextInt(roomTypes.length);
        String type = roomTypes[k];

        return type;
    }

    private int price_per_night() {
        int k = new Random().nextInt(2000);
        return k;
    }

    private double rating() {
        double k = (new Random().nextInt(50-0+1) + 0)/10.0;
        return k;
    }

    private String address() throws IOException {
        String address;
        NameGenerator addressGenerator = new NameGenerator("./src/main/resources/dataFiles/names.txt");
        address = addressGenerator.compose();

        return address;
    }

    private int postal_code() {

        int postal_code = new Random().nextInt(100000-10000+1) + 10000;

        return postal_code;
    }
}