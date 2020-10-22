package clone;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AuctionTest {

    @Test
    public void testClone() {
        Auction auction = new Auction(5, LocalDateTime.parse("2018-01-01T12:00"),
                new User("Joe"),
                new Product("Computer")
        );

        Auction another = new Auction(auction);

        assertThat(another.getPrice(), equalTo(5));
        assertThat(another.getStart(), equalTo(LocalDateTime.parse("2018-01-01T12:00")));
        assertThat(another.getUser().getName(), equalTo("Joe"));
        assertThat(another.getProduct().getName(), equalTo("Computer"));
        auction.setPrice(10);
        auction.setStart(LocalDateTime.parse("2018-01-01T15:00"));
        auction.getUser().setName("Jack");
        auction.getProduct().setName("Computer2");
        assertThat(auction.getPrice(), equalTo(10));
        assertThat(auction.getStart(), equalTo(LocalDateTime.parse("2018-01-01T15:00")));
        assertThat(auction.getUser().getName(), equalTo("Jack"));
        assertThat(auction.getProduct().getName(), equalTo("Computer2"));

        assertThat(another.getPrice(), equalTo(5));
        assertThat(another.getStart(), equalTo(LocalDateTime.parse("2018-01-01T12:00")));
        assertThat(another.getUser().getName(), equalTo("Jack"));
        assertThat(another.getProduct().getName(), equalTo("Computer"));
    }
}
