package insper.oneFootball.Team;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> allTeams(){
        return teamService.allTeams();
    }

    @PostMapping
    public Team save(@RequestBody Team T){
        teamService.save(T);
        return T;
    }
}
