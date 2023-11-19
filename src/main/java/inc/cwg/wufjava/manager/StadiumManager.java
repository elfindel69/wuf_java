package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Stadium;
import inc.cwg.wufjava.services.StadiumService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StadiumManager {

    private final StadiumService stadiumService;

    public Stadium fetchStadium(Long id) {
        return stadiumService.fetchStadium(id);
    }
    
    public Stadium fetchStadium(String name) {
        return stadiumService.fetchStadium(name);
    }
    
}
