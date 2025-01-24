package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class CountryLeague extends Country{
    private int leaguePts;
    
    private int playedMatches;

    private int victories;

    private int draws;

    private int defeats;

    private int pointsFor;

    private int pointsAgainst;

    private int pointsDiff;

    private int leagueRank;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public CountryLeague() {
    }

    public CountryLeague(String name, double pts, int score, League league) {
        super(name, pts, score);
        this.league = league;
    }
}
