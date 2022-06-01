package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WorldCup;

import java.time.LocalDate;
import java.util.List;

public interface WorldCupService {
    WorldCup addWorldCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host);

    List<WorldCup> fetchWorldCups();

    WorldCup fetchWorldCup(long id);

    WorldCup saveWorldCup(WorldCup worldCup);

    boolean deleteWorldCup(long id);
}
