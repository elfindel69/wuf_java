package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WufJavaRestController {

    private final RankingController rankingController;
    private final WufBoardService wufService;
    private final ConfService confService;

    public WufJavaRestController(RankingController rankingController, WufBoardService wufService, ConfService confService) {

        this.rankingController = rankingController;
        this.wufService = wufService;
        this.confService = confService;
    }

    @PostMapping("/api/doCalcPoints")
    Points doCalcPoints(@RequestBody CalcPoints calcPoints) {
        int diff = calcPoints.getSc1() - calcPoints.getSc2();
        return CalcPointsController.doCalcPoints(calcPoints.getPts1(),calcPoints.getPts2(),calcPoints.getCoeff(),diff);
    }

    @PostMapping("/api/doCalcScores")
    Score doCalcScores(@RequestBody Points points) {
        return CalcScoreController.doCalcScores(points.getPointsHome(),points.getPointsAway());
    }
    @GetMapping("/wufBoard/{id}/ranking")
    List<Nation> getWorldRanking(@PathVariable Long id){
        WufBoard wufBoard = wufService.fetchWufBoard(id);
        return rankingController.fetchWorldRanking(wufBoard);
    }

    @GetMapping("/conf/{id}/ranking")
    List<Nation> getConfRanking(@PathVariable Long id){
        Conf conf = confService.fetchConf(id);
        return rankingController.fetchConfRanking(conf);
    }
}
