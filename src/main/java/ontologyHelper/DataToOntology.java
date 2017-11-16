package ontologyHelper;

import org.semanticweb.owlapi.model.*;

public class DataToOntology {

    // Import String data
    public void importData(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        if(value != null)
            ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, property, value);
    }

    // Import Integer data
    public void importData(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, Integer value) throws OWLOntologyStorageException {
        if(value != null)
            ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, property, String.valueOf(value));
    }

    // Import Double data
    public void importData(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, Double value) throws OWLOntologyStorageException {
        if(value != null)
            ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, property, String.valueOf(value));
    }

    // Import Byte data
    public void importData(OntologyHelper ontologyHelper, OWLOntology owlOntology, OWLIndividual owlIndividual, String property, Byte value) throws OWLOntologyStorageException {
        if(value != null)
            ontologyHelper.addDataToIndividual(owlOntology, owlIndividual, property, String.valueOf(value));
    }
}