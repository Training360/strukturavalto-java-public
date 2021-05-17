package hu.nive.ujratervezes.pokebag.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonTest {

  @Test
  void testDefaultValues() {
    Pokemon pikachu = new Pikachu();
    Pokemon bulbasaur = new Bulbasaur();
    Pokemon charmander = new Charmander();

    int expectedHealth = 10;
    assertEquals(expectedHealth, pikachu.getHealth());
    assertEquals(expectedHealth, bulbasaur.getHealth());
    assertEquals(expectedHealth, charmander.getHealth());

    assertEquals(10, pikachu.getStrength());
    assertEquals(6, bulbasaur.getStrength());
    assertEquals(8, charmander.getStrength());

    assertEquals("Pikachu", pikachu.getName());
    assertEquals("Bulbasaur", bulbasaur.getName());
    assertEquals("Charmander", charmander.getName());
  }

  @Test
  void testCustomNames() {
    Pokemon pikachu = new Pikachu("Petra");
    Pokemon bulbasaur = new Bulbasaur("Bob");
    Pokemon charmander = new Charmander("Charlie");

    assertEquals("Petra", pikachu.getName());
    assertEquals("Bob", bulbasaur.getName());
    assertEquals("Charlie", charmander.getName());
  }
}
