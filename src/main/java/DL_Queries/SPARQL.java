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
            "}\n" +
            "ORDER BY ?x";

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
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <urn:absolute:bookbest#>" +
            "SELECT ?VeryCheapHotels ?Price\n" +
            "WHERE { \n" +
            "  ?VeryCheapHotels rdf:type hotel:isVeryCheap." +
                    "?VeryCheapHotels hotel:hasPricePerNight ?Price" +
            "}" +
            "ORDER BY ?Price";

        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Important - free up resources used running the query
        queryExecution.close();
    }

    public void getAccommodations(InfModel model) {
        String s =
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX hotel: <urn:absolute:bookbest#>" +
                "SELECT ?Hotels \n" +
                "WHERE { \n" +
                "  ?Hotels rdf:type hotel:Hotel" +
                "} \n" +
                "ORDER BY ?Hotels";

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
