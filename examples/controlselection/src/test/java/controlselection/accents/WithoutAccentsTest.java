package controlselection.accents;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WithoutAccentsTest {

    @Test
    public void testWith() {
        assertThat(new WithoutAccents().convertToCharWithoutAccents('á'), equalTo('a'));
        assertThat(new WithoutAccents().convertToCharWithoutAccents('é'), equalTo('e'));
        assertThat(new WithoutAccents().convertToCharWithoutAccents('ű'), equalTo('u'));
        assertThat(new WithoutAccents().convertToCharWithoutAccents('Ű'), equalTo('U'));
    }

    @Test
    public void testWithout() {
        assertThat(new WithoutAccents().convertToCharWithoutAccents('a'), equalTo('a'));
        assertThat(new WithoutAccents().convertToCharWithoutAccents('g'), equalTo('g'));
        assertThat(new WithoutAccents().convertToCharWithoutAccents('z'), equalTo('z'));
    }
}
