package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class MatchCup extends Match{
    @ManyToOne
    @JoinColumn(name = "cup_id")
    @JsonIgnore
    private Cup cup;

    @Builder
    public MatchCup(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue, Cup cup) {
        super(homeNation, awayNation, scHome, scAway, matchTime, timeZone, venue);
        this.cup = cup;
    }
   
   
}
