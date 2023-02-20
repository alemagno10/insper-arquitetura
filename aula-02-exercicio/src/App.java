import User.User;
import Mensagem.Mensagem;

public class App {
    public static void main(String[] args) throws Exception {
        User ale = new User("alexandre magno", "alemagno03@gmail.com", "alemagno");
        User tom = new User("thomas chiari", "tchiari@gmail.com", "thomaschiari");
        User edu = new User("eduardo barros", "eduburrodms@gmail.com", "edu.sbarros");
        User leo = new User("leo scarlato", "leozao@gmail.com", "leoscarlato");

        ale.post("Gol do curintia!");
        edu.like(ale.getPost(0));

        ale.post("1 x 1");
        tom.like(ale.getPost(1));

        tom.post("Dia no parque!", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/how-to-keep-ducks-call-ducks-1615457181.jpg?crop=0.669xw:1.00xh;0.166xw,0&resize=1200:*");
        ale.like(tom.getPost(0));
        edu.like(tom.getPost(0));

        leo.post("We go gym!");
        ale.like(leo.getPost(0));
        tom.like(leo.getPost(0));
        edu.like(leo.getPost(0));

        for (Mensagem msg : Mensagem.feed) {
            System.out.println("");
            System.out.println(msg.toString());
        }
    }
}
