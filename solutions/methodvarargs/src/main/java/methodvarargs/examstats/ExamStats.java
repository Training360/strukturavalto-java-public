package methodvarargs.examstats;

public class ExamStats {

    private double maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {

        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        int numberOfTop = 0;
        for (int point : results) {
            if (point > (1.0 * limitInPercent / 100) * maxPoints) {
                numberOfTop++;
            }
        }
        return numberOfTop;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {

        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        for (int point : results) {
            if (point < (1.0 * limitInPercent / 100) * maxPoints) {
                return true;
            }
        }
        return false;
    }
}
