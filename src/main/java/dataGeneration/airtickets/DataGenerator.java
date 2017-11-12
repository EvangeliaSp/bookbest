package dataGeneration.airtickets;

import entities.airtickets.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.Random;

public class DataGenerator {

    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {

        int airticketsCounter = 10;// = new Random().nextInt();

        for(int i=0; i<airticketsCounter; i++) {
            // Create Accommodation
            AccommodationGenerator accommodationGenerator = new AccommodationGenerator(this.statement);
            accommodationGenerator.generate();
            Accommodation accommodation = accommodationGenerator.getAccommodation();
            // Create Facilities for the above Accommodation
            FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, accommodation.getId());
            facilityGenerator.generate();
        }
    }
}
