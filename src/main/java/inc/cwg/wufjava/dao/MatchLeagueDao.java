package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.MatchLeague;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchLeagueDao extends JpaRepository<MatchLeague,Long> {
}
