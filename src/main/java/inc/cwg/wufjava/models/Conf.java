package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
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
