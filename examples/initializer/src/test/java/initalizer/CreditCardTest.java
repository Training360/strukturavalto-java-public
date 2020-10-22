package initalizer;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(card.getBalance(), equalTo(308_230L));
    }

    @Test
    public void testConstructorW1Parameter() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertThat(card.getBalance(), equalTo(100_000L));
    }

    @Test
    public void testPaymentW2ParametersSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertThat(card.payment(100, Currency.EUR), is(true));
        assertThat(card.getBalance(), equalTo(69177L));
    }

    @Test
    public void testPaymentW2ParametersFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertThat(card.payment(1000, Currency.EUR), is(false));
        assertThat(card.getBalance(), equalTo(100_000L));
    }

    @Test
    public void testPaymentW1ParameterSuccess() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertThat(card.payment(10_000), is(true));
        assertThat(card.getBalance(), equalTo(90_000L));
    }

    @Test
    public void testPaymentW1ParameterFail() {
        //Given
        CreditCard card = new CreditCard(100_000);
        //Then
        assertThat(card.payment(150_000), is(false));
        assertThat(card.getBalance(), equalTo(100_000L));
    }
}