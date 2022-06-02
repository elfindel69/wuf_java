package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchService {

    Match addMatch(Nation homeNation, Nation awayNation, int scHome, int scAway,
                   LocalDateTime matchTime, String timeZone, Stadium venue);

    List<Match> fetchMatches();

    Match fetchMatch(long id);

    Match saveMatch(Match m);

    boolean deleteMatch(long id);

    List<Match> getFiveLastMatches(Nation nation);
}
