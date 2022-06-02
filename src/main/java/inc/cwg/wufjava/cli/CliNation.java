package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.Nation;

import java.util.List;
import java.util.Scanner;

public class CliNation {
    public static int menuNations(List<Nation> nations)
    {
        System.out.println("Nations:");
        for (int i = 0; i < nations.size(); i++)
        {
            System.out.println(nations.get(i).getId().intValue()+ "- " + nations.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void doViewNation(Nation nat)
    {
        System.out.println("Nation :");
        System.out.println("nom : " + nat.getName());
        System.out.println("confédération : " + nat.getConf().getName());
        System.out.println("date d'adhésion : " + nat.getAdmissionYear());
        System.out.println("stade principal : " + nat.getMainStadium());
        System.out.println("Classement WUF : " + nat.getWufRanking());
        System.out.println("Classement WUF " + nat.getConf().getName()+" : " + nat.getConfRanking());
        System.out.println("points : " + nat.getPts());
    }
}
