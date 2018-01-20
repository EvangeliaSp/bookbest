package dataMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mappings {

    private String filename;
    public HashMap<String, ArrayList<String>> mappings;

    public HashMap<String, ArrayList<String>> getMappings() {
        return mappings;
    }

    public Mappings(String filename) {
        this.filename = filename;
        this.mappings = new HashMap<>();
    }

    public void mapFromFile() {
        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader br = new BufferedReader(fileReader);
            String line, key, value, values;
            int k, index;
            ArrayList<String> arrayValues;

            while ((line = br.readLine()) != null) {
                k = line.indexOf(":");
                key = line.substring(0, k);
                values = line.substring(k+1, line.length());
                arrayValues = new ArrayList<>();

                index = values.indexOf(",");
                while (index != -1) {
                    if((value = values.substring(0, index)) != null) {
                        //System.out.print(value+"-");
                        arrayValues.add(value);
                        values = values.substring(index+1);
                        index = values.indexOf(",");
                    }
                    else break;
                }
                if((value = values.substring(0)) != null && (values.length() > 0)) {
                    //System.out.println(value);
                    arrayValues.add(value);
                }
                mappings.put(key, arrayValues);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void printMappings() {
        Iterator iterator = this.mappings.entrySet().iterator();
        int i=1;
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)iterator.next();
            System.out.print((i++)+"."+pair.getKey()+": ");
            ArrayList<String> values = pair.getValue();
            for(String value: values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

    public String findColumn(String column) {
        Iterator iterator = this.mappings.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)iterator.next();
            ArrayList<String> values = pair.getValue();
            if(values.contains(column))
                return pair.getKey();
        }
        return null;
    }

    public ArrayList<String> getHasIdValues() {
        return this.mappings.get("hasId");
    }
}
