package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.CupHolder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CupDto {

    private Long id;

    private String name;

    private  String edition;

    private String firstDay;

    private String lastDay;

    private String hostName;

   public CupDto(CupHolder holder) {
       this.id = holder.getId();
       this.name = holder.getName();
       this.edition = holder.getEdition();
       this.firstDay = holder.getFirstDay().toString();
       this.lastDay = holder.getLastDay().toString();
       this.hostName = holder.getHostName();
   }

}
