package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.CupDao;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.services.CupService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CupServiceImpl implements CupService {

    private final CupDao cupDao;

    @Override
    public Cup fetchCup(String name) {
       return cupDao.findFirstByName(name);
    }
    
}
