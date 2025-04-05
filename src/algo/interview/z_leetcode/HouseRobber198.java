package algo.interview.z_leetcode;

import java.util.*;
public class HouseRobber198 {

    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int result = rob(nums);
        System.out.println(result);
    }

    // Method2. memoization
    public static int rob(int[] nums) {
        return dfs(0, nums);
    }

    public static int dfs(int start, int[] nums) {

        if (memo.containsKey(start)) return memo.get(start);
        if (start >= nums.length) {
            memo.put(start, 0);
        } else {
            memo.put(start, Math.max(
                    nums[start] + dfs(start + 2, nums),
                    dfs(start + 1 , nums)
            ));
        }
        System.out.println(memo);
        return memo.get(start);
    }

    // Method1. Depth-First Search
    // Time Out => O(2^N)
//    public static int rob(int[] nums) {
//        return dfs(0, nums);
//    }
//
//    public static int dfs(int start, int[] nums) {
//        if (start >= nums.length) return 0;
//        return Math.max(nums[start] + dfs(start + 2, nums), dfs(start + 1, nums));
//    }
}
