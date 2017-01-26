package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;
    private MemberRepository memberRepository;
    private Member member;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String name) {
        userRepository.addUser(new User(counter.incrementAndGet(), name));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public List<Member> getShortDetailsAllMembers() {
        return memberRepository.getShortDetailsListMembers();
    }

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }
}
