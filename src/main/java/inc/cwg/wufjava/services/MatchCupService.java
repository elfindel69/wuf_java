package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchCupService {
    MatchCup addMatchCup(Nation homeNation, Nation awayNation, int scHome, int scAway,
                      LocalDateTime matchTime, String timeZone, Stadium venue, Cup cup);

    List<MatchCup> fetchMatchesCup();

    MatchCup fetchMatchCup(long id);

    MatchCup saveMatchCup(MatchCup m);

    boolean deleteMatchCup(long id);

}
