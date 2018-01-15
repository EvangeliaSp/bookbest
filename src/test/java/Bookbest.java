import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import database.CreateDBs;
import ontologyHelper.OntologyHelper;
import org.junit.Before;
import org.junit.Test;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class Bookbest {

    public void main(String[] args) {

        /*///////////////////////////////////////////////////////////////////////
        //          Variables Declaration                                      //
        ///////////////////////////////////////////////////////////////////////*/

        String filename = "./src/main/resources/databases";


        /*///////////////////////////////////////////////////////////////////////
        //          START                                                      //
        ///////////////////////////////////////////////////////////////////////*/

        System.out.println("Please, type the name of the file which contains the databases: (including the path)");


        /*///////////////////////////////////////////////////////////////////////
        //          Create databases                                           //
        ///////////////////////////////////////////////////////////////////////*/

        CreateDBs createDBs = new CreateDBs("./src/main/resources/databases");
        //createDBs.createDatabases();

        System.out.println("Database(s) created successfully.");


        /*///////////////////////////////////////////////////////////////////////
        //          Generate DBs Data                                          //
        ///////////////////////////////////////////////////////////////////////*/



        /*///////////////////////////////////////////////////////////////////////
        //          Create the Ontology                                        //
        ///////////////////////////////////////////////////////////////////////*/
        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            OWLOntology owlOntology = ontologyHelper.createOntology();


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
            reasoner.printDataproperties();

            // Print rules
            System.out.println("Would you like to see the Rules?");
            reasoner.printRules();

            // Print instances
            System.out.println("Would you like to see the Instances?");
            reasoner.printInstances();


        /*///////////////////////////////////////////////////////////////////////
        //          Create the Graph                                           //
        ///////////////////////////////////////////////////////////////////////*/

        // Get the KB from the reasoner
        KnowledgeBase knowledgeBase = reasoner.getKnowledgeBase();

        // Create a Pellet graph using the KB from OWLAPI
        PelletInfGraph graph = reasoner.getGraph(knowledgeBase);

        // Wrap the graph in a Jena model
        InfModel model = ModelFactory.createInfModel(graph);

        }
        catch (OWLOntologyCreationException exception) {
            exception.printStackTrace();
        }

        /*///////////////////////////////////////////////////////////////////////
        //          Answer Queries                                             //
        ///////////////////////////////////////////////////////////////////////*/

        SPARQL sparql = new SPARQL();

        System.out.println("Please, give the country you want to visit:");
        System.out.println("Please, give the name of the city:");
        System.out.println("Price: (0-Any, 1-Very Cheap, 2-Cheap, 3-Average, 4-Expensive, 5-Very Expensive");
        System.out.println("Rating: (0-Any, 1-Pleasant, 2-Good, 3-Superb");
        System.out.println("Family Friendly: (0-Any, 1-Yes, 2-No, 3-Average, 4-Expensive, 5-Very Expensive");

    }
}
