package dataGeneration.hotelclub;

import entities.hotelclub.Accommodation;

import java.io.IOException;
import java.sql.Statement;

public class DataGenerator {

    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {

        int hotelclubCounter = 10;// = new Random().nextInt();

        for(int i=0; i<hotelclubCounter ; i++) {
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
