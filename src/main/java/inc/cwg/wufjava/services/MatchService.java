package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.ConfLeague;
import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.Nation;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchService {
    Match addMatch(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone);

    List<Match> fetchMatches();

    Match fetchMatch(long id);

    Match saveMatch(Match m);

    boolean deleteMatch(long id);

    List<Match> getFiveLastMatches(Nation nation);
}
