package ontologyHelper;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public class OntologyHelper {
    String ontFile = "./src/main/resources/bookbest.owl";
    String prefix = "file:";

    URI basePhysicalURI = URI.create(prefix + ontFile);//URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));

    IRI iri = IRI.create(basePhysicalURI);

    OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();
    OWLDataFactory owlDataFactory = OWLManager.getOWLDataFactory();


    public OWLOntology readOntology() throws OWLOntologyCreationException {
        return owlOntologyManager.loadOntologyFromOntologyDocument(iri);
    }

    // OWL Class functions
    public Set<OWLClass> getClasses(OWLOntology owlOntology) {
        return owlOntology.getClassesInSignature();
    }

    public void printClasses(Set<OWLClass> owlClasses) {
        for(OWLClass owlClass: owlClasses) {
            System.out.println("Class: " + owlClass.getIRI().getFragment());
        }
    }

    public void printClasses(OWLOntology owlOntology) {
        for(OWLClass owlClass: owlOntology.getClassesInSignature()) {
            System.out.println("Class: " + owlClass.getIRI().getFragment());
        }
    }

    // OWL Data Property functions
    public Set<OWLDataPropertyDomainAxiom> getDataProperties(OWLOntology owlOntology) {
        return owlOntology.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN);
    }

    public void printDataProperties(Set<OWLDataPropertyDomainAxiom> owlDataProperties) {
        for(OWLDataPropertyDomainAxiom p: owlDataProperties)
            System.out.println("Data Property: "+p.getProperty().asOWLDataProperty().getIRI().getFragment());
    }

    public OWLDataProperty createDataProperty(String property) {
        return owlDataFactory.getOWLDataProperty(iri.create(basePhysicalURI+"#"+property));
    }

    public void printDataProperties(OWLOntology owlOntology) {
        Set<OWLDataPropertyDomainAxiom> properties = owlOntology.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN);
        for(OWLDataPropertyDomainAxiom p: properties)
            System.out.println("Data Property: "+p.getProperty().asOWLDataProperty().getIRI().getFragment());
    }

    // OWL Individual functions
    public OWLIndividual createIndividual(String name) {
        return owlDataFactory.getOWLNamedIndividual(iri.create(basePhysicalURI+"#"+name));
    }

    public int getIndividualsCounter(OWLOntology owlOntology) {
        return owlOntology.getIndividualsInSignature().size();
    }

    public OWLIndividual addIndividual(OWLIndividual owlIndividual) {

        return owlIndividual;
    }

    public OWLAxiom createAxiom(OWLIndividual owlIndividual, OWLClass owlClass) {
        return owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);
    }

    public OWLDataPropertyAssertionAxiom createDataPropertyAssertionAxiom(OWLDataProperty owlDataProperty, OWLIndividual owlIndividual, String value) {
        return owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, value);
    }


    public OWLAxiomChange associateIndividualWithClass(OWLOntology owlOntology, OWLClass owlClass, OWLIndividual owlIndividual) {
        return new AddAxiom(owlOntology, owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual));
    }

    public OWLAxiomChange addDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, OWLDataProperty owlDataProperty, String value) {
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_STRING);
        return new AddAxiom(owlOntology, owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal));
    }

    public OWLAxiomChange addDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, OWLDataProperty owlDataProperty, boolean value) {
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value);
        return new AddAxiom(owlOntology, owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal));
    }

    public OWLAxiomChange addDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, OWLDataProperty owlDataProperty, int value) {
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value);
        return new AddAxiom(owlOntology, owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal));
    }

    public void saveOntology(OWLOntology owlOntology, AddAxiom addAxiom) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        owlOntologyManager.applyChange(addAxiom);

        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

}
