package constructoroverloading.bus;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SimpleTimeTest {

    @Test
    public void constructorTest2Parameters() {
        //Given
        SimpleTime time = new SimpleTime(15, 16);
        //Then
        assertThat(time.getHours(), equalTo(15));
        assertThat(time.getMinutes(), equalTo(16));
    }

    @Test
    public void constructorTest1Parameter() {
        //Given
        SimpleTime time = new SimpleTime(15);
        //Then
        assertThat(time.getHours(), equalTo(15));
        assertThat(time.getMinutes(), equalTo(0));
    }

    @Test
    public void constructorTestSimpleTimeParameter() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        //Then
        assertThat(time.getHours(), equalTo(15));
        assertThat(time.getMinutes(), equalTo(16));
    }

    @Test
    public void differenceAfter() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(14, 10));
        //Then
        assertThat(time.difference(anotherTime), equalTo(66));
    }

    @Test
    public void differenceIfEqual() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(15, 16));
        //Then
        assertThat(time.difference(anotherTime), equalTo(0));
    }

    @Test
    public void differenceEarlier() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(17, 26));
        //Then
        assertThat(time.difference(anotherTime), equalTo(-130));
    }

    @Test
    public void toStringTest() {
        //Given
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        //Then
        assertThat(time.toString(), equalTo("15:16"));
    }
}