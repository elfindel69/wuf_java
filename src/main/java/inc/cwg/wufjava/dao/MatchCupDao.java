package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.MatchCup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchCupDao extends JpaRepository<MatchCup,Long> {
    List<MatchCup> findAllByCupId(Long id);
}
