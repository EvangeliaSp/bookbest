package dataMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Mappings {

    private String filename;
    private String flCharacteristics;


    public String getFilename() {
        return filename;
    }

    public HashMap<String, ArrayList<String>> mappings;

    public HashMap<String, ArrayList<String>> characteristics;

    public HashMap<String, ArrayList<String>> getMappings() {
        return mappings;
    }

    public HashMap<String, ArrayList<String>> getCharacteristics() {
        return characteristics;
    }

    public Mappings(String filename, String flCharacteristics) {
        this.filename = filename;
        this.flCharacteristics = flCharacteristics;
        this.mappings = new HashMap<>();
        this.characteristics = new HashMap<>();
    }

    public void mapFromFile() {
        try {
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line, key, value, values;
            int k, index;
            ArrayList<String> arrayValues;

            while ((line = bufferedReader.readLine()) != null) {
                k = line.indexOf(":");
                key = line.substring(0, k);
                values = line.substring(k+1, line.length());
                arrayValues = new ArrayList<>();

                index = values.indexOf(",");
                while (index != -1) {
                    if((value = values.substring(0, index)) != null) {
                        arrayValues.add(value);
                        values = values.substring(index+1);
                        index = values.indexOf(",");
                    }
                    else break;
                }
                if((value = values.substring(0)) != null && (values.length() > 0)) {
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

    public void makeCharacteristics() {
        try {
            FileReader fileReader = new FileReader(this.flCharacteristics);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line, database, rating, distance, subline;
            int index;
            while((line = bufferedReader.readLine()) != null) {
                index = line.indexOf(":");
                database = line.substring(0, index);
                subline = line.substring(index+1, line.length());

                index = subline.indexOf(",");
                rating = subline.substring(0, index);
                subline = subline.substring(index+1, subline.length());

                distance = subline.substring(0);

                ArrayList<String> array = new ArrayList<>();
                array.add(rating);
                array.add(distance);
                this.characteristics.put(database, array);
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void printCharacteristics() {
        Iterator iterator = this.characteristics.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)iterator.next();
            System.out.print(pair.getKey()+": ");
            ArrayList<String> values = pair.getValue();
            for(String value: values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> findCharacteristic(String database) {
        Iterator iterator = this.characteristics.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)iterator.next();
            if(pair.getKey().equals(database)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public ArrayList<String> getDataPropCols(ArrayList<String> columns) {
        ArrayList<String> dataPropCols = new ArrayList<>();
        for(String c: columns) {
            String dp = this.findColumn(c);
            dataPropCols.add(dp);
        }

        return dataPropCols;
    }

    public String convertMiToKm(double k) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(k/0.62137);
    }

    public String convertRate(int k, double l) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(10*l/k);
    }
}
