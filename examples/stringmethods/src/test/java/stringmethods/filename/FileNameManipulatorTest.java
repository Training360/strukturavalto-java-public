package stringmethods.filename;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileNameManipulatorTest {


    @Test
    public void invalidParametersShouldThrowExceptionIfEmptyString() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findLastCharacter("");
        });
        assertEquals("Empty string!", ex.getMessage());

    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWhiteSpaceOnly() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().changeExtensionToLowerCase("\t\n\r ");
        });
        assertEquals("Empty string!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionJustPoint() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().changeExtensionToLowerCase(".");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionJustExtension() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().changeExtensionToLowerCase(".java");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }


    @Test
    public void invalidParametersShouldThrowExceptionIfNullString() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findLastCharacter(null);
        });
        assertEquals("Empty string!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWrongFileName() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findFileExtension(".");
        });
        assertEquals("Invalid file name!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWrongExtension() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findFileExtension(".d");
        });
        assertEquals("Invalid file name!", ex.getMessage());
    }

    @Test
    public void invalidFileNameEmptyString() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findFileExtension("\t\n\r");
        });
        assertEquals("Invalid file name!", ex.getMessage());
    }

    @Test
    public void invalidFileNameNull() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().findFileExtension(null);
        });
        assertEquals("Invalid file name!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension("d", ".d");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileNameShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension("d", ".");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileNameEmptyStringGoodExtension() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension("d", "\t\n\r");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileNameNullGoodExtension() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension("d", null);
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidExtensionEmptyStringGoodFileName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension("\t\n\r", "record.dat");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidExtensionNullGoodFileTwoName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().identifyFilesByExtension(null, "record.dat");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }


    @Test
    public void invalidFileOneNullGoodFileTwoName() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().compareFilesByName(null, "record.dat");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileTwoNullGoodFileOneName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().compareFilesByName("record.dat", null);
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileTwoEmptyStringGoodFileOneName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().compareFilesByName("record.dat", "\n\t\r");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileOneEmptyStringGoodFileName() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().compareFilesByName("\n\t\r", "record.dat");
        });
        assertEquals("Invalid argument!", ex.getMessage());
    }

    @Test
    public void invalidFileNameToReplaceEmptyString() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().replaceStringPart("\n\t\r", "jpeg", "jpg");
        });
        assertEquals("Empty string!", ex.getMessage());
    }

    @Test
    public void invalidFileNameToReplaceNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FileNameManipulator().replaceStringPart(null, "jpeg", "jpg");
        });
        assertEquals("Empty string!", ex.getMessage());
    }


    @Test
    public void findLastCharacter() {

        assertEquals('f', new FileNameManipulator().findLastCharacter("abcdef"));
        assertEquals('f', new FileNameManipulator().findLastCharacter("abcdef \t  \n "));
    }

    @Test
    public void findFileExtension() {

        assertEquals(".dat", new FileNameManipulator().findFileExtension("record.dat"));
    }

    @Test
    public void identifyFilesByExtension() {

        assertTrue(new FileNameManipulator().identifyFilesByExtension("mm", "tematika.mm"));
        assertFalse(new FileNameManipulator().identifyFilesByExtension("md", "tematika.mm"));
    }

    @Test
    public void compareFilesByName() {

        assertTrue(new FileNameManipulator().compareFilesByName("String.java", "String.JAVA"));
        assertFalse(new FileNameManipulator().compareFilesByName("String.java", "Sting.java"));
    }

    @Test
    public void changeExtensionToLowerCase() {
        assertEquals("String.java", new FileNameManipulator().changeExtensionToLowerCase("String.JAVA"));
    }

    @Test
    public void replaceExtension() {
        assertEquals("picture.png", new FileNameManipulator().replaceStringPart("picture.png", "jpeg", "jpg"));
        assertEquals("picture.jpg", new FileNameManipulator().replaceStringPart("picture.jpeg", "jpeg", "jpg"));
        assertEquals("long_descriptive_name.txt", new FileNameManipulator().replaceStringPart("long descriptive name.txt", " ", "_"));
    }
}
