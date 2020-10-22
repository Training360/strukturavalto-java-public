package stringmethods.filename;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileNameManipulatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidParametersShouldThrowExceptionIfEmptyString() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string!");

        // When
        new FileNameManipulator().findLastCharacter("");
    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWhiteSpaceOnly() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string!");

        // When
        new FileNameManipulator().changeExtensionToLowerCase("\t\n\r ");
    }

    @Test
    public void invalidParametersShouldThrowExceptionJustPoint() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        // When
        new FileNameManipulator().changeExtensionToLowerCase(".");
    }

    @Test
    public void invalidParametersShouldThrowExceptionJustExtension() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        // When
        new FileNameManipulator().changeExtensionToLowerCase(".java");
    }




    @Test
    public void invalidParametersShouldThrowExceptionIfNullString() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string!");

        // When
        new FileNameManipulator().findLastCharacter(null);
    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWrongFileName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid file name!");

        // When
        new FileNameManipulator().findFileExtension(".");
    }

    @Test
    public void invalidParametersShouldThrowExceptionIfWrongExtension() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid file name!");

        // When
        new FileNameManipulator().findFileExtension(".d");
    }

    @Test
    public void invalidFileNameEmptyString() throws IllegalArgumentException{


        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid file name!");

        // When
        new FileNameManipulator().findFileExtension("\t\n\r");
    }

    @Test
    public void invalidFileNameNull() throws IllegalArgumentException{

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid file name!");

        // When
        new FileNameManipulator().findFileExtension(null);
    }

    @Test
    public void invalidParametersShouldThrowException() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension("d", ".d");
    }

    @Test
    public void invalidFileNameShouldThrowException() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension("d", ".");
    }

    @Test
    public void invalidFileNameEmptyStringGoodExtension() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension("d", "\t\n\r");
    }

    @Test
    public void invalidFileNameNullGoodExtension() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension("d", null);
    }

    @Test
    public void invalidExtensionEmptyStringGoodFileName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension("\t\n\r", "record.dat");
    }

    @Test
    public void invalidExtensionNullGoodFileTwoName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().identifyFilesByExtension(null, "record.dat");
    }


    @Test
    public void invalidFileOneNullGoodFileTwoName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().compareFilesByName(null, "record.dat");
    }

    @Test
    public void invalidFileTwoNullGoodFileOneName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().compareFilesByName("record.dat", null);
    }

    @Test
    public void invalidFileTwoEmptyStringGoodFileOneName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().compareFilesByName("record.dat", "\n\t\r");
    }

    @Test
    public void invalidFileOneEmptyStringGoodFileName() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid argument!");

        //When
        new FileNameManipulator().compareFilesByName("\n\t\r", "record.dat");
    }

    @Test
    public void invalidFileNameToReplaceEmptyString() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string!");

        //When
        new FileNameManipulator().replaceStringPart("\n\t\r", "jpeg","jpg");
    }

    @Test
    public void invalidFileNameToReplaceNull() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string!");

        //When
        new FileNameManipulator().replaceStringPart(null, "jpeg","jpg");
    }



    @Test
    public void findLastCharacter() {

        assertThat(new FileNameManipulator().findLastCharacter("abcdef"), equalTo('f'));
        assertThat(new FileNameManipulator().findLastCharacter("abcdef \t  \n "), equalTo('f'));
    }

    @Test
    public void findFileExtension() {

        assertThat(new FileNameManipulator().findFileExtension("record.dat"), equalTo(".dat"));
    }

    @Test
    public void identifyFilesByExtension() {

        assertThat(new FileNameManipulator().identifyFilesByExtension("mm", "tematika.mm"), is(true));
        assertThat(new FileNameManipulator().identifyFilesByExtension("md", "tematika.mm"), is(false));
    }

    @Test
    public void compareFilesByName(){

        assertThat(new FileNameManipulator().compareFilesByName("String.java", "String.JAVA"), is(true));
        assertThat(new FileNameManipulator().compareFilesByName("String.java", "Sting.java"), is(false));
    }

    @Test
    public void changeExtensionToLowerCase(){
        assertThat(new FileNameManipulator().changeExtensionToLowerCase("String.JAVA"), equalTo("String.java"));
    }

    @Test
    public void replaceExtension() {
        assertThat(new FileNameManipulator().replaceStringPart("picture.png", "jpeg", "jpg"), equalTo("picture.png"));
        assertThat(new FileNameManipulator().replaceStringPart("picture.jpeg", "jpeg", "jpg"), equalTo("picture.jpg"));
        assertThat(new FileNameManipulator().replaceStringPart("long descriptive name.txt", " ", "_"), equalTo("long_descriptive_name.txt"));
    }
}
