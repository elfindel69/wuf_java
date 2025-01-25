package inc.cwg.wufjava.services;


import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.Nation;

import java.util.List;

public interface CupService {


    Cup fetchCup(String name);

    List<Cup> fetchAllCups(CountryCup countryCup);

    Cup fetchCup(Long id);

    Cup saveCup(Cup c);

    void deleteCup(Long id);



    List<Cup> fetchAllCups();

    List<Cup> fetchCupsByNation(Nation n);
}
    
