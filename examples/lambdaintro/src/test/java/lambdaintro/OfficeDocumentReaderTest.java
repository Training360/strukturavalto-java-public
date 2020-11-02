package lambdaintro;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OfficeDocumentReaderTest {

    @TempDir
    public File folder;


    @BeforeEach
    public void setUp() {
        String testDirectory = folder.getAbsolutePath();

        createDirectories(testDirectory, "dir.xlsx", "dir2.docx");

        createFiles(testDirectory,
                "a.txt",
                "b.txt",
                "p.pptx",
                "a.xlsx",
                "c.csv",
                "e.docxv",
                "f.docx",
                "z.DOCX",
                "z.xls",
                "zxls"
        );
    }

    @Test
    public void testListOfficeDocuments() {
        List<File> files = new OfficeDocumentReader().listOfficeDocuments(folder);

        assertEquals("a.xlsx", files.get(0).getName());
        assertEquals("f.docx", files.get(1).getName());
        assertEquals("p.pptx", files.get(2).getName());
        assertEquals("z.DOCX", files.get(3).getName());
    }

    private void createDirectories(String prefix, String... paths) {
        for (String path : paths) {
            new File(prefix + File.separator + path.replace("/", File.separator)).mkdir();
        }
    }

    private void createFiles(String prefix, String... paths) {
        String path = null;
        try {
            for (String suffix : paths) {
                path = prefix + File.separator + suffix.replace("/", File.separator);
                new File(path).createNewFile();
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot create test file: " + path, ioe);
        }
    }
}
