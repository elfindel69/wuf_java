package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import inc.cwg.wufjava.models.Cup;

import java.util.List;


public interface CupDao extends JpaRepository<Cup, Long> {

    Cup findFirstByName(String name);

    List<Cup> findCupsByCountry(Nation nation);
}



