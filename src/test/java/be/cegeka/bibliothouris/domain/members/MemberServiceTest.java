package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.swing.*;

/**
 * Created by xanv on 26/01/2017.
 */
public class MemberServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    public void addMember_ShouldCallMemberRepository(){
        memberService.addMember("1","Vranckaert","Xan", "Schoolstraat", "78", "1745", "Opwijk");

        Mockito.verify(memberRepository).addMember(new Member("1","Vranckaert","Xan", "Schoolstraat", "78", "1745", "Opwijk"));
    }

    @Test
    public void addMemberWithoutLastName_SHouldReturnLastNameMessage(){
       //Member member = new Member("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");
       // memberService.addMember("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");

       String expected= "Please fill in: last name ";
       Assertions.assertThat(memberService.addMember("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk")).isEqualTo(expected);
    }
    @Test
    public void addMemberWithoutINSZ_SHouldReturnINSZMessage(){
       // Member member = new Member("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");
        // memberService.addMember("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");

        String expected= "Please fill in: INSZ";
        Assertions.assertThat(memberService.addMember(null,"Vranckaert","Xan", "Schoolstraat", "78", "1745", "Opwijk")).isEqualTo(expected);
    }

    @Test
    public void addMemberWithoutCityAndINSZ_SHouldReturnCityAndINSZMessage(){
       // Member member = new Member("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");
        // memberService.addMember("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");

        String expected= "Please fill in: city INSZ";
        Assertions.assertThat(memberService.addMember(null,"Vranckaert","Xan", "Schoolstraat", "78", "1745", null)).isEqualTo(expected);
    }
}
