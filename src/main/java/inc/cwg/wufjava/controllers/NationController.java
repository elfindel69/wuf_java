package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.manager.NationManager;
import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/nations")

public class NationController {
    NationManager nationManager;


    @GetMapping("/{id}")
    public Nation getNation(@PathVariable Long id) {
        return nationManager.fetchNation(id);
    }

    @GetMapping("/{name}")
    public Nation getNation(@PathVariable String name) {
        return nationManager.fetchNation(name);
    }

    @GetMapping("/{id}/lastMatches")
    public List<Match> getLastMatches(@RequestAttribute("id") Long id) {
        return nationManager.getMatches(id);
    }

    @PostMapping("/save")
    public Nation saveNation(@RequestBody Nation nation) {
        return nationManager.saveNation(nation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNation(@PathVariable Long id) {
        nationManager.deleteNation(id);
    }

}
