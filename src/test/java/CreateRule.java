import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;

import java.util.HashSet;
import java.util.Set;

public class CreateRule {
    @Deprecated
    public static void main (String[] args) {

        try {
            OntologyHelper ontologyHelper = new OntologyHelper();
            OWLOntology owlOntology = ontologyHelper.readOntology();
           // ontologyHelper.createRule(owlOntology, "isLuxurious");
            //ontologyHelper.createRule2(owlOntology, "isVeryCheap");

            Set<SWRLAtom> body = new HashSet<>();
            Set<SWRLAtom> head = new HashSet<>();

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Very Cheap hotels                                 //
            ///////////////////////////////////////////////////////////////////////*/

            // Create body of "isVeryCheap" rule
            body.clear();
            SWRLBuiltInAtom atom = ontologyHelper.createComparisonAtom("price", "<", "50");
            body.add(atom);
            SWRLBuiltInAtom k = ontologyHelper.createMathAtom("price", "/", "50", "k");
            body.add(k);
            SWRLBuiltInAtom d = ontologyHelper.createMathAtom2("1", "-", "k", "d");
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

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Average hotels                                    //
            ///////////////////////////////////////////////////////////////////////*/

            /*///////////////////////////////////////////////////////////////////////
            //          Rule for Expensive hotels                                  //
            ///////////////////////////////////////////////////////////////////////*/

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
