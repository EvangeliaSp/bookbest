package ontologyHelper;

import dataMapping.Mappings;
import database.DBConnection;
import org.semanticweb.owlapi.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OntologyGenerator {
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    Mappings mappings;
    DBConnection dbConnection;
    DataToOntology dataToOntology;

    public OWLOntology getOwlOntology() {
        return owlOntology;
    }

    public OntologyGenerator(Mappings mappings, DBConnection dbConnection) {
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        this.mappings = mappings;
        this.dbConnection = dbConnection;
        this.dataToOntology = new DataToOntology();
    }

    // Create OWL Ontology
    public void generateOntology() {
        try {
            this.owlOntology = this.ontologyHelper.createOntology();
            this.generateClasses();
            this.generateDataProperties();
            this.generateRules();
            this.mapInstances();
        }
        catch (OWLOntologyCreationException ce) {
            ce.printStackTrace();
        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    // Create OWL Class
    private void generateClasses() throws OWLOntologyStorageException {
        OWLClass owlClass = ontologyHelper.createClass("Hotel");
        ontologyHelper.saveOntology(owlOntology, owlClass);
    }

    // Create OWL Data Properties
    private void generateDataProperties() throws OWLOntologyStorageException {
        String filename = mappings.getFilename(), line, value;
        OWLDataProperty owlDataProperty;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                value = line.substring(0, line.indexOf(":"));
                owlDataProperty = ontologyHelper.createDataProperty(value);
                ontologyHelper.saveOntology(owlOntology, owlDataProperty);
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create OWL Rules
    private void generateRules() {
        // Create rules for Price
        generatePriceRules();

        // Create rules for Rating
        //generateRatingRules();

    }

    private void generatePriceRules() {

        Set<SWRLAtom> body = new HashSet<>();
        Set<SWRLAtom> head = new HashSet<>();

        SWRLBuiltInAtom atom, atom1, atom2, k, l, d;

        try {
            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Very Cheap hotels                                 //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isVeryCheap" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("price", "<", "50");
            body.add(atom);
            k = ontologyHelper.createMathAtom("price", "/", "50", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom2("1", "-", "k", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody(owlOntology, "hasPricePerNight", "price", body);

            // Create head of "isVeryCheap" rule
            head.clear();
            ontologyHelper.createRuleHead(owlOntology, "isVeryCheap", "d", head);

            // Create "isVeryCheap" rule
            ontologyHelper.createRule(owlOntology, body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Cheap hotels                                      //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isAverage" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "50");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "100");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "50", "k");
            body.add(k);
            l = ontologyHelper.createMathAtom("k", "/", "50", "l");
            body.add(l);
            d = ontologyHelper.createMathAtom2("1", "-", "k", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody(owlOntology, "hasPricePerNight", "price", body);

            // Create head of "isVeryCheap" rule
            head.clear();
            ontologyHelper.createRuleHead(owlOntology, "isVeryCheap", "d", head);

            // Create "isVeryCheap" rule
            ontologyHelper.createRule(owlOntology, body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Average hotels                                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isAverage" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "100");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "150");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "100", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "50", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody(owlOntology, "hasPricePerNight", "price", body);

            // Create head of "isAverage" rule
            head.clear();
            ontologyHelper.createRuleHead(owlOntology, "isAverage", "d", head);

            // Create "isAverage" rule
            ontologyHelper.createRule(owlOntology, body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Expensive hotels                                  //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isExpensive" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "150");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "200");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "150", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "50", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody(owlOntology, "hasPricePerNight", "price", body);

            // Create head of "isExpensive" rule
            head.clear();
            ontologyHelper.createRuleHead(owlOntology, "isExpensive", "d", head);

            // Create "isExpensive" rule
            ontologyHelper.createRule(owlOntology, body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Very Expensive hotels                             //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isVeryExpensive" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("price", ">", "200");
            body.add(atom);
            k = ontologyHelper.createMathAtom("price", "-", "200", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "50", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody(owlOntology, "hasPricePerNight", "price", body);

            // Create head of "isVeryExpensive" rule
            head.clear();
            ontologyHelper.createRuleHead(owlOntology, "isVeryExpensive", "d", head);

            // Create "isVeryExpensive" rule
            ontologyHelper.createRule(owlOntology, body, head);
        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    private void generateRatingRules() {


    }

    public void mapInstances() {
        Set<String> keys = mappings.getCharacteristics().keySet();
        int i, j, counter=1, k;
        String dp;
        for(String database: keys) {
            dbConnection.connect(database);
            Connection connection = dbConnection.getConnection();
            ArrayList<String> characteristics = this.mappings.findCharacteristic(database);
            ResultSet hotels = dbConnection.getAll("Hotel");
            ResultSet facilities = dbConnection.getAll("Facilities");


            ArrayList<String> hotelCols = dbConnection.getColumns(connection, database, "Hotel");
            ArrayList<String> hotelDataProps = mappings.getDataPropCols(hotelCols);

            ArrayList<String> facilitiesCols = dbConnection.getColumns(connection, database, "Facilities");
            ArrayList<String> facilitiesDataProps = mappings.getDataPropCols(facilitiesCols);
            try {
                while (hotels.next() && facilities.next()) {
                    // Create the individual
                    OWLIndividual owlIndividual = ontologyHelper.createIndividual("Hotel_"+counter);
                    System.out.println("Hotel_"+counter++);
                    OWLClass owlClass = ontologyHelper.getFirstClass(owlOntology);
                    this.ontologyHelper.associateIndividualWithClass(owlOntology, owlClass, owlIndividual);
                    i=0;
                    j=0;
                    for (String c : hotelCols) {
                        dp = hotelDataProps.get(i++);
                        if(dp.equals("hasName") || dp.equals("isInCountry") || dp.equals("isInCity"))
                            this.ontologyHelper.addStringDataToIndividual(owlIndividual, dp, hotels.getString(c));
                            //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, hotels.getString(c));
                        else if(dp.equals("hasRating") || dp.equals("hasLocationRating")) {
                            if((k=Integer.parseInt(characteristics.get(0)))!=10) {
                                this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, this.mappings.convertRate(k,hotels.getDouble(c)));
                                //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, this.mappings.convertRate(k,hotels.getDouble(c)));
                            }
                            else this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, hotels.getString(c));
                                //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, hotels.getDouble(c));
                        }
                        else if(dp.equals("hasCityCenterDistance")) {
                            if(characteristics.get(1).equals("mi"))
                                this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, this.mappings.convertMiToKm(hotels.getDouble(c)));
                                //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, mappings.convertMiToKm(hotels.getDouble(c)));
                            else this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, hotels.getString(c));
                                //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, hotels.getDouble(c));
                        }
                        else {
                            this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, hotels.getString(c));
                            //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, hotels.getInt(c));
                        }
                    }
                    for (String c : facilitiesCols) {
                        dp = facilitiesDataProps.get(j++);
                        if(dp.equals("hasId"))
                            this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, facilities.getString(c));
                            //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, facilities.getInt(c));
                        else {
                            if(facilities.getString(c) != null)
                                this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, facilities.getString(c));
                                //dataToOntology.importData(this.ontologyHelper, this.owlOntology, owlIndividual, dp, facilities.getByte(c));
                        }
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (OWLOntologyStorageException se) {
                se.printStackTrace();
            }

            dbConnection.disconnect();
        }
    }
}
