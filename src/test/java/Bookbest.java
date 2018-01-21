import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import dataMapping.Mappings;
import database.DBConnection;
import database.DataGenerator;
import ontologyHelper.OntologyGenerator;
import ontologyHelper.OntologyHelper;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;

public class Bookbest {

    public static void main(String[] args) {

        /*///////////////////////////////////////////////////////////////////////
        //          Variables Declaration                                      //
        ///////////////////////////////////////////////////////////////////////*/

        String filenameDBs = "./src/main/resources/databases";
        String filenameMaps = "./src/main/resources/mappings";
        String filenameCharacteristics = "./src/main/resources/specificCharacteristics";
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int answer;


        /*///////////////////////////////////////////////////////////////////////
        //          START                                                      //
        ///////////////////////////////////////////////////////////////////////*/

        //System.out.println("Please, type the name of the file which contains the databases: (including the path)");

        /*///////////////////////////////////////////////////////////////////////
        //          Create mappings                                            //
        ///////////////////////////////////////////////////////////////////////*/

        Mappings mappings = new Mappings(filenameMaps, filenameCharacteristics);
        mappings.mapFromFile();
        mappings.makeCharacteristics();


        /*///////////////////////////////////////////////////////////////////////
        //          Create databases                                           //
        ///////////////////////////////////////////////////////////////////////*/

        DBConnection dbConnection = new DBConnection(filenameDBs);
        //dbConnection.createDatabases();

        //System.out.println("Database(s) created successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Generate DBs Data                                          //
        ///////////////////////////////////////////////////////////////////////*/

        DataGenerator dataGenerator = new DataGenerator(filenameDBs, mappings, dbConnection);
        //dataGenerator.generateData();


        /*///////////////////////////////////////////////////////////////////////
        //          Create the Ontology                                        //
        ///////////////////////////////////////////////////////////////////////*/
        OntologyHelper ontologyHelper = new OntologyHelper();


        OntologyGenerator ontologyGenerator = new OntologyGenerator(mappings, dbConnection);
        ontologyGenerator.generateOntology();
        OWLOntology owlOntology = ontologyGenerator.getOwlOntology();


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

        try {
            // Print datatype properties
            System.out.println("\nWould you like to see the Datatype Properties?\n(1-Yes, 0-No)");
            do {
                answer = Integer.parseInt(bufferedReader.readLine());
            } while (answer != 0 && answer != 1);
            if(answer==1)   reasoner.printDataproperties();

            // Print rules
            System.out.println("\nWould you like to see the Rules?\n(1-Yes, 0-No)");
            do {
                answer = Integer.parseInt(bufferedReader.readLine());
            } while (answer != 0 && answer != 1);
            if(answer==1)   reasoner.printRules();

            // Print instances
            System.out.println("\nWould you like to see the Instances?\n(1-Yes, 0-No)");
            do {
                answer = Integer.parseInt(bufferedReader.readLine());
            } while (answer != 0 && answer != 1);
            if(answer==1)   reasoner.printInstances();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


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
            //BufferedReader br = null;
            //br = new BufferedReader(new InputStreamReader(System.in));
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
}