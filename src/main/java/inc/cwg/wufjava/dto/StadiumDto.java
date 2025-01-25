package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.StadiumHolder;
import lombok.Data;

@Data
public class StadiumDto {
    private Long id;
    private String name;
    private String city;
    private String country;

    public StadiumDto(StadiumHolder stadiumHolder) {

        this.id = stadiumHolder.getId();
        this.name = stadiumHolder.getName();
        this.city = stadiumHolder.getCity();
        this.country = stadiumHolder.getCountry();
    }
}
