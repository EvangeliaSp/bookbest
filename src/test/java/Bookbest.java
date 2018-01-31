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

        /*OntologyGenerator ontologyGenerator = new OntologyGenerator(mappings, dbConnection);
        ontologyGenerator.generateOntology();
        OWLOntology owlOntology = ontologyGenerator.getOwlOntology();*/
        OntologyHelper ontologyHelper = new OntologyHelper();
        OWLOntology owlOntology = ontologyHelper.readOntology();

        /*///////////////////////////////////////////////////////////////////////
        //          Create and Use the Reasoner                                //
        ///////////////////////////////////////////////////////////////////////*/

        // Create reasoner
        Reasoner reasoner = new Reasoner(owlOntology);

        // Classify ontology
        reasoner.classifyOntology();
        System.out.println();
        System.out.println();
        // Get ontology information
        //reasoner.printOntologyInfo();

        System.out.println();
        /*try {
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
*/

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
        //sparql.findResults(model,"");
        //BufferedReader br = null;
        //br = new BufferedReader(new InputStreamReader(System.in));
        int rating, price, ff, fd;
        int counter = 0;
        String query, proposed="";
        try {
            // Country
            System.out.println("Country: ");
            String country = bufferedReader.readLine();
            query = sparql.hotelsByCountry(country);

            // City
            System.out.println("City: ");
            String city = bufferedReader.readLine();
            query = query+sparql.hotelsByCity(city);

            // Price
            System.out.println("Price: (0-Any, 1-Very Cheap, 2-Cheap, 3-Average, 4-Expensive, 5-Very Expensive)");
            do {
                price = Integer.parseInt(bufferedReader.readLine());
            } while(price<0 || price>5);
            if (price != 0) {
                query = query + sparql.hotelsByPrice(price);
                proposed = proposed+"?dPrice";
                counter++;
            }

            // Rating
            System.out.println("Rating: (0-Any, 1-Pleasant, 2-Good, 3-Superb)");
            do {
                rating = Integer.parseInt(bufferedReader.readLine());
            } while(rating<0 || rating>3);
            if (rating != 0) {
                query = query + sparql.hotelsByRating(rating);
                if(proposed.equals(""))
                    proposed = proposed+"?dRating";
                else proposed = proposed+"+?dRating";
                counter++;
            }

            // For Disabled People
            /*System.out.println("For Disabled People: (0-Any, 1-Yes)");
            do {
                fd = Integer.parseInt(bufferedReader.readLine());
            } while (fd<0 || fd>1);
            if (fd == 1)
                query = query+sparql.hotelsForDisabled(fd);*/

            // Family Friendly
            /*System.out.println("Family Friendly: (0-Any, 1-Yes)");
            do {
                ff = Integer.parseInt(bufferedReader.readLine());
            } while (ff<0 || ff>1);
            if (ff == 1)
                ;
                */
            sparql.findResults(model, query, proposed, counter);
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