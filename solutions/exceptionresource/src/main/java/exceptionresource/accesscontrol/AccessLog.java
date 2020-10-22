package exceptionresource.accesscontrol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");

    private String filename;

    public AccessLog(String filename) {
        this.filename = filename;
    }

    public List<String> inAtTime(LocalDateTime time) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return inAtTime(reader, time);
        } catch (IOException ex) {
            throw new LogException(ex);
        }
    }

    private List<String> inAtTime(BufferedReader reader, LocalDateTime time) throws IOException {
        List<String> in = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            LogEntry entry = parseLine(line);
            if (!entry.isBefore(time)) {
                return in;
            }
            if (entry.getAccessType() == LogEntry.AccessType.IN) {
                in.add(entry.getPersonId());
            } else {
                in.remove(entry.getPersonId());
            }
        }
        return in;
    }

    public List<LocalDateTime> loginsById(String personId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return loginsById(reader, personId);
        } catch (IOException ex) {
            throw new LogException(ex);
        }
    }

    private List<LocalDateTime> loginsById(BufferedReader reader, String personId) throws IOException {
        List<LocalDateTime> logins = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            LogEntry entry = parseLine(line);
            if (entry.getPersonId().equals(personId) && entry.getAccessType() == LogEntry.AccessType.IN) {
                logins.add(entry.getTime());
            }
        }
        return logins;
    }

    private LogEntry parseLine(String line) {
        String[] words = line.split(",");
        LocalDateTime time = LocalDateTime.parse(words[0], DATETIME_FORMATTER);
        LogEntry.AccessType accessType = LogEntry.AccessType.valueOf(words[2]);
        return new LogEntry(time, words[1], accessType);
    }
}
