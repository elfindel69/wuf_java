package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.NationDto;
import inc.cwg.wufjava.holders.NationHolder;
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
    private final NationManager nationManager;

    @GetMapping("/")
    public List<NationDto> getNations() {
        return nationManager.getNations().stream().map(NationDto::new).toList();
    }

    @GetMapping("/{id}")
    public NationDto getNation(@PathVariable Long id) {
        NationHolder holder = nationManager.fetchNation(id);
        return new NationDto(holder);
    }

    @GetMapping("/{name}")
    public NationDto getNation(@PathVariable String name) {
        NationHolder holder = nationManager.fetchNation(name);
        return new NationDto(holder);
    }

    @GetMapping("/{id}/lastMatches")
    public List<Match> getLastFiveMatches(@RequestAttribute("id") Long id) {
        return nationManager.getFiveLastMatches(id);
    }

    @PostMapping("/save")
    public NationDto saveNation(@RequestBody NationDto nation) {
        NationHolder holder = new NationHolder(nation);
        NationHolder savedHolder =  nationManager.saveNation(holder);
        return new NationDto(savedHolder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNation(@PathVariable Long id) {
        nationManager.deleteNation(id);
    }

}
