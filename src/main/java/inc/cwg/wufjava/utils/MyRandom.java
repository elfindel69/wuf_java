package inc.cwg.wufjava.utils;

import java.util.Random;

public class MyRandom {
    public static int RNG5(Random rand, int rng)
    {
        return (int)Math.floor(rand.nextDouble() * rng * 5);
    }
    public static int RNG2(Random rand, int rng)
    {
        return (int)Math.floor(rand.nextDouble() * rng * 2);
    }
}
