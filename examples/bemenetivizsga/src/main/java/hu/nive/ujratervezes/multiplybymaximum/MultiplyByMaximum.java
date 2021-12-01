package hu.nive.ujratervezes.multiplybymaximum;

public class MultiplyByMaximum {

  public int[] multiplyByMaximum(int[] numbers, int n) {
    if (numbers == null || n < 1) {
      throw new IllegalArgumentException();
    }
    if (numbers.length == 0) {
      return new int[0];
    }

    int[] solution = new int[numbers.length];

    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }

    for (int i = 0; i < solution.length; i++) {
      solution[i] = (i + 1) % n == 0 ? numbers[i] * max : numbers[i];
    }
    return solution;
  }

}
