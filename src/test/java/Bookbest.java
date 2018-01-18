import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import database.CreateDBs;
import ontologyHelper.OntologyHelper;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bookbest {

    public static void main(String[] args) {

        /*///////////////////////////////////////////////////////////////////////
        //          Variables Declaration                                      //
        ///////////////////////////////////////////////////////////////////////*/

        String filename = "./src/main/resources/databases";


        /*///////////////////////////////////////////////////////////////////////
        //          START                                                      //
        ///////////////////////////////////////////////////////////////////////*/

        //System.out.println("Please, type the name of the file which contains the databases: (including the path)");


        /*///////////////////////////////////////////////////////////////////////
        //          Create databases                                           //
        ///////////////////////////////////////////////////////////////////////*/

        CreateDBs createDBs = new CreateDBs(filename);
        createDBs.createDatabases();

        System.out.println("Database(s) created successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Generate DBs Data                                          //
        ///////////////////////////////////////////////////////////////////////*/



        /*///////////////////////////////////////////////////////////////////////
        //          Create the Ontology                                        //
        ///////////////////////////////////////////////////////////////////////*/
        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            //OWLOntology owlOntology = ontologyHelper.createOntology();
            OWLOntology owlOntology = ontologyHelper.readOntology();


        /*///////////////////////////////////////////////////////////////////////
        //          Map data from DBs to Ontology                              //
        ///////////////////////////////////////////////////////////////////////*/


        /*///////////////////////////////////////////////////////////////////////
        //          Create and Use the Reasoner                                //
        ///////////////////////////////////////////////////////////////////////*/

            // Create reasoner
            Reasoner reasoner = new Reasoner(owlOntology, ontologyHelper);

            // Classify ontology
            reasoner.classifyOntology();

            // Print datatype properties
            System.out.println("Would you like to see the Datatype Properties?");
            //reasoner.printDataproperties();

            // Print rules
            System.out.println("Would you like to see the Rules?");
            //reasoner.printRules();

            // Print instances
            System.out.println("Would you like to see the Instances?");
            //reasoner.printInstances();


        /*///////////////////////////////////////////////////////////////////////
        //          Create the Graph                                           //
        ///////////////////////////////////////////////////////////////////////*/

        // Get the KB from the reasoner
        KnowledgeBase knowledgeBase = reasoner.getKnowledgeBase();

        // Create a Pellet graph using the KB from OWLAPI
        PelletInfGraph graph = reasoner.getGraph(knowledgeBase);

        // Wrap the graph in a Jena model
        InfModel model = ModelFactory.createInfModel(graph);



        /*///////////////////////////////////////////////////////////////////////
        //          Answer Queries                                             //
        ///////////////////////////////////////////////////////////////////////*/

           /* SPARQL sparql = new SPARQL();

            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(System.in));
            int rating, price, ff;
            String query = null;

            try {
                // Country
                System.out.println("Country: ");
                String country = br.readLine();
                query = sparql.hotelsByCountry(country);

                // City
                System.out.println("City: ");
                String city = br.readLine();
                query = query+sparql.hotelsByCity(city);

                // Price
                System.out.println("Price: (0-Any, 1-Very Cheap, 2-Cheap, 3-Average, 4-Expensive, 5-Very Expensive)");
                do {
                    price = Integer.parseInt(br.readLine());

                } while(price<0 || price>5);
                if (price != 0)
                    ;

                // Rating
                System.out.println("Rating: (0-Any, 1-Pleasant, 2-Good, 3-Superb)");
                do {
                    rating = Integer.parseInt(br.readLine());

                } while(rating<0 || rating>3);
                if (rating != 0)
                    ;

                // Family Friendly
                System.out.println("Family Friendly: (0-Any, 1-Yes, 2-No)");
                do {
                    ff = Integer.parseInt(br.readLine());
                } while (ff<0 || ff>2);
                if (ff != 0)
                    ;

                sparql.findResults(model, query);

            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
            finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }*/
        }
        catch (OWLOntologyCreationException exception) {
            exception.printStackTrace();
        }
    }
}