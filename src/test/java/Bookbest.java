import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import dataMapping.Mappings;
import database.DBConnection;
import database.DataGenerator;
import ontologyHelper.OntologyGenerator;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bookbest {
    @Deprecated
    public static void main(String[] args) {

        /*///////////////////////////////////////////////////////////////////////
        //          Variables Declaration                                      //
        ///////////////////////////////////////////////////////////////////////*/

        String filenameDBs = "./src/main/resources/databases";
        String filenameMaps = "./src/main/resources/mappings";
        String filenameCharacteristics = "./src/main/resources/specificCharacteristics";
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int answer;

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
        System.out.println("Database(s) created successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Generate DBs Data                                          //
        ///////////////////////////////////////////////////////////////////////*/

        DataGenerator dataGenerator = new DataGenerator(filenameDBs, mappings, dbConnection);
        //dataGenerator.generateData();
        System.out.println("Database(s) filled successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Create the Ontology and map the data from DBs              //
        ///////////////////////////////////////////////////////////////////////*/

        OntologyGenerator ontologyGenerator = new OntologyGenerator(mappings, dbConnection);
        ontologyGenerator.generateOntology();
        OWLOntology owlOntology = ontologyGenerator.getOwlOntology();
        System.out.println("Ontology created successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Create and Use the Reasoner                                //
        ///////////////////////////////////////////////////////////////////////*/


        // Create reasoner
        Reasoner reasoner = new Reasoner(owlOntology);

        // Classify ontology
        //reasoner.classifyOntology();
        System.out.println();

        try {
            // Print ontology information
            System.out.println("\nWould you like to see the Ontology Information?\n(1-Yes, 0-No)");
            do {
                answer = Integer.parseInt(bufferedReader.readLine());
            } while (answer != 0 && answer != 1);
            if(answer==1)   reasoner.printOntologyInfo();

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
            System.out.println();
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

        SPARQL sparql = new SPARQL();
        int rating, price, distance, lux, again;
        String query;

        try {
            do {
                // Country
                System.out.println("Country: ");
                String country = bufferedReader.readLine();
                query = sparql.hotelsByCountry(country);

                // City
                System.out.println("City: ");
                String city = bufferedReader.readLine();
                query = query + sparql.hotelsByCity(city);

                // Price
                System.out.println("Price: (0-Any, 1-Very Cheap, 2-Cheap, 3-Average, 4-Expensive, 5-Very Expensive)");
                do {
                    price = Integer.parseInt(bufferedReader.readLine());
                } while (price < 0 || price > 5);
                if (price != 0)
                    query = query + sparql.hotelsByPrice(price);

                // Rating
                System.out.println("Rating: (0-Any, 1-Pleasant, 2-Good, 3-Superb)");
                do {
                    rating = Integer.parseInt(bufferedReader.readLine());
                } while (rating < 0 || rating > 3);
                if (rating != 0)
                    query = query + sparql.hotelsByRating(rating);

                // Distance
                System.out.println("City Center Distance: (0-Any, 1-Short, 2-Medium, 3-Long)");
                do {
                    distance = Integer.parseInt(bufferedReader.readLine());
                } while (distance < 0 || distance > 3);
                if (distance != 0)
                    query = query + sparql.hotelsByCityCenterDistance(distance);

                // Luxurious
                System.out.println("Luxurious: (0-Any, 1-Yes)");
                do {
                    lux = Integer.parseInt(bufferedReader.readLine());
                } while (lux < 0 || lux > 1);
                if (lux == 1)
                    query = query + sparql.luxuriousHotels();

                sparql.findResults(model, query);

                System.out.println("\n\n"+"New Search? (1-Yes, 0-No)");
                again = Integer.parseInt(bufferedReader.readLine());
                System.out.println();
            } while (again==1);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}