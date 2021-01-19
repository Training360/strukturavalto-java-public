package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;

    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... skillParams) {
        for (String skillParam: skillParams) {
            String name = skillParam.substring(0, skillParam.indexOf("(") - 1).trim();
            int level = Integer.parseInt(skillParam.substring(skillParam.indexOf("(") + 1, skillParam.indexOf(")")));
            Skill skill = new Skill(name, level);
            skills.add(skill);
        }
    }

    public int findSkillLevelByName(String name) {
        for (Skill skill: skills) {
            if (skill.getName().equals(name)) {
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException("Skill not found: " + name);
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
