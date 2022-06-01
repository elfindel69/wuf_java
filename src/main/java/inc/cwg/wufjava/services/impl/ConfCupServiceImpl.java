package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.ConfCupDao;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.ConfCup;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.ConfCupService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConfCupServiceImpl implements ConfCupService {
    private final ConfCupDao confCupDao;

    public ConfCupServiceImpl(ConfCupDao confCupDao) {
        this.confCupDao = confCupDao;
    }

    @Override
    public ConfCup addConfCup(String name, String edition, LocalDate firstDay, LocalDate lastDay, Nation host, Conf conf) {
        return confCupDao.save(new ConfCup(name,edition,firstDay,lastDay,host,conf));
    }

    @Override
    public List<ConfCup> fetchConfCups() {
        return confCupDao.findAll();
    }

    @Override
    public ConfCup fetchConfCup(long id) {
        return confCupDao.findById(id).orElse(null);
    }

    @Override
    public ConfCup saveConfCup(ConfCup c) {
        return confCupDao.save(c);
    }

    @Override
    public boolean deleteConfCup(long id) {
        ConfCup confCup = fetchConfCup(id);
        if(confCup == null){
            return false;
        }else {
            confCupDao.deleteById(id);
            return fetchConfCup(id) == null;
        }
    }
}
