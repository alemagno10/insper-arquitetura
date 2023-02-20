package Mensagem;
import User.User;
import java.util.Date;

public class MensagemArquivo extends Mensagem{
    private String fileUrl;

    public MensagemArquivo(User user, String content, String url) {
        super(user, new Date(), content);
        this.fileUrl = url;
    }

}