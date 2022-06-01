package inc.cwg.wufjava.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_nation_id")
    private Nation homeNation;

    @ManyToOne
    @JoinColumn(name = "away_nation_id")
    private Nation awayNation;

    @Column(name="sc_home")
    private int scHome;
    @Column(name="sc_away")
    private int scAway;

    private LocalDateTime matchTime;

    private String timeZone;



    public Nation getAwayNation() {
        return awayNation;
    }

    public void setAwayNation(Nation awayNation) {
        this.awayNation = awayNation;
    }

    public Nation getHomeNation() {
        return homeNation;
    }

    public void setHomeNation(Nation homeNation) {
        this.homeNation = homeNation;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScHome() {
        return scHome;
    }

    public void setScHome(int sc1) {
        this.scHome = sc1;
    }

    public int getScAway() {
        return scAway;
    }

    public void setScAway(int sc2) {
        this.scAway = sc2;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Match(){}

    public Match(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone) {
        this.homeNation = homeNation;
        this.awayNation = awayNation;
        this.scHome = scHome;
        this.scAway = scAway;
        this.matchTime = matchTime;
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", homeNation=" + homeNation.getName() +
                ", awayNation=" + awayNation.getName() +
                ", scHome=" + scHome +
                ", scAway=" + scAway +
                ", matchTime=" + matchTime +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
