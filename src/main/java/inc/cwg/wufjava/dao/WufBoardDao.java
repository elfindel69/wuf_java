package inc.cwg.wufjava.dao;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface WufBoardDao extends JpaRepository<WufBoard,Long> {
    @Query("select w.nations from WufBoard w join Nation n group by n order by n.pts desc ")
    List<Nation> findAllNationsOrderByPtsDesc();
}
