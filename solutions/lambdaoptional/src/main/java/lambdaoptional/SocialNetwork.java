package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        for (Member member: members) {
            if (predicate.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.isEmpty()) {
            return Optional.empty();
        }
        int sum = 0;
        for (Member member: members) {
            sum += member.getSkills().size();
        }
        return Optional.of(sum / (double) members.size());
    }
}
