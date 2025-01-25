package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.ConfDto;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.WufBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ConfHolder {
    private Long id;

    private String name;

    private String adjective;

    private int nbMembers;

    private String dof;

    public ConfHolder(Conf conf) {
        this.id = conf.getId();
        this.name = conf.getName();
        this.adjective = conf.getAdjective();
        this.nbMembers = conf.getNbMembers();
        this.dof = conf.getDof();
    }

    public ConfHolder(ConfDto confDto) {
        this.id = confDto.getId();
        this.name = confDto.getName();
        this.adjective = confDto.getAdjective();
        this.nbMembers = confDto.getNbMembers();
        this.dof = confDto.getDof();
    }
}
