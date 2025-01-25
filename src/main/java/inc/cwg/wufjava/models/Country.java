package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    protected String name;

    protected double pts;

    protected int score;

    public Country() {
    }

    public Country(String name, double pts, int score) {
        this.name = name;
        this.pts = pts;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pts=" + pts +
                ", score=" + score +
                '}';
    }
}
