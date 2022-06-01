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
    private final WufBoardService wufBoardService;
    private final ConfService confService;

    public RankingController(WufBoardService wufBoardService, ConfService confService) {
        this.wufBoardService = wufBoardService;
        this.confService = confService;
    }

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

    public  void viewRanking(List<Nation> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(i + 1 + " - " + list.get(i).getName() + " - " + list.get(i).getPts());
        }
    }
}
