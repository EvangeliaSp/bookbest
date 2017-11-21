package DLReasoner;

import static org.junit.Assert.assertTrue;

import aterm.ATermAppl;
import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import ontologyHelper.OntologyHelper;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.*;

import java.util.Set;

public class Reasoner {

    OWLOntology owlOntology;
    OntologyHelper ontologyHelper;
    com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory reasonerFactory;
    PelletReasoner owlReasoner;



    public Reasoner(OWLOntology owlOntology, OntologyHelper ontologyHelper) {
        this.owlOntology = owlOntology;
        this.ontologyHelper = ontologyHelper;
        this.reasonerFactory = com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory.getInstance();
        this.owlReasoner = reasonerFactory.createReasoner(owlOntology);
    }

    public void classifyOntology() {
        this.owlReasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        assertTrue(this.owlReasoner.isConsistent());
        // get a list of unsatisfiable classes
        Node<OWLClass> bottomNode = this.owlReasoner.getUnsatisfiableClasses();
        // leave owl:Nothing out
        Set<OWLClass> unsatisfiable = bottomNode.getEntitiesMinusBottom();
        if (!unsatisfiable.isEmpty()) {
            System.out.println("The following classes are unsatisfiable: ");
            for (OWLClass cls : unsatisfiable) {
                System.out.println(cls.getIRI().getFragment());
            }
        } else {
            System.out.println("There are no unsatisfiable classes");
        }

    }

    public void printSubclasses() {
        // Look up and print all direct subclasses for all classes
        for (OWLClass c : this.owlOntology.getClassesInSignature()) {
            // the boolean argument specifies direct subclasses; false would specify all subclasses
            // a NodeSet represents a set of Nodes.
            // a Node represents a set of equivalent classes
            NodeSet<OWLClass> subClasses = this.owlReasoner.getSubClasses(c, true);
            for (OWLClass subClass : subClasses.getFlattened()) {
                System.out.println(subClass.getIRI().getFragment() + "\tsubclass of\t"
                        + c.getIRI().getFragment());
            }
            /*this.owlReasoner.getKB().realize();
            this.owlReasoner.getKB().printClassTree();
            Set<ATermAppl> inds = this.owlReasoner.getKB().getIndividuals();
            System.out.println("Individuals::: "+inds.size());

            for(ATermAppl a: inds) {
                //System.out.println(a.getName().toString());
            }*/
        }
    }

    public void printDataProperties() {
        for (OWLClass owlClass : this.owlOntology.getClassesInSignature()) {
            //NodeSet<OWLDataProperty> owlDataProperties = owlReasoner.get
        }
    }

    public void printInstances(OWLClass owlClass) {
        // for each class, look up the instances

        //for (OWLClass owlClass : this.owlOntology.getClassesInSignature()) {
            // the boolean argument specifies direct subclasses; false would specify all subclasses
            // a NodeSet represents a set of Nodes.
            // a Node represents a set of equivalent classes/or sameAs individuals

            Set<OWLNamedIndividual> instances = this.owlReasoner.getInstances(owlClass, true).getFlattened();
            if(instances.size()==0)
                System.out.println("Class '"+owlClass.getIRI().getFragment()+"' has no instances!!!");
            for (OWLNamedIndividual i : instances) {
                System.out.println(i.getIRI().getFragment()+" instance of "+owlClass.getIRI().getFragment());

                for(OWLDataProperty owlDataProperty: this.ontologyHelper.getDataProperties(this.owlOntology)) {
                    System.out.print("\t"+owlDataProperty.getIRI().getFragment()+": ");
                    Set<OWLLiteral> owlLiterals = owlReasoner.getDataPropertyValues(i,owlDataProperty);
                    for(OWLLiteral owlLiteral: owlLiterals) {
                        System.out.println(owlLiteral.getLiteral());
                    }
                }
            }
       // }
    }

    public KnowledgeBase getKnowledgeBase() {
        return this.owlReasoner.getKB();
    }

    public PelletInfGraph getGraph(KnowledgeBase knowledgeBase) {
        return new org.mindswap.pellet.jena.PelletReasoner().bind(knowledgeBase);
    }

    public void printInstances() {
        KnowledgeBase knowledgeBase = getKnowledgeBase();
        knowledgeBase.realize();

        Set<ATermAppl> inds = knowledgeBase.getIndividuals();
        System.out.println("Individuals::: "+inds.size());

        for(ATermAppl a: inds) {
            System.out.println(a.getName().toString());
        }

    }
}
