package database;

import dataMapping.Mappings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {

    private static final int DATA=1000;

    private String filename;
    Mappings mappings;
    DBConnection dbConnection;

    public DataGenerator (String filename, Mappings mappings, DBConnection dbConnection) {
        this.filename = filename;
        this.mappings = mappings;
        this.dbConnection = dbConnection;
    }

    public void generateData() {
        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String database, table1, table2;
            ArrayList<String> columns1, columns2;
            Connection connection;
            Statement statement;
            ArrayList<String> idValues = mappings.getHasIdValues();

            while ((database = bufferedReader.readLine()) != null) {
                dbConnection.connect(database);
                connection = dbConnection.getConnection();
                statement = dbConnection.getStatement();
                ArrayList<String> characteristics = this.mappings.findCharacteristic(database);

                if((table1 = bufferedReader.readLine()) != null) {
                    bufferedReader.readLine();
                    columns1 = dbConnection.getColumns(connection, database, table1);
                    this.generateHotels(statement, table1, columns1, characteristics.get(0));
                    if((table2 = bufferedReader.readLine()) != null) {
                        columns2 = dbConnection.getColumns(connection, database, table2);
                        this.generateFacilities(statement, table2, columns2, idValues);
                        bufferedReader.readLine();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateHotels(Statement statement, String table, ArrayList<String> columns, String rate) {
        String cols, values, sqlInsert, key;
        CSVReader csvReader = new CSVReader();
        try {
            for (int i = 1; i <= DATA; i++) {
                cols = "";
                values = "";
                String[][] place = csvReader.getRandomPlace();
                for (String c: columns) {
                    key = mappings.findColumn(c);
                    switch (key) {
                        case "hasId":
                            break;
                        case "hasName":
                            cols = cols + c + ",";
                            values = values +"'"+csvReader.getRandomName()+"'"+ ",";
                            break;
                        case "hasStars":
                            cols = cols + c + ",";
                            values = values + stars() + ",";
                            break;
                        case "hasPricePerNight":
                            cols = cols + c + ",";
                            values = values + price_per_night() + ",";
                            break;
                        case "isInCountry":
                            cols = cols + c + ",";
                            values = values+"'" + place[0][0]+"'" + ",";
                            break;
                        case "isInCity":
                            cols = cols + c + ",";
                            values = values+"'" + place[0][1]+"'" + ",";
                            break;
                        case "hasCityCenterDistance":
                            cols = cols + c + ",";
                            values = values + distance() + ",";
                            break;
                        default:    // hasRating or hasLocationRating
                            cols = cols + c + ",";
                            values = values + rating(Integer.valueOf(rate)) + ",";
                    }
                }
                cols = cols.substring(0, cols.length() - 1);
                values = values.substring(0, values.length() - 1);
                sqlInsert = "INSERT INTO " + table + " (" + cols + ") VALUES (" + values + ")";
                statement.executeUpdate(sqlInsert);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateFacilities(Statement statement, String table, ArrayList<String> columns, ArrayList<String> idValues) throws SQLException {
        int k;
        String cols, values, sqlInsert;
        try {
            for (int i = 1; i <= DATA; i++) {
                cols = "";
                values = "";
                for (String c : columns) {
                    if (idValues.contains(c)) {
                        cols = cols + c + ",";
                        values = values + String.valueOf(i) + ",";
                    } else {
                        if ((k = bit()) != 2) {
                            cols = cols + c + ",";
                            values = values + String.valueOf(k) + ",";
                        }
                    }
                }
                cols = cols.substring(0, cols.length() - 1);
                values = values.substring(0, values.length() - 1);
                sqlInsert = "INSERT INTO "+table+" ("+cols+") VALUES ("+values+")";
                statement.executeUpdate(sqlInsert);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int bit() {
        return new Random().nextInt(3);
    }

    private int stars() {
        int k = new Random().nextInt(6);
        return k;
    }

    private int price_per_night() {
        int k = new Random().nextInt(220);
        return k;
    }

    private double distance() {
        double k = (new Random().nextInt(101))/10.0;
        return k;
    }

    private double rating(int n) {
        double k = (new Random().nextInt(n+1)+n%2)/10.0;
        return k;
    }
}
