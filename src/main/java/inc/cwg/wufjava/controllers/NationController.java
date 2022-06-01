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
        if(nation.getLastWorldCup() != null){
            CliCup.DoViewCup(nation.getLastWorldCup().getName(),nation.getWorldCupParticipations(),
                    nation.getBestWCResult(),nation.getBestWorldCup().getEdition() );
        }
       if(nation.getLastConfCup() != null){
           CliCup.DoViewCup(nation.getLastConfCup().getName(),nation.getConfCupParticipations(),
                   nation.getBestCCResult(),nation.getBestConfCup().getEdition() );
       }
        if(!nation.getMatchesHome().isEmpty() || !nation.getMatchesAway().isEmpty()){
            char[] results = getLastFiveResults(nation);

            for (char result : results) {
                System.out.print(result);
            }
            System.out.print("\n\n");
            List<Match> matches = getMatches(nation);
            for (Match m:
                    matches) {
                CliMatch.doViewMatches(m);
            }
        }

}

    private char[] getLastFiveResults(Nation nation) {
        List<Match> matches = getMatches(nation);
        int size = 5;
        if (matches.size()<size){
            size = matches.size();
        }
        char[] results = new char[size];
        for(int i = 0; i < size; i++)
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
        return matchService.getFiveLastMatches(nation);
    }
}
