package inc.cwg.wufjava.models;

import javax.persistence.*;

@Entity
public class ConfLeague extends League{

    @ManyToOne
    @JoinColumn(name = "conf_id")
    private Conf conf;

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }

    public ConfLeague(String name, String edition, String level, Conf conf) {
        super(name, edition, level);
        this.conf = conf;
    }

    public ConfLeague() {
        super();
    }

    @Override
    public String toString() {
        return "ConfLeague{" +
                "conf=" + conf +
                "} " + super.toString();
    }
}
