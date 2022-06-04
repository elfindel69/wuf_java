package inc.cwg.wufjava.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conf extends Organization {
    @OneToMany(mappedBy = "conf", orphanRemoval = true)
    private List<Nation> nations = new ArrayList<>();

    @OneToMany(mappedBy = "conf", orphanRemoval = true)
    private List<ConfLeague> confLeagues = new ArrayList<>();

    @OneToMany(mappedBy = "conf", orphanRemoval = true)
    private List<ConfCup> confCups = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "wuf_board_id")
    private WufBoard wufBoard;

    public WufBoard getWufBoard() {
        return wufBoard;
    }

    public void setWufBoard(WufBoard wufBoard) {
        this.wufBoard = wufBoard;
    }

    public List<ConfCup> getConfCups() {
        return confCups;
    }

    public void setConfCups(List<ConfCup> confCups) {
        this.confCups = confCups;
    }

    public List<ConfLeague> getConfLeagues() {
        return confLeagues;
    }

    public void setConfLeagues(List<ConfLeague> confLeagues) {
        this.confLeagues = confLeagues;
    }

    public List<Nation> getNations() {
        return nations;
    }

    public void setNations(List<Nation> nations) {
        this.nations = nations;
    }


    public int getNbMembers() {
        return nbMembers;
    }

    public void setNbMembers(int nbMembers) {
        this.nbMembers = nbMembers;
    }



    public Conf(){}

    public Conf(String name, String adjective, int nbMembers, String dof, WufBoard wuf) {
        super(name, adjective, nbMembers, dof);
        this.wufBoard = wuf;
    }

    @Override
    public String toString() {
        return "Conf{} " + super.toString();
    }
}
