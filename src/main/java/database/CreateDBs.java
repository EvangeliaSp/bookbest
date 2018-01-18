package database;

import java.io.BufferedReader;
import java.io.FileReader;
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
        int Result = s.executeUpdate("CREATE DATABASE IF NOT EXISTS "+database+";");
        System.out.println(database);
    }

    private String createTable(Statement statement, String table, String columns) throws SQLException {
        int k = columns.indexOf(" ");
        String key = columns.substring(0, k);
        String sqlCreate = "CREATE TABLE " + table +"(" +
                columns +
                " PRIMARY KEY ("+key+"))";

        statement.executeUpdate(sqlCreate);
        return key;
    }

    private void createTable2(Statement statement, String table, String columns, String fkey, String ftable) throws SQLException {
        int k = columns.indexOf(" ");
        String key = columns.substring(0, k);
        String sqlCreate = "CREATE TABLE " + table +"(" +
                columns +
                " PRIMARY KEY ("+key+"), "+
                " FOREIGN KEY ("+key+") REFERENCES "+ftable+" ("+fkey+"))";
        System.out.println(sqlCreate);
        statement.executeUpdate(sqlCreate);
    }

    public void createDatabases() {

        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine, database, table, table2, key;
            DBConnection dbConnection = new DBConnection();
            Statement statement;

            while ((currentLine = br.readLine()) != null) {
                // Create Database
                database = currentLine;
                this.createDB(database);
                dbConnection.connect(database);
                statement = dbConnection.getStatement();

                if((currentLine = br.readLine()) != null) {
                    table = currentLine;
                    if((currentLine = br.readLine()) != null) {
                        key = this.createTable(statement, table, currentLine);
                        if((currentLine = br.readLine()) != null) {
                            table2 = currentLine;
                            if((currentLine = br.readLine()) != null) {
                                this.createTable2(statement, table2, currentLine, key, table);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
