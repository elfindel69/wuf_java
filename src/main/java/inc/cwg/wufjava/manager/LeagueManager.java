package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.LeagueHolder;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.League;
import inc.cwg.wufjava.services.LeagueService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LeagueManager {

    private final LeagueService leagueService;

    public LeagueHolder fetchLeague(Long id) {
        League league = leagueService.fetchLeague(id);
        return new LeagueHolder(league);
    }
    public LeagueHolder fetchLeague(String name) {
        League league = leagueService.fetchLeague(name);
        return new LeagueHolder(league);
    }

    public List<LeagueHolder> fetchLeagues() {
        return leagueService.fetchLeagues().stream().map(LeagueHolder::new).toList();
    }

    public LeagueHolder saveLeague(LeagueHolder leagueHolder) {
        League league = new League(leagueHolder.getName(),leagueHolder.getEdition(),leagueHolder.getLevel());
        League savedLeague = leagueService.saveLeague(league);
        return new LeagueHolder(savedLeague);
    }

    public void delete(Long id) {
        leagueService.deleteLeague(id);
    }
}

