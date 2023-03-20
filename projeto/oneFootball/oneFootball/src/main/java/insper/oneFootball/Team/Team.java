package insper.oneFootball.Team;

import java.util.*;
import insper.oneFootball.Match.Match;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter 
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identifier;
    private String name;
    private String Stadium;

    @OneToMany
    private List<Match> homeMatches;
    @OneToMany
    private List<Match> awayMatches;
}
