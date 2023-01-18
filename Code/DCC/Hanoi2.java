package DCC;

import java.math.BigInteger;
import java.util.Scanner;

public class Hanoi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 2 * (2 ^ n - 1)
        System.out.println(BigInteger.valueOf(2).pow(n + 1).subtract(BigInteger.valueOf(2)));
    }
}