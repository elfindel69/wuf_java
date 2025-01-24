package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Points {

    private double pointsHome;
    private double pointsAway;

    public Points(double pointsHome, double pointsAway) {
        this.pointsHome = pointsHome;
        this.pointsAway = pointsAway;
    }

    @Override
    public String toString() {
        return "Points{" +
                "pointsHome=" + pointsHome +
                ", pointsAway=" + pointsAway +
                '}';
    }
}
