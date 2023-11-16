package rs.ogix2.levi9.player_statistics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdvancedStatistics {
    private double valorization;
    private double effectiveFieldGoalPercentage;
    private double trueShootingPercentage;
    private double hollingerAssistRatio;

    void update(TraditionalStatistics traditional){
        //Trebalo bi da su sve ove kalkulacije sa prosecnim vrednostima?

        // nikako nije dobro
        this.valorization = ((traditional.getFreeThrows().getMade() + 
                              2 * traditional.getTwoPoints().getMade() +
                              3 * traditional.getThreePoints().getMade() +
                              traditional.getRebounds() +
                              traditional.getBlocks() +
                              traditional.getAssists()+
                              traditional.getSteals())
        );

        this.effectiveFieldGoalPercentage = (traditional.getTwoPoints().getMade() +
                                             1.5 * traditional.getThreePoints().getMade());

        this.effectiveFieldGoalPercentage = this.effectiveFieldGoalPercentage / (traditional.getTwoPoints().getAttempts() + traditional.getThreePoints().getAttempts());

        this.effectiveFieldGoalPercentage = this.effectiveFieldGoalPercentage * 100;

        this.trueShootingPercentage = traditional.getPoints() / (2 * (traditional.getTwoPoints().getAttempts() 
                + traditional.getThreePoints().getAttempts() + 0.475 
                * traditional.getFreeThrows().getAttempts())) * 100;
    }

    public void roundToOneDecimal(){

        this.valorization =  Math.round(this.valorization * 10.0) / 10.0;
        this.effectiveFieldGoalPercentage =  Math.round(this.effectiveFieldGoalPercentage * 10.0) / 10.0;
        this.trueShootingPercentage =  Math.round(this.trueShootingPercentage * 10.0) / 10.0;
        this.hollingerAssistRatio =  Math.round(this.hollingerAssistRatio * 10.0) / 10.0;
    
    }
}
