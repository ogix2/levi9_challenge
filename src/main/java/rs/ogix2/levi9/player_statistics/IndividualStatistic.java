package rs.ogix2.levi9.player_statistics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IndividualStatistic {
    private double attempts;
    private double made;
    private double shootingPercentage;

    public void update(int attempts, int made){
        
        this.attempts += attempts;
        this.made += made;
    }

    public void calcAverage(int gamesPlayed){

        this.attempts = this.attempts / gamesPlayed;
        this.made = this.made / gamesPlayed;

        this.shootingPercentage = this.made / this.attempts;
    }

    public void roundToOneDecimal(){

        this.attempts =  Math.round(this.attempts * 10.0) / 10.0;
        this.made =  Math.round(this.made * 10.0) / 10.0;
        this.shootingPercentage =  Math.round(this.shootingPercentage * 10.0) / 10.0;

    }

}
