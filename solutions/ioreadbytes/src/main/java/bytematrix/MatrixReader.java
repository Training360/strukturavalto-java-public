package bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixReader {

    private List<byte[]> myMatrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String fileName) {
        Path path = Path.of(fileName);

        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[1000];
            int size = 0;

            while ((size = inputStream.read(buffer)) > 0) {

                myMatrix.add(buffer);

            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't find file!", e);
        }

    }


    public int numberOfColumnsWhereMoreZeros() {
        int numOfColumns = 0;
        for (int i = 0; i < 1000; i++) {
            int zeros = 0;
            int ones = 0;

            for (int j = 0; j < myMatrix.size(); j++) {

                if (myMatrix.get(j)[i] == 48) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (zeros > ones) {
                numOfColumns++;
            }
        }

        return numOfColumns;
    }


    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }
}
