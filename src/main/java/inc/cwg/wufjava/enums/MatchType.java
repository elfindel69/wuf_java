package inc.cwg.wufjava.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MatchType {
    LEAGUE("League"),
    CUP("Cup"),
    FRIENDLY("Friendly");

    private String type;

    public static MatchType getMatchType(String type) {
        for (MatchType matchType : MatchType.values()) {
            if(matchType.type.equals(type)) {
                return matchType;
            }
        }
        return null;
    }


    
}
