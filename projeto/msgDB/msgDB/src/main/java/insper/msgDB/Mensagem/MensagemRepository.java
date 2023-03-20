package insper.msgDB.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem,Integer>{
    Mensagem findByIdentifier(String id);
}
