package clone;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuctionTest {

    @Test
    public void testClone() {
        Auction auction = new Auction(5, LocalDateTime.parse("2018-01-01T12:00"),
                new User("Joe"),
                new Product("Computer")
        );

        Auction another = new Auction(auction);

        assertEquals(5, another.getPrice());
        assertEquals(LocalDateTime.parse("2018-01-01T12:00"), another.getStart());
        assertEquals("Joe", another.getUser().getName());
        assertEquals("Computer", another.getProduct().getName());
        auction.setPrice(10);
        auction.setStart(LocalDateTime.parse("2018-01-01T15:00"));
        auction.getUser().setName("Jack");
        auction.getProduct().setName("Computer2");
        assertEquals(10, auction.getPrice());
        assertEquals(LocalDateTime.parse("2018-01-01T15:00"), auction.getStart());
        assertEquals("Jack", auction.getUser().getName());
        assertEquals("Computer2", auction.getProduct().getName());

        assertEquals(5, another.getPrice());
        assertEquals(LocalDateTime.parse("2018-01-01T12:00"), another.getStart());
        assertEquals("Jack", another.getUser().getName());
        assertEquals("Computer", another.getProduct().getName());
    }
}
