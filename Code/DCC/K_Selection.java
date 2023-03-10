package DCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class K_Selection {
    static int[] a = new int[]{3, 2, 3, 1, 2};

    public static void main(String[] args) {
        System.out.println(findKthLargest(a, 5));
    }

    static int findKthLargest(int[] nums, int k) {
        // base case
        if (nums.length <= 4) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }

        // recursive case
        // divide nums into nums.length/5 groups with size 5
        // COMMENTS: SOOOOOOOOOOO MANY TRIVIAL DETAILS
        int remainder = nums.length % 5;
        int numOfGroup = (remainder > 0) ? (nums.length / 5 + 1) : (nums.length / 5);
        int[] median = new int[numOfGroup];
        int index = 0;
        if (remainder != 0) {
            int res = nums[remainder >> 1];
            if ((remainder & 1) != 1) res = (res + nums[remainder >> 1 + 1]) >> 1;
            median[numOfGroup - 1] = res;
            index = remainder - 1;
        }
        for (; index + 4 < nums.length; index += 5) {
            Arrays.sort(nums, index, index + 5);
            median[index / 5] = nums[index + 2];
        }

        // FIXME theoretically best pivot (median of medians)
        int MoM = findKthLargest(median, median.length >> 1 > 0 ? median.length >> 1 : (median.length >> 1) + 1);

        // FIXME randomized median is of competitive edge on LEETCODE
        // int MoM = nums[new Random().nextInt(nums.length)];

        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > MoM) more.add(nums[i]);
            else if (nums[i] < MoM) less.add(nums[i]);
            else equal.add(nums[i]);
        }


        // FIXME Which to conquer: X<, X> or X= ?
        if (k - 1 < more.size()) {
            int[] moreArray = new int[more.size()];
            for (int i = 0; i < more.size(); i++) moreArray[i] = more.get(i);
            return findKthLargest(moreArray, k);
        } else if (k - 1 < more.size() + equal.size()) {
            return MoM;
        }

        int[] lessArray = new int[less.size()];
        for (int i = 0; i < less.size(); i++) lessArray[i] = less.get(i);
        return findKthLargest(lessArray, k - more.size() - equal.size());
    }
}
