package stringbuilder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NameBuilderTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new NameBuilder().concatNameHungarianStyle(null, "G", "John", Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new NameBuilder().concatNameHungarianStyle("Smith", "G", null, Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");

        // When
        new NameBuilder().concatNameHungarianStyle("", "G", "John", Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");

        // When
        new NameBuilder().concatNameHungarianStyle("Smith", "G", "", Title.MR);
    }

    @Test
    public void westernStyleNameConcatenation() {

        assertThat(new NameBuilder().concatNameWesternStyle("Smith", "G", "John", Title.MR), equalTo("Mr. John G Smith"));
        assertThat(new NameBuilder().concatNameWesternStyle("Smith", "G", "John", null), equalTo("John G Smith"));
        assertThat(new NameBuilder().concatNameWesternStyle("Smith", "", "John", Title.MR), equalTo("Mr. John Smith"));
        assertThat(new NameBuilder().concatNameWesternStyle("Smith", null, "John", Title.MR), equalTo("Mr. John Smith"));
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertThat(new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", Title.MR), equalTo("Mr. Smith G John"));
        assertThat(new NameBuilder().concatNameHungarianStyle("Smith", "G", "John", null), equalTo("Smith G John"));
        assertThat(new NameBuilder().concatNameHungarianStyle("Smith", "", "John", Title.MR), equalTo("Mr. Smith John"));
        assertThat(new NameBuilder().concatNameHungarianStyle("Smith", null, "John", Title.MR), equalTo("Mr. Smith John"));
    }

    @Test
    public void insertTitle() {
        //Given
        String name = "Dr. John G Smith";
        //Then
        assertThat(new NameBuilder().insertTitle(name, Title.PROF, " "), equalTo("Dr. Prof. John G Smith"));
    }

    @Test
    public void deleteNamePart() {

        assertThat(new NameBuilder().deleteNamePart("Dr. Prof. John G Smith", "Prof. "), equalTo("Dr. John G Smith"));
    }
}
