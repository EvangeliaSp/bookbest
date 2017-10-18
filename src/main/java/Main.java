import dao.HotelDAO;
import dao.HotelDAOImpl;
import entities.Hotel;
import hotelGeneration.HotelGenerator;
import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.sql.*;
import java.util.List;
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

        Statement stmt;
        HotelDAO hotelDAO = new HotelDAOImpl();
        OntologyHelper ontologyHelper = new OntologyHelper();

        try {
            stmt = conn.createStatement();

            //HotelGenerator hotelGenerator = new HotelGenerator();

            //hotelGenerator.generate(stmt);
            OWLOntology owlOntology = ontologyHelper.readOntology();

            // Print OWLClasses
            ontologyHelper.printClasses(owlOntology);

            //Set<OWLClass> owlClasses = ontologyHelper.getOWLClasses(owlOntology);

            // Print OWLDataProperties
            ontologyHelper.printDataProperties(owlOntology);

            System.out.println("Individuals: " + ontologyHelper.getIndividualsCounter(owlOntology));
            System.out.println();


            // Create Individuals from database

            //OWLIndividual individual = ontologyHelper.createIndividual("vaggo2");

            //OWLDataProperty owlDataProperty = ontologyHelper.createDataProperty("price");
            //OWLAxiom owlAxiom1 = ontologyHelper.createDataPropertyAssertionAxiom(owlDataProperty, individual, "VeryCheap");

            //OWLDataProperty owlDataProperty = ontologyHelper.createDataProperty("distance");
            //OWLAxiom owlAxiom1 = ontologyHelper.createDataPropertyAssertionAxiom(owlDataProperty, individual, "Away");

            Set<OWLClass> owlClasses = ontologyHelper.getClasses(owlOntology);
            for(OWLClass owlClass: owlClasses) {
                if(owlClass.getIRI().getFragment().toString().equals("Hotel")) {
                    //ontologyHelper.associateIndividualWithClass(owlOntology, owlClass, individual);
                    //OWLAxiom owlAxiom = ontologyHelper.createAxiom(individual, owlClass);
                    //AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom1);
                    //ontologyHelper.saveOntology(owlOntology, addAxiom);
                    DataToOntology dataToOntology = new DataToOntology();
                    dataToOntology.importData(stmt, ontologyHelper, owlOntology, owlClass);
                    break;
                }
            }



            // ontologyHelper.addDataToIndividual(owlOntology, individual, "newIndividual");

            System.out.println("Individuals: " + ontologyHelper.getIndividualsCounter(owlOntology));


        }
        catch (Exception e){
            // Handle the errors
            e.printStackTrace();
            //System.out.println("SQLException: " + ex.getMessage());
            //System.out.println("SQLState: " + ex.getSQLState());
            //System.out.println("VendorError: " + ex.getErrorCode());
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



        //try {



            System.out.println();

            /*
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
        //}
       /* catch (OWLException e) {
            e.printStackTrace();
        }*/


    }
}
