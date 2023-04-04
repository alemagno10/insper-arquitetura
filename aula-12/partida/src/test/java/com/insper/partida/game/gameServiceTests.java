package com.insper.partida.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;

@ExtendWith(MockitoExtension.class)
public class gameServiceTests {
    @InjectMocks
    GameService gameService;

    @Mock
    TeamService teamService;

    @Mock
    GameRepository gameRepository;

    @Test   
    void test_listGamesWhenHomeAndAwayNotNull(){
        Team T1 = new Team(1,"time-1","time-1",null,null,null);
        Team T2 = new Team(2,"time-2","time-2",null,null,null);

        Mockito.when(teamService.getTeam("time-1")).thenReturn(T1);
        Mockito.when(teamService.getTeam("time-1")).thenReturn(T2);
        gameService.listGames("time-1", "time-2", null, null);

    }


}
