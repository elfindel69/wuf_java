package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.StadiumDao;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;
import inc.cwg.wufjava.services.StadiumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumDao stadiumDao;

    public StadiumServiceImpl(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    @Override
    public Stadium addStadium(String name, String city, Nation country) {
        return stadiumDao.save(new Stadium(name,city,country));
    }

    @Override
    public List<Stadium> fetchStadiums() {
        return stadiumDao.findAll();
    }

    @Override
    public Stadium fetchStadium(long id) {
        return stadiumDao.findById(id).orElse(null);
    }

    @Override
    public Stadium saveStadium(Stadium stadium) {
        return stadiumDao.save(stadium);
    }

    @Override
    public boolean deleteStadium(long id) {
        Stadium stadium = fetchStadium(id);
        if(stadium == null){
            return false;
        }else {
            stadiumDao.deleteById(id);
            return fetchStadium(id) == null;
        }
    }

    @Override
    public Stadium fetchStadium(String name) {
      return stadiumDao.findFirstByName(name);
    }

    @Override
    public List<Stadium> fetchStadiums(Nation nation) {
        return stadiumDao.getAllByCountry(nation);
    }

    @Override
    public Stadium fetchMainStadium(Long id) {
        return stadiumDao.findStadiumByNationId(id);
    }
}
