package inc.cwg.wufjava.cli;

public class CliCup {
    public static void DoViewCup(String lastCupName, int cupParticipations, String lastCupRes, String bestCupEdition)
    {
        System.out.println("\n" + lastCupName + ":");
        System.out.println("participations: " + cupParticipations);
        System.out.println("meilleur résultat: " + lastCupRes + " (" + bestCupEdition + ") \n");
    }
}
