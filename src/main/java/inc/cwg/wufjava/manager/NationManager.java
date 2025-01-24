package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.services.MatchService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.NationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NationManager {
    private final NationService nationService;
    private final MatchService matchService;

    public Nation fetchNation(Long id) {
        return nationService.fetchNation(id);
    }

    public Nation fetchNation(String name) {
        return nationService.fetchNation(name);
    }

    public List<Match> getMatches(Long id) {
        Nation nation = fetchNation(id);
        return matchService.getFiveLastMatches(nation);
    }

    public Nation saveNation(Nation nation) {
        return nationService.saveNation(nation);
    }

    public void deleteNation(Long id) {
        nationService.deleteNation(id);
    }
}
