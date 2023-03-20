package insper.msgDB.Mensagem;
import insper.msgDB.User.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class MensagemTexto extends Mensagem{
    public MensagemTexto(User user, String content) {
        super(user, new Date(), content);
    }   
}
