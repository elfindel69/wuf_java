package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Score {
    private int scoreHome;
    private int scoreAway;

    public Score(int scoreHome, int scoreAway) {
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
    }


    @Override
    public String toString() {
        return "Score{" +
                "scoreHome=" + scoreHome +
                ", scoreAway=" + scoreAway +
                '}';
    }
}
