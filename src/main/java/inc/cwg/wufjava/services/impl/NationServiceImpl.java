package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.NationDao;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.NationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    private final NationDao nationDao;

    public NationServiceImpl(NationDao nationDao) {
        this.nationDao = nationDao;
    }

    @Override
    public List<Nation> fetchNations() {
        return nationDao.findAll();
    }

    @Override
    public List<Nation> fetchNationsByConf(Conf conf) {
        return nationDao.findAllByConf(conf);
    }

    @Override
    public Nation fetchNation(long id) {
        return nationDao.findById(id).orElse(null);
    }

    @Override
    public Nation saveNation(Nation n) {
        return nationDao.save(n);
    }

    @Override
    public boolean deleteNation(long id) {
        Nation nation = fetchNation(id);
        if(nation == null){
            return false;
        }else {
            nationDao.deleteById(id);
            return fetchNation(id) == null;
        }
    }

    @Override
    public Nation fetchNation(String s) {
        return nationDao.findFirstByName(s);
    }
}
