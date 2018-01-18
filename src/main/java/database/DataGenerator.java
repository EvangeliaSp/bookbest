package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DataGenerator {
    private String filename;
    private static String jdbcDriver = "com.mysql.jdbc.Driver";

    public DataGenerator (String filename) {
        this.filename = filename;
    }

    public void generateData() {
        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine, database, table1, table2, columns1, columns2;
            DBConnection dbConnection = new DBConnection();
            Connection connection;
            Statement statement;

            while ((database = br.readLine()) != null) {
                dbConnection.connect(database);
                connection = dbConnection.getConnection();
                statement = dbConnection.getStatement();


                if((table1 = br.readLine()) != null) {

                    if((columns1 = br.readLine()) != null) {

                        /*for(int i=0; i<1000; i++) {
                            generateTableData(table1, columns1);
                        }*/

                        if((table2 = br.readLine()) != null) {

                            if((columns2 = br.readLine()) != null) {
                                /*for(int j=0; j<1000; j++) {
                                    String sqlInsert = "INSERT INTO "+table2+" (";
                                }*/
                                CreateDBs createDBs = new CreateDBs(database);
                                createDBs.getColumns(connection, database, table2);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateFacilities(Statement statement, String table) throws SQLException {
        int k;

        if((k=bit()) != 2) {
            //facility.setPetsAllowed((byte) k);
        }


        String sqlInsert = "INSERT INTO "+table+" ("+
                " PRIMARY KEY ("+"))";

        statement.executeUpdate(sqlInsert);
        return ;
    }

    private int bit() {
        return new Random().nextInt(3);
    }

    private void generateTableData(String table, String columns) {

    }
}
