package inc.cwg.wufjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="matches")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_nation_id")
    @JsonIgnore
    private Nation homeNation;

    @ManyToOne
    @JoinColumn(name = "away_nation_id")
    @JsonIgnore
    private Nation awayNation;

    @Column(name="sc_home")
    private int scHome;
    @Column(name="sc_away")
    private int scAway;

    private LocalDateTime matchTime;

    private String timeZone;

    @OneToOne
    @JoinColumn(name = "venue_id")
    private Stadium venue;

    public Match(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue) {
        this.homeNation = homeNation;
        this.awayNation = awayNation;
        this.scHome = scHome;
        this.scAway = scAway;
        this.matchTime = matchTime;
        this.timeZone = timeZone;
        this.venue = venue;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Match match = (Match) o;
        return getId() != null && Objects.equals(getId(), match.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
