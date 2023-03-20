package insper.msgDB.User;

import lombok.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import insper.msgDB.Mensagem.Mensagem;
import jakarta.persistence.*;

@Getter
@Setter
@Entity(name="tb_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String username;
    private String identifier;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Mensagem> timeline;

    public User(String name, String email, String username) {  
        this.name = name;
        this.email = email;
        this.username = username;
        this.timeline = new ArrayList<>();
    }

    public void updateTimeline(Mensagem m){
        timeline.add(m);
    }

    public void deletePost(int index){
        timeline.remove(index);
    }

    public String toString(){
        return this.username;
    }
}
