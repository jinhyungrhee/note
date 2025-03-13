package algo.interview.b_linear.a_array.two_sum;

import java.util.*;
public class TwoSum02 {

    public static void main(String[] args) {

        int[] nums = {2, 6, 11, 15};
        int target = 8;
        int[] result = twoSum(nums, target);
        System.out.println("result[1] : " + nums[result[0]] + ", result[2] : " + nums[result[1]]);

    }

    // 2 - HashMap 사용 -> hashMap 조회 O(1) => 시간복잡도  : O(N)
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        // 키(index)와 값을 바꿔서 map에 저장
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        //System.out.println(numMap);

        // (1) target에서 현재값을 뺀 값이 key로 존재
        // (2) target에서 현재값을 뺀 값이 현재 인덱스가 아니어야 함
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i]) && i != numMap.get(target - nums[i])) {
                return new int[]{i, numMap.get(target - nums[i])};
            }
        }

        return null;
    }

}
