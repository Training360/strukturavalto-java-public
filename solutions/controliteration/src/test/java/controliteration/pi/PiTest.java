package controliteration.pi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PiTest {

    @Test
    public void getPi() {
        assertEquals("3.141592653589793238462643383279", new PiGenerator().getPi());
    }
}
