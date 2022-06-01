package inc.cwg.wufjava.models;

public class Points {

    private double pointsHome;
    private double pointsAway;

    public double getPointsHome() {
        return pointsHome;
    }

    public void setPointsHome(double pointsHome) {
        this.pointsHome = pointsHome;
    }

    public double getPointsAway() {
        return pointsAway;
    }

    public void setPointsAway(double pointsAway) {
        this.pointsAway = pointsAway;
    }

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
