package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.services.LeagueService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LeagueManager {

    private final LeagueService leagueService;

    public League fetchLeague(Long id) {
        return leagueService.fetchLeague(id);
    }
    public League fetchLeague(String name) {
        return leagueService.fetchLeague(name);
    }

    public List<League> fetchLeagues() {
        return leagueService.fetchLeagues();
    }

    public League saveLeague(League league) {
        return leagueService.saveLeague(league);
    }

    public void delete(Long id) {
        leagueService.deleteLeague(id);
    }
}

