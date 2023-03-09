package insper.msg.User;

import lombok.*;
import java.util.*;
import insper.msg.Mensagem.Mensagem;

@Getter
@Setter
public class User {
    private String name;
    private String email;
    private String username;
    private String id;
    private List<String>timeline;

    public User(String name, String email, String username) {  
        this.name = name;
        this.email = email;
        this.username = username;
        this.timeline = new ArrayList<>();
    }

    public void updateTimeline(String m){
        timeline.add(m);
    }

    public void deletePost(int index){
        timeline.remove(index);
    }

    public void like(Mensagem msg){
        msg.like(this);
    }

    public void dislike(Mensagem msg){
        msg.dislike(this);
    }

    public String toString(){
        return this.username;
    }
}
