package dataGeneration;

import dao.AccommodationDAO;
import dao.AccommodationDAOImpl;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import entities.Accommodation;
import entities.Room;

import java.io.IOException;
import java.sql.Statement;
import java.util.List;

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
            roomGenerate(accommodation.getId());
            facilityGenerate(accommodation.getId());
            roomGenerate(accommodation.getId());
            break;
        }
    }

    private void roomGenerate(int id) throws IOException {
        for(int i=0; i<4; i++) {
            RoomGenerator roomGenerator = new RoomGenerator(this.statement, id);
            roomGenerator.generate();
            Room room = roomGenerator.getRoom();
            roomFacilityGenerate(room.getId());
        }
    }

    private void facilityGenerate(int id) {
        FacilityGenerator facilityGenerator = new FacilityGenerator(this.statement, id);
        facilityGenerator.generate();
    }

    private void roomFacilityGenerate(int id) {
        RoomFacilityGenerator roomFacilityGenerator = new RoomFacilityGenerator(this.statement, id);
        roomFacilityGenerator.generate();
    }
}
