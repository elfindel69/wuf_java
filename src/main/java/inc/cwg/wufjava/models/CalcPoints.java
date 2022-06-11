package inc.cwg.wufjava.models;

public class CalcPoints {
    private int pts1;
    private int pts2;
    private int coeff;
    private int sc1;
    private int sc2;

    public CalcPoints() {
    }

    public CalcPoints(int pts1, int pts2, int coeff, int sc1, int sc2) {
        this.pts1 = pts1;
        this.pts2 = pts2;
        this.coeff = coeff;
        this.sc1 = sc1;
        this.sc2 = sc2;
    }

    public int getPts1() {
        return pts1;
    }

    public void setPts1(int pts1) {
        this.pts1 = pts1;
    }

    public int getPts2() {
        return pts2;
    }

    public void setPts2(int pts2) {
        this.pts2 = pts2;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getSc1() {
        return sc1;
    }

    public void setSc1(int sc1) {
        this.sc1 = sc1;
    }

    public int getSc2() {
        return sc2;
    }

    public void setSc2(int sc2) {
        this.sc2 = sc2;
    }

    @Override
    public String toString() {
        return "CalcPoints{" +
                "pts1=" + pts1 +
                ", pts2=" + pts2 +
                ", coeff=" + coeff +
                ", sc1=" + sc1 +
                ", sc2=" + sc2 +
                '}';
    }
}
