package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CSVReader {

    int mapLength = 352;
    String[][] map = new String[2][mapLength];

    int nameLength = 5065;
    String[] names = new String[nameLength];

    public CSVReader() {
        this.importFromCSV();
    }


    public void importFromCSV() {
        String csvMapFile = "./src/main/resources/dataFiles/simplemaps-worldcities-basic.csv";
        String csvNameFile = "./src/main/resources/dataFiles/hotelnames.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        int i=0;


        try {
            // Import map cities
            br = new BufferedReader(new FileReader(csvMapFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] place = line.split(cvsSplitBy);

                this.map[0][i] = place[0];
                this.map[1][i] = place[1];
                i++;
            }

            // Import hotel names
            i=0;
            br = new BufferedReader(new FileReader(csvNameFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String name[] = line.split(cvsSplitBy);
                this.names[i] = name[0];
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
        String[][] place = new String[1][2];
        place[0][0] = this.map[0][k];
        place[0][1] = this.map[1][k];

        return place;
    }

    public String getRandomName() {
        int k = new Random().nextInt(nameLength);
        String name = this.names[k];

        return name;
    }

    public void print() {
        for(String name:names) {
            System.out.println(name);
        }
        System.out.println("-->"+names.length);
    }

}
