package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class MatchLeague extends Match{
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public MatchLeague() {
    }

    public MatchLeague(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue, League league) {
        super(homeNation, awayNation, scHome, scAway, matchTime, timeZone, venue);
        this.league = league;
    }

    @Override
    public String toString() {
        return "MatchLeague{" +
                "league=" + league +
                "} " + super.toString();
    }
}
