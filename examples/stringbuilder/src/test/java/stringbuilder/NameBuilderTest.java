package stringbuilder;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameBuilderTest {


    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle(null, "G", "John", Title.MR);
        });

        assertEquals("Family name and given name must not be empty!", ex.getMessage());

    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle("Smith", "G", null, Title.MR);
        });

        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle("", "G", "John", Title.MR);
        });

        assertEquals("Family name and given name must not be empty!", ex.getMessage());


    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new NameBuilder().concatNameHungarianStyle("Smith", "G", "", Title.MR);

        });

        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void westernStyleNameConcatenation() {

        assertEquals("Mr. John G Smith", new NameBuilder().concatNameWesternStyle("Smith", "G", "John", Title.MR));
        assertEquals("John G Smith", new NameBuilder().concatNameWesternStyle("Smith", "G", "John", null));
        assertEquals("Mr. John Smith", new NameBuilder().concatNameWesternStyle("Smith", "", "John", Title.MR));
        assertEquals("Mr. John Smith", new NameBuilder().concatNameWesternStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertEquals("Mr. Smith G John", new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", Title.MR));
        assertEquals("Smith G John", new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", null));
        assertEquals("Mr. Smith John", new NameBuilder().concatNameHungarianStyle("Smith", "", "John", Title.MR));
        assertEquals("Mr. Smith John", new NameBuilder().concatNameHungarianStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void insertTitle() {
        //Given
        String name = "Dr. John G Smith";
        //Then
        assertEquals("Dr. Prof. John G Smith", new NameBuilder().insertTitle(name, Title.PROF, " "));
    }

    @Test
    public void deleteNamePart() {

        assertEquals("Dr. John G Smith", new NameBuilder().deleteNamePart("Dr. Prof. John G Smith", "Prof. "));
    }
}
