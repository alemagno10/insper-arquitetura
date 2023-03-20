package insper.msgDB.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public List<Mensagem> allMessages(){
        return mensagemService.allMessages();
    }

    @GetMapping("/{userId}/user")
    public List<Mensagem> userMessages(@PathVariable String userId){
        return mensagemService.userMessages(userId);
    }

    @GetMapping("/{mensagemId}")
    public Mensagem idMessage(@PathVariable String mensagemId){
        return mensagemService.idMessage(mensagemId);
    }

    @PostMapping("/Text")
    public Mensagem textMessage(@RequestBody Map<String,String> data){
        return mensagemService.postText(data);
    }

    @PostMapping("/Arquivo")
    public Mensagem archiveMessage(@RequestBody Map<String,String> data){
        return mensagemService.postArchive(data);
    }
}
