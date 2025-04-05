package algo.interview.z_leetcode;

import java.util.*;
public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println(result);

    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> table = new HashSet<>();
        for (int n : nums) {
            table.add(n);
        }


        int longest = 0;
        for (int num : table) {
            if (!table.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (table.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }

        // TIME OUT
//        int longest = 0;
//        for (int n : nums) {
//            if (table.contains(n - 1)) continue;
//            int len = 1;
//            while (table.contains(n + len)){
//                len++;
//            }
//            longest = Math.max(len, longest);
//        }

        return longest;
    }
}
