package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.Country;

import java.util.Scanner;

public class CliCountry {
    public static Country NewCountry(boolean scoreB)
    {
        Scanner sc = new Scanner(System.in);
       System.out.println("nom Pays");
        String name = sc.nextLine();
        System.out.println("points Pays");
        double pts = sc.nextDouble();
        int score = 0;
        if (scoreB)
        {

            System.out.println("score Pays");
            sc.nextLine();
           score = sc.nextInt();
        }
        return new Country(name, pts, score);
    }
}
