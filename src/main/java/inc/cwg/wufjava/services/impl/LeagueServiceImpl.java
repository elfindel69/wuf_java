package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.LeagueDao;
import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.services.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueDao leagueDao;

    public LeagueServiceImpl(LeagueDao leagueDao) {
        this.leagueDao = leagueDao;
    }

    @Override
    public League addLeague(String name, String edition, String level) {
        return leagueDao.save(new League(name,edition,level));
    }

    @Override
    public List<League> fetchLeagues() {
        return leagueDao.findAll();
    }

    @Override
    public League fetchLeague(long id) {
        return leagueDao.findById(id).orElse(null);
    }


    @Override
    public League fetchLeague(String name) {
        return leagueDao.findFirstByName(name);
    }

    @Override
    public League saveLeague(League c) {
        return leagueDao.save(c);
    }

    @Override
    public boolean deleteLeague(long id) {
        League league = fetchLeague(id);
        if(league == null){
            return false;
        }else {
            leagueDao.deleteById(id);
            return fetchLeague(id) == null;
        }
    }
}
