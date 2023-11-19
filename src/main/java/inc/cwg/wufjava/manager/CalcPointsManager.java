package inc.cwg.wufjava.manager;

import org.springframework.stereotype.Component;

import inc.cwg.wufjava.models.Points;


@Component
public class CalcPointsManager {
    public static Points doCalcPoints(double pts1, double pts2, int coeff, int diff)
    {
        double newPts1 = 0;
        double newPts2 = 0;

        // calcul de G
        double lDiff = calcDiff(diff);

        // calcul de Delta
        double delta = pts1 - pts2;
        delta = delta / 400;
        delta = Math.pow(10, delta) + 1;
        delta = 1 / delta;

        delta = delta * coeff * lDiff;

        // attribution des points
        if (diff > 0)
        {
            newPts1 = roundToTwo(pts1 + delta);
            newPts2 = roundToTwo(pts2 - delta);
        }
        if (diff == 0)
        {
            newPts1 = roundToTwo(pts1 + delta);
            newPts2 = roundToTwo(pts2 + delta);
        }
        if (diff < 0)
        {
            newPts1 = roundToTwo(pts1 - delta);
            newPts2 = roundToTwo(pts2 + delta);
        }



        Points points = new Points(newPts1, newPts2);

        return points;
    }

    private static double calcDiff(int diff)
    {
        int lDiff = Math.abs(diff);
        double res = 0;
        if (lDiff <= 5)
        {
            res = 1;
        }
        if (lDiff > 5 && lDiff <= 10)
        {
            res = 1.5;
        }
        if (lDiff > 10)
        {
            res = 1.75 + (lDiff - 3.0) / 8.0;
        }

        return res;
    }

    private static double roundToTwo(double num)
    {
        return (double)Math.round(num * 100d) / 100d;
    }
}
