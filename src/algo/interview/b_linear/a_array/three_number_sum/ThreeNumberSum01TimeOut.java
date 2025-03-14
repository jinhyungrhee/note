package algo.interview.b_linear.a_array.three_number_sum;

import java.util.*;
public class ThreeNumberSum01TimeOut {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -5};
        List<List<Integer>> result = threeNumberSum(nums);
        System.out.println(result);

    }

    // 1 - Brute Force => O(N^3)
    public static List<List<Integer>>threeNumberSum(int[] nums) {

        Arrays.sort(nums); // {-5, -1, -1, 0, 1, 2}; => O(NlogN)

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // System.out.println("[DUP] nums[i] = " + nums[i] + ", nums[i-1] = " + nums[i-1]);
                continue;
            }
            for (int j = i + 1 ; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // System.out.println("[DUP] nums[j] = " + nums[j] + ", nums[j-1] = " + nums[j-1]);
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        // System.out.println("[DUP] nums[k] = " + nums[k] + ", nums[k-1] = " + nums[k-1]);
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // System.out.println("[ANSWER] i = " + nums[i] + ", j = " + nums[j] + ", k = " + nums[k]);
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return result;
    }
}
