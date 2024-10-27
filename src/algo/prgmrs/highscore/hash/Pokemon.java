package algo.prgmrs.highscore.hash;

/**
 * 프로그래머스 > 고득점 kit > 해시 > 포켓몬
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.*;
import java.util.stream.Collectors;

public class Pokemon {
    public static void main(String[] args) {
        /**
         * input
         */
//        int[] nums = { 3,1,2,3 };
//        int[] nums = { 3,3,3,2,2,4 };
        int[] nums = { 3,3,3,2,2,2 };

        System.out.println("MY_SOLUTION : " + mySolution(nums));
        System.out.println("REFACTORING : " + refactoredSolution(nums));

    }

    public static int mySolution(int[] nums) {

        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int targetSize = nums.length / 2;
        int setSize = numSet.size();

        if (targetSize < setSize) {
            return targetSize;
        }
        return setSize;

    }

    public static int refactoredSolution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        pokemons -> Integer.min(pokemons.size(), nums.length / 2)));
    }


}
