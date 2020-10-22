package abstractclass.gamecharacter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PointTest {
	@Test
	public void creation() {
		Point point = new Point(5,6);

		assertThat(point.getX(), is(5L));
		assertThat(point.getY(), is(6L));
	}

	@Test
	public void distance() {
		Point point1 = new Point(0,0);
		Point point2 = new Point(100,100);


		assertThat(point1.distance(point2), is(141L));
	}

}