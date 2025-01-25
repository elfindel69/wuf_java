package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.StadiumHolder;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.NationService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Stadium;
import inc.cwg.wufjava.services.StadiumService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StadiumManager {

    private final StadiumService stadiumService;
    private final NationService nationService;

    public StadiumHolder fetchStadium(Long id) {
        Stadium stadium =  stadiumService.fetchStadium(id);
        return new StadiumHolder(stadium);
    }
    
    public StadiumHolder fetchStadium(String name) {
        Stadium stadium =  stadiumService.fetchStadium(name);
        return new StadiumHolder(stadium);
    }

    public List<StadiumHolder> findAll() {
        return stadiumService.fetchStadiums().stream().map(StadiumHolder::new).toList();
    }

    public List<StadiumHolder> findAll(Long id) {
        Nation nation = nationService.fetchNation(id);
        return stadiumService.fetchStadiums(nation).stream().map(StadiumHolder::new).toList();
    }

    public StadiumHolder save(StadiumHolder holder) {
        Stadium stadium = buildStadium(holder);
        Stadium savedStadium =  stadiumService.saveStadium(stadium);
        return new StadiumHolder(savedStadium);
    }

    public boolean delete(Long id) {
        return stadiumService.deleteStadium(id);
    }

    public Stadium buildStadium(StadiumHolder stadiumHolder) {
        Nation country = nationService.fetchNation(stadiumHolder.getCountry());
        return new Stadium(
                stadiumHolder.getName(),
                stadiumHolder.getCity(),
                country
        );

    }
}
