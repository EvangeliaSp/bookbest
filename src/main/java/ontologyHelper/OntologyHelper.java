package ontologyHelper;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.SWRLBuiltInsVocabulary;

import java.io.File;
import java.net.URI;
import java.util.*;

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
    PrefixManager prefixManager = new DefaultPrefixManager(this.base+this.ontName+"#");




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

    public OWLClass getClass(OWLOntology owlOntology, String name) {
        Set<OWLClass> owlClasses = owlOntology.getClassesInSignature();
        for(OWLClass owlClass: owlClasses) {
            if(owlClass.getIRI().getFragment().equals(name))
                return owlClass;
        }
        return null;
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

    // OWL Object property functions

    public OWLObjectProperty createObjectProperty(String property) {
        return owlDataFactory.getOWLObjectProperty(iri.create(this.base+this.ontName+"#"+property));
    }

    // OWL Data property functions

    public OWLDataProperty createDataProperty(String property) {
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

    public int getIndividualsCounter(OWLOntology owlOntology) {
        return owlOntology.getIndividualsInSignature().size();
    }

    public OWLAxiom createAxiom(OWLIndividual owlIndividual, OWLClass owlClass) {
        return owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);
    }

    public OWLDataPropertyAssertionAxiom createDataPropertyAssertionAxiom(OWLDataProperty owlDataProperty, OWLIndividual owlIndividual, String value) {
        return owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, value);
    }


    public void associateIndividualWithClass(OWLOntology owlOntology, OWLClass owlClass, OWLIndividual owlIndividual) throws OWLOntologyStorageException {
        OWLClassAssertionAxiom owlClassAssertionAxiom = this.owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);
        AddAxiom addAxiom = new AddAxiom(owlOntology, owlClassAssertionAxiom);
        saveOntology(owlOntology, addAxiom);
    }

    public void addStringDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = createDataProperty(property);//getDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_STRING);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        saveOntology(owlOntology, addAxiom);
    }

    public void addIntegerDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_INTEGER);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        saveOntology(owlOntology, addAxiom);
    }

    public void addDoubleDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String  value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_DOUBLE);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(owlOntology, owlAxiom);
        saveOntology(owlOntology, addAxiom);
    }

    public void addByteDataToIndividual(OWLOntology owlOntology, OWLIndividual owlIndividual, String property, String  value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_BYTE);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

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

    public void saveOntology(OWLOntology owlOntology, SWRLRule rule) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        AddAxiom addAxiom = new AddAxiom(owlOntology, rule);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLOntology owlOntology) throws OWLOntologyStorageException {
        File file = new File("./src/main/resources/bookbest.owl");

        owlOntologyManager.saveOntology(owlOntology, IRI.create(file.toURI()));
    }

    // OWL Rule functions
    public void createRule(OWLOntology owlOntology, String rule) throws OWLOntologyStorageException {
        OWLClass owlClass = getClass(owlOntology, "Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = createDataProperty("hasStarRating");

        // Create rule body
        // 1st Atom
        SWRLClassAtom atom1 = this.owlDataFactory.getSWRLClassAtom(owlClass, x);

        //2nd Atom
        OWLLiteral five = this.owlDataFactory.getOWLLiteral("5", OWL2Datatype.XSD_INTEGER);
        SWRLDArgument fiveArgument = this.owlDataFactory.getSWRLLiteralArgument(five);
        SWRLDataPropertyAtom atom2 = this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, fiveArgument);

        // Intersection of Atoms
        Set<SWRLAtom> body = new HashSet<>();
        body.add(atom1);
        body.add(atom2);

        // Create rule head
        OWLDataProperty dataProperty = createDataProperty(rule);

        Set<SWRLAtom> head = new HashSet<>();
        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral("100", OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);
        head.add(this.owlDataFactory.getSWRLDataPropertyAtom(dataProperty, x, swrldArgument));

        SWRLRule swrlRule = this.owlDataFactory.getSWRLRule(body, head);
        saveOntology(owlOntology, swrlRule);
    }

    // OWL Rule functions
    public void createRule2(OWLOntology owlOntology, String rule) throws OWLOntologyStorageException {
        OWLClass owlClass = getClass(owlOntology, "Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = createDataProperty("hasPricePerNight");//getDataProperty("hasPricePerNight");
        System.out.println("Data property: " + owlDataProperty.getIRI().getFragment());

        SWRLVariable price = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#price"));

        // Create rule body
        // 1st Atom
        SWRLClassAtom atom1 = this.owlDataFactory.getSWRLClassAtom(owlClass, x);

        // 2nd Atom
        SWRLDataPropertyAtom atom2 = this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, price);

        // 3rd Atom
        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral("50", OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        List<SWRLDArgument> arguments = new ArrayList<>();
        arguments.add(price);
        arguments.add(swrldArgument);
        SWRLBuiltInAtom atom3 = this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.LESS_THAN_OR_EQUAL.getIRI(), Arrays.asList(price, swrldArgument));

        // Intersection of Atoms
        Set<SWRLAtom> body = new HashSet<>();
        body.add(atom1);
        body.add(atom2);
        body.add(atom3);


        // Create rule head
        //OWLObjectProperty objectProperty = createObjectProperty(rule);
        //saveOntology(owlOntology, dataProperty);
        OWLClass newClass = createClass(rule);
        Set<SWRLAtom> head = new HashSet<>();
        head.add(this.owlDataFactory.getSWRLClassAtom(newClass, x));

        SWRLRule swrlRule = this.owlDataFactory.getSWRLRule(body, head);
        saveOntology(owlOntology, swrlRule);
    }
}
