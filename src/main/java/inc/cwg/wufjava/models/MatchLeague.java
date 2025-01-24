package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MatchLeague extends Match{
    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonIgnore
    private League league;


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
