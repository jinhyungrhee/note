package algo.interview.b_linear.a_array.three_number_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeNumberSum02 {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -5};
        Arrays.sort(nums); // {-5, -1, -1, 0, 1, 2}; => O(NlogN)
        List<List<Integer>> result = threeNumberSum(nums);
        System.out.println(result);

    }

    // 1 - Two Pointer => O(N^2)
    public static List<List<Integer>>threeNumberSum(int[] nums) {

        int left, right, sum;
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복 값 skip
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 이후부터 two pointer로 탐색
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else { // sum == 0

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // *중복값 건너뛰기*
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동
                    // 합이 0인 상황이므로, 양쪽 모두 이동 필요!
                    left++;
                    right--;
                }
            }

        }

        return result;
    }
}
