import DLReasoner.Reasoner;
import dataMapping.AirticketsMapping;
import dataMapping.BookingMapping;
import dataMapping.HotelclubMapping;
import dataMapping.PricelineMapping;
import database.DBConnection;
import ontologyHelper.OntologyGenerator;
import ontologyHelper.OntologyHelper;
import org.junit.Before;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.sql.Statement;

public class Main {



    @Before
    public void init() throws OWLOntologyCreationException {

    }

    public static void main(String[] args) {
        OWLOntology owlOntology;
        OntologyHelper ontologyHelper;
        Reasoner reasoner;


        // Connect to database


        // Generate data



        try {

            ontologyHelper = new OntologyHelper();
            /* Create Ontology */
            owlOntology = ontologyHelper.createOntology();
            /* Create reasoner */
            reasoner = new Reasoner(owlOntology, ontologyHelper);


            /* Generate Ontology */
            OntologyGenerator ontologyGenerator = new OntologyGenerator();

            // Create Ontology Classes
            ontologyGenerator.generateClasses();

            // Create Ontology Data Properties
            ontologyGenerator.generateDataProperties();

            /* Map data to the ontology */
            // Connect to Airtickets database
            DBConnection airticketsDB = new DBConnection();
            airticketsDB.connect("airtickets");
            Statement statement = airticketsDB.getStatement();

            AirticketsMapping airticketsMapping = new AirticketsMapping(statement);
            airticketsMapping.importData();

            // Connect to Booking database
            DBConnection bookingDB = new DBConnection();
            bookingDB.connect("booking");
            statement = bookingDB.getStatement();

            BookingMapping bookingMapping = new BookingMapping(statement);
            bookingMapping.importData();

            // Connect to Hotelclub database
            DBConnection hotelclubDB = new DBConnection();
            hotelclubDB.connect("hotelclub");
            statement = hotelclubDB.getStatement();

            HotelclubMapping hotelclubMapping = new HotelclubMapping(statement);
            hotelclubMapping.importData();

            // Connect to Priceline database
            DBConnection pricelineDB = new DBConnection();
            pricelineDB.connect("priceline");
            statement = pricelineDB.getStatement();

            PricelineMapping pricelineMapping = new PricelineMapping(statement);
            pricelineMapping.importData();

            // Classify ontology
            reasoner.classifyOntology();

        }
        catch (Exception e) {
            e.printStackTrace();
        }









        // Get the KB from the reasoner


        // Create a Pellet graph using the KB from OWLAPI


        // Wrap the graph in a Jena model


        // Disconnect from database


    }
}
