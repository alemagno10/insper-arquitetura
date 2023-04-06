package com.insper.partida.aposta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamController;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.game.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BetControllerTests {

    MockMvc mockMvc;

    @InjectMocks
    BetController betController;

    @Mock
    BetService betService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(betController)
                .build();
    }

    private static Bet getBet(){
        Bet bet = new Bet();
        bet.setId(1);
        bet.setGame(getGame());
        return bet;
    }

    private static Game getGame(){
        Game g = new Game();
        return g;
    }

    @Test
    void test_listBets() throws Exception {
        Bet b = getBet();

        List<Bet> bets = new ArrayList<>();
        bets.add(b);

        Mockito.when(betService.listBets()).thenReturn(bets);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/bet"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(bets), resp);
    }

    @Test
    void test_createBets() throws Exception {
        
    }

    @Test
    void test_verifyBets() throws Exception {

    }
}
