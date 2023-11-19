package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.NationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NationManager {
    private final NationService nationService;

    public Nation fetchNation(Long id) {
        return nationService.fetchNation(id);
    }

    public Nation fetchNation(String name) {
        return nationService.fetchNation(name);
    }
}
