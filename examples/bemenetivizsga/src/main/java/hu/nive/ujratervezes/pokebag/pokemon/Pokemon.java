package hu.nive.ujratervezes.pokebag.pokemon;

public abstract class Pokemon {
  private int health;
  private int strength;
  private String name;

  public Pokemon(int strength, String name) {
    this.health = 10;
    this.strength = strength;
    this.name = name;
  }

  public abstract String speak();

  public void loseHealth(int n) {
    health -= n;
  }

  public int getHealth() {
    return health;
  }

  public int getStrength() {
    return strength;
  }

  public String getName() {
    return name;
  }
}
