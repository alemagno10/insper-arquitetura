package insper.msg.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import insper.msg.Mensagem.Mensagem;
import insper.msg.Mensagem.MensagemArquivo;
import insper.msg.Mensagem.MensagemTexto;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.allUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User u){
        return userService.saveUser(u);
    }

    @PostMapping("/post")
    public List<Mensagem> postMessage(@RequestParam String userId, @RequestBody MensagemTexto m){
        return userService.postMessage(userId, m);
    }

    @PostMapping("/post/1")
    public List<Mensagem> postMessage(@RequestParam String userId, @RequestBody MensagemArquivo m){
        return userService.postMessage(userId, m);
    }
}
