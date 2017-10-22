package DLReasoner;

import static org.junit.Assert.assertTrue;
//import org.semanticweb.owlapi.dlsyntax.renderer.DLSyntaxObjectRenderer;
//import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
//import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.*;
//import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import uk.ac.manchester.cs.jfact.JFactFactory;

import java.util.Set;
//import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;

public class Reasoner {
    //private OWLReasoner reasoner;
    //private OWLObjectRenderer h = new DLSyntaxObjectRenderer();

    // JFact
    OWLReasonerFactory owlReasonerFactory = null;
    OWLOntology owlOntology;
    OWLReasonerConfiguration owlReasonerConfiguration;
    OWLReasoner owlReasoner;


    public Reasoner(OWLOntology owlOntology) {
        //OWLReasonerFactory reasonerFactory = PelletReasonerFactory.getInstance();
        //this.reasoner = reasonerFactory.createReasoner(owlOntology, new SimpleConfiguration());

        // JFact
        this.owlReasonerFactory = new JFactFactory();
        this.owlOntology = owlOntology;
        this.owlReasonerConfiguration = new SimpleConfiguration(50000);
        this.owlReasoner = this.owlReasonerFactory.createReasoner(this.owlOntology, owlReasonerConfiguration);

    }

    public void getIndividuals(OWLClass owlClass) {
        //for(OWLNamedIndividual hotel: reasoner.getInstances(owlClass, false).getFlattened()) {
          //  System.out.println("hotel: "+h.render(hotel));
        //}
    }

    public void classifyOntology() {
        this.owlReasoner.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        assertTrue(owlReasoner.isConsistent());
        // get a list of unsatisfiable classes
        Node<OWLClass> bottomNode = owlReasoner.getUnsatisfiableClasses();
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

    public void printSubclasses(OWLClass owlClass) {
        // Look up and print all direct subclasses for all classes
        for (OWLClass c : this.owlOntology.getClassesInSignature()) {
            // the boolean argument specifies direct subclasses; false would
            // specify all subclasses
            // a NodeSet represents a set of Nodes.
            // a Node represents a set of equivalent classes
            NodeSet<OWLClass> subClasses = owlReasoner.getSubClasses(c, true);
            for (OWLClass subClass : subClasses.getFlattened()) {
                System.out.println(subClass.getIRI().getFragment() + "\tsubclass of\t"
                        + c.getIRI().getFragment());
            }
        }
    }

    public void printInstances(OWLClass owlClass) {
        // for each class, look up the instances
        //for (OWLClass c : this.owlOntology.getClassesInSignature()) {
            // the boolean argument specifies direct subclasses; false would
            // specify all subclasses
            // a NodeSet represents a set of Nodes.
            // a Node represents a set of equivalent classes/or sameAs
            // individuals
            NodeSet<OWLNamedIndividual> instances = owlReasoner.getInstances(owlClass, true);
            if(instances.isEmpty())
                System.out.println("No instances!!!");
            for (OWLNamedIndividual i : instances.getFlattened()) {
                System.out.println(i.getIRI().getFragment() + "\tinstance of\t"
                        + owlClass.getIRI().getFragment());
                // look up all property assertions
                for (OWLObjectProperty op : this.owlOntology
                        .getObjectPropertiesInSignature()) {
                    NodeSet<OWLNamedIndividual> petValuesNodeSet = owlReasoner
                            .getObjectPropertyValues(i, op);
                    for (OWLNamedIndividual value : petValuesNodeSet.getFlattened()) {
                        System.out.println(i.getIRI().getFragment() + "\t"
                                + op.getIRI().getFragment() + "\t"
                                + value.getIRI().getFragment());
                    }
                }
            }
        //}
    }
}
