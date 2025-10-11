package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.CupDto;
import inc.cwg.wufjava.models.Cup;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CupHolder {
    private Long id;

    private String name;

    private  String edition;

    private LocalDate firstDay;

    private LocalDate lastDay;

    private String hostName;

    private List<MatchCupHolder> matchCups = null;

    public CupHolder(CupDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.edition = dto.getEdition();
        this.firstDay = LocalDate.parse(dto.getFirstDay());
        this.lastDay = LocalDate.parse(dto.getLastDay());;
        this.hostName = dto.getHostName() != null && !dto.getHostName().isEmpty() ? dto.getHostName() : "multi";
    }

    public CupHolder(Cup cup) {
        this.id = cup.getId();
        this.name = cup.getName();
        this.edition = cup.getEdition();
        this.firstDay = cup.getFirstDay();
        this.lastDay = cup.getLastDay();
        this.hostName = cup.getHost().getName() != null && !cup.getHost().getName().isEmpty() ? cup.getHost().getName() : "multi";
    }

    public CupHolder(Cup cup, List<MatchCupHolder> matches) {
        this.id = cup.getId();
        this.name = cup.getName();
        this.edition = cup.getEdition();
        this.firstDay = cup.getFirstDay();
        this.lastDay = cup.getLastDay();
        this.hostName = cup.getHost().getName() != null && !cup.getHost().getName().isEmpty() ? cup.getHost().getName() : "multi";
        this.matchCups = matches;
    }
}
