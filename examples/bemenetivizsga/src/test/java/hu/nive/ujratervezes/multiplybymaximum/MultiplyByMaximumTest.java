package hu.nive.ujratervezes.multiplybymaximum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MultiplyByMaximumTest {

  @Test
  void testCorrectInput1() {
    int[] expected = new int[]{0, 1, 25, 4};
    int[] actual = new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 1, 5, 4}, 3);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testCorrectInput2() {
    int[] expected = new int[]{0, 18, 5, 24, 3, 36};
    int[] actual = new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 3, 5, 4, 3, 6}, 2);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testCorrectInput3() {
    int[] expected = new int[]{0, 12, 24, 18, 36};
    int[] actual = new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 2, 4, 3, 6}, 1);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testCorrectInput4() {
    int[] expected = new int[]{0, 1, 5, 4};
    int[] actual = new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 1, 5, 4}, 10);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testEmptyArray() {
    int[] emptyArray = new int[0];
    int[] actual = new MultiplyByMaximum().multiplyByMaximum(emptyArray, 1);
    assertNotEquals(emptyArray, actual);
    assertArrayEquals(emptyArray, actual);
  }

  @Test
  void testNullArray() {
    assertThrows(IllegalArgumentException.class,
        () -> new MultiplyByMaximum().multiplyByMaximum(null, 1));
  }

  @Test
  void testInvalidN1() {
    assertThrows(IllegalArgumentException.class,
        () -> new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 1, 5, 4}, 0));
  }

  @Test
  void testInvalidN2() {
    assertThrows(IllegalArgumentException.class,
        () -> new MultiplyByMaximum().multiplyByMaximum(new int[]{0, 1, 5, 4}, -1));
  }
}
