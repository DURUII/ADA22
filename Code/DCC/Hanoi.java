package DCC;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hanoi {
    static int step = 0;
    static List<String> moves = new ArrayList<>();
    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        move(M, "A", "C", "B");
        System.out.println(moves.get(N - 1));
        System.out.println(moves.size());
    }

    /**
     * 将 src 塔上 n 个盘片，借助 spare 塔，转移至 dest 塔
     * T(n) = 2^n -1 = O(2^n)
     */
    static void move(int n, String src, String dest, String spare) {
        // base case
        if (n == 1) {
            moves.add("#" + n + ": " + src + "->" + dest);
        }

        // recursive case
        else {
            // Move Disk 1 ~ n-1 from A to B
            move(n - 1, src, spare, dest);
            // Move Disk No. n from A to C
            // FIXME cannot use 'move(1, src, dest, "")' due to the output rules.
            moves.add("#" + n + ": " + src + "->" + dest);
            // Move Disk 1 ~ n-1 from B to C
            move(n - 1, spare, dest, src);
        }
    }
}