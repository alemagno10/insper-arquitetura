package insper.oneFootball.Match;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import insper.oneFootball.Team.Team;
import insper.oneFootball.Team.TeamService;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamService teamService;

    public Page<Match> allMatches(String home, String away, Pageable pageable){
        if(home != null && away != null){
            Team tHome = teamService.getTeam(home);
            Team tAway = teamService.getTeam(away);
            return matchRepository.findByHomeAndAway(tHome, tAway, pageable);
        }
        return matchRepository.findAll(pageable);
    }

    public Match getMatch(String identifier){
        return matchRepository.findbyIdentifier(identifier);
    }

    public Match save(Match M){
        M.setHome(teamService.getTeam(M.getHome().getIdentifier()));
        M.setAway(teamService.getTeam(M.getAway().getIdentifier()));
        M.setIdentifier(UUID.randomUUID().toString());
        matchRepository.save(M);
        return M;
    }

    public Match edit(Match M, String Identifier){
        Match match = getMatch(Identifier);
        match.setCrowd(M.getCrowd());
        match.setHomeScore(M.getHomeScore());
        match.setAwayScore(M.getAwayScore());
        match.setMvp(M.getMvp());
        return match;
    }
}
