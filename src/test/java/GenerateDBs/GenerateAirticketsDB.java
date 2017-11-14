package GenerateDBs;

import dataGeneration.airtickets.DataGenerator;
import database.DBConnection;

import java.sql.Statement;

public class GenerateAirticketsDB {
    public static void main(String[] args) {

        // Connect to database
        DBConnection dbConnection = new DBConnection();
        dbConnection.connect("airtickets");
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
    }
}
