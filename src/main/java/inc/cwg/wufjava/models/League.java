package inc.cwg.wufjava.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<CountryLeague> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CountryLeague> participants) {
        this.participants = participants;
    }

    public List<MatchLeague> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchLeague> matches) {
        this.matches = matches;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
