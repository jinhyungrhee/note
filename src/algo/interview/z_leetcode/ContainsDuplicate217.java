package algo.interview.z_leetcode;

import java.util.*;
public class ContainsDuplicate217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        // avg : O(NlogN)
        // worst : O(N^2)
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return true;
        }

        return false;
    }
}
