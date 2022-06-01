package inc.cwg.wufjava.models;

import javax.persistence.*;

@Entity
public class ConfLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String edition;

    private String level;

    @ManyToOne
    @JoinColumn(name = "conf_id")
    private Conf conf;

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
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

    public ConfLeague() {
    }

    public ConfLeague(String name, String edition, String level, Conf conf) {
        this.name = name;
        this.edition = edition;
        this.level = level;
        this.conf = conf;
    }

    @Override
    public String toString() {
        return "ConfLeague{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", level='" + level + '\'' +
                ", conf=" + conf +
                '}';
    }
}
