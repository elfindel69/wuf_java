package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
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

    public Nation() {

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

