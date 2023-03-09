package insper.msg.Mensagem;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import insper.msg.User.UserService;
import insper.msg.User.User;

@Service
public class MensagemService {

    @Autowired
    private UserService userService;
    private List<Mensagem> messages = new ArrayList<>();

    public List<Mensagem> allMessages(){
        return messages;
    }

    public List<Mensagem> userMessages(String id){
        List<Mensagem> msg = new ArrayList<>();
        User u = userService.getUser(id);
        for (String m : u.getTimeline()) {
            msg.add(idMessage(m));
        }
        return msg;
    }

    public Mensagem idMessage(String id){
        for (Mensagem m : messages) {
            if(m.getId().equals(id)){
                return m;
            }
        }
        throw new RuntimeException("Mensagem não encontrada.");
    }

    private Mensagem post(User u, Mensagem msg){
        msg.setId(UUID.randomUUID().toString());
        u.updateTimeline(msg.getId());
        messages.add(msg);
        return msg;
    }

    public Mensagem postText(Map<String,String> data){
        User u = userService.getUser(data.get("userId"));
        Mensagem msg = new MensagemTexto(u, data.get("content"));
        return post(u, msg);
    }

    public Mensagem postArchive(Map<String,String> data){
        User u = userService.getUser(data.get("userId"));
        Mensagem msg = new MensagemArquivo(u, data.get("content"), data.get("url"));
        return post(u, msg);
    }
}
