package DP;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedIntervalScheduling {
    static int[] start = new int[]{1, 2, 3, 4, 6};
    static int[] finish = new int[]{3, 5, 10, 6, 9};
    static int[] value = new int[]{20, 20, 100, 70, 60};

    public static void main(String[] args) {
        System.out.println(jobScheduling(start, finish, value));
    }

    static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[3][n + 1];
        for (int i = 1; i <= n; i++) {
            jobs[0][i] = startTime[i - 1];
            jobs[1][i] = endTime[i - 1];
            jobs[2][i] = profit[i - 1];
        }
        // bubble sort by end time
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (jobs[1][i] > jobs[1][i + 1]) {
                    for (int j = 0; j <= 2; j++) {
                        int tmp = jobs[j][i];
                        jobs[j][i] = jobs[j][i + 1];
                        jobs[j][i + 1] = tmp;
                    }
                    flag = true;
                }
            }
        }
        // indicate whose end time is the closest to the start time of the indexed task
        int[] adj = new int[n + 1];
        for (int i = adj.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[1][j] <= jobs[0][i]) {
                    adj[i] = j;
                    break;
                }
            }
        }
        return schedule(n, jobs[2], adj);
    }

    static int schedule(int n, int[] v, int[] p) {
        int[] opt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // choose or not
            opt[i] = Math.max(v[i] + opt[p[i]], opt[i - 1]);
        }
        return opt[n];
    }
}