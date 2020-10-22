package byteacount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteCheckerTest {
    ByteChecker byteChecker = new ByteChecker();



    @Test
    public void readBytesAndFindAsTest(){

        assertEquals(129,byteChecker.readBytesAndFindAs("data.dat"));
    }
}
