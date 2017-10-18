package hotelGeneration;

import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;

import java.io.IOException;
import java.sql.Statement;

public class HotelGenerator {
    public void generate(Statement stmt) throws IOException {
        HotelDAO hotelDAO = new HotelDAOImpl();
        NameGenerator nameGenerator;

            RandomValues randomValues = new RandomValues();

            nameGenerator = new NameGenerator("./src/main/resources/names.txt");

            for(int i=1; i<100; i++) {
                Hotel hotel = new Hotel();
                hotel.setIdHotel(i);
                String name;
                Boolean flag;
                do {
                    name = nameGenerator.compose();
                    flag = hotelDAO.find(stmt, name);
                } while(flag == true);

                hotel.setName(name);
                hotel.setPrice(randomValues.price());
                hotel.setRating(randomValues.rating());
                hotel.setDistance(randomValues.distance());
                hotelDAO.create(stmt, hotel);
            }


    }
}
