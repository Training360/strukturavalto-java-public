package exceptions.polinom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {


    @Test
    public void constructorDoubleNullParameterShouldThrowException() throws Exception {
        double[] coefficients = null;

        Exception ex = assertThrows(NullPointerException.class, () -> new Polynomial(coefficients));
        assertEquals("coefficients is null", ex.getMessage());
    }

    @Test
    public void constructorStringNullParameterShouldThrowException() throws Exception {
        String[] coefficients = null;

        Exception ex = assertThrows(NullPointerException.class, () -> new Polynomial(coefficients));
        assertEquals("coefficientStrs is null", ex.getMessage());


    }

    @Test
    public void constructorStringInvalidCoefficientShouldThrowException() throws Exception {
        String[] coefficientStrs = new String[]{"a", "1", "2"};

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Polynomial(coefficientStrs));
        assertEquals("Illegal coefficients, not a number", ex.getMessage());
        assertEquals("For input string: \"a\"", ex.getCause().getMessage());
    }

    @Test
    public void constructorStringShouldConvert() throws Exception {
        String[] coefficientStrs = new String[]{"1", "2", "2"};

        Polynomial polynomial = new Polynomial(coefficientStrs);

        double[] expected = new double[]{1, 2, 2};
        assertArrayEquals(expected, polynomial.getCoefficients());
    }

    @Test
    public void evaluate() throws Exception {
        Polynomial p = new Polynomial(new double[]{1, 2, 3});
        double x = 1;
        assertEquals(x * x + 2 * x + 3, p.evaluate(x));

        x = 2;
        assertEquals(x * x + 2 * x + 3, p.evaluate(x));

        x = -2;
        assertEquals(x * x + 2 * x + 3, p.evaluate(x));

        Polynomial p2 = new Polynomial(new double[]{1, 1, 0, 1});
        x = 3;
        assertEquals(x * x * x + x * x + 1, p2.evaluate(x));
    }

}