package DP;


public class Coin {
    static int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        // Project Euler Answer:  73682
        System.out.println(waysToChange(coins, 200));
    }
    
    static public int waysToChange(int[] coins, int amount) {
        int[] values = new int[coins.length + 1];
        for (int i = 1; i < values.length; i++) {
            values[i] = coins[i - 1];
        }
        int[] opt = new int[amount + 1];
        opt[0] = 1;

        for (int j = 1; j < values.length; j++) {
            for (int i = 1; i < opt.length; i++) {
                if (i - values[j] >= 0)
                    opt[i] += opt[i - values[j]];
            }
        }
        return opt[amount];
    }
}