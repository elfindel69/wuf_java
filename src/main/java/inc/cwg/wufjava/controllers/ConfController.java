package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.ConfDto;
import inc.cwg.wufjava.dto.NationDto;
import inc.cwg.wufjava.holders.ConfHolder;
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
    public List<ConfDto> getAllConfs() {
        return confManager.getConfs().stream().map(ConfDto::new).toList();
    }
    @GetMapping("/{id}/nations")
    public List<NationDto> getNations(@RequestAttribute("id") Long id) {
        return confManager.getNations(id).stream().map(NationDto::new).toList();
    }

    @GetMapping("/{id}")
    public ConfDto getConf(@PathVariable Long id) {
        ConfHolder holder = confManager.getConf(id);
        return new ConfDto(holder);
    }

    @PostMapping("/save")
    public ConfDto saveConf(@RequestBody ConfDto conf) {
        ConfHolder holder = new ConfHolder(conf);
        ConfHolder savedHolder =  confManager.save(holder);
        return new ConfDto(savedHolder);
    }

    @PostMapping("/{id}/delete")
    public void deleteConf(@PathVariable Long id) {
        confManager.delete(id);
    }

}
