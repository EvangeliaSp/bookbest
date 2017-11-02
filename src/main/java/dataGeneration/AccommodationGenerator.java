package dataGeneration;

// General: random.nextInt(max - min + 1) + min

import entities.Accommodation;
import hotelGeneration.NameGenerator;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class AccommodationGenerator {

    public AccommodationGenerator() throws IOException {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(name());
        accommodation.setType(type());
        accommodation.setStars(stars());
        accommodation.setCountry(country());
        accommodation.setPostalCode(postal_code());
    }

    private String name() throws IOException {
        NameGenerator nameGenerator = new NameGenerator("./src/main/resources/names.txt");
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

    private String country() {
        String[] locales = Locale.getISOCountries();

        int k = new Random().nextInt(locales.length);
        String countryCode = locales[k];

        Locale obj = new Locale("", countryCode);

        return obj.getDisplayCountry();
    }


    private String city() {
        String city=null;
        return city;
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
