package lambdaintro;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OfficeDocumentReaderTest {

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();



    @Before
    public void setUp() {
        String testDirectory = folder.getRoot().getAbsolutePath();

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
        List<File> files = new OfficeDocumentReader().listOfficeDocuments(folder.getRoot());

        assertThat(files.get(0).getName(), equalTo("a.xlsx"));
        assertThat(files.get(1).getName(), equalTo("f.docx"));
        assertThat(files.get(2).getName(), equalTo("p.pptx"));
        assertThat(files.get(3).getName(), equalTo("z.DOCX"));
    }

    private void createDirectories(String prefix, String... paths) {
        for (String path: paths) {
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
        }
        catch (IOException ioe) {
            throw new RuntimeException("Cannot create test file: " + path, ioe);
        }
    }
}
