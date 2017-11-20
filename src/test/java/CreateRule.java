import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.OWLOntology;

public class CreateRule {
    @Deprecated
    public static void main(String[] args) {

        try {
            OntologyHelper ontologyHelper = new OntologyHelper();
            OWLOntology owlOntology = ontologyHelper.readOntology();
            ontologyHelper.createRule(owlOntology, "isLuxurious");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
