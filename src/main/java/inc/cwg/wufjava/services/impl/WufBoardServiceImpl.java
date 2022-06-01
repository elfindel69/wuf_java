package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.WufBoardDao;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.WufBoardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WufBoardServiceImpl implements WufBoardService {
    private final WufBoardDao wufBoardDao;

    public WufBoardServiceImpl(WufBoardDao wufBoardDao) {
        this.wufBoardDao = wufBoardDao;
    }

    @Override
    public WufBoard addWufBoard(String name, String adjective, int nbMembers, String dof) {
        return wufBoardDao.save(new WufBoard(name,adjective,nbMembers,dof));
    }

    @Override
    public WufBoard fetchWufBoard(long id) {
        return wufBoardDao.findById(id).orElse(null);
    }

    @Override
    public WufBoard saveWufBoard(WufBoard wufBoard) {
        return wufBoardDao.save(wufBoard);
    }

    @Override
    public boolean deleteWufBoard(long id) {
        WufBoard wufBoard = fetchWufBoard(id);
        if(wufBoard == null){
            return false;
        }else {
            wufBoardDao.deleteById(id);
            return fetchWufBoard(id) == null;
        }
    }

    @Override
    public List<Nation> fetchWorldRanking() {
        return wufBoardDao.findAllNationsOrderByPtsDesc();
    }
}
