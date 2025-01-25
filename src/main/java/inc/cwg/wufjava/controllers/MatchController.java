package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.MatchDto;
import inc.cwg.wufjava.holders.MatchHolder;
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

    @GetMapping("/all")
    public List<MatchDto> getAllMatches() {
        return manager.getMatches().stream().map(MatchDto::new).toList();
    }
    @GetMapping("/{id}")
    public MatchDto getMatch(Long id) {
        MatchHolder holder = manager.getMatch(id);
        return new MatchDto(holder);
    }


    @GetMapping("/nation/{id}")
    public List<MatchDto> getMatchesByNation(Long id) {
        return manager.getMatchesByNation(id).stream().map(MatchDto::new).toList();
    }



    @PostMapping("/save")
    public MatchDto saveMatch(@RequestBody MatchDto match){
        MatchHolder matchholder = new MatchHolder(match);
        MatchHolder savedMatch =  manager.saveMatch(matchholder);
        return new MatchDto(savedMatch);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        manager.delete(id);
    }

}
