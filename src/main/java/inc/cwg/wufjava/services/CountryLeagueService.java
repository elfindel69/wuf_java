package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.CountryLeague;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.League;

import java.util.List;

public interface CountryLeagueService {
    CountryLeague addCountryLeague(String name, double pts, int score, League league);

    List<CountryLeague> fetchCountryLeagues();

    CountryLeague fetchCountryLeague(long id);

    CountryLeague saveCountryCup(CountryLeague c);

    boolean deleteCountryLeague(long id);
}
