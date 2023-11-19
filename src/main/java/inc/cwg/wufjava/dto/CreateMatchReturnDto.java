package inc.cwg.wufjava.dto;

import java.time.LocalDateTime;

import inc.cwg.wufjava.holders.CreateMatchHolder;
import lombok.Data;

@Data
public class CreateMatchReturnDto {

    private String homeNation;
    private String awayNation;
    private int homeScore;
    private int awayScore;
    private double homePoints;
    private double awayPoints;
    private int coeff;

    private String stadium;
    private LocalDateTime date;
    private String timeZone;

    String cup;
    String league;

    public CreateMatchReturnDto(CreateMatchHolder createMatchHolder) {
        homeNation = createMatchHolder.getHomeNation().getName();
        awayNation = createMatchHolder.getAwayNation().getName();
        homeScore = createMatchHolder.getCalcPoints().getSc1();
        awayScore = createMatchHolder.getCalcPoints().getSc2();
        homePoints = createMatchHolder.getCalcPoints().getPts1();
        awayPoints = createMatchHolder.getCalcPoints().getPts2();
        coeff = createMatchHolder.getCalcPoints().getCoeff();
        stadium = createMatchHolder.getStadium().getName();
        date = createMatchHolder.getDate();
        timeZone = createMatchHolder.getTimeZone();
        cup = createMatchHolder.getCup().getName();
        league = createMatchHolder.getLeague().getName();
    }
    
}
