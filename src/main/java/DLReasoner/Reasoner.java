package DLReasoner;

// http://jfact.sourceforge.net/Example.java
import static org.junit.Assert.assertTrue;

//import aterm.ATermAppl;
//import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
//import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.*;
import uk.ac.manchester.cs.jfact.JFactFactory;

import java.util.Set;

public class Reasoner {

    // JFact
    OWLReasonerFactory owlReasonerFactory = null;
    OWLOntology owlOntology;
    OWLReasonerConfiguration owlReasonerConfiguration;
    OWLReasoner owlReasoner;
/*
    OWLOntology owlOntology;
    com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory reasonerFactory;
    PelletReasoner owlReasoner;*/


    public Reasoner(OWLOntology owlOntology) {
        this.owlReasonerFactory = new JFactFactory();
        this.owlOntology = owlOntology;
        this.owlReasonerConfiguration = new SimpleConfiguration(50000);
        this.owlReasoner = this.owlReasonerFactory.createReasoner(this.owlOntology, owlReasonerConfiguration);
/*
        this.owlOntology = owlOntology;
        this.reasonerFactory =  com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory.getInstance();
        this.owlReasoner = reasonerFactory.createReasoner(owlOntology);*/
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

    public void printInstances() {
        // for each class, look up the instances
        int m=1;
        
        for (OWLClass owlClass : this.owlOntology.getClassesInSignature()) {
            // the boolean argument specifies direct subclasses; false would specify all subclasses
            // a NodeSet represents a set of Nodes.
            // a Node represents a set of equivalent classes/or sameAs individuals
            System.out.println(m++);
            Set<OWLNamedIndividual> instances = this.owlReasoner.getInstances(owlClass, true).getFlattened();
            if(instances.size()==0)
                System.out.println("Class '"+owlClass.getIRI().getFragment()+"' has no instances!!!");
            for (OWLNamedIndividual i : instances) {
                System.out.println(i.getIRI().getFragment() + "\tinstance of\t"
                        + owlClass.getIRI().getFragment());
                // look up all property assertions
                for (OWLObjectProperty op : this.owlOntology
                        .getObjectPropertiesInSignature()) {
                    NodeSet<OWLNamedIndividual> petValuesNodeSet = this.owlReasoner
                            .getObjectPropertyValues(i, op);
                    for (OWLNamedIndividual value : petValuesNodeSet.getFlattened()) {
                        System.out.println(i.getIRI().getFragment() + "\t"
                                + op.getIRI().getFragment() + "\t"
                                + value.getIRI().getFragment());
                    }
                }
            }
        }
    }
}