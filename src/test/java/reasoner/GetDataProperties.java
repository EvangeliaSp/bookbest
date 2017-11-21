package reasoner;

import DLReasoner.Reasoner;
import ontologyHelper.OntologyHelper;
import org.junit.Before;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class GetDataProperties {
    private OWLOntology owlOntology;
    private OntologyHelper ontologyHelper;
    private Reasoner reasoner;

    @Before
    public void init() throws OWLOntologyCreationException {
        this.ontologyHelper = new OntologyHelper();
        this.owlOntology = ontologyHelper.readOntology();
        this.reasoner = new Reasoner(owlOntology, ontologyHelper);
    }

    @Test
    public void getIndividuals() {
        // Classify ontology
        reasoner.classifyOntology();

        // Print datatype properties
        reasoner.printDataproperties();
    }
}
