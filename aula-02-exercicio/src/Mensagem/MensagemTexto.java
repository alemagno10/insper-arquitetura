package Mensagem;
import User.User;
import java.util.Date;

public class MensagemTexto extends Mensagem{

    public MensagemTexto(User user, String content) {
        super(user, new Date(), content);
    }
    
}
