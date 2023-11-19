package inc.cwg.wufjava.services;


import inc.cwg.wufjava.models.League;

import java.util.List;

public interface LeagueService {
    League addLeague(String name, String edition, String level);

    List<League> fetchLeagues();

    League fetchLeague(long id);

    League fetchLeague(String name);

    League saveLeague(League c);

    boolean deleteLeague(long id);
}
