package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueDao extends JpaRepository<League,Long> {

    League findFirstByName(String name);
}
