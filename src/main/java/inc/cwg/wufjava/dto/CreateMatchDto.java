package inc.cwg.wufjava.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMatchDto {
    
    private String homeNation;
    private String awayNation;
    private int coeff;

    private String stadium;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    private String timeZone;

    String cup;
    String league;


}
