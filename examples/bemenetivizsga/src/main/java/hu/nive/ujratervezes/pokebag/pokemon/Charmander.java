package hu.nive.ujratervezes.pokebag.pokemon;

public class Charmander extends Pokemon {

  public Charmander(String name) {
    super(8, name);
  }

  public Charmander() {
    super(8, "Charmander");
  }

  @Override
  public String speak() {
    return "Char-char";
  }
}
