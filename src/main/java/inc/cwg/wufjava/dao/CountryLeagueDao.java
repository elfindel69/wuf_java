package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.CountryLeague;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLeagueDao extends JpaRepository<CountryLeague,Long> {
}
