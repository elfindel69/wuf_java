package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.MatchDto;
import inc.cwg.wufjava.models.Match;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MatchHolder {
    private String homeTeam;
    private String awayTeam;
    private int scHome;
    private int scAway;
    private String stadium;
    private String matchTime;
    private String timeZone;

   public MatchHolder(Match match) {
        homeTeam = match.getHomeNation().getName();
        awayTeam = match.getAwayNation().getName();
        this.scHome = match.getScHome();
        this.scAway = match.getScAway();
        this.stadium = match.getVenue().getName();
        this.matchTime = match.getMatchTime().toString();
        this.timeZone = match.getTimeZone();

   }

    public MatchHolder (MatchDto matchDto) {
        this.homeTeam = matchDto.getHomeTeam();
        this.awayTeam = matchDto.getAwayTeam();
        this.scHome = matchDto.getScHome();
        this.scAway = matchDto.getScAway();
        this.stadium = matchDto.getStadium();
        this.matchTime = matchDto.getMatchTime();
        this.timeZone = matchDto.getTimeZone();
    }

}
