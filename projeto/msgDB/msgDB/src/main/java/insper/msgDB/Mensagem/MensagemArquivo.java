package insper.msgDB.Mensagem;
import insper.msgDB.User.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class MensagemArquivo extends Mensagem{
    private String fileUrl;
    public MensagemArquivo(User user, String content, String url) {
        super(user, new Date(), content);
        this.fileUrl = url;
    }
}
