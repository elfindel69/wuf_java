package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.MatchLeagueDao;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.MatchLeagueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchLeagueServiceImpl implements MatchLeagueService {
    private final MatchLeagueDao matchLeagueDao;


    public MatchLeagueServiceImpl(MatchLeagueDao matchLeagueDao) {
        this.matchLeagueDao = matchLeagueDao;
    }

    @Override
    public MatchLeague addMatchLeague(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue, League cup) {
        return matchLeagueDao.save(new MatchLeague(homeNation,awayNation,scHome,scAway,matchTime,timeZone,venue,cup));
    }

    @Override
    public List<MatchLeague> fetchMatchesLeague() {
        return matchLeagueDao.findAll();
    }

    @Override
    public MatchLeague fetchMatchLeague(long id) {
        return matchLeagueDao.findById(id).orElse(null);
    }

    @Override
    public MatchLeague saveMatchLeague(MatchLeague m) {
        return matchLeagueDao.save(m);
    }

    @Override
    public boolean deleteMatchLeague(long id) {
        MatchLeague match = fetchMatchLeague(id);
        if(match == null){
            return false;
        }else {
            matchLeagueDao.deleteById(id);
            return fetchMatchLeague(id) == null;
        }
    }
}
