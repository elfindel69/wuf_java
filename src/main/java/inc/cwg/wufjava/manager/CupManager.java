package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.services.CupService;
import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor
public class CupManager {
    private final CupService cupService;

    public Cup fetchCup(String name) {
        return cupService.fetchCup(name);
    }
    
}
