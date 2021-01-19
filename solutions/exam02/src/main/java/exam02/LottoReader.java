package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(";");
                for (int i = 11; i < 16; i++) {
                    int number = Integer.parseInt(fields[i]);
                    numbers[number - 1] ++;
                }
            }
        }
        catch (IOException ioe) {
            throw new RuntimeException("Error reading file", ioe);
        }
    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }
}
