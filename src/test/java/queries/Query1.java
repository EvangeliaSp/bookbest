package queries;

import DLReasoner.Reasoner;
import DL_Queries.SPARQL;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import ontologyHelper.OntologyHelper;
import org.junit.Before;
import org.junit.Test;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class Query1 {
    private OWLOntology owlOntology;
    private OntologyHelper ontologyHelper;
    private Reasoner reasoner;
    private SPARQL sparql;

    @Before
    public void init() throws OWLOntologyCreationException {
        this.ontologyHelper = new OntologyHelper();
        this.owlOntology = ontologyHelper.readOntology();
        this.reasoner = new Reasoner(owlOntology);
        this.sparql = new SPARQL();
    }

    @Test
    public void getCheapAccommodations() {
        // Get the KB from the reasoner
        KnowledgeBase knowledgeBase = reasoner.getKnowledgeBase();

        // Create a Pellet graph using the KB from OWLAPI
        PelletInfGraph graph = reasoner.getGraph(knowledgeBase);

        // Wrap the graph in a Jena model
        InfModel model = ModelFactory.createInfModel(graph);

        sparql.getCheap(model);
    }
}
