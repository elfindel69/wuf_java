package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class WorldCup extends Cup{
    @ManyToOne
    @JoinColumn(name = "wuf_board_id")
    private WufBoard wufBoard;

    public WorldCup() {
    }

    public WorldCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host) {
        super(name, edition, firstDay, lastDay, host);
    }
}

