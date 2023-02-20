package Mensagem;
import User.User;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Mensagem {
    public static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    public static ArrayList<Mensagem> feed = new ArrayList<Mensagem>();
    protected User user;
    protected Date creationDate;
    protected String content;
    protected ArrayList<User> likes;

    public Mensagem(User user, Date creationDate, String content) {
        this.user = user;
        this.creationDate = creationDate;
        this.content = content;
        this.likes = new ArrayList<User>();
        Mensagem.feed.add(this);
    }

    public void like(User u){
        if(likes.indexOf(u) == -1){
            this.likes.add(u);
        }
    }

    public void dislike(User u){
        if(likes.indexOf(u) != -1){
            this.likes.remove(u);
        }
    }

    public String toString(){
        return user.getUsername()+": "+content+"\n"+
        "Likes: "+likes.size()+". Posted: "+df.format(creationDate)+"\n"+
        "Liked by: "+likes.toString();
    }

    public User getUser() {return user;}
    public Date getCreationDate() {return creationDate;}
    public String getContent() {return content;}
    public ArrayList<User> getLikes() {return likes;}
}
