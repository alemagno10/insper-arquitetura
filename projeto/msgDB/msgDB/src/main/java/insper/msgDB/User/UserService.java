package insper.msgDB.User;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        User u = userRepository.findByIdentifier(id);
        if(u == null){
            throw new RuntimeException("Usuário não encontrado");
        } else {
            return u;
        }
    }

    public User saveUser(User u){
        u.setIdentifier(UUID.randomUUID().toString());
        userRepository.save(u);
        return u;
    }
}
