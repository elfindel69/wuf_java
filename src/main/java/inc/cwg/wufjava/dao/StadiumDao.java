package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StadiumDao extends JpaRepository<Stadium,Long> {

    Stadium findFirstByName(String name);

    List<Stadium> getAllByCountry(Nation nation);
}
