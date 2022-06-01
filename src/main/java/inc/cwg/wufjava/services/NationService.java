package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;

import java.util.List;

public interface NationService {
    List<Nation> fetchNations();

    List<Nation> fetchNationsByConf(Conf conf);

    Nation fetchNation(long id);

    Nation saveNation(Nation n);

    boolean deleteNation(long id);

    Nation fetchNation(String s);
}
