package ontologyHelper;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLOntologyDocumentSource;
import org.semanticweb.owlapi.model.*;

import java.net.URI;
import java.util.Set;

public class OntologyHelper {
    String ontFile = "./src/main/resources/bookbest.owl";
    String prefix = "file:";

    URI basePhysicalURI = URI.create(prefix + ontFile);//URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));

    IRI iri = IRI.create(basePhysicalURI);

    OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();


    public OWLOntology readOntology()
            throws OWLOntologyCreationException {
        return owlOntologyManager.loadOntologyFromOntologyDocument(iri);
    }

    public Set<OWLClass> getOWLClasses(OWLOntology owlOntology) {
        return owlOntology.getClassesInSignature();
    }

    /*public void printOWLClasses(Set<OWLClass> owlClasses) {
        for(OWLClass owlClass: owlClasses) {
            System.out.println("Class: " + owlClass.getIRI().getFragment());
        }
    }*/

    public void printOWLClasses(OWLOntology owlOntology) {
        for(OWLClass owlClass: owlOntology.getClassesInSignature()) {
            System.out.println("Class: " + owlClass.getIRI().getFragment());
        }
    }

    public void printOWLDataProperties(OWLOntology owlOntology) {
        Set<OWLDataPropertyDomainAxiom> properties = owlOntology.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN);
        for(OWLDataPropertyDomainAxiom p: properties)
            System.out.println("Data Property: "+p.getProperty().asOWLDataProperty().getIRI().getFragment());
    }




}
