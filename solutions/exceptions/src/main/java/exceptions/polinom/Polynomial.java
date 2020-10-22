package exceptions.polinom;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null)
            throw new NullPointerException("coefficientStrs is null");
        try {
            this.coefficients = convertCoefficientStrs(coefficientStrs);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
        }
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x,(double)n - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    private double[] convertCoefficientStrs(String[] coefficientStrs) {
        double[] coefficients = new double[coefficientStrs.length];
        for (int j = 0; j < coefficientStrs.length; j++) {
            coefficients[j] = Double.parseDouble(coefficientStrs[j]);
        }
        return coefficients;
    }

}
