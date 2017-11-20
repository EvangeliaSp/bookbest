package ontologyHelper;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import java.io.File;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OntologyHelper {
    String ontFile = "./src/main/resources/bookbest.owl";
    String prefix = "file:";
    URI basePhysicalURI = URI.create(prefix + ontFile);//URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));

    String base = "urn:absolute:";
    String ontName = "bookbest";
    IRI iri = IRI.create(base+ontName);

    OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();
    OWLDataFactory owlDataFactory = OWLManager.getOWLDataFactory();

    OWLOntology owlOntology;

    @Deprecated
    PrefixManager prefixManager = new DefaultPrefixManager(base+"#");




    public void printBasePhysicalURI() {
        //System.out.println(basePhysicalURI+"#");
    }

    public OWLOntologyManager getOwlOntologyManager() {
        return owlOntologyManager;
    }

    public OWLDataFactory getOwlDataFactory() {
        return owlDataFactory;
    }

    public OWLOntology createOntology() throws OWLOntologyCreationException {
        this.owlOntology = owlOntologyManager.createOntology(this.iri);
        return this.owlOntology;
    }

    public OWLOntology readOntology() throws OWLOntologyCreationException {
        this.owlOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(this.basePhysicalURI));
        return this.owlOntology;
    }

    // OWL Class functions

    public OWLClass createClass(String name) {
        //return this.owlDataFactory.getOWLEntity(EntityType.CLASS, iri.create(basePhysicalURI+"#"+name));
        return this.owlDataFactory.getOWLEntity(EntityType.CLASS, iri.create(this.base+this.ontName+"#"+name));
    }

    public Set<OWLClass> getClasses(OWLOntology owlOntology) {
        return owlOntology.getClassesInSignature();
    }

    public OWLClass getFirstClass(OWLOntology owlOntology) {
        Set<OWLClass> owlClasses = owlOntology.getClassesInSignature();
        Iterator<OWLClass> iterator = owlClasses.iterator();
        return iterator.next();
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
    public OWLDataProperty createDataProperty(String property) {
        //return owlDataFactory.getOWLDataProperty(iri.create(basePhysicalURI+"#"+property));
        return owlDataFactory.getOWLDataProperty(iri.create(this.base+this.ontName+"#"+property));
    }

    @Deprecated
    public OWLDataProperty getDataProperty(String property) {
        return this.owlDataFactory.getOWLDataProperty(property, this.prefixManager);
    }

 /*   public Set<OWLDataPropertyDomainAxiom> getDataProperties(OWLOntology owlOntology) {
        return owlOntology.getAxioms(AxiomType.DATA_PROPERTY_DOMAIN);
    }*/

    public Set<OWLDataProperty> getDataProperties(OWLOntology owlOntology) {
        return owlOntology.getDataPropertiesInSignature();
    }

/*    public void printDataProperties(Set<OWLDataPropertyDomainAxiom> owlDataProperties) {
        for(OWLDataPropertyDomainAxiom p: owlDataProperties)
            System.out.println("Data Property: "+p.getProperty().asOWLDataProperty().getIRI().getFragment());
    }*/

    public void printDataProperties(OWLOntology owlOntology) {
        Set<OWLDataProperty> owlDataProperties = owlOntology.getDataPropertiesInSignature();
        for(OWLDataProperty owlDataProperty: owlDataProperties)
            System.out.println("Data Property: "+owlDataProperty.getIRI().getFragment());
    }

    // OWL Individual functions
    public OWLIndividual createIndividual(String name) {
        return owlDataFactory.getOWLNamedIndividual(iri.create(this.base+this.ontName+"#"+name));
    }

    public void createIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, OWLClass owlClass) throws OWLOntologyStorageException {
        OWLClassAssertionAxiom owlClassAssertionAxiom = this.owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);
        AddAxiom addAxiom = new AddAxiom(owlOntology, owlClassAssertionAxiom);
        saveOntology(owlOntology, addAxiom);
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

    public void addDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLAxiom owlAxiom = createDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, value);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        saveOntology(owlOntology, addAxiom);
    }

    public void saveOntology(OWLOntology owlOntology, AddAxiom addAxiom) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        owlOntologyManager.applyChange(addAxiom);

        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLOntology owlOntology, OWLClass owlClass) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        OWLAxiom owlAxiom = this.owlDataFactory.getOWLDeclarationAxiom(owlClass);
        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLOntology owlOntology, OWLDataProperty owlDataProperty) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        OWLAxiom owlAxiom = this.owlDataFactory.getOWLDeclarationAxiom(owlDataProperty);
        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLOntology owlOntology) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    // OWL Individual functions
    @Deprecated
    public void createRule(OWLOntology owlOntology, String rule) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        OWLClass owlClass = getFirstClass(owlOntology);
        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = getDataProperty("hasStarRating");

        // Create rule body
        SWRLClassAtom atom1 = this.owlDataFactory.getSWRLClassAtom(owlClass, swrlVariable);

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(1);
        SWRLLiteralArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);
        SWRLDataPropertyAtom atom2 = this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, swrlVariable, swrldArgument);
                //(owlDataProperty, swrlVariable, owlLiteral);

        Set<SWRLAtom> body = new HashSet<>();
        body.add(atom1);
        body.add(atom2);

        // Create rule head
        OWLDataProperty dataProperty;

        dataProperty = createDataProperty(rule);
        saveOntology(owlOntology, dataProperty);

        Set<SWRLAtom> head = new HashSet<>();
        owlLiteral = this.owlDataFactory.getOWLLiteral(100);
        swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);
        head.add(this.owlDataFactory.getSWRLDataPropertyAtom(dataProperty, swrlVariable, swrldArgument));

        SWRLRule swrlRule = this.owlDataFactory.getSWRLRule(body, head);
        this.owlOntologyManager.applyChange(new AddAxiom(owlOntology, swrlRule));
        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

}
