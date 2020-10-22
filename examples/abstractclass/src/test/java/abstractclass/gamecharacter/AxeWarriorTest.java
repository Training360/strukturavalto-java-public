package abstractclass.gamecharacter;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.*;

public class AxeWarriorTest {

	@Test
	public void creation()  {
		Random random = new Random(123);
		Character character = new AxeWarrior(new Point(5, 10), random);

		assertThat(character.getHitPoint(), is(100));
		assertThat(character.isAlive(), is(true));
		assertThat(character.getPosition().getX(), is(5L));
		assertThat(character.getPosition().getY(), is(10L));
	}

	@Test
	public void secondaryAttack() {
		Random random = new Random(123);
		Character offender = new AxeWarrior(new Point(0,0), random);
		Character defender = new AxeWarrior(new Point(0,0), random);
		offender.secondaryAttack(defender);

		assertThat(offender.getHitPoint(), is(100));
		assertThat(defender.getHitPoint(), greaterThanOrEqualTo(80));
	}
}