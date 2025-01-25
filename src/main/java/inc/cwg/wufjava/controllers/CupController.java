package inc.cwg.wufjava.controllers;


import inc.cwg.wufjava.dto.CupDto;
import inc.cwg.wufjava.holders.CupHolder;
import inc.cwg.wufjava.manager.CupManager;
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
    public List<CupDto> getAllCups() {
        return manager.getAllCups().stream().map(CupDto::new).toList();
    }

    @GetMapping("/all/{id}")
    public List<CupDto> getAllCups(@PathVariable Long id) {
        return manager.fetchCupByNation(id).stream().map(CupDto::new).toList();
    }

    @GetMapping("/{id}")
    public CupDto getCup(@PathVariable Long id) {
        CupHolder holder =  manager.fetchCup(id);
        return new CupDto(holder);
    }

    @GetMapping("/{name}")
    public CupDto getCup(@PathVariable String name) {
        CupHolder holder = manager.fetchCup(name);
        return new CupDto(holder);
    }

    @PostMapping
    public CupDto saveCup(@RequestBody CupDto cup) {
        CupHolder cupholder = new CupHolder(cup);
        CupHolder savedHolder = manager.saveCup(cupholder);
        return new CupDto(savedHolder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        manager.deleteCup(id);
    }
}
