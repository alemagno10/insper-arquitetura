package insper.msg.User;

import java.util.*;
import org.springframework.stereotype.Service;
import insper.msg.Mensagem.Mensagem;

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
        return null;
    }

    public User saveUser(User u){
        u.setId(UUID.randomUUID().toString());
        users.add(u);
        return u;
    }

    public List<Mensagem> postMessage(String userId, Mensagem m){
        User u = getUser(userId);
        m.setId(UUID.randomUUID().toString());
        u.post(m);
        return u.getTimeline(); 
    }
}
