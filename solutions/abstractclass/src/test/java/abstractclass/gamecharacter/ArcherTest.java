package abstractclass.gamecharacter;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;


public class ArcherTest {

	@Test
	public void creation()  {
		Random random = new Random(123);
		Character character = new Archer(new Point(5, 10), random);

		assertThat(character.getHitPoint(), is(100));
		assertThat(character.isAlive(), is(true));
		assertThat(character.getPosition().getX(), is(5L));
		assertThat(character.getPosition().getY(), is(10L));
	}

	@Test
	public void kill()  {
		Random random = new Random(123);
		Archer offender = new Archer(new Point(0,0), random);
		Character defender = new Archer(new Point(12,0), random);

		while (defender.getHitPoint() > 0) {
			offender.secondaryAttack(defender);
		}

		assertThat(defender.getHitPoint(), lessThanOrEqualTo(0));
		assertThat(defender.isAlive(), is(false));
	}

	@Test
	public void secondaryAttack() throws Exception {
		Random random = new Random(123);
		Archer offender = new Archer(new Point(0,0), random);
		Character defender = new Archer(new Point(12,0), random);

		offender.secondaryAttack(defender);

		assertThat(offender.getHitPoint(), is(100));
		assertThat(defender.getHitPoint(), greaterThanOrEqualTo(96));
		assertThat(offender.getNumberOfArrow(), is(99));
	}

}