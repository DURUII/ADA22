package DCC;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n >= 0) {
                System.out.println(f(n));
            }
        }
    }

    // Recurrence
    static int f(int n) {
        // base case: directly output
        if (n < 2) return 1;
        // recursive case: divide the problem into two sub-problems
        // compute each sub-problem recursively and add them both
        return f(n - 1) + f(n - 2);
    }
}
