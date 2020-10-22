package lambdaintro;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SocialNetworkTest {

    @Test
    public void createMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        assertThat(member.getName(), equalTo("John Doe"));
        assertThat(member.getSkills(), equalTo(Arrays.asList("Java", "OOP")));
        assertThat(member.getGender(), equalTo(Sex.MALE));
        assertThat(member.getMessages().size(), equalTo(0));
    }

    @Test
    public void testSendMessage() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE);
        member.sendMessage("Hello!");
        member.sendMessage("Dear John!");

        assertThat(member.getMessages(), equalTo(Arrays.asList("Hello!", "Dear John!")));
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
        assertThat(found.size(), equalTo(2));
        assertThat(found.get(0).getName(), equalTo("John Doe"));
        assertThat(found.get(1).getName(), equalTo("James Doe"));
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
                m -> m.sendMessage("Dear " + m.getName() + "!") );

        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("Jane Doe")).get(0).getMessages().get(0), equalTo("Dear Jane Doe!"));
        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("Janet Doe")).get(0).getMessages().get(0), equalTo("Dear Janet Doe!"));
        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("Jenifer Doe")).get(0).getMessages().size(), equalTo(0));
    }

    @Test
    public void testTransformMembers() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Sex.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP", "db"), Sex.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Sex.MALE)));
        List<String> names = socialNetwork.transformMembers(Member::getName);
        assertThat(names.size(), equalTo(3));
        assertThat(names.get(0), equalTo("John Doe"));
        assertThat(names.get(2), equalTo("James Doe"));
    }
}
