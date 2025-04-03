package algo.interview.z_leetcode;

public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = {1, 7, 9, 11};
        int target = 10;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }


    // brute-force : O(N^2)
    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int[] answer = new int[2];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}
