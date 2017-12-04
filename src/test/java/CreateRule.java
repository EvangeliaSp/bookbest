import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.*;
import org.swrlapi.core.SWRLAPIRule;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.factory.SWRLAPIFactory;

public class CreateRule {
    @Deprecated
    public static void main (String[] args) {

        try {
            OntologyHelper ontologyHelper = new OntologyHelper();
            OWLOntology owlOntology = ontologyHelper.readOntology();
            ontologyHelper.createRule(owlOntology, "isLuxurious");
            //ontologyHelper.createRule2(owlOntology, "isVeryCheap");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
