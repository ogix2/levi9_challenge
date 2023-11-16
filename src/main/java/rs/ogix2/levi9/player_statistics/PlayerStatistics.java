package rs.ogix2.levi9.player_statistics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.ogix2.levi9.model.Player;

@Getter
@Setter
@NoArgsConstructor
public class PlayerStatistics {
    private String playerName;
    private int gamesPlayed;
    private TraditionalStatistics traditional;
    private AdvancedStatistics advanced;

    public PlayerStatistics(String playerName){
        this.playerName = playerName;
        this.traditional = new TraditionalStatistics();
        this.advanced = new AdvancedStatistics();
    }

    public void update(Player player){
        
        this.gamesPlayed++;

        traditional.update(player);
    }

    public void callAfterInjectingData(){

        this.calcAverage();
        this.updateAdvanced();
        this.roundToOneDecimal();
    }

    private void calcAverage(){

        traditional.calcAverage(this.gamesPlayed);
    }

    private void updateAdvanced(){

        advanced.update(traditional);
    }

    private void roundToOneDecimal(){

        traditional.roundToOneDecimal();
        advanced.roundToOneDecimal();

    }
}
