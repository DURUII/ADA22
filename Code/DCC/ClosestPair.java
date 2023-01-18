package DCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class ClosestPair {
    static int n;
    static double[][] p;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        p = new double[n][2];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            p[i][0] = in.nval;
            in.nextToken();
            p[i][1] = in.nval;
        }
        System.out.printf("%.4f%n", closestPair(p));
    }

    static double closestPair(double[][] p) {
        // termination condition: brute-force finding the closest pair and return it
        if (p.length <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = 0; i < p.length; i++) {
                for (int j = i + 1; j < p.length; j++) {
                    double dist = Math.sqrt(Math.pow(p[i][0] - p[j][0], 2) + Math.pow(p[i][1] - p[j][1], 2));
                    if (dist < min) {
                        min = dist;
                    }
                }
            }
            return min;
        }


        // divide: find a vertical line L s.t. both planes contain half of the points
        Arrays.sort(p, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            return 0;
        });
        // conquer: find the closest pair in each region recursively
        int index = p.length / 2;
        double X = p[index][0];
        double minLeft = closestPair(Arrays.copyOfRange(p, 0, index));
        double minRight = closestPair(Arrays.copyOfRange(p, index, p.length));
        // combine
        // #1 Find the closest pair across regions
        double delta = Math.min(minLeft, minRight);
        // *# remove points that delta or more away from L
        double L = X - delta;
        double R = X + delta;
        int from, to;
        int lo = 0, hi = index;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (p[mid][0] >= L) hi = mid;
            else lo = mid + 1;
        }
        from = lo;

        lo = index;
        hi = p.length;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (p[mid][0] >= R) hi = mid;
            else lo = mid + 1;
        }
        to = hi;
        double[][] px = Arrays.copyOfRange(p, from, to);
        // *# sort remaining points by y
        Arrays.sort(px, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] > o2[1]) return -1;
            return 0;
        });

        for (int i = 0; i < px.length; i++) {
            for (int j = i + 1; j < i + 8 && j < px.length; j++) {
                double dist = Math.sqrt(Math.pow(px[i][0] - px[j][0], 2) + Math.pow(px[i][1] - px[j][1], 2));
                if (dist < delta) {
                    delta = dist;
                }
            }
        }
        // return the best of 3 solutions
        return delta;
    }
}
