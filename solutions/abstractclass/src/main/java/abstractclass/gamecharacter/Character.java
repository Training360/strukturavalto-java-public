package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {
	private static final int MAX_DAMAGE = 10;
	private static final int MAX_DEFENCE = 5;
	private int hitPoint = 100;
	private Point position;
	private Random random;

	public Character(Point position, Random random) {
		this.position = position;
		this.random = random;
	}

	protected int getActualPrimaryDamage() {
		return random.nextInt(MAX_DAMAGE - 1) + 1;
	}

	private int getActualDefence() {
		return random.nextInt(MAX_DEFENCE);
	}

	protected void hit(Character enemy, int damage) {
		int actualDefence = enemy.getActualDefence();
		if(actualDefence < damage) {
			enemy.decreaseHitPoint(damage);
		}
	}

	public void primaryAttack(Character enemy) {
		hit(enemy, getActualPrimaryDamage());
	}

	private void decreaseHitPoint(int diff) {
		this.hitPoint -= diff;
	}

	public abstract void secondaryAttack(Character enemy);

	public int getHitPoint() {
		return hitPoint;
	}

	public Point getPosition() {
		return position;
	}

	public boolean isAlive() {
		return hitPoint > 0;
	}

	public Random getRandom() {
		return random;
	}
}
