package ioconvert.products;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream os, List<Product> products) {
        try (PrintStream pw = new PrintStream(os)) {
            for (Product product : products) {
                pw.print(product.getName());
                pw.print(";");
                pw.print(product.getPrice());
                pw.println();
            }
        }
    }
}
