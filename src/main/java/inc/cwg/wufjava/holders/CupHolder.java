package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.CupDto;
import inc.cwg.wufjava.models.Cup;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CupHolder {
    private Long id;

    private String name;

    private  String edition;

    private LocalDate firstDay;

    private LocalDate lastDay;

    private String hostName;

    public CupHolder(CupDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.edition = dto.getEdition();
        this.firstDay = LocalDate.parse(dto.getFirstDay());
        this.lastDay = LocalDate.parse(dto.getLastDay());;
        hostName = dto.getHostName();
    }

    public CupHolder(Cup cup) {
        this.id = cup.getId();
        this.name = cup.getName();
        this.edition = cup.getEdition();
        this.firstDay = cup.getFirstDay();
        this.lastDay = cup.getLastDay();
        this.hostName = cup.getHost().getName();
    }
}
