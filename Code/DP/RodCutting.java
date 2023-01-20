package DP;

import java.util.Scanner;

/**
 * Optimization: maximum gain
 * <p>
 * #1 sub-problem overlapping?
 * <p>
 * #2 optimal solution constructed from optimal substructure
 * (ignore non-optimal solutions)?
 */
public class RodCutting {
    static long[] prices;
    static long[] revenue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        prices = new long[n + 1];
        revenue = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = sc.nextInt();
            revenue[i] = -1;
        }
        System.out.println(cut_dp2(n));
    }

    /**
     * Top-Down without memoization
     * Status: Time limit exceeded on test 2
     * Calling overlapping sub-problems results in poor efficiency
     */
    static long cut_naive(int n) {
        // base-case
        if (n == 0) return 0;
        if (n == 1) return prices[1];
        // recursive case
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, prices[i] + cut_naive(n - i));
        }
        return max;
    }

    /**
     * TOP-DOWN with Memoization
     * Status: Accepted
     */
    static long cut_dp(int n) {
        // solution already saved
        if (revenue[n] >= 0) return revenue[n];

        long max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, prices[i] + cut_dp(n - i));
        }
        // update memo
        revenue[n] = max;
        return revenue[n];
    }

    /**
     * Bottom-Up with Tabulation
     * Status: Accepted
     */
    static long cut_dp2(int n) {
        // compute revenue[1:] in order
        for (int i = 1; i <= n; i++) {
            long max = Long.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, prices[j] + revenue[i - j]);
            }
            revenue[i] = max;
        }
        return revenue[n];
    }
}
