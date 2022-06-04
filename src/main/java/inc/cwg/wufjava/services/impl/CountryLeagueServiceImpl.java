package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.CountryLeagueDao;
import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.CountryLeague;
import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.services.CountryLeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLeagueServiceImpl implements CountryLeagueService {
    private final CountryLeagueDao countryLeagueDao;


    public CountryLeagueServiceImpl(CountryLeagueDao countryLeagueDao) {
        this.countryLeagueDao = countryLeagueDao;
    }

    @Override
    public CountryLeague addCountryLeague(String name, double pts, int score, League league) {
        return countryLeagueDao.save(new CountryLeague(name,pts,score,league));
    }

    @Override
    public List<CountryLeague> fetchCountryLeagues() {
        return countryLeagueDao.findAll();
    }

    @Override
    public CountryLeague fetchCountryLeague(long id) {
        return countryLeagueDao.findById(id).orElse(null);
    }

    @Override
    public CountryLeague saveCountryCup(CountryLeague c) {
        return countryLeagueDao.save(c);
    }

    @Override
    public boolean deleteCountryLeague(long id) {
        CountryLeague countryLeague = fetchCountryLeague(id);
        if(countryLeague == null){
            return false;
        }else {
            countryLeagueDao.deleteById(id);
            return fetchCountryLeague(id) == null;
        }
    }
}
