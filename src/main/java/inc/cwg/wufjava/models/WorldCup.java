package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

