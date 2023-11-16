package rs.ogix2.levi9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import rs.ogix2.levi9.model.Player;
import rs.ogix2.levi9.player_statistics.PlayerStatistics;
import rs.ogix2.levi9.repository.PlayerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private ResourceLoader resourceLoader;

    public void loadCsvData(String resourcePath) {

        Resource resource = resourceLoader.getResource("classpath:" + resourcePath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            br.readLine(); // Preskočiti zaglavlje

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                Player stats = new Player();
                stats.setPlayerName(fields[0]);
                stats.setPosition(fields[1]);
                stats.setFtm(Integer.parseInt(fields[2]));
                stats.setFta(Integer.parseInt(fields[3]));
                stats.setTwopm(Integer.parseInt(fields[4]));
                stats.setTwopa(Integer.parseInt(fields[5]));
                stats.setThreepm(Integer.parseInt(fields[6]));
                stats.setThreepa(Integer.parseInt(fields[7]));
                stats.setReb(Integer.parseInt(fields[8]));
                stats.setBlk(Integer.parseInt(fields[9]));
                stats.setAst(Integer.parseInt(fields[10]));
                stats.setStl(Integer.parseInt(fields[11]));
                stats.setTov(Integer.parseInt(fields[12]));

                repository.save(stats);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getPlayerStatsByName(String name) {
        return repository.findByPlayerName(name);
    }

    public PlayerStatistics getStatisticsForPlayer(String name){

        List<Player> players = repository.findByPlayerName(name);

        if(players.size() == 0){
            return null;
        }

        PlayerStatistics playerStats = new PlayerStatistics(name);

        for(Player player : players){
            playerStats.update(player);
        }

        playerStats.callAfterInjectingData();

        return playerStats;
    }
}
