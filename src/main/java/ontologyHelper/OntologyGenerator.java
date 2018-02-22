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

    public OWLOntology getOwlOntology() {
        return owlOntology;
    }

    public OntologyGenerator(Mappings mappings, DBConnection dbConnection) {
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        this.mappings = mappings;
        this.dbConnection = dbConnection;
    }

    // Create OWL Ontology
    @Deprecated
    public void generateOntology() {
            //this.owlOntology = this.ontologyHelper.readOntology();
            this.owlOntology = this.ontologyHelper.createOntology();
            this.generateClasses();
            this.generateDataProperties();
            this.generateRules();
            this.mapInstances();
    }

    // Create OWL Class
    private void generateClasses() {
        try {
            OWLClass owlClass = ontologyHelper.createClass("Hotel");
            ontologyHelper.saveOntology(owlClass);
        }
        catch (OWLOntologyStorageException e) {
            e.printStackTrace();
        }
    }

    // Create OWL Data Properties
    private void generateDataProperties() {
        String filename = mappings.getFilename(), line, value;
        OWLDataProperty owlDataProperty;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                value = line.substring(0, line.indexOf(":"));
                owlDataProperty = ontologyHelper.createDataProperty(value);
                ontologyHelper.saveOntology(owlDataProperty);
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create OWL Rules
    @Deprecated
    private void generateRules() {
        // Create rules for Price
        generatePriceRules();

        // Create rules for Rating
        generateRatingRules();

        // Create rules for Distance from city center
        generateDistanceRules();

        // Create rules for Luxurious hotels
        generateLuxuriousRules();

    }

    @Deprecated
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
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isVeryCheap" rule
            head.clear();
            ontologyHelper.createRuleHead("isVeryCheap", "d", head);

            // Create "isVeryCheap" rule
            ontologyHelper.createRule(body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Cheap hotels                                      //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isCheap" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "50");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "100");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "50", "k");
            body.add(k);
            l = ontologyHelper.createMathAtom("k", "/", "50", "l");
            body.add(l);
            d = ontologyHelper.createMathAtom2("1", "-", "l", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isVeryCheap" rule
            head.clear();
            ontologyHelper.createRuleHead("isCheap", "d", head);

            // Create "isVeryCheap" rule
            ontologyHelper.createRule(body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Average hotels                                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isAverage" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "100");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "125");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "100", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "25", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isAverage" rule
            head.clear();
            ontologyHelper.createRuleHead("isAverage", "d", head);

            // Create "isAverage" rule
            ontologyHelper.createRule(body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Average hotels                                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isAverage" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("price", ">=", "125");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("price", "<", "150");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("price", "-", "125", "k");
            body.add(k);
            l = ontologyHelper.createMathAtom("k", "/", "25", "l");
            body.add(l);
            d = ontologyHelper.createMathAtom2("1", "-", "l", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isAverage" rule
            head.clear();
            ontologyHelper.createRuleHead("isAverage", "d", head);

            // Create "isAverage" rule
            ontologyHelper.createRule(body, head);

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
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isExpensive" rule
            head.clear();
            ontologyHelper.createRuleHead("isExpensive", "d", head);

            // Create "isExpensive" rule
            ontologyHelper.createRule(body, head);

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
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isVeryExpensive" rule
            head.clear();
            ontologyHelper.createRuleHead("isVeryExpensive", "d", head);

            // Create "isVeryExpensive" rule
            ontologyHelper.createRule(body, head);

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Very Expensive hotels                             //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isVeryExpensive" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("price", ">", "250");
            body.add(atom);
            body = ontologyHelper.createRuleBody("hasPricePerNight", "price", body);

            // Create head of "isVeryExpensive" rule
            head.clear();
            ontologyHelper.createRuleHead("isVeryExpensive", 1, head);

            // Create "isVeryExpensive" rule
            ontologyHelper.createRule(body, head);
        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    @Deprecated
    private void generateRatingRules() {
        Set<SWRLAtom> body = new HashSet<>();
        Set<SWRLAtom> head = new HashSet<>();

        SWRLBuiltInAtom atom, atom1, atom2, k, l, d;

        try {
            /*///////////////////////////////////////////////////////////////////////
            //          Rule for No Rate hotels                                 //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "hasNoRate" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("rating", "<", "5");
            body.add(atom);
            d = ontologyHelper.createMathAtom("rating", "/", "5", "d");
            //body.add(k);
            //d = ontologyHelper.createMathAtom("k", "*", "100", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasRating", "rating", body);

            // Create head of "hasNoRate" rule
            head.clear();
            ontologyHelper.createRuleHead("hasNoRate", "d", head);

            // Create "hasNoRate" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Pleasant hotels                                      //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isPleasant" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("rating", ">=", "5");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("rating", "<", "7");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("rating", "-", "5", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "2", "d");
            //body.add(l);
            //d = ontologyHelper.createMathAtom("l", "*", "100", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasRating", "rating", body);

            // Create head of "isPleasant" rule
            head.clear();
            ontologyHelper.createRuleHead("isPleasant", "d", head);

            // Create "isPleasant" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Good hotels                                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isGood" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("rating", ">=", "7");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("rating", "<", "9");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("rating", "-", "7", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "2", "d");
            //body.add(l);
            //d = ontologyHelper.createMathAtom("l", "*", "100", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasRating", "rating", body);

            // Create head of "isGood" rule
            head.clear();
            ontologyHelper.createRuleHead("isGood", "d", head);

            // Create "isGood" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Superb hotels                                  //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isSuperb" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("rating", ">=", "9");
            body.add(atom1);
            d = ontologyHelper.createMathAtom("rating", "-", "9", "d");
            //body.add(k);
            //d = ontologyHelper.createMathAtom("k", "*", "100", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasRating", "rating", body);

            // Create head of "isSuperb" rule
            head.clear();
            ontologyHelper.createRuleHead("isSuperb", "d", head);

            // Create "isSuperb" rule
            ontologyHelper.createRule(body, head);

        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    @Deprecated
    public void generateDistanceRules() {
        Set<SWRLAtom> body = new HashSet<>();
        Set<SWRLAtom> head = new HashSet<>();

        SWRLBuiltInAtom atom, atom1, atom2, k, d;

        try {
            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels with short distance from center            //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isShort" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("distance", "<=", "2");
            body.add(atom);
            k = ontologyHelper.createMathAtom("distance", "/", "2", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom2("1", "-", "k", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasCityCenterDistance", "distance", body);

            // Create head of "isShort" rule
            head.clear();
            ontologyHelper.createRuleHead("isShort", "d", head);

            // Create "isShort" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels with medium distance from center           //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isMedium" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("distance", ">", "2");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("distance", "<=", "5");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("distance", "-", "2", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "3", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasCityCenterDistance", "distance", body);

            // Create head of "isMedium" rule
            head.clear();
            ontologyHelper.createRuleHead("isMedium", "d", head);

            // Create "isMedium" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels with long distance from center             //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLong" rule
            body.clear();
            atom1 = ontologyHelper.createComparisonAtom("distance", ">", "5");
            body.add(atom1);
            atom2 = ontologyHelper.createComparisonAtom("distance", "<=", "10");
            body.add(atom2);
            k = ontologyHelper.createMathAtom("distance", "-", "5", "k");
            body.add(k);
            d = ontologyHelper.createMathAtom("k", "/", "5", "d");
            body.add(d);
            body = ontologyHelper.createRuleBody("hasCityCenterDistance", "distance", body);

            // Create head of "isSuperb" rule
            head.clear();
            ontologyHelper.createRuleHead("isLong", "d", head);

            // Create "isLong" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels with long distance from center             //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLong" rule
            body.clear();
            atom = ontologyHelper.createComparisonAtom("distance", ">", "10");
            body.add(atom);
            body = ontologyHelper.createRuleBody("hasCityCenterDistance", "distance", body);

            // Create head of "isSuperb" rule
            head.clear();
            ontologyHelper.createRuleHead("isLong", 1, head);

            // Create "isLong" rule
            ontologyHelper.createRule(body, head);
        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    @Deprecated
    public void generateLuxuriousRules() {
        Set<SWRLAtom> body = new HashSet<>();
        Set<SWRLAtom> head = new HashSet<>();

        try {
            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 100% Luxurious                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            SWRLClassAtom swrlClassAtom = ontologyHelper.createClassAtom();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 1, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 75% Luxurious                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.75, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 75% Luxurious                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.75, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 75% Luxurious                    //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.75, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 75% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.75, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 50% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.5, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 25% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSwimmingPool", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.25, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 25% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasFitnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.25, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 25% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasSpaWellnessCenter", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.25, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);


            /*///////////////////////////////////////////////////////////////////////
            //          Rule for hotels that are 25% Luxurious                     //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isLuxurious" rule
            body.clear();
            body.add(swrlClassAtom);
            body.add(ontologyHelper.createDataPropertyAtom("hasCasino", (byte)1));

            // Create head of "isLuxurious" rule
            head.clear();
            ontologyHelper.createRuleHead("isLuxurious", 0.25, head);

            // Create "isLuxurious" rule
            ontologyHelper.createRule(body, head);

        }
        catch (OWLOntologyStorageException se) {
            se.printStackTrace();
        }
    }

    @Deprecated
    public void mapInstances() {
        Set<String> keys = mappings.characteristics.keySet();
        OWLClass owlClass = ontologyHelper.getFirstClass();
        OWLIndividual owlIndividual;
        int i, j, counter=1;
        String dp, facility, rate, distance;
        for(String database: keys) {
            System.out.println("Database: "+database);
            dbConnection.connect(database);
            Connection connection = dbConnection.getConnection();

            ArrayList<String> characteristics = this.mappings.findCharacteristic(database);
            rate = characteristics.get(0);
            distance = characteristics.get(1);

            ResultSet hotels = dbConnection.getAll("Hotel");
            ResultSet facilities = dbConnection.getAll("Facilities");

            ArrayList<String> hotelCols = dbConnection.getColumns(connection, database, "Hotel");
            ArrayList<String> hotelDataProps = mappings.getDataPropCols(hotelCols);

            ArrayList<String> facilitiesCols = dbConnection.getColumns(connection, database, "Facilities");
            ArrayList<String> facilitiesDataProps = mappings.getDataPropCols(facilitiesCols);

            try {
                while (hotels.next() && facilities.next()) {
                    // Create the individual
                    owlIndividual = this.ontologyHelper.createIndividual("Hotel_"+counter++);
                    System.out.println("Hotel_"+(counter-1));
                    this.ontologyHelper.associateIndividualWithClass(owlClass, owlIndividual);
                    i=0;
                    j=0;
                    for (String c : hotelCols) {
                        dp = hotelDataProps.get(i++);
                        if(dp.equals("hasName") || dp.equals("isInCountry") || dp.equals("isInCity"))
                            this.ontologyHelper.addStringDataToIndividual(owlIndividual, dp, hotels.getString(c));
                        else if(dp.equals("hasRating") || dp.equals("hasLocationRating")) {
                            if(!rate.equals("10"))
                                this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, this.mappings.convertRate(Integer.parseInt(rate), hotels.getDouble(c)));
                            else this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, hotels.getString(c));
                        }
                        else if(dp.equals("hasCityCenterDistance")) {
                            if(distance.equals("mi"))
                                this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, this.mappings.convertMiToKm(hotels.getDouble(c)));
                            else this.ontologyHelper.addDoubleDataToIndividual(owlIndividual, dp, hotels.getString(c));
                        }
                        else
                            this.ontologyHelper.addIntegerDataToIndividual(owlIndividual, dp, hotels.getString(c));
                    }
                    for (String c: facilitiesCols) {
                        if((facility=facilities.getString(c)) != null) {
                            dp = facilitiesDataProps.get(j);
                            if (!dp.equals("hasId"))
                                this.ontologyHelper.addByteDataToIndividual(owlIndividual, dp, facility);
                        }
                        j++;
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
        try {
            ontologyHelper.saveOntology();
        }
        catch (OWLOntologyStorageException ee) {
            ee.printStackTrace();
        }
    }
}
