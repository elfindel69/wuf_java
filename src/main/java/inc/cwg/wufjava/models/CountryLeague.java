package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getLeaguePts() {
        return leaguePts;
    }

    public void setLeaguePts(int leaguePts) {
        this.leaguePts = leaguePts;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(int pointsFor) {
        this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public int getPointsDiff() {
        return pointsDiff;
    }

    public void setPointsDiff(int pointsDiff) {
        this.pointsDiff = pointsDiff;
    }

    public int getLeagueRank() {
        return leagueRank;
    }

    public void setLeagueRank(int leagueRank) {
        this.leagueRank = leagueRank;
    }

    public CountryLeague() {
    }

    public CountryLeague(String name, double pts, int score, League league) {
        super(name, pts, score);
        this.league = league;
    }
}
