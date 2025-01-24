package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.manager.ConfManager;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/confs")
public class ConfController {

    private final ConfManager confManager;
    ConfManager manager;

    @GetMapping("/{id}/nations")
    public List<Nation> getNations(@RequestAttribute("id") Long id) {
        return manager.getNations(id);
    }

    @GetMapping("/{id}")
    public Conf getConf(@PathVariable Long id) {
        return manager.getConf(id);
    }

    @PostMapping("/save")
    public Conf saveConf(@RequestBody Conf conf) {
        return manager.save(conf);
    }

    @PostMapping("/{id}/delete")
    public void deleteConf(@PathVariable Long id) {
        confManager.delete(id);
    }

}
