package inc.cwg.wufjava.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WufBoard extends Organization{
    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<Conf> confs = new ArrayList<>();

    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<Nation> nations = new ArrayList<>();

    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<WorldCup> worldCups = new ArrayList<>();

    public List<WorldCup> getWorldCups() {
        return worldCups;
    }

    public void setWorldCups(List<WorldCup> worldCups) {
        this.worldCups = worldCups;
    }

    public List<Nation> getNations() {
        return nations;
    }

    public void setNations(List<Nation> nations) {
        this.nations = nations;
    }

    public List<Conf> getConfs() {
        return confs;
    }

    public void setConfs(List<Conf> confs) {
        this.confs = confs;
    }

    public WufBoard() {
    }

    public WufBoard(String name, String adjective, int nbMembers, String dof) {
        super(name, adjective, nbMembers, dof);
    }

    @Override
    public String toString() {
        return "WufBoard{} " + super.toString();
    }
}
