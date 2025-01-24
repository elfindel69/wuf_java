package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface ConfDao extends JpaRepository<Conf,Long> {
    @Query("select c.nations from Conf c join Nation n group by n order by n.pts desc ")
    List<Nation> findAllNationsOrderByPtsDesc();
}
