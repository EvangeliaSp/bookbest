import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;
import hotelGeneration.HotelGenerator;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.*;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        // Load driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtain a connection from the DriverManager
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bookbest?" + "user=root&password=5698");
        } catch (SQLException ex) {
            // handle the errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        Statement stmt = null;
        //HotelDAO hotelDAO = new HotelDAOImpl();
        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            stmt = conn.createStatement();

            // Generate data
            //HotelGenerator hotelGenerator = new HotelGenerator();
            //hotelGenerator.generate(stmt);

            // Read Ontology
            OWLOntology owlOntology = ontologyHelper.readOntology();

            // Print OWLClasses
            ontologyHelper.printClasses(owlOntology);

            // Print OWLDataProperties
            ontologyHelper.printDataProperties(owlOntology);

            Set<OWLClass> owlClasses = ontologyHelper.getClasses(owlOntology);
            for(OWLClass owlClass: owlClasses) {
                if(owlClass.getIRI().getFragment().toString().equals("Hotel")) {
                    DataToOntology dataToOntology = new DataToOntology();
                    dataToOntology.importData(stmt, ontologyHelper, owlOntology, owlClass);
                    break;
                }
            }
            System.out.println("Individuals: " + ontologyHelper.getIndividualsCounter(owlOntology));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
