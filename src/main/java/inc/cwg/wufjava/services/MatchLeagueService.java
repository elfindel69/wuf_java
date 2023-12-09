package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchLeagueService {
    MatchLeague addMatchLeague(Nation homeNation, Nation awayNation, int scHome, int scAway,
                            LocalDateTime matchTime, String timeZone, Stadium venue, League league);

    List<MatchLeague> fetchMatchesLeague();

    MatchLeague fetchMatchLeague(long id);

    MatchLeague saveMatchLeague(MatchLeague m);

    boolean deleteMatchLeague(long id);
}
