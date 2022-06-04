package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CountryCup extends Country{

    @ManyToOne
    @JoinColumn(name = "cup_id")
    private Cup cup;



    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    public CountryCup() {
    }

    public CountryCup(String name, double pts, int score, Cup cup) {
        super(name, pts, score);
        this.cup = cup;
    }

    @Override
    public String toString() {
        return "CountryCup{" +
                "cup=" + cup.getName() + '-' + cup.getEdition()+
                "} " + super.toString();
    }
}
