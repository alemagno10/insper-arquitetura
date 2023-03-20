package insper.oneFootball.Match;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import insper.oneFootball.Team.Team;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
    Match findbyIdentifier(String identifier);
    Page<Match> findByHomeAndAway(Team home, Team away, Pageable pageable);
}
