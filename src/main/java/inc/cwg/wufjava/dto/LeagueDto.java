package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.LeagueHolder;
import inc.cwg.wufjava.models.League;
import lombok.Data;

@Data
public class LeagueDto {
    private Long id;
    private String name;
    private String edition;
    private String level;



    public LeagueDto(LeagueHolder leagueHolder) {
        this.id = leagueHolder.getId();
        this.name = leagueHolder.getName();
        this.edition = leagueHolder.getEdition();
        this.level = leagueHolder.getLevel();
    }
}
