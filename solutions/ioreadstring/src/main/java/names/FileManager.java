package names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    private Path myFile ;
    private List<Human> humans = new ArrayList<>();


    public FileManager(String fileRealtivePath) {
        this.myFile =  Path.of(fileRealtivePath);
    }

    public void readFromFile(){
        try {
             List<String> fileInString = Files.readAllLines(myFile);
            for (String s : fileInString) {
                String firstAndLast[] = s.split(" ");
                Human h = new Human(firstAndLast[0], firstAndLast[1]);
                humans.add(h);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't reach file!", e);
        }
    }


    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }


    public Path getMyFile() {
        return myFile;
    }
}
