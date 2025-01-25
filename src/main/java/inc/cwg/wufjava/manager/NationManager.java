package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.MatchHolder;
import inc.cwg.wufjava.holders.NationHolder;
import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.*;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NationManager {
    private final NationService nationService;
    private final MatchService matchService;
    private final WufBoardService wufBoardService;
    private final StadiumService stadiumService;
    private final ConfService confService;

    public NationHolder fetchNation(Long id) {
        Nation nation = nationService.fetchNation(id);
        return new NationHolder(nation);
    }

    public NationHolder fetchNation(String name) {

        Nation nation =  nationService.fetchNation(name);
        return new NationHolder(nation);
    }

    public List<Match> getMatches(Long id) {
        Nation nation = nationService.fetchNation(id);
        return matchService.fetchMatches(nation);
    }

    public NationHolder saveNation(NationHolder holder) {

        Nation nationToSave = nationBuilder(holder);
        Nation savedNation = nationService.saveNation(nationToSave);
        return new NationHolder(savedNation);
    }

    public Nation nationBuilder(NationHolder holder) {
        WufBoard wuf = wufBoardService.fetchWufBoard(1L);
        Stadium stadium = stadiumService.fetchMainStadium(holder.getId());
        Conf conf = confService.getConfByNation(holder.getId());
        return new Nation(
                holder.getName(),
                holder.getPts(),
                0,
                conf,
                holder.getAdmissionYear(),
                stadium,
                holder.getWufRanking(),
                holder.getConfRanking(),
                holder.getTimeZone(),
                wuf
        );
    }
    public void deleteNation(Long id) {
        nationService.deleteNation(id);
    }

    public List<NationHolder> getNations() {
       return nationService.fetchNations().stream().map(NationHolder::new).toList();
    }

    public List<MatchHolder> getFiveLastMatches(Long id) {
        Nation n = nationService.fetchNation(id);
        List<Match> matches = matchService.fetchMatches(n).stream().toList().reversed().subList(0,5);
        return matches.stream().map(MatchHolder::new).toList();
    }
}
