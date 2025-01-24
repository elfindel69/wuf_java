package inc.cwg.wufjava.manager;

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

    public Stadium fetchStadium(Long id) {
        return stadiumService.fetchStadium(id);
    }
    
    public Stadium fetchStadium(String name) {
        return stadiumService.fetchStadium(name);
    }

    public List<Stadium> findAll() {
        return stadiumService.fetchStadiums();
    }

    public List<Stadium> findAll(Long id) {
        Nation nation = nationService.fetchNation(id);
        return stadiumService.fetchStadiums(nation);
    }

    public Stadium save(Stadium stadium) {
        return stadiumService.saveStadium(stadium);
    }

    public boolean delete(Long id) {
        return stadiumService.deleteStadium(id);
    }
}
