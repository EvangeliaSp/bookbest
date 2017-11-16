package dataMapping;

import ontologyHelper.DataToOntology;
import ontologyHelper.OntologyHelper;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.sql.Statement;

public class PricelineMapping {
    Statement statement;
    OntologyHelper ontologyHelper;
    OWLOntology owlOntology;
    DataToOntology dataToOntology;

    public PricelineMapping(Statement statement) throws OWLOntologyCreationException {
        this.statement = statement;
        OntologyHelper ontologyHelper = new OntologyHelper();
        this.ontologyHelper = ontologyHelper;
        this.owlOntology = ontologyHelper.readOntology();
        this.dataToOntology = new DataToOntology();
    }

    public void importData() throws OWLOntologyStorageException {

    }
}
