package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class CountryCup extends Country{

    @ManyToOne
    @JoinColumn(name = "cup_id")
    private Cup cup;


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
