package com.insper.partida.game.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class GameReturnDTO {
    private String identifier;
    private Integer scoreHome;
    private Integer scoreAway;
    private Integer attendance;
    private LocalDateTime gameDate;
    private String status;

    private static GameReturnDTO convert(Game game){
        
    }
}
