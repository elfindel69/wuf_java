package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.NationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConfManager {
    private final ConfService confService;
    private final NationService nationService;

    public List<Nation> getNations(Long id) {
        Conf conf = confService.fetchConf(id);
        return nationService.fetchNationsByConf(conf);
    }

    public Conf getConf(Long id) {
        return confService.fetchConf(id);
    }

    public Conf save(Conf conf) {
        return confService.saveConf(conf);
    }

    public void delete(Long id) {
        confService.deleteConf(id);
    }

    public List<Conf> getConfs() {
        return confService.fetchConfs();
    }
}
