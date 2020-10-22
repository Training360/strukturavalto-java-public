package stringconcat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NameTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new Name(null, "G", "John", Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new Name("Smith", "G", null, Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new Name("", "G", "John", Title.MR);
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Family name and given name must not be empty!");
        // When
        new Name("Smith", "G", "", Title.MR);
    }

    @Test
    public void westernStyleNameConcatenation() {

        assertThat(new Name("Smith", "G", "John", Title.MR).concatNameWesternStyle(), equalTo("Mr. John G Smith"));
        assertThat(new Name("Smith", "G", "John").concatNameWesternStyle(), equalTo("John G Smith"));
        assertThat(new Name("Smith", "", "John", Title.MR).concatNameWesternStyle(), equalTo("Mr. John Smith"));
        assertThat(new Name("Smith", null, "John", Title.MR).concatNameWesternStyle(), equalTo("Mr. John Smith"));
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertThat(new Name("Smith", "G", "John", Title.MR).concatNameHungarianStyle(), equalTo("Mr. Smith G John"));
        assertThat(new Name("Smith", "G", "John").concatNameHungarianStyle(), equalTo("Smith G John"));
        assertThat(new Name("Smith", "", "John", Title.MR).concatNameHungarianStyle(), equalTo("Mr. Smith John"));
    }
}
