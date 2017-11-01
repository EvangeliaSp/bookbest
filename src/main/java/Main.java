import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import hotelGeneration.CountryGenerator;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
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
        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            stmt = conn.createStatement();

            // Generate data
            /*System.out.println("Generate Hotels");
            HotelGenerator hotelGenerator = new HotelGenerator();
            hotelGenerator.generate(stmt);
            System.out.println();*/

            // Read Ontology
            OWLOntology owlOntology = ontologyHelper.readOntology();

            // Create Ontology
            //OWLOntology owlOntology = ontologyHelper.createOntology();

            // Create OWL Class
        /*    OWLClass owlClass = ontologyHelper.createClass("Hotel");
            ontologyHelper.saveOntology(owlOntology, owlClass);*/


            // Create OWL Data Properties
        /*    OWLDataProperty owlDataProperty;

            owlDataProperty = ontologyHelper.createDataProperty("hasId");
            ontologyHelper.saveOntology(owlOntology, owlDataProperty);

            owlDataProperty = ontologyHelper.createDataProperty("hasPrice");
            ontologyHelper.saveOntology(owlOntology, owlDataProperty);

            owlDataProperty = ontologyHelper.createDataProperty("hasRating");
            ontologyHelper.saveOntology(owlOntology, owlDataProperty);

            owlDataProperty = ontologyHelper.createDataProperty("hasDistance");
            ontologyHelper.saveOntology(owlOntology, owlDataProperty);
*/
            // Print OWLClasses
            ontologyHelper.printClasses(owlOntology);
            System.out.println();

            // Print OWLDataProperties
            System.out.println("Data Properties");
            ontologyHelper.printDataProperties(owlOntology);
            System.out.println();

            Reasoner reasoner = new Reasoner(owlOntology, ontologyHelper);

            Set<OWLClass> owlClasses = ontologyHelper.getClasses(owlOntology);
            for(OWLClass owlClass1: owlClasses) {
                if(owlClass1.getIRI().getFragment().toString().equals("Hotel")) {
                  //  DataToOntology dataToOntology = new DataToOntology();
                  //  dataToOntology.importData(stmt, ontologyHelper, owlOntology, owlClass1);
                    // Print Individuals
                    System.out.println("Before Reasoner");

                    reasoner.classifyOntology();
                    reasoner.printSubclasses();
                    //reasoner.printInstances();

                    System.out.println("After Reasoner");
                    break;
                }
            }
            // Get the KB from the reasoner
            KnowledgeBase knowledgeBase = reasoner.getKnowledgeBase();

            // Create a Pellet graph using the KB from OWLAPI
            PelletInfGraph graph = reasoner.getGraph(knowledgeBase);

            // Wrap the graph in a Jena model
            InfModel model = ModelFactory.createInfModel(graph);

            // Use the model to answer SPARQL queries
            StmtIterator stmtIterator = model.listStatements();
           // while (stmtIterator.hasNext()) {
             //   System.out.println(stmtIterator.nextStatement());
            //}

            SPARQL sparql = new SPARQL();
            sparql.getCheap(model);



            //ontologyHelper.saveOntology(owlOntology);


            CountryGenerator countryGenerator = new CountryGenerator();
            System.out.println(countryGenerator.generate());
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
