package dataGeneration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CSVReader {

    int mapLength = 7323;
    String[][] map = new String[2][mapLength];


    public CSVReader() {
        this.importFromCSV();
    }

    public String[][] getMap() {
        return map;
    }

    public void importFromCSV() {
        String csvFile = "./src/main/resources/dataFiles/simplemaps-worldcities-basic.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int i=0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);


                this.map[0][i] = country[5];
                this.map[1][i] = country[0];
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.mapLength = i;
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public String[][] getRandomPlace() {
        int k = new Random().nextInt(mapLength);
        String[][] place = new String[2][1];
        place[0][0] = this.map[0][k];
        place[1][0] = this.map[1][k];

        return place;
    }

}
