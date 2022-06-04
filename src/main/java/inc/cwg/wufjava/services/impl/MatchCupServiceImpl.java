package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.MatchCupDao;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.MatchCupService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchCupServiceImpl implements MatchCupService {
    private final MatchCupDao matchCupDao;


    public MatchCupServiceImpl(MatchCupDao matchCupDao) {
        this.matchCupDao = matchCupDao;
    }

    @Override
    public MatchCup addMatchCup(Nation homeNation, Nation awayNation, int scHome, int scAway, LocalDateTime matchTime, String timeZone, Stadium venue, Cup cup) {
        return matchCupDao.save(new MatchCup(homeNation,awayNation,scHome,scAway,matchTime,timeZone,venue,cup));
    }

    @Override
    public List<MatchCup> fetchMatchesCup() {
        return matchCupDao.findAll();
    }

    @Override
    public MatchCup fetchMatchCup(long id) {
        return matchCupDao.findById(id).orElse(null);
    }

    @Override
    public MatchCup saveMatchCup(MatchCup m) {
        return matchCupDao.save(m);
    }

    @Override
    public boolean deleteMatchCup(long id) {
        MatchCup match = fetchMatchCup(id);
        if(match == null){
            return false;
        }else {
            matchCupDao.deleteById(id);
            return fetchMatchCup(id) == null;
        }
    }
}
