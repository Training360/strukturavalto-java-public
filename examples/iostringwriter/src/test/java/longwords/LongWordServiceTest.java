package longwords;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongWordServiceTest {


    LongWordService  longWordService = new LongWordService();



    @Test
    public void writeWithStringWriterTest(){
        List<String> testWords = List.of("Pseudopseudohypoparathyroidism",
                                         "Supercalifragilisticexpialidocious",
                                         "Strengths");


        String s =longWordService.writeWithStringWriter(testWords);
        String[] testS = s.split("\n");
        assertEquals(3,testS.length);
        assertEquals(true,testS[1].contains("34"));
    }

}
