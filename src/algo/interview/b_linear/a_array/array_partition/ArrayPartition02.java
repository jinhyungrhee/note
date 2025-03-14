package algo.interview.b_linear.a_array.array_partition;

import java.util.Arrays;

public class ArrayPartition02 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    // 불필요한 리스트 객체 생성 생략
    // 불필요한 min() 함수 호출 생략
    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }

        return sum;
    }
}
