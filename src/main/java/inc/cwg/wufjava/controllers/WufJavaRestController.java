package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.CreateMatchDto;
import inc.cwg.wufjava.enums.MatchType;
import inc.cwg.wufjava.holders.CreateMatchHolder;
import inc.cwg.wufjava.manager.CalcPointsManager;
import inc.cwg.wufjava.manager.CupManager;
import inc.cwg.wufjava.manager.LeagueManager;
import inc.cwg.wufjava.manager.MatchManager;
import inc.cwg.wufjava.manager.NationManager;
import inc.cwg.wufjava.manager.StadiumManager;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class WufJavaRestController {

    private final MatchManager matchManager;
    private final NationManager nationManager;
    private final StadiumManager stadiumManager;

    private final RankingController rankingController;
    private final WufBoardService wufService;
    private final ConfService confService;
    private CupManager cupManager;
    private LeagueManager leagueManager;


 

    @PostMapping("/api/doCalcPoints")
    Points doCalcPoints(@RequestBody CalcPoints calcPoints) {
        int diff = calcPoints.getSc1() - calcPoints.getSc2();
        return CalcPointsManager.doCalcPoints(calcPoints.getPts1(),calcPoints.getPts2(),calcPoints.getCoeff(),diff);
    }

    @PostMapping("/api/doCalcScores")
    Score doCalcScores(@RequestBody Points points) {
        return CalcScoreController.doCalcScores(points.getPointsHome(),points.getPointsAway());
    }

    @PostMapping("api/doCreateMatch")
    CreateMatchDto doCreateMatch(@RequestBody CreateMatchDto createMatchDto){


        
        Nation home = nationManager.fetchNation(createMatchDto.getHomeNation());
        Nation away = nationManager.fetchNation(createMatchDto.getAwayNation());
        Stadium stadium = stadiumManager.fetchStadium(createMatchDto.getStadium());

        CalcPoints calcPoints = new CalcPoints(createMatchDto.getHomePoints(),createMatchDto.getAwayPoints(),createMatchDto.getCoeff(),createMatchDto.getHomeScore(),createMatchDto.getAwayScore());
        MatchType matchType = MatchType.getMatchType(createMatchDto.getType());
        Cup cup = null;
        League league = null;
        if (createMatchDto.getCup() != null){
            cup = cupManager.fetchCup(createMatchDto.getCup());
           
        } else {
            league = leagueManager.fetchLeague(createMatchDto.getLeague());
        }

        CreateMatchHolder createMatchHolder = CreateMatchHolder.builder()
                .homeNation(home)
                .awayNation(away)
                .stadium(stadium)
                .calcPoints(calcPoints)
                .matchType(matchType)
                .date(createMatchDto.getDate())
                .timeZone(createMatchDto.getTimeZone())
                .cup(cup)
                .league(league)
                .build();


       createMatchHolder = matchManager.doCreateMatch(createMatchHolder);

       return new CreateMatchDto(createMatchHolder);
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
