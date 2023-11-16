package rs.ogix2.levi9.player_statistics;

import lombok.Getter;
import lombok.Setter;
import rs.ogix2.levi9.model.Player;

@Getter
@Setter
public class TraditionalStatistics {
    private IndividualStatistic freeThrows;
    private IndividualStatistic twoPoints;
    private IndividualStatistic threePoints;
    private double points;
    private double rebounds;
    private double blocks;
    private double assists;
    private double steals;
    private double turnovers;

    public TraditionalStatistics(){

        this.freeThrows = new IndividualStatistic();
        this.twoPoints = new IndividualStatistic();
        this.threePoints = new IndividualStatistic();
    }

    public void update(Player player){

        this.points += player.getFtm() + 2 * player.getTwopm() + 3 * player.getThreepm();
        this.rebounds += player.getReb();
        this.blocks += player.getBlk();
        this.assists += player.getAst();
        this.steals += player.getStl();
        this.turnovers += player.getTov();

        freeThrows.update(player.getFta(), player.getFtm());
        twoPoints.update(player.getThreepa(), player.getTwopm());
        threePoints.update(player.getThreepa(), player.getThreepm());
    }

    public void calcAverage(int gamesPlayed){
        
        this.points = this.points / gamesPlayed;
        this.rebounds = this.rebounds / gamesPlayed;
        this.blocks = this.blocks / gamesPlayed;
        this.assists = this.assists / gamesPlayed;
        this.steals = this.steals / gamesPlayed;
        this.turnovers = this.turnovers / gamesPlayed;

        freeThrows.calcAverage(gamesPlayed);
        twoPoints.calcAverage(gamesPlayed);
        threePoints.calcAverage(gamesPlayed);
    }

    public void roundToOneDecimal(){
        
        this.points =  Math.round(this.points * 10.0) / 10.0;
        this.rebounds =  Math.round(this.rebounds * 10.0) / 10.0;
        this.blocks =  Math.round(this.blocks * 10.0) / 10.0;
        this.assists =  Math.round(this.assists * 10.0) / 10.0;
        this.steals =  Math.round(this.steals * 10.0) / 10.0;
        this.turnovers =  Math.round(this.turnovers * 10.0) / 10.0;

        freeThrows.roundToOneDecimal();
        twoPoints.roundToOneDecimal();
        threePoints.roundToOneDecimal();
    }
}
