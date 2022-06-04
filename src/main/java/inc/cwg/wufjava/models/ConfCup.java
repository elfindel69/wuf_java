package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class ConfCup extends Cup{

    @ManyToOne
    @JoinColumn(name = "conf_id")
    protected Conf conf;

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }


    public ConfCup(){}

    public ConfCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host, Conf conf) {
        super(name, edition, firstDay, lastDay, host);
        this.conf = conf;
    }

    @Override
    public String toString() {
        return "ConfCup{" +
                "conf=" + conf +
                "} " + super.toString();
    }
}
