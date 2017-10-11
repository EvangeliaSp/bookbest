package hotelGeneration;

import java.util.Random;

public class RandomValues {

    public String price() {
        String[] prices = {"VeryCheap", "Cheap", "Average", "Expensive"};
        int k = new Random().nextInt(prices.length);
        String price = prices[k];

        return price;
    }

    public String rating() {
        String[] ratings = {"NoRate", "Pleasant", "Good", "Superb"};
        int k = new Random().nextInt(ratings.length);
        String rating = ratings[k];

        return rating;
    }

    public String distance() {
        String[] distances = {"Close", "Away", "FarAway"};
        int k = new Random().nextInt(distances.length);
        String distance = distances[k];

        return distance;
    }
}

