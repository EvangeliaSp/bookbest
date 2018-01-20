package database;

import dataMapping.Mappings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;



public class DataGenerator {

    private static final int DATA=1000;

    private String filename;
    private static String jdbcDriver = "com.mysql.jdbc.Driver";
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
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine, database, table1, table2;
            ArrayList<String> columns1, columns2;
            Connection connection;
            Statement statement;
            ArrayList<String> idValues = mappings.getHasIdValues();


            while ((database = br.readLine()) != null) {
                dbConnection.connect(database);
                connection = dbConnection.getConnection();
                statement = dbConnection.getStatement();


                if((table1 = br.readLine()) != null) {
                    br.readLine();
                    columns1 = dbConnection.getColumns(connection, database, table1);
                    this.generateHotels(statement, table1, columns1);
                    if((table2 = br.readLine()) != null) {
                        columns2 = dbConnection.getColumns(connection, database, table2);
                        this.generateFacilities(statement, table2, columns2, idValues);
                        br.readLine();
                    }
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateHotels(Statement statement, String table, ArrayList<String> columns) {
        int k;
        String cols, values, sqlInsert, key;
        String[][] array = new String[DATA+1][columns.size()];
        int j=0;
        for(String c:columns) {
            array[0][j] = c;
            key = mappings.findColumn(c);
            switch (key) {
                case "hasId":
                    break;
                case "hasName":
                    break;
                case "hasStars":
                    break;
                case "hasPricePerNight":
                    break;
                case "isInCountry":
                    break;
                case "isInCity":
                    break;
                case "hasCityCenterDistance":
                    break;
                default:
                    
            }
            /*if(idValues.contains(c)) {
                for(int i=1; i<=DATA; i++) {
                    array[i][j] = String.valueOf(i);
                }
            }
            else {
                for(int i=1; i<=DATA; i++) {
                    k=bit();
                    array[i][j] = String.valueOf(k);
                }
            }*/
            j++;
        }
        /*for(int i=1; i<DATA+1; i++) {
            cols="";
            values="";
            for(j=0; j<columns.size(); j++) {
                if(!array[i][j].equals("2")) {
                    cols = cols+array[0][j]+",";
                    values = values+array[i][j]+",";
                }
                else {
                    if(idValues.contains(array[0][j])) {
                        cols = cols+array[0][j]+",";
                        values = values+array[i][j]+",";
                    }
                }
            }
            cols = cols.substring(0, cols.length()-1);
            values = values.substring(0, values.length()-1);
            System.out.println(cols);
            System.out.println(values);

            //sqlInsert = "INSERT INTO "+table+" ("+cols+") VALUES ("+values+")";
            //statement.executeUpdate(sqlInsert);
        }*/
    }

    private void generateFacilities(Statement statement, String table, ArrayList<String> columns, ArrayList<String> idValues) throws SQLException {
        int k;
        String cols, values, sqlInsert;
        String[][] array = new String[DATA+1][columns.size()];
        int j=0;
        for(String c:columns) {
            array[0][j] = c;

            if(idValues.contains(c)) {
                for(int i=1; i<=DATA; i++) {
                    array[i][j] = String.valueOf(i);
                }
            }
            else {
                for(int i=1; i<=DATA; i++) {
                    k=bit();
                    array[i][j] = String.valueOf(k);
                }
            }
            j++;
        }
        for(int i=1; i<DATA+1; i++) {
            cols="";
            values="";
            for(j=0; j<columns.size(); j++) {
                if(!array[i][j].equals("2")) {
                    cols = cols+array[0][j]+",";
                    values = values+array[i][j]+",";
                }
                else {
                    if(idValues.contains(array[0][j])) {
                        cols = cols+array[0][j]+",";
                        values = values+array[i][j]+",";
                    }
                }
            }
            cols = cols.substring(0, cols.length()-1);
            values = values.substring(0, values.length()-1);
            System.out.println(cols);
            System.out.println(values);

            //sqlInsert = "INSERT INTO "+table+" ("+cols+") VALUES ("+values+")";
            //statement.executeUpdate(sqlInsert);
        }
    }

    private int bit() {
        return new Random().nextInt(3);
    }

}
