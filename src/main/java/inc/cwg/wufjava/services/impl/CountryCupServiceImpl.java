package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.CountryCupDao;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.MatchCup;
import inc.cwg.wufjava.services.CountryCupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCupServiceImpl implements CountryCupService {
    private final CountryCupDao countryCupDao;

    public CountryCupServiceImpl(CountryCupDao countryCupDao) {
        this.countryCupDao = countryCupDao;
    }

    @Override
    public CountryCup addCountryCup(String name, double pts, int score, Cup cup) {
        return countryCupDao.save(new CountryCup(name,pts,score,cup));
    }

    @Override
    public List<CountryCup> fetchCountryCups() {
        return countryCupDao.findAll();
    }

    @Override
    public CountryCup fetchCountryCup(long id) {
        return countryCupDao.findById(id).orElse(null);
    }

    @Override
    public CountryCup saveCountryCup(CountryCup c) {
        return countryCupDao.save(c);
    }

    @Override
    public boolean deleteCountryCup(long id) {
        CountryCup countryCup = fetchCountryCup(id);
        if(countryCup == null){
            return false;
        }else {
            countryCupDao.deleteById(id);
            return fetchCountryCup(id) == null;
        }
    }
}
