package inc.cwg.wufjava.controllers;


import inc.cwg.wufjava.manager.CupManager;
import inc.cwg.wufjava.models.Cup;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/cups")
public class CupController {
    private final CupManager manager;

    @GetMapping("/all")
    public List<Cup> getAllCups() {
        return manager.getAllCups();
    }

    @GetMapping("/all/{id}")
    public List<Cup> getAllCups(@PathVariable Long id) {
        return manager.fetchCupByNation(id);
    }

    @GetMapping("/{id}")
    public Cup getCup(@PathVariable Long id) {
        return manager.fetchCup(id);
    }

    @GetMapping("/{name}")
    public Cup getCup(@PathVariable String name) {
        return manager.fetchCup(name);
    }

    @PostMapping
    public Cup saveCup(@RequestBody Cup cup) {
        return manager.saveCup(cup);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        manager.deleteCup(id);
    }
}
