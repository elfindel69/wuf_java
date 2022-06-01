package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.Conf;

import java.util.List;
import java.util.Scanner;

public class CliConf {
    public static int menuConf(List<Conf> confs)
    {
        System.out.println("Confédérations :");
        for(int i = 0; i < confs.size(); i++)
        {
            System.out.println(confs.get(i).getId().intValue()+"- "+confs.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void doViewConf(Conf conf)
    {
        System.out.println("Confédération :");
        System.out.println("nom : " + conf.getName());
        System.out.println("affiliation: WUF");
        System.out.println("sport: United Football");
        System.out.println("date de création: " + conf.getDof());
        System.out.println("nombre de membres: " + conf.getNbMembers());

    }
}
