package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Match;
import inc.cwg.wufjava.models.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface MatchDao extends JpaRepository<Match,Long> {
    @Query(value = "select distinct m from matches m" +
            " where m.awayNation =:nation or m.homeNation =:nation")
    List<Match> getMatchesByNation(Nation nation);
}
