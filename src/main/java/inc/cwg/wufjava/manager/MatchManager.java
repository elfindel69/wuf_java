package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.holders.CreateMatchHolder;
import inc.cwg.wufjava.models.CalcPoints;
import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.MatchCup;
import inc.cwg.wufjava.models.MatchLeague;
import inc.cwg.wufjava.models.Points;
import inc.cwg.wufjava.services.MatchService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MatchManager {

    private final MatchService matchService;

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
        calcPoints.setPts1((int) newPoints.getPointsHome());
        calcPoints.setPts2((int) newPoints.getPointsAway());
        createMatchHolder.setCalcPoints(calcPoints);
        return createMatchHolder;
    }
}
