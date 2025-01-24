package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.manager.StadiumManager;
import inc.cwg.wufjava.models.Stadium;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumManager manager;

    @GetMapping("/all")
    public List<Stadium> getAllStadiums() {
        return manager.findAll();
    }

    @GetMapping("/all/{id}")
    public List<Stadium> getAllStadiums(@PathVariable Long id) {
        return manager.findAll(id);
    }

    @GetMapping("/{id}")
    public Stadium getStadium(@PathVariable Long id){
        return manager.fetchStadium(id);
    }

    @GetMapping("/{name}")
    public Stadium getStadium(@PathVariable String name){
        return manager.fetchStadium(name);
    }

    @PostMapping
    public Stadium saveStadium(@RequestBody Stadium stadium){
        return manager.save(stadium);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStadium(@PathVariable Long id){
        return manager.delete(id);

    }
}
