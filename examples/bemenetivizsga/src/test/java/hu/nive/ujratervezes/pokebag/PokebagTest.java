package hu.nive.ujratervezes.pokebag;

import hu.nive.ujratervezes.pokebag.pokemon.Bulbasaur;
import hu.nive.ujratervezes.pokebag.pokemon.Charmander;
import hu.nive.ujratervezes.pokebag.pokemon.Pikachu;
import hu.nive.ujratervezes.pokebag.pokemon.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PokebagTest {
  private Pokebag pokebag;

  @BeforeEach
  void setupEach() {
    pokebag = new Pokebag();
  }

  @Test
  void testConstructor_PokebagIsEmptyWhenCreated() {
    assertEquals(0, pokebag.getNumberOfPokemons());
  }

  @Test
  void testAdd_EmptyPokebag_OnePokemon() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);

    assertEquals(1, pokebag.getNumberOfPokemons());
    assertEquals(pikachu, pokebag.getByIndex(0));
  }

  @Test
  void testAdd_EmptyPokebag_PokemonIsNull() {
    assertThrows(IllegalArgumentException.class,
        () -> pokebag.add(null));
  }

  @Test
  void testAdd_EmptyPokebag_ManyPokemons() {
    for (int i = 0; i < 100; i++) {
      pokebag.add(new Pikachu());
    }

    assertEquals(100, pokebag.getNumberOfPokemons());
  }

  @Test
  void testGetByIndex_OnePokemon_ValidIndex() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);

    assertEquals(pikachu, pokebag.getByIndex(0));
  }

  @Test
  void testGetByIndex_SomePokemons_ValidIndex() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    Pokemon bulbasaur = new Bulbasaur();
    pokebag.add(bulbasaur);
    Pokemon charmander = new Charmander();
    pokebag.add(charmander);

    assertEquals(pikachu, pokebag.getByIndex(0));
    assertEquals(bulbasaur, pokebag.getByIndex(1));
    assertEquals(charmander, pokebag.getByIndex(2));
  }

  @Test
  void testGetByIndex_ManyPokemons_ValidIndex() {
    for (int i = 0; i < 100; i++) {
      pokebag.add(new Pikachu());
    }
    Pokemon bulbasaur = new Bulbasaur();
    pokebag.add(bulbasaur);

    assertEquals(bulbasaur, pokebag.getByIndex(100));
  }

  @Test
  void testGetStrongest_EmptyPokebag() {
    assertThrows(NoSuchElementException.class,
        () -> pokebag.getStrongest());
  }

  @Test
  void testGetStrongest_OnePokemon() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);

    assertEquals(pikachu, pokebag.getStrongest());
  }

  @Test
  void testGetStrongest_TwoPokemons1() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    pokebag.add(new Bulbasaur());

    assertEquals(pikachu, pokebag.getStrongest());
  }

  @Test
  void testGetStrongest_TwoPokemons2() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    pokebag.add(new Charmander());

    assertEquals(pikachu, pokebag.getStrongest());
  }

  @Test
  void testGetStrongest_TwoPokemons3() {
    pokebag.add(new Bulbasaur());
    Pokemon charmander = new Charmander();
    pokebag.add(charmander);

    assertEquals(charmander, pokebag.getStrongest());
  }

  @Test
  void testFight_TwoPokemons_SameIndex() {
    pokebag.add(new Pikachu());
    pokebag.add(new Pikachu());

    assertThrows(IllegalArgumentException.class,
        () -> pokebag.fight(0, 0));
  }

  @Test
  void testFight_TwoPokemons1() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    Pokemon bulbasaur = new Bulbasaur();
    pokebag.add(bulbasaur);

    Pokemon winner = pokebag.fight(0, 1);
    assertEquals(pikachu, winner);
    assertEquals(10, pikachu.getHealth());
    assertEquals(9, bulbasaur.getHealth());
  }

  @Test
  void testFight_TwoPokemons2() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    Pokemon charmander = new Charmander();
    pokebag.add(charmander);

    Pokemon winner = pokebag.fight(0, 1);
    assertEquals(pikachu, winner);
    assertEquals(10, pikachu.getHealth());
    assertEquals(9, charmander.getHealth());
  }

  @Test
  void testFight_TwoPokemons3() {
    Pokemon bulbasaur = new Bulbasaur();
    pokebag.add(bulbasaur);
    Pokemon charmander = new Charmander();
    pokebag.add(charmander);

    Pokemon winner = pokebag.fight(0, 1);
    assertEquals(charmander, winner);
    assertEquals(10, charmander.getHealth());
    assertEquals(9, bulbasaur.getHealth());
  }

  @Test
  void testFight_TwoIdenticalPokemons() {
    Pokemon pikachu1 = new Pikachu();
    pokebag.add(pikachu1);
    Pokemon pikachu2 = new Pikachu();
    pokebag.add(pikachu2);

    Pokemon winner = pokebag.fight(0, 1);
    Pokemon loser = winner == pikachu1 ? pikachu2 : pikachu1;

    assertTrue(winner == pikachu1 || winner == pikachu2);
    assertEquals(10, winner.getHealth());
    assertEquals(9, loser.getHealth());
    assertTrue(winner == pikachu1 ? pikachu1.getHealth() == 10 : pikachu2.getHealth() == 10);
    assertTrue(winner == pikachu2 ? pikachu1.getHealth() == 9 : pikachu2.getHealth() == 9);
  }

  @Test
  void testFight_TwoPokemons_TwoFights() {
    Pokemon pikachu = new Pikachu();
    pokebag.add(pikachu);
    Pokemon bulbasaur = new Bulbasaur();
    pokebag.add(bulbasaur);

    Pokemon firstWinner = pokebag.fight(0, 1);
    assertEquals(pikachu, firstWinner);
    assertEquals(10, pikachu.getHealth());
    assertEquals(9, bulbasaur.getHealth());

    Pokemon secondWinner = pokebag.fight(0, 1);
    assertEquals(pikachu, secondWinner);
    assertEquals(10, pikachu.getHealth());
    assertEquals(8, bulbasaur.getHealth());
  }
}
