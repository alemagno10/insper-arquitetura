package insper.oneFootball.Match;

import insper.oneFootball.Team.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identifier;
    private Integer homeScore;
    private Integer awayScore;
    private Integer crowd;
    private String mvp;

    @ManyToOne
    private Team home;
    @ManyToOne
    private Team away;
}
