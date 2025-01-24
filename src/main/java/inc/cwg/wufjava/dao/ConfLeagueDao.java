package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.ConfLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface ConfLeagueDao extends JpaRepository<ConfLeague,Long> {
}
