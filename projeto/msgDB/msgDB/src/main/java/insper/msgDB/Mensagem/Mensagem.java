package insper.msgDB.Mensagem;
import java.util.Date;
import java.text.SimpleDateFormat;
import insper.msgDB.User.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    protected User user;
    protected Date creationDate;
    protected String content;
    protected String identifier;
    public static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    public Mensagem(User user, Date creationDate, String content) {
        this.creationDate = creationDate;
        this.content = content;
        this.user = user;
    }
}
