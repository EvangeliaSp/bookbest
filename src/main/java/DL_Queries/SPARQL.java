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

    public String hotelsByCityCenterDistance(int k) {

        return "";
    }

    public String luxuriousHotels() {
        return "   ?Hotels hotel:isLuxurious ?dLux .";
    }

    public void findResults(InfModel model, String q, String proposed, int counter) {
        if(proposed.equals(""))
            proposed="?name";
        else if(counter!=1)
            proposed = "("+proposed+")/"+counter;
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <urn:absolute:bookbest.owl#>" +
            "SELECT ?name ?dPrice ?dRating ?dLux ("+proposed+" AS ?degree) \n" +
            "WHERE { \n" +
            "  ?Hotels rdf:type hotel:Hotel. " +
            "  ?Hotels hotel:hasName ?name. "+ q +
            "}\n" +
            "ORDER BY DESC(?degree)";

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
