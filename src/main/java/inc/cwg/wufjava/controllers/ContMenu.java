package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.cli.CliCountry;
import inc.cwg.wufjava.cli.CliPoints;
import inc.cwg.wufjava.cli.CliScores;
import inc.cwg.wufjava.models.Country;
import inc.cwg.wufjava.models.Points;
import inc.cwg.wufjava.models.Score;
import org.springframework.stereotype.Controller;

@Controller
public class ContMenu {
    public  void execScores()
    {
        System.out.println("Scores !");
        System.out.println("Pays 1:");
        Country ct1 = CliCountry.NewCountry(false);
        System.out.println("Pays 2:");

        Country ct2 = CliCountry.NewCountry(false);
        Score scores = CalcScore.doCalcScores(ct1.getPts(), ct2.getPts());
        ct1.setScore(scores.getScoreHome());
        ct2.setScore(scores.getScoreAway());
        CliScores.doViewScores(ct1, ct2);
    }

    public  void execPoints()
    {
        System.out.println("Points !");
        System.out.println("Pays 1:");
        Country ct1 = CliCountry.NewCountry(true);
        System.out.println("Pays 2:");

        Country ct2 = CliCountry.NewCountry(true);
        int coeff = CliPoints.getCoeff();
        int diff = ct1.getScore() - ct2.getScore();
        Points points = CalcPoints.doCalcPoints(ct1.getPts(), ct2.getPts(), coeff, diff);
        ct1.setPts(points.getPointsHome());
        ct2.setPts(points.getPointsAway());
        CliPoints.doViewPoints(ct1, ct2);
    }
}

