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
        accommodation.setPostalCode(postal_code());

        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        accommodationDAO.create(this.statement, accommodation);

        this.accommodation = accommodation;
    }


    private String name() throws IOException {
        NameGenerator nameGenerator = new NameGenerator("./src/main/resources/dataFiles/names.txt");
        String name;
        Boolean flag;
        //do {
        name = nameGenerator.compose();
        //flag = hotelDAO.find(stmt, name);
        //} while(flag == true);
        return name;
    }

    private String type() {
        String[] types = {"Hotel", "Apartment", "Guest house", "Hostel", "Holiday home",
                "Boat", "Bed and breakfast", "Motel", "Homestay", "Vila", "Lodge"};
        int k = new Random().nextInt(types.length);
        String type = types[k];

        return type;
    }

    private int stars() {
        int k = new Random().nextInt(5) + 1;
        return k;
    }

    private String roomType() {
        String[] roomTypes = {"Twin", "Double Room", "Single Room", "Studio", "Bed in Dormitory",
                "Triple Room", "Family Room", "Quadruple Room", "King Suite"};
        int k = new Random().nextInt(roomTypes.length);
        String type = roomTypes[k];

        return type;
    }

    private int price_per_night() {
        int k = new Random().nextInt(2000);
        return k;
    }

    private double rating() {
        double k = (new Random().nextInt(100-10+1) + 10)/10.0;
        return k;
    }

    private String address() {

        String address = null;

        return address;
    }

    private int postal_code() {

        int postal_code = new Random().nextInt(100000-10000+1) + 10000;

        return postal_code;
    }
}
