package DCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Plane {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long n = (long) in.nval;
        /*
         * recurrence relation
         * T(n)=T(n-1)+n
         * T(0)=1
         */
        System.out.println((2 + n) * (n - 1) / 2 + 2);
    }
}
