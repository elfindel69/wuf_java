package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.Country;

import java.util.Scanner;

public class CliPoints {
    public static int getCoeff()
    {
        System.out.println("Coeff");
        System.out.println("20");
        System.out.println("30");
        System.out.println("40");
        System.out.println("50");
        System.out.println("60");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void doViewPoints(Country ct1, Country ct2)
    {
        System.out.println("Pays 1:");
        System.out.println("nom:" + ct1.getName());
        System.out.println("points: " + ct1.getPts());
        System.out.println("Pays 2:");
        System.out.println("nom:" + ct2.getName());
        System.out.println("points: " + ct2.getPts());
    }
}
