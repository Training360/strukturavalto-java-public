package lambdaoptional;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SocialNetworkTest {

    @Test
    public void testCreateMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        assertThat(member.getName(), equalTo("John Doe"));
        assertThat(member.getSkills(), equalTo(Arrays.asList("Java", "OOP")));
        assertThat(member.getGender(), equalTo(Sex.MALE));
    }

    @Test
    public void testFindFirst() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Sex.MALE)
        ));

        assertThat(socialNetwork.findFirst(m -> m.getName().equals("Joe")).isPresent(), equalTo(false));

        assertThat(socialNetwork.findFirst(m -> m.getName().equals("John Doe")).isPresent(), equalTo(true));
        assertThat(socialNetwork.findFirst(m -> m.getName().equals("John Doe")).get().getName(), equalTo("John Doe"));
    }

    @Test
    public void testAvg() {
        assertThat(new SocialNetwork(Collections.emptyList()).averageNumberOfSkills().isPresent(), equalTo(false));

        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Sex.MALE)
        ));


        assertThat(socialNetwork.averageNumberOfSkills().get(), equalTo(2.25));
    }
}
