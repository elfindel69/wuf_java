package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.WufBoardHolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WufBoardDto {

    private Long id;

    private String name;

    private String adjective;

    private int nbMembers;

    private String dof;

    public WufBoardDto(WufBoardHolder board) {
        this.id = board.getId();
        this.name = board.getName();
        this.adjective = board.getAdjective();
        this.nbMembers = board.getNbMembers();
        this.dof = board.getDof();
    }
}
