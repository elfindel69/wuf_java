package inc.cwg.wufjava.models;

public class Score {
    private int scoreHome;
    private int scoreAway;

    public int getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(int scoreHome) {
        this.scoreHome = scoreHome;
    }

    public int getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(int scoreAway) {
        this.scoreAway = scoreAway;
    }

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
