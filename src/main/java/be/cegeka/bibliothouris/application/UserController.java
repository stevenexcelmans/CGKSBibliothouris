package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.members.MemberService;
import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public

    @ResponseBody
    void addUser(@RequestParam(value = "name", required = true) String name) {
        userService.addUser(name);
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public
    @ResponseBody
    void addMember(
            @RequestParam(value = "INSZ", required = true) String INSZ,
            @RequestParam(value = "last name", required = true) String lastName,
            @RequestParam(value = "first name") String firstName,
            @RequestParam(value = "street") String street,
            @RequestParam(value = "number") String number,
            @RequestParam(value = "postal code") String postalCode,
            @RequestParam(value = "city", required = true) String city) {
        memberService.addMember(INSZ, lastName, firstName, street, number, postalCode, city);
    }
}

