package generateDBs;

import dataGeneration.hotelclub.DataGenerator;
import database.DBConnection;

import java.sql.Statement;

public class GenerateHotelclubDB {
   /* public static void main(String[] args) {

        // Connect to database
        DBConnection dbConnection = new DBConnection();
        dbConnection.connect("hotelclub");
        Statement statement = dbConnection.getStatement();

        // Generate data
        DataGenerator dataGenerator = new DataGenerator(statement);
        try {
            dataGenerator.accommodationGenerate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Disconnect from database
        dbConnection.disconnect();
    }*/
}
