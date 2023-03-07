package insper.msg.Mensagem;
import insper.msg.User.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class MensagemArquivo extends Mensagem{
    private String fileUrl;

    public MensagemArquivo(User user, String content, String url) {
        super(user, new Date(), content);
        this.fileUrl = url;
    }
}
