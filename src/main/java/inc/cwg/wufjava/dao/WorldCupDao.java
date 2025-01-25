package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.WorldCup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface WorldCupDao extends JpaRepository<WorldCup,Long> {
}
