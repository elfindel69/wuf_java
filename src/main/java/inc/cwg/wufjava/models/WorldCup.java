package inc.cwg.wufjava.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class WorldCup extends Cup{
    @ManyToOne
    @JoinColumn(name = "wuf_board_id")
    private WufBoard wufBoard;

    public WufBoard getWufBoard() {
        return wufBoard;
    }

    public void setWufBoard(WufBoard wufBoard) {
        this.wufBoard = wufBoard;
    }

    public WorldCup() {
    }

    public WorldCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host) {
        super(name, edition, firstDay, lastDay, host);
    }
}

