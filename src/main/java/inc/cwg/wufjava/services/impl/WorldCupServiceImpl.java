package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.WorldCupDao;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WorldCup;
import inc.cwg.wufjava.services.WorldCupService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorldCupServiceImpl implements WorldCupService {
    private final WorldCupDao worldCupDao;

    public WorldCupServiceImpl(WorldCupDao worldCupDao) {
        this.worldCupDao = worldCupDao;
    }


    @Override
    public WorldCup addWorldCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host) {
        return worldCupDao.save(new WorldCup(name,edition,firstDay,lastDay,host));
    }

    @Override
    public List<WorldCup> fetchWorldCups() {
        return worldCupDao.findAll();
    }

    @Override
    public WorldCup fetchWorldCup(long id) {
        return worldCupDao.findById(id).orElse(null);
    }

    @Override
    public WorldCup saveWorldCup(WorldCup worldCup) {
        return worldCupDao.save(worldCup);
    }

    @Override
    public boolean deleteWorldCup(long id) {
        WorldCup worldCup = fetchWorldCup(id);
        if(worldCup == null){
            return false;
        }else {
            worldCupDao.deleteById(id);
            return fetchWorldCup(id) == null;
        }
    }
}
