package DCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class MergeSort {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        A = new int[N];
        for (int i = 0; i < N; i++) {
            in.nextToken();
            A[i] = (int) in.nval;
        }

        mergeSort(0, A.length - 1);
        for (int i = 0; i < A.length; i++) System.out.print(A[i] + " ");
    }

    /**
     * O(nlogn)
     */
    static void mergeSort(int l, int r) {
        // base case
        if (l == r) return;
        // recursive case
        // divide the list into 2 sub-lists
        // FIXME priority of various operators!!
        int mid = l + (r - l >> 1);
        // conquer each sub-list recursively
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        // combine two sorted lists with 2 pointers
        int p1 = l;
        int p2 = mid + 1;
        int[] tmp = new int[r - l + 1];
        int index = 0;
        while (p1 <= mid && p2 <= r) tmp[index++] = A[p1] < A[p2] ? A[p1++] : A[p2++];
        while (p1 <= mid) tmp[index++] = A[p1++];
        while (p2 <= r) tmp[index++] = A[p2++];
        for (int k = l; k <= r; k++) A[k] = tmp[k - l];
    }
}