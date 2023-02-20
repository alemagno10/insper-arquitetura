package User;
import java.util.ArrayList;

import Mensagem.Mensagem;
import Mensagem.MensagemTexto;
import Mensagem.MensagemArquivo;

public class User {
    private String name;
    private String email;
    private String username;
    private ArrayList<Mensagem>timeline;

    public User(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.timeline = new ArrayList<Mensagem>();
    }

    public void post(String content){
        timeline.add(new MensagemTexto(this, content));
    }

    public void post(String content, String url){
        timeline.add(new MensagemArquivo(this, content, url));
    }

    public Mensagem getPost(int index){
        return timeline.get(index);
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

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getUsername() {return username;}
    public void setUsername(String cpf) {this.username = cpf;}
    public ArrayList<Mensagem> getTimeline() {return timeline;}
}
