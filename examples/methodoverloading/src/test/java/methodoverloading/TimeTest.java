package methodoverloading;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
    @Test
    public void testCreateTimeWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertEquals(13, time.getHours());
        assertEquals(14, time.getMinutes());
        assertEquals(15, time.getSeconds());
    }

    @Test
    public void testCreateTimeWith2Parameters() {
        //Given
        Time time = new Time(13, 14);
        //Then
        assertEquals(13, time.getHours());
        assertEquals(14, time.getMinutes());
        assertEquals(0, time.getSeconds());
    }

    @Test
    public void testCreateTimeWith1Parameter() {
        //Given
        Time time = new Time(13);
        //Then
        assertEquals(13, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());

    }

    @Test
    public void testCreateTimeWithTimeParameter() {
        //Given
        Time anotherTime = new Time(13, 14, 15);
        //When
        Time time = new Time(anotherTime);

        assertEquals(13, time.getHours());
        assertEquals(14, time.getMinutes());
        assertEquals(15, time.getSeconds());
    }

    @Test
    public void testIsEqualWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertTrue(time.isEqual(13, 14, 15));
        assertFalse(time.isEqual(15, 10, 10));
    }

    @Test
    public void testIsEqualWithTimeParameter() {
        //Given
        Time time = new Time(13, 14, 15);
        Time anotherTime = new Time(13, 14, 15);
        Time laterTime = new Time(14, 14, 15);
        //Then
        assertTrue(time.isEqual(anotherTime));
        assertFalse(time.isEqual(laterTime));
    }

    @Test
    public void testIsEarlierWith3Parameters() {
        //Given
        Time time = new Time(13, 14, 15);
        //Then
        assertTrue(time.isEarlier(15, 10, 10));
        assertFalse(time.isEarlier(10, 10, 10));
    }

    @Test
    public void testIsEarlierWithTimeParameter() {
        //Given
        Time time = new Time(13, 14, 15);
        Time laterTime = new Time(15, 14, 15);
        Time earlierTime = new Time(10, 14, 15);
        //Then
        assertTrue(time.isEarlier(laterTime));
        assertFalse(time.isEarlier(earlierTime));
    }
}