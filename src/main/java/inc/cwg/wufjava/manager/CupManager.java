package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.CountryCup;
import inc.cwg.wufjava.services.CountryCupService;
import inc.cwg.wufjava.services.NationService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.services.CupService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component 
@RequiredArgsConstructor
public class CupManager {
    private final CupService cupService;
    private final CountryCupService countryCupService;

    public Cup fetchCup(Long id) { return cupService.fetchCup(id);}

    public Cup fetchCup(String name) {
        return cupService.fetchCup(name);
    }

    public List<Cup> getAllCups() {
        return cupService.fetchAllCups();
    }

    public List<Cup> fetchCupByNation(Long id){
        CountryCup countryCup = countryCupService.fetchCountryCup(id);
        return cupService.fetchAllCups(countryCup);
    }

    public Cup saveCup(Cup cup) {
        return cupService.saveCup(cup);
    }

    public void deleteCup(Long id) {
        cupService.deleteCup(id);
    }
}
