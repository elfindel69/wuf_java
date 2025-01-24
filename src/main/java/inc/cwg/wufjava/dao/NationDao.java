package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface NationDao extends JpaRepository<Nation,Long> {

    List<Nation> findAllByConf(Conf conf);

    Nation findFirstByName(String s);
}
