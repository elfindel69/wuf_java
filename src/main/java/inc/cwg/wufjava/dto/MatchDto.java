package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.MatchHolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MatchDto {

    private String homeTeam;
    private String awayTeam;
    private int scHome;
    private int scAway;
    private String stadium;
    private String matchTime;
    private String timeZone;

    public MatchDto(MatchHolder matchHolder) {
        this.homeTeam = matchHolder.getHomeTeam();
        this.awayTeam = matchHolder.getAwayTeam();
        this.scHome = matchHolder.getScHome();
        this.scAway = matchHolder.getScAway();
        this.stadium = matchHolder.getStadium();
        this.matchTime = matchHolder.getMatchTime();
        this.timeZone = matchHolder.getTimeZone();
    }
}
