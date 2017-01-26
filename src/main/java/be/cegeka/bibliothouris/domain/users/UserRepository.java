package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.domain.members.Member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {
        @Inject
    Member member;


    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }



}
