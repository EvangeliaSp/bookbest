package DL_Queries;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.InfModel;

import javax.sound.midi.SysexMessage;
import java.sql.Struct;
import java.text.DecimalFormat;
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
                return "   ?Hotels hotel:isSuperb ?dRating .";
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

    public void findResults(InfModel model, String q) {
        String s =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
            "PREFIX hotel: <urn:absolute:bookbest.owl#>" +
            "SELECT ?name ?city ?dPrice ?dRating ?dDistance ?dLux \n" +
            "WHERE { \n" +
            "  ?Hotels rdf:type hotel:Hotel. " +
            "  ?Hotels hotel:isInCity ?city. " +
            "  ?Hotels hotel:hasName ?name. " + q +
            "}\n" +
            "ORDER BY DESC(?degree)";

        Query query = QueryFactory.create(s);

        // Execute the query and obtain results
        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = queryExecution.execSelect();
        dempsterCombination(resultSet);

        // Free up resources used running the query
        queryExecution.close();
    }

    private void dempsterCombination(ResultSet resultSet) {
        HashMap<ArrayList<String>, ArrayList<Double>> results = new HashMap<>();

        while(resultSet.hasNext()) {
            QuerySolution querySolution = resultSet.next();

            ArrayList<String> key = new ArrayList<>();
            key.add(querySolution.get("name").asLiteral().getString());
            key.add(querySolution.get("city").asLiteral().getString());

            ArrayList<Double> value = new ArrayList<>();
            if ((querySolution.get("dPrice")) != null)
                value.add(querySolution.get("dPrice").asLiteral().getDouble());
            else    value.add(0.0);
            if ((querySolution.get("dRating")) != null)
                value.add(querySolution.get("dRating").asLiteral().getDouble());
            else    value.add(0.0);
            if ((querySolution.get("dDistance")) != null)
                value.add(querySolution.get("dDistance").asLiteral().getDouble());
            else    value.add(0.0);
            if ((querySolution.get("dLux")) != null)
                value.add(querySolution.get("dLux").asLiteral().getDouble());
            else    value.add(0.0);


            if(results.containsKey(key)) {
                ArrayList<Double> list = new ArrayList<>(results.get(key));
                Double v;
                v = DempsterType(list.get(0), value.get(0));
                list.set(0, v);
                v = DempsterType(list.get(1), value.get(1));
                list.set(1, v);
                v = DempsterType(list.get(2), value.get(2));
                list.set(2, v);
                v = DempsterType(list.get(3), value.get(3));
                list.set(3, v);

                results.replace(key, list);
            }
            else {
                results.put(key, value);
            }
        }

        Map<String, Double> mymap = new HashMap<>();

        for(Map.Entry<ArrayList<String>, ArrayList<Double>> entry: results.entrySet()) {
            String hotelName = entry.getKey().get(0);

            ArrayList<Double> degrees = new ArrayList<>(entry.getValue());
            for(int i=0; i<degrees.size(); i++) {
                double d = degrees.get(i);
                if(d==0.0) {
                    degrees.remove(d);
                    i--;
                }
            }
            double minDegree = 1.0;
            if (degrees.size() != 0)
                minDegree = degrees.get(degrees.indexOf(Collections.min(degrees)));
            mymap.put(hotelName, minDegree);
        }
        sortMapByValues(mymap);
    }

    private static void sortMapByValues(Map<String, Double> aMap) {
        DecimalFormat df = new DecimalFormat("0.00");
        Set<Map.Entry<String, Double>> mapEntries = aMap.entrySet();

        // used linked list to sort, because insertion of elements in linked list is faster than an array list.
        List<Map.Entry<String, Double>> aList = new LinkedList<>(mapEntries);

        // sorting the List
        Collections.sort(aList, new Comparator<Map.Entry<String, Double>>() {

            @Override
            public int compare(Map.Entry<String, Double> ele1,
                               Map.Entry<String, Double> ele2) {

                return ele2.getValue().compareTo(ele1.getValue());
            }
        });

        // Storing the list into Linked HashMap to preserve the order of insertion.
        Map<String, Double> aMap2 = new LinkedHashMap<>();
        for(Map.Entry<String, Double> entry: aList) {
            aMap2.put(entry.getKey(), entry.getValue());
        }

        // Printing values after sorting of map
        System.out.println();
        for(int i=0; i<32; i++)
            System.out.print(" ");
        System.out.println("PROPOSED HOTELS");
        for(int i=0; i<47; i++)
            System.out.print(" ");
        System.out.println();

        System.out.print("      Name");
        for(int i=0; i<48; i++)
            System.out.print(" ");
        System.out.println("Degree");

        for(int i=0; i<80; i++)
            System.out.print("-");
        System.out.println();
        for(Map.Entry<String, Double> entry : aMap2.entrySet()) {
            String hotel = entry.getKey();
            double degree = entry.getValue();
            if(degree<0.25)
                break;
            System.out.print("|   "+hotel);
            int l=entry.getKey().length()+"|   ".length()+1;
            l=60-l;
            for(int i=0; i<l; i++)
                System.out.print(" ");
            System.out.print(df.format(degree));
            for(int i=0; i<16; i++)
                System.out.print(" ");
            System.out.println("|");
        }
        for(int i=0; i<80; i++)
            System.out.print("-");
    }

    protected Double DempsterType(Double v1, Double v2) {
        if (v1==0.0 && v2!=0.0)
            return v2;
        else if (v1!=0.0 && v2!=0.0)
            return (v1*v2)/(1-(v1*(1-v2)+v2*(1-v1)));
        else if (v1!=0.0 && v2==0.0)
            return v1;
        else return 0.0;
    }
}


