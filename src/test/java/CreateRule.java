import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.util.HashSet;
import java.util.Set;

public class CreateRule {

    public static void main (String[] args) {

        try {
            OntologyHelper ontologyHelper = new OntologyHelper();
            OWLOntology owlOntology = ontologyHelper.readOntology();

            Set<SWRLAtom> body = new HashSet<>();
            Set<SWRLAtom> head = new HashSet<>();

            SWRLBuiltInAtom atom, atom1, atom2, k, l, d;

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
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
