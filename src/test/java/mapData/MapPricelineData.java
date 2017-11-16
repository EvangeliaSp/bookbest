package mapData;

import dataMapping.AirticketsMapping;
import dataMapping.PricelineMapping;
import database.DBConnection;

import java.sql.Statement;

public class MapPricelineData {

    public static void main(String[] args) {
        // Connect to database
        DBConnection dbConnection = new DBConnection();
        dbConnection.connect("priceline");
        Statement statement = dbConnection.getStatement();

        try {
            PricelineMapping pricelineMapping = new PricelineMapping(statement);
            pricelineMapping.importData();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Disconnect from database
        dbConnection.disconnect();
    }
}
