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

    @GetMapping("/all")
    public List<Conf> getAllConfs() {
        return confManager.getConfs();
    }
    @GetMapping("/{id}/nations")
    public List<Nation> getNations(@RequestAttribute("id") Long id) {
        return confManager.getNations(id);
    }

    @GetMapping("/{id}")
    public Conf getConf(@PathVariable Long id) {
        return confManager.getConf(id);
    }

    @PostMapping("/save")
    public Conf saveConf(@RequestBody Conf conf) {
        return confManager.save(conf);
    }

    @PostMapping("/{id}/delete")
    public void deleteConf(@PathVariable Long id) {
        confManager.delete(id);
    }

}
