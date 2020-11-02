package lambdaintro;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SocialNetworkTest {

    @Test
    public void createMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        assertEquals("John Doe", member.getName());
        assertEquals(Arrays.asList("Java", "OOP"), member.getSkills());
        assertEquals(Sex.MALE, member.getGender());
        assertEquals(0, member.getMessages().size());
    }

    @Test
    public void testSendMessage() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        member.sendMessage("Hello!");
        member.sendMessage("Dear John!");

        assertEquals(Arrays.asList("Hello!", "Dear John!"), member.getMessages());
    }

    @Test
    public void testFindMembersBy() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Sex.MALE)
        ));

        List<Member> found = socialNetwork.findMembersBy(m -> m.getSkills().contains("Java"));
        assertEquals(2, found.size());
        assertEquals("John Doe", found.get(0).getName());
        assertEquals("James Doe", found.get(1).getName());
    }

    @Test
    public void testApplyToSelectedMembers() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP", "db"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting", "db"), Sex.FEMALE),
                new Member("Jenifer Doe", Arrays.asList("C", "C++", "ASM"), Sex.FEMALE)
        ));

        socialNetwork.applyToSelectedMembers(
                m -> m.getGender() == Sex.FEMALE && m.getSkills().contains("db"),
                m -> m.sendMessage("Dear " + m.getName() + "!"));

        assertEquals("Dear Jane Doe!", socialNetwork.findMembersBy(m -> m.getName().equals("Jane Doe")).get(0).getMessages().get(0));
        assertEquals("Dear Janet Doe!", socialNetwork.findMembersBy(m -> m.getName().equals("Janet Doe")).get(0).getMessages().get(0));
        assertEquals(0, socialNetwork.findMembersBy(m -> m.getName().equals("Jenifer Doe")).get(0).getMessages().size());
    }

    @Test
    public void testTransformMembers() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP", "db"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE)));
        List<String> names = socialNetwork.transformMembers(Member::getName);
        assertEquals(3, names.size());
        assertEquals("John Doe", names.get(0));
        assertEquals("James Doe", names.get(2));
    }
}
