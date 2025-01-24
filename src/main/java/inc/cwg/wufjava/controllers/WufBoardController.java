package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.manager.WufBoardManager;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.WufBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/wufboard")
public class WufBoardController {
    WufBoardManager wufBoardManager;


    @GetMapping("/")
    public WufBoard getWufBoard() {
        return wufBoardManager.getWufBoard(1L);
    }

    @GetMapping("/confs")
    public List<Conf> getConfs(){
        return wufBoardManager.getConfs();
    }

}
