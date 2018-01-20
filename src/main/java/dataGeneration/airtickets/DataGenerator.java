package dataGeneration.airtickets;

import dao.airtickets.AccommodationDAO;
import dao.airtickets.AccommodationDAOImpl;
import entities.airtickets.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

public class DataGenerator {
/*
    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {

        int airticketsCounter = 10;// = new Random().nextInt();

        AccommodationGenerator accommodationGenerator = new AccommodationGenerator(this.statement);
        for(int i=0; i<airticketsCounter; i++) {
            // Create Accommodation
            accommodationGenerator.generate();
        }

        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        List<Accommodation> accommodations = accommodationDAO.list(this.statement);
        for(Accommodation accommodation: accommodations) {
            // Create Accommodation Facilities
            FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, accommodation.getId());
            facilityGenerator.generate();
        }
    }*/
}
