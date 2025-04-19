package algo.interview.z_leetcode;

import java.util.*;
public class DecodeWays91 {
    public static List<Integer> nums;
    public static void main(String[] args) {
        nums = new ArrayList<>();
//        String s = "1111111111111111111111";
        String s = "226";
        for (int i = 0; i < s.length(); i++) {
            nums.add(s.charAt(i) - 48);
        }
        int[] memo = new int[nums.size() + 1];
        Arrays.fill(memo, -1);
        System.out.println(dfs(0, memo));

    }
    public static int dfs(int start, int[] memo) {

        if (start == nums.size()) return 1;

        if (memo[start] != -1) {
            return memo[start];
        }
        if (nums.get(start) == 0) {
            memo[start] = 0;
        }
        else if (start + 1 < nums.size() && nums.get(start) * 10 + nums.get(start + 1) < 27) {
            memo[start] = dfs(start + 1, memo) + dfs(start + 2, memo);
        } else {
            memo[start] = dfs(start + 1, memo);
        }
        return memo[start];
    }

    /** [Time-Out]

     public static int dfs(int start) {
     if (start == nums.size()) return 1;
     if (nums.get(start) == 0) return 0;
     if (start + 1 < nums.size() && nums.get(start) * 10 + nums.get(start + 1) < 27) {
     return dfs(start + 1) + dfs(start + 2);
     }
     return dfs(start + 1);
     }
     */
}
