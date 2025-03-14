package algo.interview.b_linear.a_array.array_partition;

import java.util.*;
public class ArrayPartition01 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        for (int n : nums) {
            pair.add(n);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }
}
