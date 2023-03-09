package insper.msg.User;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> allUsers(){
        return users;
    }

    public User getUser(String id){
        for (User u : users) {
            if(id.equals(u.getId())){
                return u;
            }
        }
        throw new RuntimeException("Usuario nao encontrado! ");
    }

    public User saveUser(User u){
        u.setId(UUID.randomUUID().toString());
        users.add(u);
        return u;
    }
}
