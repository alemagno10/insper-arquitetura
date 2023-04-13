package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String identifier;
    @NonNull
    private Integer scoreHome;
    @NonNull
    private Integer scoreAway;

    @ManyToOne
    @JoinColumn(name = "id_home")
    private Team home;

    @ManyToOne
    @JoinColumn(name = "id_away")
    private Team away;

    @NonNull
    private Integer attendance;

    @NonNull
    private LocalDateTime gameDate;

    @NonNull
    private String status;

}
