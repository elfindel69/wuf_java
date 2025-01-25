package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.holders.ConfHolder;
import inc.cwg.wufjava.holders.WufBoardHolder;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WufBoardManager {
    private final WufBoardService wufBoardService;
    private final ConfService confService;


    public WufBoardHolder getWufBoard(long id) {
        WufBoard board = wufBoardService.fetchWufBoard(id);
        return new WufBoardHolder(board);
    }

    public List<ConfHolder> getConfs(){
        return confService.fetchConfs().stream().map(ConfHolder::new).toList();
    }
}
