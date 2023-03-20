package insper.msgDB.Mensagem;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import insper.msgDB.User.UserService;
import insper.msgDB.User.User;

@Service
public class MensagemService {

    @Autowired
    private UserService userService;
    @Autowired
    private MensagemRepository mensagemRepository;

    public List<Mensagem> allMessages(){
        return mensagemRepository.findAll();
    }

    public List<Mensagem> userMessages(String id){
        User u = userService.getUser(id);
        return u.getTimeline();
    }

    public Mensagem idMessage(String identifier){
        Mensagem msg = mensagemRepository.findByIdentifier(identifier);
        if(msg == null){
            throw new RuntimeException("Mensagem não encontrada");
        } else {
            return msg;
        }
    }

    private Mensagem post(User u, Mensagem msg){
        msg.setIdentifier(UUID.randomUUID().toString());
        u.updateTimeline(msg);
        mensagemRepository.save(msg);
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
