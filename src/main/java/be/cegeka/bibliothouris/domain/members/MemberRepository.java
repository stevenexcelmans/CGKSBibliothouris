package be.cegeka.bibliothouris.domain.members;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public List<Member> getAllMembers() {
        return members;
    }


    public void addMember(Member member) {
        members.add(member);

    }
    public List<Member> searchMemberINSZ(String partialINSZ) {
        partialINSZ = partialINSZ.replaceAll("\\*", "[0-9]*-?[0-9]*");
        List<Member> membersWithPartialINSZ = new ArrayList<>();
        for (Member member : members) {
            if (member.getINSZ().matches(partialINSZ)) {
                membersWithPartialINSZ.add(member);
            }
        }
        return membersWithPartialINSZ;
    }


}