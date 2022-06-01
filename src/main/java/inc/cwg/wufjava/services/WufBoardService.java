package inc.cwg.wufjava.services;

import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WorldCup;
import inc.cwg.wufjava.models.WufBoard;

import java.time.LocalDate;
import java.util.List;


public interface WufBoardService {

    WufBoard addWufBoard(String name, String adjective, int nbMembers, String dof);

    WufBoard fetchWufBoard(long id);

    WufBoard saveWufBoard(WufBoard wufBoard);

    boolean deleteWufBoard(long id);

    List<Nation> fetchWorldRanking();
}
