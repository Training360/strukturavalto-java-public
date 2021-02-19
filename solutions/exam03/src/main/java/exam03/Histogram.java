package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public static final String STAR_CHARACTER = "*";
    public static final String LINE_BREAK = "\n";

    public String createHistogram(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine())  != null) {
            //System.out.println(line);
            int number = Integer.parseInt(line);
//            for (int i = 0; i < number; i++) {
//                sb.append(STAR_CHARACTER);
//            }
            sb.append("*".repeat(number));
            sb.append(LINE_BREAK);
        }
        return sb.toString();
    }
}
