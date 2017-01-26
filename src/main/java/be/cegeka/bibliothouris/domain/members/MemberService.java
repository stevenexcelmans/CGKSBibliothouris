package be.cegeka.bibliothouris.domain.members;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.*;
import java.util.List;

@Named
public class MemberService {

    @Inject
    private MemberRepository memberRepository = new MemberRepository();

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    public void addMember(String INSZ, String lastName, String firstName, String street, String number, String postalCode, String city) {
        if (lastName == null) {
            JOptionPane.showMessageDialog(null, "Please fill in last name.");
        }
        if (city == null) {
            JOptionPane.showMessageDialog(null, "Please fill in city.");
        }
        if (INSZ == null) {
            JOptionPane.showMessageDialog(null, "Please fill in INSZ.");
        } else {
            memberRepository.addMember(new Member(INSZ, lastName, firstName, street, number, postalCode, city));
        }

    }
}