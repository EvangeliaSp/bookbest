package hotelGeneration;

import java.util.Locale;
import java.util.Random;

public class CountryGenerator {

    public String generate() {
        String[] locales = Locale.getISOCountries();


        int k = new Random().nextInt(locales.length);
        String countryCode = locales[k];

        Locale obj = new Locale("", countryCode);

        System.out.println("Country Code = " + obj.getCountry()
                + ", Country Name = " + obj.getDisplayCountry());

        return obj.getDisplayCountry();

    }
}
