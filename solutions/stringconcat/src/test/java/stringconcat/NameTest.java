package stringconcat;


import employee.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {


    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Name(null, "G", "John", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Name("Smith", "G", null, Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Name("", "G", "John", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Name("Smith", "G", "", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void westernStyleNameConcatenation() {

        assertEquals("Mr. John G Smith", new Name("Smith", "G", "John", Title.MR).concatNameWesternStyle());
        assertEquals("John G Smith", new Name("Smith", "G", "John").concatNameWesternStyle());
        assertEquals("Mr. John Smith", new Name("Smith", "", "John", Title.MR).concatNameWesternStyle());
        assertEquals("Mr. John Smith", new Name("Smith", null, "John", Title.MR).concatNameWesternStyle());
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertEquals("Mr. Smith G John", new Name("Smith", "G", "John", Title.MR).concatNameHungarianStyle());
        assertEquals("Smith G John", new Name("Smith", "G", "John").concatNameHungarianStyle());
        assertEquals("Mr. Smith John", new Name("Smith", "", "John", Title.MR).concatNameHungarianStyle());
    }
}
