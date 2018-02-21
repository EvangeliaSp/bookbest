package DLReasoner;

import static org.junit.Assert.assertTrue;

import aterm.ATermAppl;
import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.rules.model.Rule;
import ontologyHelper.OntologyHelper;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.*;

import java.util.Set;

public class Reasoner {

    OWLOntology owlOntology;
    com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory reasonerFactory;
    PelletReasoner owlReasoner;



    public Reasoner(OWLOntology owlOntology) {
        this.owlOntology = owlOntology;
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

    public void printOntologyInfo() {
        KnowledgeBase knowledgeBase = getKnowledgeBase();
        System.out.println(knowledgeBase.getInfo());
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
        }
    }

    public KnowledgeBase getKnowledgeBase() {
//        KnowledgeBase knowledgeBase = this.owlReasoner.getKB();
//        knowledgeBase.realize();
//        return  knowledgeBase;
        return this.owlReasoner.getKB();
    }

    public PelletInfGraph getGraph(KnowledgeBase knowledgeBase) {
        return new org.mindswap.pellet.jena.PelletReasoner().bind(knowledgeBase);
    }

    public void printInstances() {
        KnowledgeBase knowledgeBase = getKnowledgeBase();

        Set<ATermAppl> individuals = knowledgeBase.getIndividuals();
        System.out.println("Individuals::: "+individuals.size());

        for(ATermAppl individual: individuals) {
            System.out.println(individual.getName().toString());
        }
    }

    public void printDataproperties() {
        KnowledgeBase knowledgeBase = getKnowledgeBase();

        Set<ATermAppl> dataProperties = knowledgeBase.getDataProperties();
        System.out.println("Data Properties::: "+dataProperties.size());

        for(ATermAppl dataProperty: dataProperties) {
            System.out.println(dataProperty.getName().toString());
        }
    }

    public void printRules() {
        KnowledgeBase knowledgeBase = getKnowledgeBase();

        Set<Rule> rules = knowledgeBase.getRules();
        System.out.println("Rules::: "+rules.size());

        for(Rule rule: rules) {
            System.out.println(rule.toString());
            System.out.println("Body: "+rule.getBody().toString());
            System.out.println("Head: "+rule.getHead().toString());
            System.out.println();
        }
    }
}
