package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.ConfCup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ConfCupDao extends JpaRepository<ConfCup,Long> {
}
