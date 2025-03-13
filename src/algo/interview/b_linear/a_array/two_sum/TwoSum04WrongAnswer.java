package algo.interview.b_linear.a_array.two_sum;

import java.util.*;
public class TwoSum04WrongAnswer {

    public static void main(String[] args) {

        int[] nums = {2, 6, 11, 15};
        int target = 8;
        int[] result = twoSum(nums, target);
        System.out.println("result[1] : " + nums[result[0]] + ", result[2] : " + nums[result[1]]);

    }

    // 4 - 투포인터 => 오답 (정렬하는 순간 인덱스 값이 엉망이 됨)
    // TODO - 값 복사로 기존 인덱스를 따로 저장해두면 되지 않을까?? -> 하지만 이 또한 성능에 큰 문제가 있을 듯!
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 정렬하는 순간 기존 index 관리에 이슈가 생긴다
        // Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[] {left, right};
            }
        }

        return null;
    }

}
