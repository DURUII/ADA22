package DP;

import java.util.Scanner;

public class Fibonacci2 {
    /**
     * Fibonacci.java
     * Calling overlapping sub-problems result in poor efficiency
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    /**
     * TOP-DOWN with Memoization
     * Avoid the overlapping sub-problems recursively using memoization
     */
    static int[] a = new int[100 + 5];
    static final int N = 1000000007;

    static int fib(int n) {
        a[0] = 0;
        a[1] = 1;
        return f(n);
    }

    static int f(int n) {
        if (a[n] > 0 || n == 0) return a[n];
        // save the result to avoid recomputation
        a[n] = (f(n - 1) % N + f(n - 2) % N) % N;
        return a[n];
    }

    /**
     * BOTTOM-UP with Tabulation
     * building up solutions to larger and larger sub-problems
     */
    static int fib2(int n) {
        final int N = 1000000007;
        int[] a = new int[n + 2];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++)
            a[i] = (a[i - 1] % N + a[i - 2] % N) % N;
        return a[n];
    }
}