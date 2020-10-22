package abstractclass.gamecharacter;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;


public class BattleFieldTest {

	@Test(timeout=1000)
	public void fight() {
		Random random = new Random(123);
		BattleField battleField = new BattleField();
		Character characterArcher = new Archer(new Point(0,0), random);
		Character characterWarrior = new AxeWarrior(new Point(5,0), random);
		battleField.fight(characterArcher, characterWarrior);

		assertThat(battleField.getRound(), greaterThan(0));
		assertTrue(!characterArcher.isAlive()|| !characterWarrior.isAlive());
	}

	@Test(timeout=1000)
	public void fightCloseTogether() {
		Random random = new Random(123);
		BattleField battleField = new BattleField();
		Character characterArcher = new Archer(new Point(0,0), random);
		Character characterWarrior = new AxeWarrior(new Point(1,0), random);
		battleField.fight(characterArcher, characterWarrior);

		assertThat(battleField.getRound(), greaterThan(0));
		assertTrue(!characterArcher.isAlive()|| !characterWarrior.isAlive());
	}
}