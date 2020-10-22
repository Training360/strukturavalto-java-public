package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    public void connect(String name, String anotherName) {
        Member first = findByName(name);
        try{
        first.connectMember(findByName(anotherName));
        }catch(NullPointerException npe){
           Logger.getAnonymousLogger().log(Level.SEVERE,"Cannot find first!",npe);
        }

    }

    private Member findByName(String name) {
        for (Member member: members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member member: members) {
            for (Member connectedMember : member.getConnections()) {
                if (connectedMember.getConnections().contains(member)) {
                    connections.add(member.getName() + " - " + connectedMember.getName());
                }
            }
        }
        return connections;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
