import ontologyHelper.OntologyGenerator;

public class GenerateOntology {

    public static void main(String[] args) {

        try {
            OntologyGenerator ontologyGenerator = new OntologyGenerator();

            // Create Ontology Classes
            ontologyGenerator.generateClasses();

            // Create Ontology Data Properties
            ontologyGenerator.generateDataProperties();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
