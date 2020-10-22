package music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path file) {
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                Band band = new Band(temp[0], Integer.parseInt(temp[1]));
                bands.add(band);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public void writeBandsBefore(Path fileToWrite, int year) {
        try (BufferedWriter bw = Files.newBufferedWriter(fileToWrite)) {
            for (Band band : olderThan(year)) {
                bw.write(band.getName() + " " + band.getYear() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    private List<Band> olderThan(int year) {
        List<Band> result = new ArrayList<>();

        for (Band band : bands) {
            if (band.getYear() < year) {
                result.add(band);
            }
        }

        return result;
    }
}
