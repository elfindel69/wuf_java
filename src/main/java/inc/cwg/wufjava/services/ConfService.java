package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;

import java.util.List;

public interface ConfService {
    Conf addConf(String name, String adjective, int nbMembers, String dof, WufBoard wuf);

    List<Conf> fetchConfs();

    Conf fetchConf(long id);

    Conf saveConf(Conf c);

    boolean deleteConf(long id);

    List<Nation> fetchConfRanking();
}
