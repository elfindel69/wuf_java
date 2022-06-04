package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class MatchCup extends Match{
    @ManyToOne
    @JoinColumn(name = "cup_id")
    private Cup cup;

    public MatchCup() {

    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    public MatchCup(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue, Cup cup) {
        super(homeNation, awayNation, scHome, scAway, matchTime, timeZone, venue);
        this.cup = cup;
    }

    @Override
    public String toString() {
        return "MatchCup{" +
                "cup=" + cup.getName() +"-"+cup.getEdition()+
                "} " + super.toString();
    }
}
