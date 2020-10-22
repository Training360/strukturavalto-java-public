package math.rounding;

import java.util.Random;

public class RoundingAnomaly {

    private double[] randomNumbers(int size, double max, int scale) {
        double[] numbers = new double[size];
        Random random = new Random();
        double factor = Math.pow(10, scale);
        for (int i = 0; i < size; i ++) {
            double number = Math.round(random.nextDouble() * max * factor) / factor;
            numbers[i] = number;
        }
        return numbers;
    }

    private double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + number;
        }
        return Math.round(sum);
    }

    private double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + Math.round(number);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        double resultAfterSum = roundAfterSum(numbers);
        double resultAfterRound = sumAfterRound(numbers);
        return Math.abs(resultAfterSum - resultAfterRound);
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        int count = 100;
        double sum = 0;
        for (int i = 0; i < count; i++) {
            double diff = roundingAnomaly.difference(1000, 1_000_000, 5);
            sum += diff;
            System.out.println("Diff: " + diff);
        }
        System.out.println(sum / count);
    }
}
