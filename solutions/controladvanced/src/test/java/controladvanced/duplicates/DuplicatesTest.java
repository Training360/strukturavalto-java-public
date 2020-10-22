package controladvanced.duplicates;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DuplicatesTest {

    @Test
    public void findDuplicates() {
        assertThat(new Duplicates().find(Arrays.asList()), equalTo(Arrays.asList()));
        assertThat(new Duplicates().find(Arrays.asList(1, 2, 3)), equalTo(Arrays.asList()));
        assertThat(new Duplicates().find(Arrays.asList(1, 2, 2, 3)), equalTo(Arrays.asList(2)));
        assertThat(new Duplicates().find(Arrays.asList(1, 2, 2, 3, 3, 4)), equalTo(Arrays.asList(2, 3)));
        assertThat(new Duplicates().find(Arrays.asList(1, 2, 3, 3, 3, 4)), equalTo(Arrays.asList(3, 3)));
        assertThat(new Duplicates().find(Arrays.asList(1, 2, 2, 3, 3, 3, 4)), equalTo(Arrays.asList(2, 3, 3)));

    }
}
