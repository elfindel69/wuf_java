package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.CupHolder;
import inc.cwg.wufjava.holders.MatchCupHolder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CupDto {

    private Long id;

    private String name;

    private  String edition;

    private String firstDay;

    private String lastDay;

    private String hostName;

    private List<MatchCupHolder> matches;

   public CupDto(CupHolder holder) {
       this.id = holder.getId();
       this.name = holder.getName();
       this.edition = holder.getEdition();
       this.firstDay = holder.getFirstDay().toString();
       this.lastDay = holder.getLastDay().toString();
       this.hostName = holder.getHostName()!=null ? holder.getHostName() : "multi";
       this.matches = holder.getMatchCups();
   }

}
