package insper.oneFootball.Team;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> allTeams(){
        return teamRepository.findAll();
    }

    public Team getTeam(String identifier){
        return teamRepository.findbyIdentifier(identifier);
    }

    public Team save(Team T){
        teamRepository.save(T);
        return T;
    }
}
