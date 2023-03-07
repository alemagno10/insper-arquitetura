package insper.msg.Mensagem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private List<Mensagem> messages = new ArrayList<>();

    public List<Mensagem> allMessages(){
        return messages;
    }

    public Mensagem saveMessage(Mensagem m){
        m.setId(UUID.randomUUID().toString());
        messages.add(m);
        return m;
    }
}
