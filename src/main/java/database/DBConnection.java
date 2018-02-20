package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private Statement statement;
    private Connection connection;
    private String filename;
    private static String jdbcDriver = "com.mysql.jdbc.Driver";

    public DBConnection (String filename) {
        this.filename = filename;
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect(String name) {
        // Load driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtain a connection from the DriverManager
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+name+"?" + "user=root&password=5698");
            this.connection = conn;
        } catch (SQLException ex) {
            // handle the errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            this.statement = conn.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (this.statement != null) {
                try {
                    this.statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void createDB(String database) throws SQLException, ClassNotFoundException {
        Class.forName(this.jdbcDriver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=5698");
        Statement statement = conn.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+database+";");
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
        statement.executeUpdate(sqlCreate);
    }

    public void createDatabases() {
        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine, database, table, table2, key;
            Statement statement;

            while ((currentLine = br.readLine()) != null) {
                // Create Database
                database = currentLine;
                this.createDB(database);
                this.connect(database);
                statement = this.getStatement();

                if((currentLine = br.readLine()) != null) {
                    table = currentLine;
                    if((currentLine = br.readLine()) != null) {
                        key = this.createTable(statement, table, currentLine);
                        //ArrayList<String> cols = this.getColumns(connection, database, table);
                        if((currentLine = br.readLine()) != null) {
                            table2 = currentLine;
                            if((currentLine = br.readLine()) != null) {
                                this.createTable2(statement, table2, currentLine, key, table);
                                //cols = this.getColumns(connection, database, table2);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getColumns(Connection connection, String database, String table) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(database, null, table, "%");
            ArrayList<String> columns = new ArrayList<>();
            while(resultSet.next()) {
                columns.add(resultSet.getString(4));
            }
            return columns;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll(String table) {
        try {
            Statement statement = this.connection.createStatement();
            String sqlSelect = "SELECT * FROM " + table;
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            return resultSet;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
