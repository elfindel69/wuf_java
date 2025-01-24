package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;

import java.util.List;

public interface StadiumService {
    Stadium addStadium(String name, String city, Nation country);

    List<Stadium> fetchStadiums();

    Stadium fetchStadium(long id);

    Stadium saveStadium(Stadium stadium);

    boolean deleteStadium(long id);

    Stadium fetchStadium(String name);

    List<Stadium> fetchStadiums(Nation nation);
}
