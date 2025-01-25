package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.StadiumDto;
import inc.cwg.wufjava.models.Stadium;
import lombok.Data;

@Data
public class StadiumHolder {
    private Long id;
    private String name;
    private String city;
    private String country;

    public StadiumHolder(Stadium stadium) {
        this.id = stadium.getId();
        this.name = stadium.getName();
        this.city = stadium.getCity();
        this.country = stadium.getCountry().getName();
    }

    public StadiumHolder(StadiumDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.city = dto.getCity();
        this.country = dto.getCountry();
    }

}
