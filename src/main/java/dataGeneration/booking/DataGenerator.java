package dataGeneration.booking;

import dao.booking.AccommodationDAO;
import dao.booking.AccommodationDAOImpl;
import entities.booking.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.List;

public class DataGenerator {
/*
    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {

        int bookingCounter = 10;// = new Random().nextInt();

        AccommodationGenerator accommodationGenerator = new AccommodationGenerator(this.statement);
        for(int i=0; i<bookingCounter; i++) {
            // Create Accommodation
            accommodationGenerator.generate();
        }

        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        List<Accommodation> accommodations = accommodationDAO.list(this.statement);
        for (Accommodation accommodation: accommodations) {
            // Creates Accommodation Facilities
            FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, accommodation.getId());
            facilityGenerator.generate();
        }
    }*/
}
