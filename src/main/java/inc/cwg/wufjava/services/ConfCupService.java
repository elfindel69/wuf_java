package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.ConfCup;
import inc.cwg.wufjava.models.Nation;

import java.time.LocalDate;
import java.util.List;

public interface ConfCupService {
    ConfCup addConfCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host, Conf conf);

    List<ConfCup> fetchConfCups();

    ConfCup fetchConfCup(long id);

    ConfCup saveConfCup(ConfCup c);

    boolean deleteConfCup(long id);
}
