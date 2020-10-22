package interfaceextends.robot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void testCreatePoint() {
        //Given
        Point point = new Point(2, 3, 4);
        //Then
        assertThat(point.getX(), is(2L));
        assertThat(point.getY(), is(3L));
        assertThat(point.getZ(), is(4L));
    }
}