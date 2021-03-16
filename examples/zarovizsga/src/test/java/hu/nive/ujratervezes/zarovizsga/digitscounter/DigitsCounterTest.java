package hu.nive.ujratervezes.zarovizsga.digitscounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsCounterTest {

    @Test
    void getCountOfDigits() {
        DigitsCounter digitsCounter = new DigitsCounter();

        assertEquals(0, digitsCounter.getCountOfDigits(null));
        assertEquals(0, digitsCounter.getCountOfDigits(""));
        assertEquals(1, digitsCounter.getCountOfDigits("1"));
        assertEquals(2, digitsCounter.getCountOfDigits("111112222"));
        assertEquals(3, digitsCounter.getCountOfDigits("1212123123123123"));
        assertEquals(3, digitsCounter.getCountOfDigits("12asd 12ewr1q2breg31 rw23123123"));
    }
}