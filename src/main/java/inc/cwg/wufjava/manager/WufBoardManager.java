package inc.cwg.wufjava.manager;

import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.WufBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WufBoardManager {
    WufBoardService wufBoardService;
    ConfService confService;


    public WufBoard getWufBoard(long id) {
        return wufBoardService.fetchWufBoard(id);
    }

    public List<Conf> getConfs(){
        return confService.fetchConfs();
    }
}
