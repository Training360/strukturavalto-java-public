package methodargvars.examstats;

import methodargvars.examstats.ExamStats;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExamStatsTest {

    private ExamStats examStats;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.examStats = new ExamStats(100);
    }

    @After
    public void tearDown() {
        this.examStats = null;
    }

    @Test
    public void zeroResultsShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Number of results must not be empty!");
        // When
        examStats.getNumberOfTopGrades(85);
    }

    @Test
    public void nullResultsShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Number of results must not be empty!");
        // When
        examStats.getNumberOfTopGrades(85, null);
    }

    @Test
    public void testGetNumberOfTopGrades() {

        assertThat(examStats.getNumberOfTopGrades(85, 2, 3, 4, 5, 86, 90, 99), is(3));
        assertThat(examStats.getNumberOfTopGrades(85, 2, 3, 4, 5, 56, 34, 70), is(0));
    }

    @Test
    public void zeroResultsShouldThrowExceptionWithFails() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Number of results must not be empty!");
        // When
        examStats.hasAnyFailed(50);
    }

    @Test
    public void testHasAnyFailed() {

        assertThat(examStats.hasAnyFailed(50, 10, 90), is(true));
        assertThat(examStats.hasAnyFailed(50, 60, 90), is(false));
    }
}