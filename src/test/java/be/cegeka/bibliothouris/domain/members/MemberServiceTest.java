package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

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
       Member member = new Member("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");
       // memberService.addMember("1",null,"Xan", "Schoolstraat", "78", "1745", "Opwijk");

        String expected= "Please fill in last name.";
      // Assertions.assertThat(expected).isEqualTo(memberService.addMember());
    }


}
