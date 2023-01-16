package DCC;

// https://leetcode.cn/problems/maximum-subarray/
public class MaxSubArray {
    static int[] A = new int[]{5, 4, -1, 7, 8};

    public static void main(String[] args) {
        System.out.println(maxSubArray(A, 0, 4));
    }

    /**
     * O(nlogn)
     */
    static int maxSubArray(int[] nums, int lo, int hi) {
        // base case
        if (lo == hi) return nums[lo];
        // recursive case
        // divide into 2 sub-arrays
        int mid = lo + (hi - lo >> 1);
        // find the max sub-array for each sub-array divided
        int l = maxSubArray(nums, lo, mid);
        int r = maxSubArray(nums, mid + 1, hi);
        // Additional conquer
        int c = maxCrossSubArray(nums, lo, mid, hi);
        // pick the maximum sum among 3 sub-arrays combined
        return Math.max(Math.max(l, r), c);
    }

    /**
     * O(n)
     */
    static int maxCrossSubArray(int[] nums, int lo, int mid, int hi) {
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            left_sum = Math.max(sum, left_sum);
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum += nums[i];
            right_sum = Math.max(sum, right_sum);
        }
        return left_sum + right_sum;
    }
}
