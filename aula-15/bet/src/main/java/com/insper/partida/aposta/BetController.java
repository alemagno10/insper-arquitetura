package com.insper.partida.aposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import com.insper.partida.game.GameReturnDTO;

import java.util.List;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping
    public Bet createBet(@RequestBody Bet bet) {
        return betService.saveBet(bet);
    }

    @GetMapping
    public List<Bet> getBets() {
        return betService.listBets();
    }

    @PutMapping("/{betId}/verify")
    public Bet verifyBet(@PathVariable Integer betId) {
        return betService.verifyBet(betId);
    }

    @GetMapping("{id_partida}/partida")
    public List<Bet> getBetbyMatch(@PathVariable String id){
        return betService.getBetbyMatch(id);
    }
}
