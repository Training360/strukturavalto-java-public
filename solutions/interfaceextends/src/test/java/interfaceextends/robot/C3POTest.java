package interfaceextends.robot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class C3POTest {

	@Test
	public void testMoveTo() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		C3PO c3PO = new C3PO(initialPoint);
		Point targetPoint = new Point(12L, 23L, 0);
		//When
        c3PO.moveTo(targetPoint);
		//Then
		assertThat(c3PO.getPosition(), is(targetPoint));
		assertThat(c3PO.getPath().get(0).getX(), is(targetPoint.getX()));
		assertThat(c3PO.getPath().get(0).getY(), is(targetPoint.getY()));
		assertThat(c3PO.getPath().get(0).getZ(), is(targetPoint.getZ()));
	}

	@Test
	public void testFastMoveTo() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		C3PO c3PO = new C3PO(initialPoint);
		Point targetPoint = new Point(12L, 23L, 0);
		//When
        c3PO.fastMoveTo(targetPoint);
		//Then
		assertThat(c3PO.getPosition(), is(targetPoint));
		assertThat(c3PO.getPath().get(0).getX(), is(targetPoint.getX()));
		assertThat(c3PO.getPath().get(0).getY(), is(targetPoint.getY()));
		assertThat(c3PO.getPath().get(0).getZ(), is(targetPoint.getZ()));
	}

	@Test
	public void testRotate() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		C3PO c3PO = new C3PO(initialPoint);
		final int angle = 12;
		//When
        c3PO.rotate(angle);
		//Then
		assertThat(c3PO.getAngle(), is(angle));
	}
}