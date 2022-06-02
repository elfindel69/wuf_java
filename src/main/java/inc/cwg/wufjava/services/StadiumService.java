package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Country;
import inc.cwg.wufjava.models.Stadium;

import java.time.LocalDate;
import java.util.List;

public interface StadiumService {
    Stadium addStadium(String name, String city, Country country);

    List<Stadium> fetchStadiums();

    Stadium fetchStadium(long id);

    Stadium saveStadium(Stadium stadium);

    boolean deleteStadium(long id);
}
