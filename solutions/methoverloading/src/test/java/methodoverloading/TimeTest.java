package methodoverloading;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TimeTest {
    @Test
    public void testCreateTimeWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertThat(time.getHours(), equalTo(13));
        assertThat(time.getMinutes(), equalTo(14));
        assertThat(time.getSeconds(), equalTo(15));
    }

    @Test
    public void testCreateTimeWith2Parameters() {
        //Given
        Time time = new Time(13, 14);
        //Then
        assertThat(time.getHours(), equalTo(13));
        assertThat(time.getMinutes(), equalTo(14));
        assertThat(time.getSeconds(), equalTo(0));
    }

    @Test
    public void testCreateTimeWith1Parameter() {
        //Given
        Time time = new Time(13);
        //Then
        assertThat(time.getHours(), equalTo(13));
        assertThat(time.getMinutes(), equalTo(0));
        assertThat(time.getSeconds(), equalTo(0));

    }

    @Test
    public void testCreateTimeWithTimeParameter() {
        //Given
        Time anotherTime = new Time(13, 14, 15);
        //When
        Time time = new Time(anotherTime);

        assertThat(time.getHours(), equalTo(13));
        assertThat(time.getMinutes(), equalTo(14));
        assertThat(time.getSeconds(), equalTo(15));
    }

    @Test
    public void testIsEqualWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertThat(time.isEqual(13, 14, 15), equalTo(true));
        assertThat(time.isEqual(15, 10, 10), equalTo(false));
    }

    @Test
    public void testIsEqualWithTimeParameter() {
        //Given
        Time time = new Time(13, 14, 15);
        Time anotherTime = new Time(13, 14, 15);
        Time laterTime = new Time(14, 14, 15);
        //Then
        assertThat(time.isEqual(anotherTime), equalTo(true));
        assertThat(time.isEqual(laterTime), equalTo(false));
    }

    @Test
    public void testIsEarlierWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertThat(time.isEarlier(15, 10, 10), equalTo(true));
        assertThat(time.isEarlier(10, 10, 10), equalTo(false));
    }

    @Test
    public void testIsEarlierWithTimeParameter() {
        //Given
        Time time = new Time(13, 14, 15);
        Time laterTime = new Time(15, 14, 15);
        Time earlierTime = new Time(10, 14, 15);
        //Then
        assertThat(time.isEarlier(laterTime), equalTo(true));
        assertThat(time.isEarlier(earlierTime), equalTo(false));
    }
}