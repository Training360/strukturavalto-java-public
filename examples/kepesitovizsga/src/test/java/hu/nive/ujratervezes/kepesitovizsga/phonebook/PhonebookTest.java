package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    private Phonebook phonebook;

    @BeforeEach
    void init() {
        phonebook = new Phonebook();
    }

    @Test
    void test_nullPhonebook() {
        String outputPath = "phonebookOutput/output0.txt";
        assertThrows(IllegalArgumentException.class, () -> phonebook.exportPhonebook(null, outputPath));
        assertFalse(Path.of(outputPath).toFile().exists());
    }

    @Test
    void test_nullPath() {
        assertThrows(IllegalArgumentException.class, () -> phonebook.exportPhonebook(new TreeMap<>(), null));
    }

    @Test
    void test_emptyPhonebook() throws IOException {
        String actualPath = "phonebookOutput/output1.txt";
        TreeMap<String, String> contacts = new TreeMap<>();
        phonebook.exportPhonebook(contacts, actualPath);

        assertTrue(Path.of(actualPath).toFile().exists());
        List<String> actual = Files.readAllLines(Path.of(actualPath));
        assertEquals(List.of(), actual);
    }

    @Test
    void test_singleEntry() throws IOException {
        String actualPath = "phonebookOutput/output2.txt";
        TreeMap<String, String> contacts = new TreeMap<>();
        contacts.put("John Doe", "1-555-1010");
        phonebook.exportPhonebook(contacts, actualPath);

        List<String> expected = List.of("John Doe: 1-555-1010");

        assertTrue(Path.of(actualPath).toFile().exists());
        List<String> actual = Files.readAllLines(Path.of(actualPath));
        assertEquals(expected, actual);
    }

    @Test
    void test_multipleEntries() throws IOException {
        String actualPath = "phonebookOutput/output3.txt";
        TreeMap<String, String> contacts = new TreeMap<>();
        contacts.put("Jane Doe", "1-555-1111");
        contacts.put("John Doe", "1-555-1010");
        contacts.put("John Smith", "1-555-2020");
        phonebook.exportPhonebook(contacts, actualPath);

        Set<String> expected = new HashSet<>(List.of("Jane Doe: 1-555-1111", "John Doe: 1-555-1010", "John Smith: 1-555-2020"));

        assertTrue(Path.of(actualPath).toFile().exists());
        Set<String> actual = new HashSet<>(Files.readAllLines(Path.of(actualPath)));
        assertEquals(expected, actual);
    }
}