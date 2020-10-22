package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;

    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectMember(Member member) {
        connections.add(member);
    }

    private List<String> connectedNames() {
        List<String> connectedNames = new ArrayList<>();
        for (Member member: connections) {
            connectedNames.add(member.getName());
        }
        return connectedNames;
    }

    public List<Member> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return name + " " + connectedNames();
    }
}
