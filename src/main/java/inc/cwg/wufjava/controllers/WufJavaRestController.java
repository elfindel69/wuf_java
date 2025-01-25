package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.CreateMatchDto;
import inc.cwg.wufjava.dto.CreateMatchReturnDto;
import inc.cwg.wufjava.holders.*;
import inc.cwg.wufjava.manager.*;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class WufJavaRestController {

    private final MatchManager matchManager;
    private final NationManager nationManager;
    private final StadiumManager stadiumManager;

    private final RankingManager rankingManager;
    private final WufBoardService wufService;
    private final ConfService confService;
    private final CupManager cupManager;
    private final LeagueManager leagueManager;


 

    @PostMapping("/api/doCalcPoints")
    Points doCalcPoints(@RequestBody CalcPoints calcPoints) {
        int diff = calcPoints.getSc1() - calcPoints.getSc2();
        return CalcPointsManager.doCalcPoints(calcPoints.getPts1(),calcPoints.getPts2(),calcPoints.getCoeff(),diff);
    }

    @PostMapping("/api/doCalcScores")
    Score doCalcScores(@RequestBody Points points) {
        return CalcScoreManager.doCalcScores(points.getPointsHome(),points.getPointsAway());
    }

    @PostMapping("/api/doCreateMatch")
    CreateMatchReturnDto doCreateMatch(@RequestBody CreateMatchDto createMatchDto){


        
        NationHolder home = nationManager.fetchNation(createMatchDto.getHomeNation());
        NationHolder away = nationManager.fetchNation(createMatchDto.getAwayNation());
        StadiumHolder stadiumHolder = stadiumManager.fetchStadium(createMatchDto.getStadium());
        if (home == null || away == null) {
            throw new EntityNotFoundException("One or both nations not found.");
        }
        if (home.equals(away)) {
            throw new IllegalArgumentException("Home and Away nations cannot be the same.");
        }
        if (stadiumHolder == null) {
            throw new EntityNotFoundException("Stadium not found.");
        }
        Score score = CalcScoreManager.doCalcScores(home.getPts(),away.getPts());

        CalcPoints calcPoints = new CalcPoints(home.getPts(),away.getPts(),createMatchDto.getCoeff(),score.getScoreHome(),score.getScoreAway());

        Cup cup = null;
        League league = null;
        if (createMatchDto.getCup() != null){
            CupHolder cupHolder = cupManager.fetchCup(createMatchDto.getCup());
            NationHolder hostHolder = nationManager.fetchNation(cupHolder.getHostName());
            Nation host = nationManager.nationBuilder(hostHolder);
            cup = cupManager.cupBuilder(cupHolder, host );
        }
        if (createMatchDto.getLeague() != null){
           LeagueHolder leagueHolder = leagueManager.fetchLeague(createMatchDto.getLeague());
           league = new League(leagueHolder.getName(), leagueHolder.getEdition(), leagueHolder.getLevel());
        }

        ZonedDateTime matchDate = ZonedDateTime.of(createMatchDto.getDate(), ZoneId.of(createMatchDto.getTimeZone()));
        Stadium stadium = stadiumManager.buildStadium(stadiumHolder);
        CreateMatchHolder createMatchHolder = CreateMatchHolder.builder()
                .homeNation(home)
                .awayNation(away)
                .stadium(stadium)
                .calcPoints(calcPoints)
                .date(matchDate.toLocalDateTime())
                .timeZone(createMatchDto.getTimeZone())
                .cup(cup)
                .league(league)
                .build();


       createMatchHolder = matchManager.doCreateMatch(createMatchHolder);

       return new CreateMatchReturnDto(createMatchHolder);
    }

    @GetMapping("/wufBoard/{id}/ranking")
    List<Nation> getWorldRanking(@PathVariable Long id){
        WufBoard wufBoard = wufService.fetchWufBoard(id);
        return rankingManager.fetchWorldRanking(wufBoard);
    }

    @GetMapping("/conf/{id}/ranking")
    List<Nation> getConfRanking(@PathVariable Long id){
        Conf conf = confService.fetchConf(id);
        return rankingManager.fetchConfRanking(conf);
    }
}
