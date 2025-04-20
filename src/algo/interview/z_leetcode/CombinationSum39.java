package algo.interview.z_leetcode;

import java.util.*;
public class CombinationSum39 {
    public static List<List<Integer>> output;
    public static void main(String[] args) {
        output = new ArrayList<>();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(candidates, target, stack, 0, 0);
        System.out.println(output);
    }

    public static void dfs(int[] candidates, int target, Deque<Integer> stack, int start, int total) {

        if (total > target) return;

        if (total == target) {
            output.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            stack.push(num);
            dfs(candidates, target, stack, i, total + num);
            stack.pop();
        }
    }
}
