package lambdaoptional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


public class SocialNetworkTest {

    @Test
    public void testCreateMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        assertEquals("John Doe", member.getName());
        assertEquals(Arrays.asList("Java", "OOP"), member.getSkills());
        assertEquals(Sex.MALE, member.getGender());
    }

    @Test
    public void testFindFirst() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Sex.MALE)
        ));

        assertFalse(socialNetwork.findFirst(m -> m.getName().equals("Joe")).isPresent());

        assertTrue(socialNetwork.findFirst(m -> m.getName().equals("John Doe")).isPresent());
        assertEquals("John Doe", socialNetwork.findFirst(m -> m.getName().equals("John Doe")).get().getName());
    }

    @Test
    public void testAvg() {
        assertEquals(false, new SocialNetwork(Collections.emptyList()).averageNumberOfSkills().isPresent());

        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Sex.MALE)
        ));


        assertEquals(2.25, socialNetwork.averageNumberOfSkills().get());
    }
}
