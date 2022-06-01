package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.cli.CliCup;
import inc.cwg.wufjava.cli.CliMatch;
import inc.cwg.wufjava.cli.CliNation;
import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.services.MatchService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NationController {
    private final MatchService matchService;

    public NationController(MatchService matchService) {
        this.matchService = matchService;
    }

    public void viewNation(Nation nation){
        CliNation.doViewNation(nation);
        CliCup.DoViewCup(nation.getLastWorldCup().getName(),nation.getWorldCupParticipations(),
                nation.getBestWCResult(),nation.getBestWorldCup().getEdition() );
        CliCup.DoViewCup(nation.getLastConfCup().getName(),nation.getConfCupParticipations(),
                nation.getBestCCResult(),nation.getBestConfCup().getEdition() );
        char[] results = getLastFiveResults(nation);
        for(int i = 0;i<5;i++){
            System.out.print(results[i]);
        }
        System.out.print("\n\n");
        List<Match> matches = getMatches(nation);
        for (Match m:
             matches) {
            CliMatch.doViewMatches(m);
        }
}

    private char[] getLastFiveResults(Nation nation) {
        List<Match> matches = getMatches(nation);
        char[] results = new char[5];
        for(int i = 0; i < 5; i++)
        {
            if ((matches.get(i).getHomeNation().getName().equals(nation.getName()) && matches.get(i).getScHome() > matches.get(i).getScAway())
                    || (matches.get(i).getAwayNation().getName().equals(nation.getName()) && matches.get(i).getScHome() < matches.get(i).getScAway()))
            {
                results[i] = 'V';
            }
            else if (matches.get(i).getScHome() == matches.get(i).getScAway())
            {
                results[i] = 'N';
            }
            else
            {
                results[i] = 'D';
            }
        }
        return results;
    }

    private List<Match> getMatches(Nation nation) {
        List<Match> matches = matchService.getFiveLastMatches(nation);
        return matches;
    }
}
