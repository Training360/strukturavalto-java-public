package hu.nive.ujratervezes.pokebag;

import hu.nive.ujratervezes.pokebag.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Pokebag {
  private final List<Pokemon> pokemons;

  public Pokebag() {
    pokemons = new ArrayList<>();
  }

  public void add(Pokemon pokemon) {
    if (pokemon == null) {
      throw new IllegalArgumentException();
    }
    pokemons.add(pokemon);
  }

  public int getNumberOfPokemons() {
    return pokemons.size();
  }

  public Pokemon getStrongest() {
    if (pokemons.size() == 0) {
      throw new NoSuchElementException();
    }
    return pokemons.stream()
        .max(Comparator.comparingInt(Pokemon::getStrength))
        .get();
  }

  public Pokemon getByIndex(int index) {
    return pokemons.get(index);
  }

  public Pokemon fight(int i, int j) {
    if (i == j) {
      throw new IllegalArgumentException();
    }

    Pokemon p1 = pokemons.get(i);
    Pokemon p2 = pokemons.get(j);

    Pokemon winner;
    Pokemon loser;
    if (p1.getStrength() > p2.getStrength()) {
      winner = p1;
      loser = p2;
    } else {
      winner = p2;
      loser = p1;
    }

    loser.loseHealth(1);
    System.out.println(winner.speak());
    return winner;
  }
}
