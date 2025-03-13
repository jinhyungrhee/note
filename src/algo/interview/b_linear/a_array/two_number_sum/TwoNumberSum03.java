package algo.interview.b_linear.a_array.two_number_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum03 {

    public static void main(String[] args) {

        int[] nums = {2, 6, 11, 15};
        int target = 8;
        int[] result = twoSum(nums, target);
        System.out.println("result[1] : " + nums[result[0]] + ", result[2] : " + nums[result[1]]);

    }

    // 3 - HashMap 저장 로직 개선 -> hashMap 조회 O(1) => 시간복잡도  : O(N) [*동일*]
    // 하나의 for문 안에서 저장/조회 로직 모두 수행 (모든 값 저장 X)
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        // 키(index)와 값을 바꿔서 map에 저장
        for (int i = 0; i < nums.length; i++) {

            // map에 taget에서 num을 뺀 값이 존재하면 정답으로 리턴
            if (numMap.containsKey(target - nums[i])) {
                //System.out.println(numMap);
                return new int[] {numMap.get(target - nums[i]), i};
            }

            // 정답이 없으면, 다음번 비교를 위해 num값과 index값 map에 저장
            numMap.put(nums[i], i);
        }

        return null;
    }

}
