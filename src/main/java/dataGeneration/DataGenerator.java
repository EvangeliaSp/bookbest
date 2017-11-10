package dataGeneration;

import dataGeneration.booking.AccommodationGenerator;
import dataGeneration.booking.FacilityGenerator;
import entities.booking.Accommodation;

import java.io.IOException;
import java.sql.Statement;

public class DataGenerator {

    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {
        for(int i=0; i<20; i++) {
            AccommodationGenerator accommodationGenerator = new AccommodationGenerator(this.statement);
            accommodationGenerator.generate();
            Accommodation accommodation = accommodationGenerator.getAccommodation();
            facilityGenerate(accommodation.getId());
        }
    }

    private void facilityGenerate(int id) {
        FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, id);
        facilityGenerator.generate();
    }
}
