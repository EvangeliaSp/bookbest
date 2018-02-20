package DL_Queries;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;

import java.util.*;

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
        switch (k) {
            case 1:
                return "   ?Hotels hotel:isShort ?dDistance .";
            case 2:
                return "   ?Hotels hotel:isMedium ?dDistance .";
            default:
                return "   ?Hotels hotel:isLong ?dDistance .";
        }
    }

    public String luxuriousHotels() {
        return "   ?Hotels hotel:isLuxurious ?dLux .";
    }

    public void findResults(InfModel model, String q, String proposed, int counter) {
        if(proposed.equals(""))
            proposed="1.0";
        else if(counter!=1)
            proposed = "("+proposed+")/"+counter;
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <urn:absolute:bookbest.owl#>" +
            "SELECT ?name ?city ?dPrice ?dRating ?dDistance ?dLux ("+proposed+" AS ?degree) \n" +
            "WHERE { \n" +
            "  ?Hotels rdf:type hotel:Hotel. " +
            "  ?Hotels hotel:isInCity ?city. " +
            "  ?Hotels hotel:hasName ?name. "+ q +
            "}\n" +
            "ORDER BY DESC(?degree)";

        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();
        dempsterCombination(resultSet);

        // Output query results
        //ResultSetFormatter.out(System.out, resultSet, query);

        // Free up resources used running the query
        queryExecution.close();
    }

    private void dempsterCombination(ResultSet resultSet) {
        HashMap<ArrayList<String>, Double> results = new HashMap<>();

        while(resultSet.hasNext()) {
            QuerySolution querySolution = resultSet.next();
            //System.out.println(querySolution);

            ArrayList<String> key = new ArrayList<>();
            key.add(querySolution.get("name").asLiteral().getString());
            key.add(querySolution.get("city").asLiteral().getString());
            double value = querySolution.get("degree").asLiteral().getDouble();

            if(results.containsKey(key)) {
                System.out.println("YYY");
                value = (value+results.get(key))/2;
                results.replace(key, value);
            }
            else {
                results.put(key, value);
            }
            System.out.println("name: "+key.get(0)+",city: "+key.get(1)+",value: "+value);
        }
        sortMapByValues(results);
    }

    private static void sortMapByValues(Map<ArrayList<String>, Double> aMap) {
        Set<Map.Entry<ArrayList<String>, Double>> mapEntries = aMap.entrySet();

        // used linked list to sort, because insertion of elements in linked list is faster than an array list.
        List<Map.Entry<ArrayList<String>, Double>> aList = new LinkedList<>(mapEntries);

        // sorting the List
        Collections.sort(aList, new Comparator<Map.Entry<ArrayList<String>, Double>>() {

            @Override
            public int compare(Map.Entry<ArrayList<String>, Double> ele1,
                               Map.Entry<ArrayList<String>, Double> ele2) {

                return ele2.getValue().compareTo(ele1.getValue());
            }
        });

        // Storing the list into Linked HashMap to preserve the order of insertion.
        Map<ArrayList<String>, Double> aMap2 = new LinkedHashMap<>();
        for(Map.Entry<ArrayList<String>, Double> entry: aList) {
            aMap2.put(entry.getKey(), entry.getValue());
        }

        // printing values after soring of map
        System.out.println("Value " + " - " + "Key");
        for(Map.Entry<ArrayList<String>, Double> entry : aMap2.entrySet()) {
            System.out.println(entry.getKey().get(0)+"  -  "+entry.getValue());
        }
    }
}


