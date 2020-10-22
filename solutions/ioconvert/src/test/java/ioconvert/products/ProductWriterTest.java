package ioconvert.products;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ProductWriterTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testSaveProduct() throws IOException {
        List<Product> products = List.of(
            new Product("apple", 10),
            new Product("pear", 15),
            new Product("plum", 16)
        );
        Path path = folder.newFile().toPath();
        ProductWriter writer = new ProductWriter();

        try (OutputStream os = Files.newOutputStream(path)) {
            writer.saveProduct(os, products);
        }

        byte[] read = Files.readAllBytes(path);
        byte[] asserted = ("apple;10" + System.lineSeparator() + "pear;15" + System.lineSeparator() + "plum;16" + System.lineSeparator()).getBytes();

        assertArrayEquals(asserted, read);
    }
}
