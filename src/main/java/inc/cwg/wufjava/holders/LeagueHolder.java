package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.LeagueDto;
import inc.cwg.wufjava.models.League;
import lombok.Data;

@Data
public class LeagueHolder {

    private Long id;
    private String name;
    private String edition;
    private String level;

    public LeagueHolder(LeagueDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.edition = dto.getEdition();
        this.level = dto.getLevel();
    }

    public LeagueHolder(League league) {
        this.id = league.getId();
        this.name = league.getName();
        this.edition = league.getEdition();
        this.level = league.getLevel();
    }
}
