package algo.interview.z_leetcode;

public class MaximumSubarray53 {
    public static void main(String[] args) {

        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // dp
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp[i] = Math.max(dp[i-1]+nums[i], nums[i-1]+nums[i]);
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }

        int maxVal = -987654321;
        for (int num : dp) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }
}
