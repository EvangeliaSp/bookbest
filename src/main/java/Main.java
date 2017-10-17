import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;
import hotelGeneration.HotelGenerator;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.System.exit;

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
        HotelDAO hotelDAO = new HotelDAOImpl();

        try {
            stmt = conn.createStatement();
            HotelGenerator hotelGenerator = new HotelGenerator();

            //hotelGenerator.generate(stmt);

            // Print hotels
            List<Hotel> hotels = new ArrayList<>();
            hotels = hotelDAO.list(stmt);
            System.out.println(hotels.size());
            //for(Hotel hotel: hotels)
                //System.out.println(hotel.getName());
        }
        catch (SQLException ex){
            // Handle the errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
       /* finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                //stmt = null;
            }
        }*/

       /////// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ///////

        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            OWLOntology owlOntology = ontologyHelper.readOntology();

            ontologyHelper.printOWLClasses(owlOntology);

            Set<OWLClass> owlClasses = ontologyHelper.getOWLClasses(owlOntology);

            // Print class data properties
            ontologyHelper.printOWLDataProperties(owlOntology);

            /*System.out.println();

            // Print class instances
            Set<OWLNamedIndividual> individuals = owlOntology.getIndividualsInSignature();
            int l=1;
            for(OWLNamedIndividual i:individuals) {
                System.out.println("Individual: "+(l++)+": "+i.getIndividualsInSignature());
                Set<OWLDataPropertyAssertionAxiom> props = owlOntology.getDataPropertyAssertionAxioms(i);
                int k=1;
                for (OWLDataPropertyAssertionAxiom ax: props) {
                    System.out.print((k++)+". "+ax.getProperty().asOWLDataProperty().getIRI().getFragment()+": ");
                    System.out.println(ax);

                }
                //System.out.println("Instance: "+i.getDataPropertiesInSignature());
            }*/
        }
        catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }


    }
}
