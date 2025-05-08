package algo.interview.z_leetcode;

import java.util.*;
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1 ; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxVal = 0;
        for (int num : dp) {
            if (num > maxVal) maxVal = num;
        }

        return maxVal;
    }
}
