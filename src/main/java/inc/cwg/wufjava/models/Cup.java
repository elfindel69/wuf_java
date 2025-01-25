package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    protected String name;

    protected  String edition;

    protected LocalDate firstDay;

    protected LocalDate lastDay;

    @OneToOne( orphanRemoval = true)
    @JoinColumn(name = "host_id")
    protected Nation host;

    @OneToMany(mappedBy = "cup", orphanRemoval = true)
    private List<MatchCup> matchCups = new ArrayList<>();

    @OneToMany(mappedBy = "cup", orphanRemoval = true)
    private List<CountryCup> participants = new ArrayList<>();

    @OneToMany(mappedBy = "cup", orphanRemoval = true)
    private List<League> groups = new ArrayList<>();

    public Cup(){

    }

    public Cup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host) {
        this.name = name;
        this.edition = edition;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.host = host;
    }

    @Override
    public String toString() {
        return "Cup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", firstDay=" + firstDay +
                ", lastDay=" + lastDay +
                ", host=" + host.getName() +
                '}';
    }
}
