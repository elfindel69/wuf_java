package inc.cwg.wufjava.controllers;

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
    public List<League> getAllLeagues() {
        return manager.fetchLeagues();
    }

    @GetMapping("/{id}")
    public League getLeague(@PathVariable Long id) {
        return manager.fetchLeague(id);
    }

    @GetMapping("/{name}")
    public League getLeague(@PathVariable String name) {
        return manager.fetchLeague(name);
    }

    @PostMapping("/save")
    public League saveLeague(@RequestBody League league){
        return manager.saveLeague(league);
    }

    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Long id) {
        manager.delete(id);
    }
}
