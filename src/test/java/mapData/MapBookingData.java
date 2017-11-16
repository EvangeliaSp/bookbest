package mapData;

import dataMapping.BookingMapping;
import database.DBConnection;

import java.sql.Statement;

public class MapBookingData {

    public static void main(String[] args) {
        // Connect to database
        DBConnection dbConnection = new DBConnection();
        dbConnection.connect("booking");
        Statement statement = dbConnection.getStatement();

        try {
            BookingMapping bookingMapping = new BookingMapping(statement);
            bookingMapping.importData();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Disconnect from database
        dbConnection.disconnect();
    }
}
