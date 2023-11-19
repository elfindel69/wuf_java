package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="matches")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_nation_id")
    @JsonIgnore
    private Nation homeNation;

    @ManyToOne
    @JoinColumn(name = "away_nation_id")
    @JsonIgnore
    private Nation awayNation;

    @Column(name="sc_home")
    private int scHome;
    @Column(name="sc_away")
    private int scAway;

    private LocalDateTime matchTime;

    private String timeZone;

    @OneToOne
    @JoinColumn(name = "venue_id")
    private Stadium venue;

    public Match() {
        super(); // Explicitly invoke the constructor of the Object class
    }

    public Match(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue) {
        this.homeNation = homeNation;
        this.awayNation = awayNation;
        this.scHome = scHome;
        this.scAway = scAway;
        this.matchTime = matchTime;
        this.timeZone = timeZone;
        this.venue = venue;
    }
}
