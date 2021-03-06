package ontologyHelper;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.SWRLBuiltInsVocabulary;
import org.semanticweb.owlapitools.builders.BuilderSWRLDataPropertyAtom;

import java.io.File;
import java.net.URI;
import java.util.*;

public class OntologyHelper {
    static String ontFile = "./src/main/resources/bookbest.owl";
    String prefix = "file:";
    URI basePhysicalURI = URI.create(prefix + ontFile);//URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));

    String base = "";
    private static String ontName = "urn:absolute:bookbest.owl";
    IRI iri = IRI.create(base+ontName);
    //IRI iri = IRI.create(this.basePhysicalURI);
    List<AddAxiom> addAxioms = new LinkedList<>();


    OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();
    OWLDataFactory owlDataFactory = OWLManager.getOWLDataFactory();

    OWLOntology owlOntology;

    @Deprecated
    PrefixManager prefixManager = new DefaultPrefixManager(this.base+this.ontName+"#");


    // OWL Ontology functions

    public OWLOntology createOntology() {
        try {
            this.owlOntology = owlOntologyManager.createOntology(this.iri);
        }
        catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        return this.owlOntology;
    }

    public OWLOntology readOntology() {
        try {
            this.owlOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(this.basePhysicalURI));
        }
        catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        return this.owlOntology;
    }

    public IRI getIri() {
        return IRI.create(this.basePhysicalURI);
    }

    // OWL Class functions

    public OWLClass createClass(String name) {
        //return this.owlDataFactory.getOWLEntity(EntityType.CLASS, iri.create(basePhysicalURI+"#"+name));
        return this.owlDataFactory.getOWLEntity(EntityType.CLASS, iri.create(this.base+this.ontName+"#"+name));
    }

    public Set<OWLClass> getClasses(OWLOntology owlOntology) {
        return owlOntology.getClassesInSignature();
    }

    public OWLClass getClass(String name) {
        Set<OWLClass> owlClasses = this.owlOntology.getClassesInSignature();
        for(OWLClass owlClass: owlClasses) {
            if(owlClass.getIRI().getFragment().equals(name))
                return owlClass;
        }
        return null;
    }

    public OWLClass getFirstClass() {
        Set<OWLClass> owlClasses = this.owlOntology.getClassesInSignature();
        Iterator<OWLClass> iterator = owlClasses.iterator();
        return iterator.next();
    }

    public void printClasses(Set<OWLClass> owlClasses) {
        for(OWLClass owlClass: owlClasses) {
            System.out.println("Class: " + owlClass.getIRI().getFragment());
        }
    }

    public void printClasses() {
        for(OWLClass owlClass: this.owlOntology.getClassesInSignature()) {
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

    public void associateIndividualWithClass(OWLClass owlClass, OWLIndividual owlIndividual) throws OWLOntologyStorageException {
        OWLClassAssertionAxiom owlClassAssertionAxiom = this.owlDataFactory.getOWLClassAssertionAxiom(owlClass, owlIndividual);
        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlClassAssertionAxiom);
        saveOntology(addAxiom);
    }

    @Deprecated
    public void addStringDataToIndividual(OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = getDataProperty(property);
        //OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_STRING);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);
        addAxioms.add(addAxiom);
        //saveOntology(addAxiom);
    }

    @Deprecated
    public void addIntegerDataToIndividual(OWLIndividual owlIndividual, String property, String value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = getDataProperty(property);
        //OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_INTEGER);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);
        addAxioms.add(addAxiom);
        //saveOntology(addAxiom);
    }

    @Deprecated
    public void addDoubleDataToIndividual(OWLIndividual owlIndividual, String property, String  value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = getDataProperty(property);
        //OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_DOUBLE);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);
        addAxioms.add(addAxiom);
        //saveOntology(addAxiom);
    }

    @Deprecated
    public void addByteDataToIndividual(OWLIndividual owlIndividual, String property, String  value) throws OWLOntologyStorageException {
        OWLDataProperty owlDataProperty = getDataProperty(property);
        //OWLDataProperty owlDataProperty = createDataProperty(property);
        OWLLiteral literal = owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_BYTE);
        OWLDataPropertyAssertionAxiom owlAxiom = owlDataFactory.getOWLDataPropertyAssertionAxiom(owlDataProperty, owlIndividual, literal);

        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);
        addAxioms.add(addAxiom);
        //saveOntology(addAxiom);
    }

    public void saveOntology(AddAxiom addAxiom) throws OWLOntologyStorageException {
        File file = new File(this.ontFile);

        owlOntologyManager.applyChange(addAxiom);

        owlOntologyManager.saveOntology(this.owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLClass owlClass) throws OWLOntologyStorageException {
        File file = new File(this.ontFile);

        OWLAxiom owlAxiom = this.owlDataFactory.getOWLDeclarationAxiom(owlClass);
        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(this.owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(OWLDataProperty owlDataProperty) throws OWLOntologyStorageException {
        File file = new File(this.ontFile);

        OWLAxiom owlAxiom = this.owlDataFactory.getOWLDeclarationAxiom(owlDataProperty);
        AddAxiom addAxiom = new AddAxiom(this.owlOntology, owlAxiom);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(this.owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology(SWRLRule rule) throws OWLOntologyStorageException {
        File file = new File(this.ontFile);

        AddAxiom addAxiom = new AddAxiom(this.owlOntology, rule);

        owlOntologyManager.applyChange(addAxiom);
        owlOntologyManager.saveOntology(this.owlOntology, IRI.create(file.toURI()));
    }

    public void saveOntology() throws OWLOntologyStorageException {
        File file = new File(this.ontFile);
        owlOntologyManager.applyChanges(addAxioms);
        owlOntologyManager.saveOntology(this.owlOntology, IRI.create(file.toURI()));
    }

    // OWL Rule functions

    public Set<SWRLAtom> createRuleHead(String dataProperty, String d, Set<SWRLAtom> head) throws OWLOntologyStorageException {
        //OWLClass owlClass = getClass(owlOntology, "Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = createDataProperty(dataProperty);
        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+d));

        head.add(this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrlVariable));
        return head;
    }

    public Set<SWRLAtom> createRuleHead(String dataProperty, int d, Set<SWRLAtom> head) throws OWLOntologyStorageException {
        //OWLClass owlClass = getClass(owlOntology, "Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = createDataProperty(dataProperty);

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(String.valueOf(d), OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        head.add(this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrldArgument));
        return head;
    }

    public Set<SWRLAtom> createRuleHead(String dataProperty, double d, Set<SWRLAtom> head) throws OWLOntologyStorageException {
        //OWLClass owlClass = getClass(owlOntology, "Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLDataProperty owlDataProperty = createDataProperty(dataProperty);

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(String.valueOf(d), OWL2Datatype.XSD_DOUBLE);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        head.add(this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrldArgument));
        return head;
    }

    @Deprecated
    public Set<SWRLAtom> createRuleBody(String dataProperty, String variable, Set<SWRLAtom> body) throws OWLOntologyStorageException {
        OWLClass owlClass = getClass("Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));
        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+variable));

        OWLDataProperty owlDataProperty = getDataProperty(dataProperty);

        // 1st Atom
        SWRLClassAtom atom1 = this.owlDataFactory.getSWRLClassAtom(owlClass, x);

        // 2nd Atom
        SWRLDataPropertyAtom atom2 = this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrlVariable);

        body.add(atom1);
        body.add(atom2);

        return body;
    }

    @Deprecated
    public Set<SWRLAtom> createRuleBody(String dataProperty, int value, Set<SWRLAtom> body) throws OWLOntologyStorageException {
        OWLClass owlClass = getClass("Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(String.valueOf(value), OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);


        OWLDataProperty owlDataProperty = getDataProperty(dataProperty);

        // 1st Atom
        SWRLClassAtom atom1 = this.owlDataFactory.getSWRLClassAtom(owlClass, x);

        // 2nd Atom
        SWRLDataPropertyAtom atom2 = this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrldArgument);

        body.add(atom1);
        body.add(atom2);

        return body;
    }

    public void createRule(Set<SWRLAtom> body, Set<SWRLAtom> head) throws OWLOntologyStorageException {
        SWRLRule swrlRule = this.owlDataFactory.getSWRLRule(body, head);
        saveOntology(swrlRule);
    }

    public SWRLClassAtom createClassAtom() {
        OWLClass owlClass = getClass("Hotel"); // hotel
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));
        return this.owlDataFactory.getSWRLClassAtom(owlClass, x);
    }

    @Deprecated
    public SWRLDataPropertyAtom createDataPropertyAtom(String dataProperty, int value) {
        OWLDataProperty owlDataProperty = getDataProperty(dataProperty);
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));
        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(String.valueOf(value), OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);
        return this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrldArgument);
    }

    @Deprecated
    public SWRLDataPropertyAtom createDataPropertyAtom(String dataProperty, byte value) {
        OWLDataProperty owlDataProperty = getDataProperty(dataProperty);
        SWRLVariable x = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#x"));
        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(String.valueOf(value), OWL2Datatype.XSD_BYTE);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);
        return this.owlDataFactory.getSWRLDataPropertyAtom(owlDataProperty, x, swrldArgument);
    }

    public SWRLBuiltInAtom createComparisonAtom(String variable, String comparison, String value) {
        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+variable));

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        List<SWRLDArgument> arguments = new ArrayList<>();
        arguments.add(swrlVariable);
        arguments.add(swrldArgument);

        switch (comparison) {
            case "=":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.EQUAL.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            case "!=":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.NOT_EQUAL.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            case "<":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.LESS_THAN.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            case "<=":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.LESS_THAN_OR_EQUAL.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            case ">":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.GREATER_THAN.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            case ">=":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.GREATER_THAN_OR_EQUAL.getIRI(), Arrays.asList(swrlVariable, swrldArgument));
            default:
                return null;
        }
    }

    public SWRLBuiltInAtom createMathAtom(String variable, String math, String value, String result) {
        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+variable));

        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        SWRLVariable k = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+result));

        switch (math) {
            case "+":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.ADD.getIRI(), Arrays.asList(k, swrlVariable, swrldArgument));
            case "-":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.SUBTRACT.getIRI(), Arrays.asList(k, swrlVariable, swrldArgument));
            case "*":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.MULTIPLY.getIRI(), Arrays.asList(k, swrlVariable, swrldArgument));
            case "/":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.DIVIDE.getIRI(), Arrays.asList(k, swrlVariable, swrldArgument));
            default:
                return null;
        }
    }

    public SWRLBuiltInAtom createMathAtom2(String value, String math, String variable, String result) {
        OWLLiteral owlLiteral = this.owlDataFactory.getOWLLiteral(value, OWL2Datatype.XSD_INTEGER);
        SWRLDArgument swrldArgument = this.owlDataFactory.getSWRLLiteralArgument(owlLiteral);

        SWRLVariable swrlVariable = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+variable));

        SWRLVariable d = this.owlDataFactory.getSWRLVariable(IRI.create(this.base+this.ontName+"#"+result));

        switch (math) {
            case "+":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.ADD.getIRI(), Arrays.asList(d, swrldArgument, swrlVariable));
            case "-":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.SUBTRACT.getIRI(), Arrays.asList(d, swrldArgument, swrlVariable));
            case "*":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.MULTIPLY.getIRI(), Arrays.asList(d, swrldArgument, swrlVariable));
            case "/":
                return this.owlDataFactory.getSWRLBuiltInAtom(SWRLBuiltInsVocabulary.DIVIDE.getIRI(), Arrays.asList(d, swrldArgument, swrlVariable));
            default:
                return null;
        }
    }
}
