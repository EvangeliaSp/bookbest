package hotelGeneration;

import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;

import java.sql.Statement;

public class HotelGenerator {
    public void generate(Statement stmt) {
        HotelDAO hotelDAO = new HotelDAOImpl();
        try {
            RandomValues randomValues = new RandomValues();
            NameGenerator nameGenerator = new NameGenerator("./src/main/resources/names.txt");
            System.out.println("Generate Hotels");
            for(int i=1; i<20; i++) {
                Hotel hotel = new Hotel();
                hotel.setName(nameGenerator.compose());
                hotel.setPrice(randomValues.price());
                hotel.setRating(randomValues.rating());
                hotel.setDistance(randomValues.distance());
                hotelDAO.create(stmt, hotel);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
