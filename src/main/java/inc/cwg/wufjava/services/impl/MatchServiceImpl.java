package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.MatchDao;
import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;
import inc.cwg.wufjava.services.MatchService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchDao matchDao;

    public MatchServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public Match addMatch(Nation homeNation, Nation awayNation, int scHome, int scAway,
                          LocalDateTime matchTime, String timeZone, Stadium venue) {
        return matchDao.save(new Match(homeNation,awayNation,scHome,scAway,matchTime,timeZone,venue));
    }

    @Override
    public List<Match> fetchMatches() {
        return matchDao.findAll();
    }

    @Override
    public Match fetchMatch(long id) {
        return matchDao.findById(id).orElse(null);
    }

    @Override
    public Match saveMatch(Match m) {
        return matchDao.save(m);
    }

    @Override
    public boolean deleteMatch(long id) {
        Match match = fetchMatch(id);
        if(match == null){
            return false;
        }else {
            matchDao.deleteById(id);
            return fetchMatch(id) == null;
        }
    }

    @Override
    public List<Match> getFiveLastMatches(Nation nation) {
        return matchDao.getFiveLastMatches(nation);
    }
}
