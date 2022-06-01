package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.ConfDao;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfServiceImpl implements ConfService {
    private final ConfDao confDao;

    public ConfServiceImpl(ConfDao confDao) {
        this.confDao = confDao;
    }

    @Override
    public Conf addConf(String name, String adjective, int nbMembers, String dof, WufBoard wuf) {
        return confDao.save(new Conf(name,adjective,nbMembers,dof, wuf));
    }

    @Override
    public List<Conf> fetchConfs() {
        return confDao.findAll();
    }

    @Override
    public Conf fetchConf(long id) {
        return confDao.findById(id).orElse(null);
    }

    @Override
    public Conf saveConf(Conf c) {
        return confDao.save(c);
    }

    @Override
    public boolean deleteConf(long id) {
        Conf conf = fetchConf(id);
        if(conf == null){
            return false;
        }else {
            confDao.deleteById(id);
            return fetchConf(id) == null;
        }
    }

    @Override
    public List<Nation> fetchConfRanking() {
        return confDao.findAllNationsOrderByPtsDesc();
    }
}
