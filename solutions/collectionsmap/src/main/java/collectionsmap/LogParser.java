package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_LOGIN = 2;
    public static final int NUMBER_OF_FIELDS = 3;
    public static final String LOG_SEPARATOR = ":";

    public Map<String, List<Entry>> parseLog(String log) {

        try (Scanner scanner = new Scanner(log)) {
            Map<String, List<Entry>> elements = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] lineElements = line.split(LOG_SEPARATOR);
                if (lineElements.length != NUMBER_OF_FIELDS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate entryDate = parseDate(lineElements[POSITION_OF_DATE]);
                fillMap(elements, new Entry(lineElements[POSITION_OF_IP], lineElements[POSITION_OF_LOGIN], entryDate));
            }
            return elements;
        }
    }

    private void fillMap(Map<String, List<Entry>> elements, Entry entry) {
        if (!elements.containsKey(entry.getIpAddress())) {
            elements.put(entry.getIpAddress(), new ArrayList<>());
        }

        elements.get(entry.getIpAddress()).add(entry);
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);
        }
        catch (DateTimeParseException pe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }
}
