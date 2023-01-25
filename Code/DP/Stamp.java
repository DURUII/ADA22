package DP;


public class Stamp {
    static int[] values = new int[]{1, 2, 5};

    public static void main(String[] args) {
        System.out.println(coinChange(values, 11));
    }

    static int coinChange(int[] coins, int amount) {
        int[] values = new int[coins.length + 1];
        for (int i = 1; i < values.length; i++) {
            values[i] = coins[i - 1];
        }

        int[] opt = new int[amount + 1];  // CAUTION: heap space
        for (int i = 1; i < opt.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < values.length; j++) {
                if (i - values[j] >= 0)
                    if (opt[i - values[j]] >= 0) {
                        if (1 + opt[i - values[j]] < min) {
                            min = 1 + opt[i - values[j]];
                        }
                    }
            }
            opt[i] = (min != Integer.MAX_VALUE) ? min : -1;
        }
        return opt[amount];
    }
}