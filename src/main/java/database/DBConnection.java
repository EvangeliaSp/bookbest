package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private Statement statement;

    public Statement getStatement() {
        return statement;
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
}
