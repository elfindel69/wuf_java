package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String city;

    @OneToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Nation country;

    public Stadium() {
    }

    public Stadium(String name, String city, Nation country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country.getName() +
                '}';
    }
}
