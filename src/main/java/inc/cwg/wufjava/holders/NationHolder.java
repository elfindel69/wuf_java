package inc.cwg.wufjava.holders;

import inc.cwg.wufjava.dto.NationDto;
import inc.cwg.wufjava.models.Nation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NationHolder {
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

    public NationHolder(Nation nation) {
        this.id = nation.getId();
        this.name = nation.getName();
        this.pts = nation.getPts();
        this.admissionYear = nation.getAdmissionYear();
        this.wufRanking = nation.getWufRanking();
        this.confRanking = nation.getConfRanking();
        this.worldCupParticipations = nation.getWorldCupParticipations();
        this.lastWCResult = nation.getLastWCResult();
        this.bestWCResult = nation.getBestWCResult();
        this.confCupParticipations = nation.getConfCupParticipations();
        this.lastCCResult = nation.getLastCCResult();
        this.bestCCResult = nation.getBestCCResult();
        this.lastCLResult = nation.getLastCLResult();
        this.bestCLResult = nation.getBestCLResult();
        this.timeZone = nation.getTimeZone();
        this.mainVenue = nation.getMainStadium().getName();

    }

    public NationHolder (NationDto nationDto) {
        this.id = nationDto.getId();
        this.name = nationDto.getName();
        this.pts = nationDto.getPts();
        this.admissionYear = nationDto.getAdmissionYear();
        this.wufRanking = nationDto.getWufRanking();
        this.confRanking = nationDto.getConfRanking();
        this.worldCupParticipations = nationDto.getWorldCupParticipations();
        this.lastWCResult = nationDto.getLastWCResult();
        this.bestWCResult = nationDto.getBestWCResult();
        this.confCupParticipations = nationDto.getConfCupParticipations();
        this.lastCCResult = nationDto.getLastCCResult();
        this.bestCCResult = nationDto.getBestCCResult();
        this.lastCLResult = nationDto.getLastCLResult();
        this.bestCLResult = nationDto.getBestCLResult();
        this.timeZone = nationDto.getTimeZone();
        this.mainVenue = nationDto.getMainVenue();
    }

}
