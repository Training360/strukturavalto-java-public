package ioconvert.shopping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingListManagerTest {

    @TempDir
    public File folder;

    @Test
    public void testSaveShoppingList() throws IOException {
        File file = new File(folder, "shopping.txt");
        List<String> shoppingList = List.of("milk", "butter", "ham", "eggs");
        try (OutputStream os = new FileOutputStream(file)) {
            ShoppingListManager manager = new ShoppingListManager();
            manager.saveShoppingList(os, shoppingList);
        }

        List<String> readList = readFromFile(file);

        assertEquals(shoppingList, readList);
    }

    @Test
    public void testLoadShoppingList() throws IOException {
        ShoppingListManager manager = new ShoppingListManager();
        try (InputStream is = this.getClass().getResourceAsStream("/shopping.txt")) {
            List<String> readList = manager.loadShoppingList(is);

            assertEquals(List.of("chicken breast", "bacon", "potato", "black pepper"), readList);
        }
    }

    private List<String> readFromFile(File file) throws IOException {
        List<String> readList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = br.readLine()) != null) {
                readList.add(line);
            }
            return readList;
        }
    }
}
