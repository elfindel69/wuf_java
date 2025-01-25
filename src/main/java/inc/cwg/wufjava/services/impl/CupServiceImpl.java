package inc.cwg.wufjava.services.impl;

import inc.cwg.wufjava.dao.CupDao;
import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.CupService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CupServiceImpl implements CupService {

    private final CupDao cupDao;

    @Override
    public Cup fetchCup(String name) {
       return cupDao.findFirstByName(name);
    }

    @Override
    public List<Cup> fetchAllCups(CountryCup countryCup) {
        return cupDao.findAll();
    }

    @Override
    public Cup fetchCup(Long id) {
        return cupDao.findById(id).orElse(null);
    }

    @Override
    public Cup saveCup(Cup c) {
        return cupDao.save(c);
    }

    @Override
    public void deleteCup(Long id) {
        cupDao.deleteById(id);
    }

    @Override
    public List<Cup> fetchAllCups() {
        return cupDao.findAll();
    }

    @Override
    public List<Cup> fetchCupsByNation(Nation n){
        return cupDao.findCupsByCountry(n);
    }



}
