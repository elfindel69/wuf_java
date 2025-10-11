package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.MatchCupHolder;
import inc.cwg.wufjava.holders.MatchHolder;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.MatchCupService;
import inc.cwg.wufjava.services.NationService;
import inc.cwg.wufjava.services.StadiumService;
import org.springframework.stereotype.Component;

import inc.cwg.wufjava.holders.CalcPoints;
import inc.cwg.wufjava.holders.CreateMatchHolder;
import inc.cwg.wufjava.services.MatchService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MatchManager {

    private final MatchService matchService;
    private final NationService nationService;
    private final MatchCupService matchCupService;
    private final StadiumService stadiumService;

    public CreateMatchHolder doCreateMatch(CreateMatchHolder createMatchHolder) {

        Nation homeNation = nationService.fetchNation(createMatchHolder.getHomeNation().getId());
        Nation awayNation = nationService.fetchNation(createMatchHolder.getAwayNation().getId());
        Match match = new Match(homeNation,
                awayNation,
                createMatchHolder.getCalcPoints().getSc1(),
                createMatchHolder.getCalcPoints().getSc2(),
                createMatchHolder.getDate(),
                createMatchHolder.getTimeZone(),
                createMatchHolder.getStadium()
        );

        if (createMatchHolder.getCup() != null) {
            match = new MatchCup(homeNation,
                    awayNation,
                    createMatchHolder.getCalcPoints().getSc1(),
                    createMatchHolder.getCalcPoints().getSc2(),
                    createMatchHolder.getDate(),
                    createMatchHolder.getTimeZone(),
                    createMatchHolder.getStadium(),
                    createMatchHolder.getCup()
            );
        }
        if (createMatchHolder.getLeague() != null) {
            match = new MatchLeague(homeNation,
                    awayNation,
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


        homeNation.setPts(newPoints.getPointsHome());
        nationService.saveNation(homeNation);


        awayNation.setPts(newPoints.getPointsAway());
        nationService.saveNation(awayNation);

        createMatchHolder.setCalcPoints(calcPoints);
        return createMatchHolder;
    }

    public List<MatchHolder> getMatches() {
        return matchService.fetchMatches().stream().map(MatchHolder::new).toList();
    }

    public MatchHolder getMatch(Long id) {
        Match match = matchService.fetchMatch(id);
        return new MatchHolder(match);
    }

    public List<MatchHolder> getMatchesByNation(Long id) {
        Nation nation = nationService.fetchNation(id);
        return matchService.fetchMatches(nation).stream().map(MatchHolder::new).toList();
    }

    public List<MatchCupHolder> fetchMatchesByCup(Long id) {

        List<MatchCup> matches = matchCupService.fetchMatchesCup(id);
        return matches.stream().map(MatchCupHolder::new).toList();
    }



    public MatchHolder saveMatch(MatchHolder match) {
        Match matchToSave = matchBuilder(match);
        Match savedMatch = matchService.saveMatch(matchToSave);
        return new MatchHolder(savedMatch);
    }

    private Match matchBuilder(MatchHolder match) {
        Nation homeNation = nationService.fetchNation(match.getHomeTeam());
        Nation awayNation = nationService.fetchNation(match.getAwayTeam());
        Stadium venue = stadiumService.fetchStadium(match.getStadium());
        return new Match (
                homeNation,
                awayNation,
                match.getScHome(),
                match.getScAway(),
                LocalDateTime.parse(match.getMatchTime()),
                match.getTimeZone(),
                venue
        );
    }
    public void delete(Long id) {
        matchService.deleteMatch(id);
    }
}

