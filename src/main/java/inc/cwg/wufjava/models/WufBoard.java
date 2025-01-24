package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class WufBoard extends Organization{
    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<Conf> confs = new ArrayList<>();

    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<Nation> nations = new ArrayList<>();

    @OneToMany(mappedBy = "wufBoard", orphanRemoval = true)
    private List<WorldCup> worldCups = new ArrayList<>();

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
