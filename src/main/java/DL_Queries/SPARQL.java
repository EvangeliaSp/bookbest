package DL_Queries;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;

public class SPARQL {

    public void getLuxurious(InfModel model) {
        String s =
            "PREFIX hotel: <urn:absolute:bookbest#>" +
            "SELECT ?x " +
            "WHERE {" +
            "   ?x hotel:isLuxurious ?value ." +
            "FILTER (?value = 100) " +
            "}";
        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Important - free up resources used running the query
        queryExecution.close();
    }

    public void getCheap(InfModel model) {
        System.out.println("Before Query");
        // Create a new query
        String s =
            "PREFIX hotel: <urn:absolute:bookbest#>" +
            "SELECT ?x ?price " +
            "WHERE {" +
            "   ?x hotel:hasPricePerNight ?price." +
            "FILTER (?price < 500) " +
            "}"+
            "ORDER BY ?price";
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
