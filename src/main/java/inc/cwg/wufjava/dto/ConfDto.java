package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.ConfHolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ConfDto {

    private Long id;

    private String name;

    private String adjective;

    private int nbMembers;

    private String dof;

    public ConfDto(ConfHolder confHolder) {
        this.id = confHolder.getId();
        this.name = confHolder.getName();
        this.adjective = confHolder.getAdjective();
        this.nbMembers = confHolder.getNbMembers();
        this.dof = confHolder.getDof();
    }
}
