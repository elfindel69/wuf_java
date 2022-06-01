package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.ConfLeagueDao;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.ConfLeague;
import inc.cwg.wufjava.services.ConfLeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfLeagueServiceImpl implements ConfLeagueService {
    private final ConfLeagueDao confLeagueDao;

    public ConfLeagueServiceImpl(ConfLeagueDao confLeagueDao) {
        this.confLeagueDao = confLeagueDao;
    }

    @Override
    public ConfLeague addConfLeague(String name, String edition, String level, Conf conf) {
        return confLeagueDao.save(new ConfLeague(name, edition, level, conf));
    }

    @Override
    public List<ConfLeague> fetchConfLeagues() {
        return confLeagueDao.findAll();
    }

    @Override
    public ConfLeague fetchConfLeague(long id) {
        return confLeagueDao.findById(id).orElse(null);
    }

    @Override
    public ConfLeague saveConfLeague(ConfLeague c) {
        return confLeagueDao.save(c);
    }

    @Override
    public boolean deleteConfLeague(long id) {
        ConfLeague conf = fetchConfLeague(id);
        if(conf == null){
            return false;
        }else {
            confLeagueDao.deleteById(id);
            return fetchConfLeague(id) == null;
        }
    }
}
