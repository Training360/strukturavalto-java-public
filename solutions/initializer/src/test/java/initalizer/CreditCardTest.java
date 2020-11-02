package initalizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class CreditCardTest {

    public final Rate[] rates = {new Rate(Currency.HUF, 1.0),
            new Rate(Currency.EUR, 308.23),
            new Rate(Currency.SFR, 289.24),
            new Rate(Currency.GBP, 362.23),
            new Rate(Currency.USD, 289.77)};

//        ACTUAL_RATES.add(new Rate(Currency.HUF, 1.0));
//        ACTUAL_RATES.add(new Rate(Currency.EUR, 308.23));
//        ACTUAL_RATES.add(new Rate(Currency.SFR, 289.24));
//        ACTUAL_RATES.add(new Rate(Currency.GBP, 362.23));
//        ACTUAL_RATES.add(new Rate(Currency.USD, 289.77));
//    }


    @Test
    public void testConstructorW3Parameters() {
        //Given
        CreditCard card = new CreditCard(1000, Currency.EUR, Arrays.asList(rates));
        //Then
        assertEquals(308_230L, card.getBalance());
    }

    @Test
    public void testConstructorW1Parameter() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertEquals(100_000L, card.getBalance());
    }

    @Test
    public void testPaymentW2ParametersSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertTrue(card.payment(100, Currency.EUR));
        assertEquals(69177L, card.getBalance());
    }

    @Test
    public void testPaymentW2ParametersFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertFalse(card.payment(1000, Currency.EUR));
        assertEquals(100_000L, card.getBalance());
    }

    @Test
    public void testPaymentW1ParameterSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertTrue(card.payment(10_000));
        assertEquals(90_000L, card.getBalance());
    }

    @Test
    public void testPaymentW1ParameterFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertFalse(card.payment(150_000));
        assertEquals(100_000L, card.getBalance());
    }
}