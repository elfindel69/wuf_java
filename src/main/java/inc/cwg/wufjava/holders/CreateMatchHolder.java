package inc.cwg.wufjava.holders;

import java.time.LocalDateTime;



import inc.cwg.wufjava.enums.MatchType;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateMatchHolder {
    public CreateMatchHolder() {
    }
    NationHolder homeNation;
    NationHolder awayNation;
    Stadium stadium;
    CalcPoints calcPoints;
    MatchType matchType;
    LocalDateTime date;
    String timeZone;
    Cup cup;
    League league;

}
