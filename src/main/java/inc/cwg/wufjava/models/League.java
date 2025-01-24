package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    protected String name;

    protected String edition;

    protected String level;

    @OneToMany(mappedBy = "league", orphanRemoval = true)
    private List<MatchLeague> matches = new ArrayList<>();

    @OneToMany(mappedBy = "league", orphanRemoval = true)
    private List<CountryLeague> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cup_id")
    private Cup cup;


    public League(){}

    public League(String name, String edition, String level) {
        this.name = name;
        this.edition = edition;
        this.level = level;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
