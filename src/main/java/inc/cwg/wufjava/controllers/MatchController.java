package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.CreateMatchDto;
import inc.cwg.wufjava.dto.CreateMatchReturnDto;
import inc.cwg.wufjava.dto.MatchDto;
import inc.cwg.wufjava.holders.*;
import inc.cwg.wufjava.manager.*;
import inc.cwg.wufjava.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.swing.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {
    private final MatchManager manager;
    private final WufJavaRestController restController;

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

    @PostMapping("/create")
    public CreateMatchReturnDto createMatch(@RequestBody CreateMatchDto match){
       return restController.doCreateMatch(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        manager.delete(id);
    }

}
