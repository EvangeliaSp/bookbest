package dataGeneration.priceline;

import dao.priceline.AccommodationDAO;
import dao.priceline.AccommodationDAOImpl;
import entities.priceline.Accommodation;

import java.io.IOException;
import java.sql.Statement;
import java.util.List;

public class DataGenerator {

    private Statement statement;

    public DataGenerator(Statement statement) {
        this.statement = statement;
    }

    public void accommodationGenerate() throws IOException {

        int pricelineCounter = 10;// = new Random().nextInt();

        for(int i=0; i<pricelineCounter ; i++) {
            // Create Accommodation
            AccommodationGenerator accommodationGenerator = new AccommodationGenerator(this.statement);
            accommodationGenerator.generate();
        }

        AccommodationDAO accommodationDAO = new AccommodationDAOImpl();
        List<Accommodation> accommodations = accommodationDAO.list(this.statement);
        for(Accommodation accommodation: accommodations) {
            // Create Accommodation Facilities
            FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, accommodation.getId());
            facilityGenerator.generate();
        }
    }
}
