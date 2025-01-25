package inc.cwg.wufjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import inc.cwg.wufjava.models.Cup;
import inc.cwg.wufjava.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CupDao extends JpaRepository<Cup, Long> {

    Cup findFirstByName(String name);

    @Query("select distinct c from Cup c join CountryCup cc on c=cc.cup join Country co on cc.name=co.name where co = :nation")
    List<Cup> findCupsByCountry(@Param("nation") Country nation);
}



