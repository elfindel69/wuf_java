package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.CupHolder;
import inc.cwg.wufjava.holders.NationHolder;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.NationService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.services.CupService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component 
@RequiredArgsConstructor
public class CupManager {
    private final CupService cupService;
    private final NationService nationService;
    private final NationManager nationManager;

    public CupHolder fetchCup(Long id) {
        Cup cup = cupService.fetchCup(id);
        return new CupHolder(cup);
    }

    public CupHolder fetchCup(String name) {
        Cup cup = cupService.fetchCup(name);
        return new CupHolder(cup);

    }

    public List<CupHolder> getAllCups() {
        return cupService.fetchAllCups().stream().map(CupHolder::new).toList();
    }

    public List<CupHolder> fetchCupByNation(Long id){
        Nation n = nationService.fetchNation(id);
        return cupService.fetchCupsByNation(n).stream().map(CupHolder::new).toList();
    }

    public CupHolder saveCup(CupHolder cupHolder) {
        NationHolder hostHolder = nationManager.fetchNation(cupHolder.getHostName());
        Nation host = nationManager.nationBuilder(hostHolder);
        Cup cup = cupBuilder(cupHolder, host);
       Cup savedCup =  cupService.saveCup(cup);

        return new CupHolder(savedCup);
    }

    public Cup cupBuilder(CupHolder holder, Nation host) {


        return new Cup(
                holder.getName(),
                holder.getEdition(),
                holder.getFirstDay(),
                holder.getLastDay(),
                host
        );

    }
    public void deleteCup(Long id) {
        cupService.deleteCup(id);
    }
}
