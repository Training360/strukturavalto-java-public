package hu.nive.ujratervezes.pokebag.pokemon;

public class Bulbasaur extends Pokemon {

  public Bulbasaur(String name) {
    super(6, name);
  }

  public Bulbasaur() {
    super(6, "Bulbasaur");
  }

  @Override
  public String speak() {
    return "Bulba-saur";
  }
}
