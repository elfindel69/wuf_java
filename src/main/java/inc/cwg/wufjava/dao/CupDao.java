package inc.cwg.wufjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.cwg.wufjava.models.Cup;


public interface CupDao extends JpaRepository<Cup, Long> {

    Cup findFirstByName(String name);

}



