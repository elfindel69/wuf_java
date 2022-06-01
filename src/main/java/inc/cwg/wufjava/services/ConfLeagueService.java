package inc.cwg.wufjava.services;


import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.ConfLeague;

import java.time.LocalDate;
import java.util.List;

public interface ConfLeagueService {
    ConfLeague addConfLeague(String name, String edition, String level, Conf conf);

    List<ConfLeague> fetchConfLeagues();

    ConfLeague fetchConfLeague(long id);

    ConfLeague saveConfLeague(ConfLeague c);

    boolean deleteConfLeague(long id);
}
