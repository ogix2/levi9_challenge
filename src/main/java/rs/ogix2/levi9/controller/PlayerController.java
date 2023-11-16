package rs.ogix2.levi9.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ogix2.levi9.player_statistics.PlayerStatistics;
import rs.ogix2.levi9.service.PlayerService;

@RestController
@RequestMapping(path = "/stats/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostConstruct
    public void init() {
        playerService.loadCsvData("L9HomeworkChallengePlayersInput.csv");
    }
    

    @GetMapping("/{playerFullName}")
    public ResponseEntity<PlayerStatistics> getPlayerStatsByName(@PathVariable String playerFullName) {
        
        PlayerStatistics stats = playerService.getStatisticsForPlayer(playerFullName);
        if (stats == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}