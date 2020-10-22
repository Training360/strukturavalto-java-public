package interfaceextends.robot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AstroBoyTest {

	@Test
	public void testMoveTo() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		AstroBoy astroBoy = new AstroBoy(initialPoint);
		Point targetPoint = new Point(12L, 23L, 0);
		//When
        astroBoy.moveTo(targetPoint);
		//Then
		assertThat(astroBoy.getPosition(), is(targetPoint));
		assertThat(astroBoy.getPath().size(), is(1));
		assertThat(astroBoy.getPath().get(0).getX(), is(targetPoint.getX()));
		assertThat(astroBoy.getPath().get(0).getY(), is(targetPoint.getY()));
		assertThat(astroBoy.getPath().get(0).getZ(), is(targetPoint.getZ()));
	}

	@Test
	public void testFastMoveTo() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		AstroBoy astroBoy = new AstroBoy(initialPoint);
		Point targetPoint = new Point(12L, 23L, 0);
		//When
        astroBoy.fastMoveTo(targetPoint);
		//Then
		assertThat(astroBoy.getPosition().getX(), is(targetPoint.getX()));
		assertThat(astroBoy.getPosition().getY(), is(targetPoint.getY()));
		assertThat(astroBoy.getPosition().getZ(), is(targetPoint.getZ()));

		assertThat(astroBoy.getPath().size(), is(3));
		assertThat(astroBoy.getPath().get(0).getX(), is(initialPoint.getX()));
		assertThat(astroBoy.getPath().get(0).getY(), is(initialPoint.getY()));
		assertThat(astroBoy.getPath().get(0).getZ(), is(AstroBoy.ALTITUDE));

		assertThat(astroBoy.getPath().get(1).getX(), is(targetPoint.getX()));
		assertThat(astroBoy.getPath().get(1).getY(), is(targetPoint.getY()));
		assertThat(astroBoy.getPath().get(1).getZ(), is(AstroBoy.ALTITUDE));

		assertThat(astroBoy.getPath().get(2).getX(), is(targetPoint.getX()));
		assertThat(astroBoy.getPath().get(2).getY(), is(targetPoint.getY()));
		assertThat(astroBoy.getPath().get(2).getZ(), is(0L));
	}

	@Test
	public void testRotate() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		AstroBoy astroBoy = new AstroBoy(initialPoint);
		final int angle = 12;
		//When
        astroBoy.rotate(angle);
		//Then
		assertThat(astroBoy.getAngle(), is(angle));
	}

	@Test
	public void testLiftTo() {
		//Given
		Point initialPoint = new Point(0, 0, 0);
		AstroBoy astroBoy = new AstroBoy(initialPoint);
		final long altitude = 12;
		//When
        astroBoy.liftTo(altitude);
		//Then
		assertThat(astroBoy.getAltitude(), is(altitude));
	}
}