package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.game.dto.GameReturnDTO;
import com.insper.partida.game.dto.SaveGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamService teamService;

    public Page<Game> listGames(String home, String away, Integer attendance, Pageable pageable) {
        if (home != null && away != null) {

            Team tHome = teamService.getTeam(home);
            Team tAway = teamService.getTeam(away);

            return gameRepository.findByHomeAndAway(tHome, tAway, pageable);

        } else if (attendance != null) {
            return gameRepository.findByAttendanceGreaterThan(attendance, pageable);
        }
        return gameRepository.findAll(pageable);
    }

    public GameReturnDTO saveGame(SaveGameDTO saveGameDTO) {

        Team teamM = teamService.getTeam(saveGameDTO.getHome());
        Team teamV = teamService.getTeam(saveGameDTO.getAway());

        if (teamM == null || teamV == null) {
            return null;
        }

        Game game = new Game();
        game.setIdentifier(UUID.randomUUID().toString());
        game.setHome(teamM);
        game.setAway(teamV);    
        game.setAttendance(0);
        game.setScoreHome(0);
        game.setScoreAway(0);
        game.setGameDate(LocalDateTime.now());
        game.setStatus("SCHEDULED");

        gameRepository.save(game);
        return GameReturnDTO.covert(game);

    }

    public Game editGame(String identifier, Game game) {
        Game gameBD = gameRepository.findByIdentifier(identifier);

        gameBD.setScoreAway(game.getScoreAway());
        gameBD.setScoreHome(game.getScoreHome());
        gameBD.setAttendance(game.getAttendance());
        gameBD.setStatus("FINISHED");

        return gameRepository.save(gameBD);
    }

    public void deleteGame(String identifier) {
        Game gameBD = gameRepository.findByIdentifier(identifier);
        if (gameBD != null) {
            gameRepository.delete(gameBD);
        }
    }

    public Integer getScoreTeam(String identifier) {
        Team team = teamService.getTeam(identifier);

        return gameRepository.sumScoreTeamHome(team);
    }

    public Game getGame(String identifier) {
        return gameRepository.findByIdentifier(identifier);
    }
}
