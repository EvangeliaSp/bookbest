package ontologyHelper;

import dataMapping.Mappings;
import org.semanticweb.owlapi.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OntologyGenerator {
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    Mappings mappings;

    public OWLOntology getOwlOntology() {
        return owlOntology;
    }

    public OntologyGenerator(Mappings mappings) {
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        this.mappings = mappings;
    }

    // Create OWL Ontology
    public void generateOntology() {
        try {
            this.owlOntology = this.ontologyHelper.createOntology();
            this.generateClasses();
            this.generateDataProperties();
            this.generateRules();
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
}
