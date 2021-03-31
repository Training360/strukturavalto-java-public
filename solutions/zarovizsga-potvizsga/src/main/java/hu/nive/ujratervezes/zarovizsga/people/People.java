package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people = new ArrayList<>();

    public int getNumberOfMales(String path) {
        readFromFile(path);
        int counter = 0;
        for (Person p : people) {
            if (p.getGender().equals("Male")) {
                counter++;
            }
        }
        return counter;
    }

    private Person processLine(String line) {
        String[] parts = line.split(",");
        return new Person(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
    }


    private void readFromFile(String path) {

        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Person p = processLine(line);
                people.add(p);
            }


        } catch (IOException e) {
            throw new IllegalStateException("Cannot read!");
        }
    }
}
