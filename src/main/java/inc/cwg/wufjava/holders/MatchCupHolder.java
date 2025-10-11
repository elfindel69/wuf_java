package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.models.MatchCup;
import lombok.Data;

@Data
public class MatchCupHolder {
    private String homeTeam;
    private String awayTeam;
    private int scHome;
    private int scAway;
    private String stadium;
    private String matchTime;
    private String timeZone;
    private String cup;

    public MatchCupHolder(String homeTeam, String awayTeam, int scHome, int scAway, String stadium, String matchTime, String timeZone, String cup) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.scHome = scHome;
        this.scAway = scAway;
        this.stadium = stadium;
        this.matchTime = matchTime;
        this.timeZone = timeZone;
        this.cup = cup;
    }

    public MatchCupHolder(MatchCup matchCup) {
        this.homeTeam = matchCup.getHomeNation().getName();
        this.awayTeam = matchCup.getAwayNation().getName();
        this.scHome = matchCup.getScHome();
        this.scAway = matchCup.getScAway();
        this.stadium = matchCup.getVenue().getName();
        this.matchTime = matchCup.getMatchTime().toString();
        this.timeZone = matchCup.getTimeZone();
        this.cup = matchCup.getCup().getName();
    }
}
