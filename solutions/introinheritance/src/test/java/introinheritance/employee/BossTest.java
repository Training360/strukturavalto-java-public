package introinheritance.employee;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BossTest {

    @Test
    public void testCreateBoss() {
        Boss boss = new Boss("John Doe", "1117 Budapest, Budafoki út 56.", 500_000, 3);

        assertThat(boss.getName(), equalTo("John Doe"));
        assertThat(boss.getAddress(), equalTo("1117 Budapest, Budafoki út 56."));
        assertThat(boss.getSalary(), equalTo(650_000.0));
        assertThat(boss.getNumberOfEmployees(), equalTo(3));
    }

    @Test
    public void testCreateBigBoss() {
        BigBoss boss = new BigBoss("John Doe", "1117 Budapest, Budafoki út 56.", 1_000_000, 6, 200_000);

        assertThat(boss.getName(), equalTo("John Doe"));
        assertThat(boss.getAddress(), equalTo("1117 Budapest, Budafoki út 56."));
        assertThat(boss.getSalary(), equalTo(1_800_000.0));
        assertThat(boss.getNumberOfEmployees(), equalTo(6));
    }
}
