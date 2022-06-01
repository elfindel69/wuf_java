package inc.cwg.wufjava.cli;

import java.util.Scanner;

public class CliMenu {
    public static int startMenu()
    {
        System.out.println("Menu:");
        System.out.println("1. scores...");
        System.out.println("2. points...");
        System.out.println("3. nations...");
        System.out.println("4. classement mondial...");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
