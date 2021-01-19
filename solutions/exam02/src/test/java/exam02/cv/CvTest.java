package exam02.cv;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CvTest {

    @Test
    public void testCreateWithName() {
        Cv cv1 = new Cv("John Doe");
        assertEquals("John Doe", cv1.getName());
    }

    @Test
    public void testAddSkills() {
        Cv cv1 = new Cv("John Doe");
        assertEquals(0, cv1.getSkills().size());
        cv1.addSkills("programming (5)", "oo design (2)");
        assertEquals(2, cv1.getSkills().size());
        assertEquals("programming", cv1.getSkills().get(0).getName());
        assertEquals(5, cv1.getSkills().get(0).getLevel());
    }

    @Test
    public void testFindSkill() {
        Cv cv = new Cv("John Doe");
        cv.addSkills("programming (5)", "oo design (2)", "english (4)");
        assertEquals(2, cv.findSkillLevelByName("oo design"));
    }


    @Test
    public void testNotFoundSkill() {
        Cv cv1 = new Cv("John Doe");
        assertThrows(SkillNotFoundException.class,
                () -> cv1.findSkillLevelByName("programming"));

    }

}
