package hu.nive.ujratervezes.pokebag.pokemon;

public class Pikachu extends Pokemon {

  public Pikachu(String name) {
    super(10, name);
  }

  public Pikachu() {
    super(10, "Pikachu");
  }

  @Override
  public String speak() {
    return "Pika-pika";
  }
}
