package DCC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/peak-index-in-a-mountain-array/
public class BitonicChampion {
    static int[] A = {3, 7, 9, 17, 35, 28, 21, 18, 6, 4};

    public static void main(String[] args) {
        // [index, value]
        System.out.println(Arrays.toString(champion2(A, 0, A.length - 1)));
    }

    // O(n)
    static int[] champion(int[] arr, int lo, int hi) {
        // base case
        if (lo == hi) return new int[]{lo, arr[lo]};
        // recursive case
        int mid = lo + (hi - lo >> 1);
        int[] l = champion(arr, lo, mid);
        int[] r = champion(arr, mid + 1, hi);
        return l[1] > r[1] ? l : r;
    }

    // O(logn)
    static int[] champion2(int[] arr, int lo, int hi) {
        // base case
        if (lo == hi) return new int[]{lo, arr[lo]};
        // stronger recursive case
        int mid = lo + (hi - lo >> 1);
        if (arr[mid] < arr[mid + 1])
            return champion(arr, mid + 1, hi);
        // if (arr[mid] > arr[mid + 1])
        return champion(arr, lo, mid);
    }

    static int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int lo = 1, hi = n - 2, ans = 0;

        // 二分查找递减的左端点
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (arr[mid] - arr[mid + 1] > 0) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    static int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int lo = 0, hi = n - 1, ans = 0;

        // 二分查找递增的右端点
        while (lo < hi) {
            int mid = lo + hi + 1 >> 1;
            if (arr[mid] - arr[mid + 1] < 0) lo = mid;
            else hi = mid - 1;
        }

        // Note: if lo, hi are assigned 1, n-2, you may need to change the final statement into
        // return (arr[hi] > arr[hi + 1]) ? hi : hi + 1
        return hi + 1;
    }
}