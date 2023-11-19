package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.Cup;

import java.util.List;

public interface CountryCupService {
    CountryCup addCountryCup(String name, double pts, int score, Cup cup);

    List<CountryCup> fetchCountryCups();

    CountryCup fetchCountryCup(long id);

    CountryCup saveCountryCup(CountryCup c);

    boolean deleteCountryCup(long id);
}
