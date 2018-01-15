package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBs {

    private String filename;
    private static String jdbcDriver = "com.mysql.jdbc.Driver";

    public CreateDBs (String filename) {
        this.filename = filename;
    }

    private void createDB(String database) throws SQLException, ClassNotFoundException {
        Class.forName(this.jdbcDriver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=5698");
        Statement s = conn.createStatement();
        int Result = s.executeUpdate("CREATE DATABASE IF NOT EXISTS "+database+"e;");
        System.out.println(database);
    }

    private void createTable(Connection connection, Statement statement, String table) throws SQLException {
        System.out.println(table);

        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + table;

        Statement stmt = connection.createStatement();
        stmt.execute(sqlCreate);

    }

    public void createDatabases() {

        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine, database, table;
            DBConnection dbConnection = new DBConnection();
            Statement statement;
            Connection connection;

            while ((currentLine = br.readLine()) != null) {
                // Create Database
                database = currentLine;
                this.createDB(database);
                dbConnection.connect(database);
                connection = dbConnection.getConnection();
                statement = dbConnection.getStatement();

                if((currentLine = br.readLine()) != null) {
                   // this.createTable(connection, statement, currentLine);
                }
                if((currentLine = br.readLine()) != null) {

                }
                if((currentLine = br.readLine()) != null) {
                    //this.createTable(currentLine);
                }
                if((currentLine = br.readLine()) != null) {

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
