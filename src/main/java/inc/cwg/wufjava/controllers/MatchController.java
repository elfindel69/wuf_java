package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.manager.MatchManager;
import inc.cwg.wufjava.models.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {
    private final MatchManager manager;

    @GetMapping("/{id}")
    public Match getMatch(Long id) {
        return manager.getMatch(id);
    }

    @GetMapping("/nation/{id}")
    public List<Match> getMatchesByNation(Long id) {
        return manager.getMatchesByNation(id);
    }

    @GetMapping("/nation/{id}/lastFive")
    public List<Match> getLastFiveMatchesByNation(Long id) {
        return manager.getLastFiveMatches(id);
    }

    @PostMapping("/save")
    public Match saveMatch(@RequestBody Match match){
        return manager.saveMatch(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        manager.delete(id);
    }

}
