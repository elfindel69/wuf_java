package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchService {



    List<Match> fetchMatches();

    Match fetchMatch(long id);

    Match saveMatch(Match m);

    boolean deleteMatch(long id);

    List<Match> fetchMatches(Nation nation);


}
