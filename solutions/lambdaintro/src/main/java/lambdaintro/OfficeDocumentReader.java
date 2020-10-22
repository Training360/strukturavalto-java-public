package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    private static final String REGEXP = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path) {
        List<File> files = Arrays.asList(path.listFiles(f -> f.isFile() && f.getName().toLowerCase().matches(REGEXP)));
        files.sort(Comparator.comparing(File::getName));
        return files;
    }

}
