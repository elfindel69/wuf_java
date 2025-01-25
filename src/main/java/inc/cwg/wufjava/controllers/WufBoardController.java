package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.dto.ConfDto;
import inc.cwg.wufjava.dto.WufBoardDto;
import inc.cwg.wufjava.holders.WufBoardHolder;
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
   private final WufBoardManager wufBoardManager;


    @GetMapping("/")
    public WufBoardDto getWufBoard() {
        WufBoardHolder holder = wufBoardManager.getWufBoard(1L);
        return new WufBoardDto(holder);
    }

    @GetMapping("/confs")
    public List<ConfDto> getConfs(){
        return wufBoardManager.getConfs().stream().map(ConfDto::new).toList();
    }

}
