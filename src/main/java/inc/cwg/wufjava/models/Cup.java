package inc.cwg.wufjava.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cup {
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

    public List<League> getGroups() {
        return groups;
    }

    public void setGroups(List<League> groups) {
        this.groups = groups;
    }

    public List<CountryCup> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CountryCup> participants) {
        this.participants = participants;
    }

    public List<MatchCup> getMatchCups() {
        return matchCups;
    }

    public void setMatchCups(List<MatchCup> matchCups) {
        this.matchCups = matchCups;
    }

    public Nation getHost() {
        return host;
    }

    public void setHost(Nation host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setLastDay(LocalDate lastDay) {
        this.lastDay = lastDay;
    }

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
