package DCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Josephus {
    static int[] j;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        j = new int[n + 1];
        j[1] = 1;
        in.nextToken();
        int k = (int) in.nval;
        // BOTTOM-UP with Memoization
        for (int i = 2; i <= n; i++) {
            /*
             * 下标重映射举例：
             * J(10,7)
             * 1 2 3 4 5 6 7 8 9 10
             *
             * (J(9,7) + 7) % 10
             * (J(9,7) + 6) % 10 + 1
             * 8 9 10 1 2 3 4 5 6
             */
            j[i] = (j[i - 1] + k - 1) % (i) + 1;
        }
        System.out.println(j[n]);
    }
}
