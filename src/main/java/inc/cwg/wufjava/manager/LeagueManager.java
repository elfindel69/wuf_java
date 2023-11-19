package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.services.LeagueService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LeagueManager {

    private final LeagueService leagueService;

    public League fetchLeague(String name) {
        return leagueService.fetchLeague(name);
    }

}

