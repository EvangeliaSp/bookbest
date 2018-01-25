package DL_Queries;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;

public class SPARQL {

    public String hotelsByCountry(String country) {
        if (country.equals("")) return "";
        return "   ?Hotels hotel:isInCountry ?country.\n"+
                "   FILTER (?country = '"+country+"')\n";
    }

    public String hotelsByCity(String city) {
        if (city.equals("")) return "";
        return "   ?Hotels hotel:isInCity ?city.\n"+
                "   FILTER (?city = '"+city+"')\n";
    }

    public String hotelsByPrice(int k) {
        switch (k) {
            case 1:
                return "   ?Hotels hotel:isVeryCheap ?dPrice.\n";
            case 2:
                return "   ?Hotels hotel:isCheap ?dPrice.\n";
            case 3:
                return "   ?Hotels hotel:isAverage ?dPrice.\n";
            case 4:
                return "   ?Hotels hotel:isExpensive ?dPrice.\n";
            default:
                return "   ?Hotels hotel:isVeryExpensive ?dPrice.\n";
        }
    }

    public String hotelsByRating(int k) {
        switch (k) {
            case 1:
                return "   ?Hotels hotel:isPleasant ?dRating .";
            case 2:
                return "   ?Hotels hotel:isGood ?dRating .";
            default:
                return "   ?Hotels hotel:isVeryGood ?dRating .";
        }
    }

    public String hotelsForDisabled(int k) {

        return "   ?Hotels hotel:isPleasant ?dRating .";
    }

    public void familyFriendlyHotels(InfModel model) {

    }

    public void getLuxurious(InfModel model) {
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX hotel: <urn:absolute:bookbest#>" +
            "SELECT ?Hotels " +
            "WHERE {" +
            "   ?Hotels rdf:type hotel:Hotel." +
            "   ?Hotels hotel:isLuxurious ?value ." +
            "FILTER (?value = 100) " +
            "}\n" +
            "ORDER BY ?Hotels " +
            "LIMIT 5";

        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Free up resources used running the query
        queryExecution.close();
    }

    public void getCheap(InfModel model) {
        // Create query
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <http://example.com/bookbest#>" +
            "SELECT ?Hotels ?Degree \n" +
            "WHERE { \n" +
            "   ?Hotels hotel:isVeryCheap ?Degree.\n"+
            "}\n" +
            "ORDER BY DESC(?dPrice+dRating)";

           // "  ?Hotels hotel:isVeryCheap ?degree." +
           //         "FILTER (?degree = 100) " +


        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Free up resources used running the query
        queryExecution.close();
    }


    public void findResults(InfModel model, String q) {
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <http://example.com/bookbest#>" +
            "SELECT ?name ?Degree\n" +
            "WHERE { \n" +
            "  ?Hotels rdf:type hotel:Hotel. " +
            "  ?Hotels hotel:hasName ?name. "+ q +
            "}\n" +
            "ORDER BY ?Degree";

        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, resultSet, query);

        // Free up resources used running the query
        queryExecution.close();
    }

    public void getAccommodations(InfModel model) {
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <http://example.com/bookbest#>" +
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

        // Free up resources used running the query
        queryExecution.close();
    }
}
