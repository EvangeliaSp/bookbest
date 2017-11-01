package DL_Queries;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;

import java.util.Iterator;


public class SPARQL {

    public void getCheap(InfModel model) {
        System.out.println("Before Query");
        // Create a new query
        String s =
                "PREFIX hotel: <http://www.example.org/bookbest#>" +
                "SELECT ?x\n" +
                "WHERE {" +
                "   ?x hotel:hasPrice \"VeryCheap\" . ?x hotel:hasRating \"NoRate\"" +
                "}\n" +
                "ORDER BY ASC(?x)";
        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Important - free up resources used running the query
        queryExecution.close();
    }
}
