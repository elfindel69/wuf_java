package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.ConfLeague;

public class CliLeague {

    public static void doViewLeague(ConfLeague lastConfLeague, String lastConfLeagueRes, String bestConfLeagueLevel,
                                   String bestConfLeagueRes)
    {
        System.out.println(lastConfLeague.getName() + " ("+lastConfLeague.getEdition()+")"+" :");
        System.out.println("dernière Ligue: " + lastConfLeague.getLevel());
        System.out.println("dernier resultat: " + lastConfLeagueRes + "\n");
        System.out.println("meilleure Ligue: " + bestConfLeagueLevel);
        System.out.println("meilleur resultat: " + bestConfLeagueRes + "\n");
    }
}
