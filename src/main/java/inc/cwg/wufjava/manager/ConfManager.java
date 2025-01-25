package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.ConfHolder;
import inc.cwg.wufjava.holders.NationHolder;
import inc.cwg.wufjava.holders.WufBoardHolder;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.NationService;
import inc.cwg.wufjava.services.WufBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ConfManager {
    private final ConfService confService;
    private final NationService nationService;
    private final WufBoardService wufBoardService;

    public List<NationHolder> getNations(Long id) {
        Conf conf = confService.fetchConf(id);
        return nationService.fetchNationsByConf(conf).stream().map(NationHolder::new).toList();
    }

    public ConfHolder getConf(Long id) {
        Conf conf = confService.fetchConf(id);
        return new ConfHolder(conf);
    }

    public ConfHolder save(ConfHolder confHolder) {
        WufBoard wufBoard = wufBoardService.fetchWufBoard(1L);
        Conf confToSave = buildConfFromHolder(confHolder, wufBoard);
        Conf savedConf = confService.saveConf(confToSave);
        return new ConfHolder(savedConf);
    }

    private Conf buildConfFromHolder(ConfHolder confHolder, WufBoard wufBoard) {
        return new Conf(
                confHolder.getName(),
                confHolder.getAdjective(),
                confHolder.getNbMembers(),
                confHolder.getDof(),
                wufBoard
        );
    }


    public void delete(Long id) {
        confService.deleteConf(id);
    }

    public List<ConfHolder> getConfs() {
        return confService.fetchConfs().stream().map(ConfHolder::new).toList();
    }
}
