package DCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/peak-index-in-a-mountain-array/
public class BitonicChampion {
    static int[] A = {3, 7, 9, 17, 35, 28, 21, 18, 6, 4};

    public static void main(String[] args) {
        // [index, value]
        System.out.println(Arrays.toString(champion(A, 0, A.length - 1)));
    }

    static int[] champion(int[] arr, int lo, int hi) {
        // base case
        if (lo == hi) return new int[]{lo, arr[lo]};
        // recursive case
        int mid = lo + (hi - lo >> 1);
        int[] l = champion(arr, lo, mid);
        int[] r = champion(arr, mid + 1, hi);
        return l[1] > r[1] ? l : r;
    }
}