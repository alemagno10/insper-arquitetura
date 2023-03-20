package insper.oneFootball.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;


@RestController
@RequestMapping("/partida")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping
    public Page<Match> allMatches(@RequestParam(required = false) String home,
                                  @RequestParam(required = false) String away,
                                  Pageable pageable){
        return matchService.allMatches(home, away, pageable);
    }

    @GetMapping("/{identifier}")
    public Match getMatch(@RequestParam String identifier){
        return matchService.getMatch(identifier);
    }

    @PostMapping
    public Match save(@RequestBody Match M){
        return matchService.save(M);
    }

    @PutMapping("/{identifier}")
    public Match edit(@RequestBody Match M, @RequestParam String Identifier){
        return matchService.edit(M,Identifier);
    }
}
