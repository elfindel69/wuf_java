package inc.cwg.wufjava.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import inc.cwg.wufjava.holders.CreateMatchHolder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMatchDto {
    public CreateMatchDto(CreateMatchHolder createMatchHolder) {
        homeNation = createMatchHolder.getHomeNation().getName();
        awayNation = createMatchHolder.getAwayNation().getName();
        homeScore = createMatchHolder.getCalcPoints().getSc1();
        awayScore = createMatchHolder.getCalcPoints().getSc2();
        homePoints = createMatchHolder.getCalcPoints().getPts1();
        awayPoints = createMatchHolder.getCalcPoints().getPts2();
        coeff = createMatchHolder.getCalcPoints().getCoeff();
        stadium = createMatchHolder.getStadium().getName();
        type = createMatchHolder.getMatchType().getType();
        date = createMatchHolder.getDate();
        timeZone = createMatchHolder.getTimeZone();
        cup = createMatchHolder.getCup().getName();
        league = createMatchHolder.getLeague().getName();
    }
    private String homeNation;
    private String awayNation;
    private int homeScore;
    private int awayScore;
    private int homePoints;
    private int awayPoints;
    private int coeff;

    private String stadium;
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    private String timeZone;

    String cup;
    String league;


}
