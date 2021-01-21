package byteacount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteCheckerTest {

    ByteChecker byteChecker = new ByteChecker();

    @Test
    public void readBytesAndFindAsTest() {
        assertEquals(116, byteChecker.readBytesAndFindAs("data.dat"));
    }
}
