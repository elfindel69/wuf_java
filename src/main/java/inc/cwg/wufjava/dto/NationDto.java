package inc.cwg.wufjava.dto;

import inc.cwg.wufjava.holders.NationHolder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NationDto {
    private Long id;
    private String name;
    private double pts;
    private String admissionYear;

    private int wufRanking;
    private int confRanking;

    private int worldCupParticipations;
    private String lastWCResult;
    private String bestWCResult;

    private int confCupParticipations;
    private String lastCCResult;
    private String bestCCResult;

    private String lastCLResult;
    private String bestCLResult;
    private String timeZone;
    private String mainVenue;

    public NationDto(NationHolder nationHolder) {
        this.id = nationHolder.getId();
        this.name = nationHolder.getName();
        this.pts = nationHolder.getPts();
        this.admissionYear = nationHolder.getAdmissionYear();
        this.wufRanking = nationHolder.getWufRanking();
        this.confRanking = nationHolder.getConfRanking();
        this.worldCupParticipations = nationHolder.getWorldCupParticipations();
        this.lastWCResult = nationHolder.getLastWCResult();
        this.bestWCResult = nationHolder.getBestWCResult();
        this.confCupParticipations = nationHolder.getConfCupParticipations();
        this.lastCCResult = nationHolder.getLastCCResult();
        this.bestCCResult = nationHolder.getBestCCResult();
        this.lastCLResult = nationHolder.getLastCLResult();
        this.bestCLResult = nationHolder.getBestCLResult();
        this.timeZone = nationHolder.getTimeZone();
        this.mainVenue = nationHolder.getMainVenue();
    }


}
