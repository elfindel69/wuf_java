package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.models.WufBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WufBoardHolder {
    private Long id;

    private String name;

    private String adjective;

    private int nbMembers;

    private String dof;

    public WufBoardHolder(WufBoard board) {
        this.id = board.getId();
        this.name = board.getName();
        this.adjective = board.getAdjective();
        this.nbMembers = board.getNbMembers();
        this.dof = board.getDof();
    }
}
