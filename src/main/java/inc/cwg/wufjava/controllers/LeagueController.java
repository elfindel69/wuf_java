package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.LeagueDto;
import inc.cwg.wufjava.holders.LeagueHolder;
import inc.cwg.wufjava.manager.LeagueManager;
import inc.cwg.wufjava.models.League;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/leagues")
public class LeagueController {
    private final LeagueManager manager;

    @GetMapping("/all")
    public List<LeagueDto> getAllLeagues() {
        return manager.fetchLeagues().stream().map(LeagueDto::new).toList();
    }

    @GetMapping("/{id}")
    public LeagueDto getLeague(@PathVariable Long id) {
        LeagueHolder holder = manager.fetchLeague(id);
        return new LeagueDto(holder);
    }

    @GetMapping("/{name}")
    public LeagueDto getLeague(@PathVariable String name) {
        LeagueHolder holder = manager.fetchLeague(name);
        return new LeagueDto(holder);
    }

    @PostMapping("/save")
    public LeagueDto saveLeague(@RequestBody LeagueDto league){
        LeagueHolder leagueholder = new LeagueHolder(league);
        LeagueHolder savedLeague = manager.saveLeague(leagueholder);
        return new LeagueDto(savedLeague);
    }

    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Long id) {
        manager.delete(id);
    }
}
