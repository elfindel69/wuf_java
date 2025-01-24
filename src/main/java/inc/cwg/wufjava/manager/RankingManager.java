package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RankingManager {
    public List<Nation> fetchWorldRanking(WufBoard wuf) {
        List<Nation> nations = wuf.getNations();
        nations = nations.stream().sorted(Comparator.comparingDouble(Nation::getPts).reversed()).toList();
        return nations;
    }

    public List<Nation> fetchConfRanking(Conf conf) {
        List<Nation> nations = conf.getNations();
        nations = nations.stream().sorted(Comparator.comparingDouble(Nation::getPts).reversed()).toList();
        return nations;
    }
}
