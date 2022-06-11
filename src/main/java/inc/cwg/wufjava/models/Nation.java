package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nation extends Country{

    @ManyToOne
    @JoinColumn(name = "conf_id")
    @JsonIgnore
    private Conf conf;

    private String admissionYear;

    @OneToOne
    @JoinColumn(name = "main_stadium_id")
    private Stadium mainStadium;

    private int wufRanking;

    private int confRanking;

    private int worldCupParticipations;

    private String lastWCResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "last_world_cup_id")
    @JsonIgnore
    private Cup lastWorldCup;

    private String bestWCResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "best_world_cup_id")
    @JsonIgnore
    private Cup bestWorldCup;

    private int confCupParticipations;

    private String lastCCResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "last_conf_cup_id")
    @JsonIgnore
    private Cup lastConfCup;

    private String bestCCResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "best_conf_cup_id")
    @JsonIgnore
    private Cup bestConfCup;

    private String lastCLResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "last_conf_league_id")
    @JsonIgnore
    private ConfLeague lastConfLeague;

    private String bestCLResult;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "best_conf_league_id")
    @JsonIgnore
    private ConfLeague bestConfLeague;

    @OneToMany(mappedBy = "homeNation", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Match> matchesHome = new ArrayList<>();

    @OneToMany(mappedBy = "awayNation", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Match> matchesAway = new ArrayList<>();

    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "wuf_board_id")
    @JsonIgnore
    private WufBoard wufBoard;

    public WufBoard getWufBoard() {
        return wufBoard;
    }

    public void setWufBoard(WufBoard wufBoard) {
        this.wufBoard = wufBoard;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Stadium getMainStadium() {
        return mainStadium;
    }

    public void setMainStadium(Stadium stadium) {
        this.mainStadium = stadium;
    }

    public int getWufRanking() {
        return wufRanking;
    }

    public void setWufRanking(int wufRanking) {
        this.wufRanking = wufRanking;
    }

    public int getConfRanking() {
        return confRanking;
    }

    public void setConfRanking(int confRanking) {
        this.confRanking = confRanking;
    }

    public int getWorldCupParticipations() {
        return worldCupParticipations;
    }

    public void setWorldCupParticipations(int worldCupParticipations) {
        this.worldCupParticipations = worldCupParticipations;
    }

    public String getLastWCResult() {
        return lastWCResult;
    }

    public void setLastWCResult(String lastWCResult) {
        this.lastWCResult = lastWCResult;
    }

    public String getBestWCResult() {
        return bestWCResult;
    }

    public void setBestWCResult(String bestWCResult) {
        this.bestWCResult = bestWCResult;
    }

    public Cup getBestWorldCup() {
        return bestWorldCup;
    }

    public void setBestWorldCup(Cup bestWorldCup) {
        this.bestWorldCup = bestWorldCup;
    }

    public int getConfCupParticipations() {
        return confCupParticipations;
    }

    public void setConfCupParticipations(int confCupParticipations) {
        this.confCupParticipations = confCupParticipations;
    }

    public String getLastCCResult() {
        return lastCCResult;
    }

    public void setLastCCResult(String lastCCResult) {
        this.lastCCResult = lastCCResult;
    }

    public Cup getLastConfCup() {
        return lastConfCup;
    }

    public void setLastConfCup(Cup lastConfCup) {
        this.lastConfCup = lastConfCup;
    }

    public String getBestCCResult() {
        return bestCCResult;
    }

    public void setBestCCResult(String bestCCResult) {
        this.bestCCResult = bestCCResult;
    }

    public Cup getBestConfCup() {
        return bestConfCup;
    }

    public void setBestConfCup(Cup bestConfCup) {
        this.bestConfCup = bestConfCup;
    }

    public String getLastCLResult() {
        return lastCLResult;
    }

    public void setLastCLResult(String lastCLResult) {
        this.lastCLResult = lastCLResult;
    }

    public String getBestCLResult() {
        return bestCLResult;
    }

    public void setBestCLResult(String bestCLResult) {
        this.bestCLResult = bestCLResult;
    }

    public ConfLeague getBestConfLeague() {
        return bestConfLeague;
    }

    public void setBestConfLeague(ConfLeague bestConfLeague) {
        this.bestConfLeague = bestConfLeague;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<Match> getMatchesAway() {
        return matchesAway;
    }

    public void setMatchesAway(List<Match> matchesAway) {
        this.matchesAway = matchesAway;
    }

    public List<Match> getMatchesHome() {
        return matchesHome;
    }

    public void setMatchesHome(List<Match> matchesHome) {
        this.matchesHome = matchesHome;
    }

    public ConfLeague getLastConfLeague() {
        return lastConfLeague;
    }

    public void setLastConfLeague(ConfLeague lastConfLeague) {
        this.lastConfLeague = lastConfLeague;
    }

    public Cup getLastWorldCup() {
        return lastWorldCup;
    }

    public void setLastWorldCup(Cup lastWorldCup) {
        this.lastWorldCup = lastWorldCup;
    }

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }

    public Nation() {
    }

    public Nation(String name, double pts, int score, Conf conf, String admissionYear, Stadium stadium,
                  int wufRanking, int confRanking, String timeZone, WufBoard board) {
        super(name, pts, score);
        this.conf = conf;
        this.admissionYear = admissionYear;
        this.mainStadium = stadium;
        this.wufRanking = wufRanking;
        this.confRanking = confRanking;
        this.timeZone = timeZone;
        this.wufBoard = board;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "conf=" + conf +
                ", admissionYear='" + admissionYear + '\'' +
                ", stadium='" + mainStadium.getName() + '\'' +
                ", wufRanking=" + wufRanking +
                ", confRanking=" + confRanking +
                ", worldCupParticipations=" + worldCupParticipations +
                ", lastWCResult='" + lastWCResult + '\'' +
                ", lastWorldCup=" + lastWorldCup +
                ", bestWCResult='" + bestWCResult + '\'' +
                ", bestWorldCup=" + bestWorldCup +
                ", confCupParticipations=" + confCupParticipations +
                ", lastCCResult='" + lastCCResult + '\'' +
                ", lastConfCup=" + lastConfCup +
                ", bestCCResult='" + bestCCResult + '\'' +
                ", bestConfCup=" + bestConfCup +
                ", lastCLResult='" + lastCLResult + '\'' +
                ", lastConfLeague=" + lastConfLeague +
                ", bestCLResult='" + bestCLResult + '\'' +
                ", bestConfLeague=" + bestConfLeague +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}

