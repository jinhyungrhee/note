package algo.interview.b_linear.a_array.two_sum;

public class TwoSum01 {

    public static void main(String[] args) {

        int[] nums = {2, 6, 11, 15};
        int target = 8;
        int[] result = twoSum(nums, target);
        System.out.println("result[1] : " + nums[result[0]] + ", result[2] : " + nums[result[1]]);

    }

    // 1 - brute force => O(N^2), (= 정확히 1/2 * N^2)
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1 ; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

}
