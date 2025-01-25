package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StadiumDao extends JpaRepository<Stadium,Long> {

    Stadium findFirstByName(String name);

    List<Stadium> getAllByCountry(Nation nation);

    @Query("select s from Stadium s join Nation n on s.country = n where n.id = :id")
    Stadium findStadiumByNationId(@Param("id") Long id);
}
