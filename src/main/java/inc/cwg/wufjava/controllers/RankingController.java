package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class RankingController {


    public  List<Nation> fetchWorldRanking(WufBoard wuf) {
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
