package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.StadiumDto;
import inc.cwg.wufjava.holders.StadiumHolder;
import inc.cwg.wufjava.manager.StadiumManager;
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
    public List<StadiumDto> getAllStadiums() {
       return manager.findAll().stream().map(StadiumDto::new).toList();
    }

    @GetMapping("/all/{id}")
    public List<StadiumDto> getAllStadiums(@PathVariable Long id) {
        return manager.findAll(id).stream().map(StadiumDto::new).toList();
    }

    @GetMapping("/{id}")
    public StadiumDto getStadium(@PathVariable Long id){
        StadiumHolder holder = manager.fetchStadium(id);
        return new StadiumDto(holder);
    }

    @GetMapping("/{name}")
    public StadiumDto getStadium(@PathVariable String name){
        StadiumHolder holder = manager.fetchStadium(name);
        return new StadiumDto(holder);
    }

    @PostMapping
    public StadiumDto saveStadium(@RequestBody StadiumDto stadium){
        StadiumHolder stadiumholder = new StadiumHolder(stadium);
        StadiumHolder savedHolder = manager.save(stadiumholder);
        return new StadiumDto(savedHolder);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStadium(@PathVariable Long id){
        return manager.delete(id);

    }
}
