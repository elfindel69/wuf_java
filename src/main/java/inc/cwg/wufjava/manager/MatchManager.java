package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.NationService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.holders.CalcPoints;
import inc.cwg.wufjava.holders.CreateMatchHolder;
import inc.cwg.wufjava.services.MatchService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MatchManager {

    private final MatchService matchService;
    private final NationService nationService;

    public CreateMatchHolder doCreateMatch(CreateMatchHolder createMatchHolder) {

        Match match =  new Match(createMatchHolder.getHomeNation(),
            createMatchHolder.getAwayNation(),
            createMatchHolder.getCalcPoints().getSc1(),
            createMatchHolder.getCalcPoints().getSc2(),
            createMatchHolder.getDate(),
            createMatchHolder.getTimeZone(),
            createMatchHolder.getStadium()
            );

        if (createMatchHolder.getCup() != null){
            match = new MatchCup(createMatchHolder.getHomeNation(),
            createMatchHolder.getAwayNation(),
            createMatchHolder.getCalcPoints().getSc1(),
            createMatchHolder.getCalcPoints().getSc2(),
            createMatchHolder.getDate(),
            createMatchHolder.getTimeZone(),
            createMatchHolder.getStadium(),
            createMatchHolder.getCup()
            );
        }
        if (createMatchHolder.getLeague() != null){
            match = new MatchLeague(createMatchHolder.getHomeNation(),
            createMatchHolder.getAwayNation(),
            createMatchHolder.getCalcPoints().getSc1(),
            createMatchHolder.getCalcPoints().getSc2(),
            createMatchHolder.getDate(),
            createMatchHolder.getTimeZone(),
            createMatchHolder.getStadium(),
            createMatchHolder.getLeague()
            );
        }

        matchService.saveMatch(match);

        CalcPoints calcPoints = createMatchHolder.getCalcPoints();
        int diff = calcPoints.getSc1() - calcPoints.getSc2();

        Points newPoints = CalcPointsManager.doCalcPoints(calcPoints.getPts1(), calcPoints.getPts2(), calcPoints.getCoeff(), diff);
        calcPoints.setPts1(newPoints.getPointsHome());
        calcPoints.setPts2(newPoints.getPointsAway());

        Nation homeNation = createMatchHolder.getHomeNation();
        homeNation.setPts(newPoints.getPointsHome());
        nationService.saveNation(homeNation);

        Nation awayNation = createMatchHolder.getAwayNation();
        awayNation.setPts(newPoints.getPointsAway());
        nationService.saveNation(awayNation);

        createMatchHolder.setCalcPoints(calcPoints);
        return createMatchHolder;
    }
}
