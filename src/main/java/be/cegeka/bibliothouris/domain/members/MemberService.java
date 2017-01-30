package be.cegeka.bibliothouris.domain.members;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.util.List;

@Named
public class MemberService {

    @Inject
    private MemberRepository memberRepository = new MemberRepository();

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    public String addMember(String INSZ, String lastName, String firstName, String street, String number, String postalCode, String city) {
        StringBuilder errorMessage = new StringBuilder("Please fill in: ");
        if (lastName == null) {
            errorMessage.append("last name ");
        }
        if (city == null) {
            errorMessage.append("city ");
        }
        if (INSZ == null) {
            errorMessage.append("INSZ");
        } else {
            memberRepository.addMember(new Member(INSZ, lastName, firstName, street, number, postalCode, city));
        }
        return errorMessage.toString();

    }

}